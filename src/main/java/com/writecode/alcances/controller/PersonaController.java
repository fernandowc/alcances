package com.writecode.alcances.controller;

import com.writecode.alcances.model.Persona;
import com.writecode.alcances.service.PersonaService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping(path = "/persona")
    public Single<ResponseEntity<Flowable<Persona>>> listar()
    {
        Flowable<Persona> allPersonas = personaService.listarPersona();
        return Single.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(allPersonas));
    }

    @GetMapping(path = "/persona/{id}")
    public Single<ResponseEntity<Maybe<Persona>>> listarPorId(@PathVariable("id") String id)
    {
        Maybe<Persona> idpersona = personaService.listarPorId(id);
        return personaService.listarPorId(id)
                .map(p -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(idpersona))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/persona")
    public Single<ResponseEntity<Single<Persona>>> agregar(@RequestBody Persona persona, final ServerHttpRequest req)
    {
        Single<Persona> add = personaService.addPersona(persona);
        return Single.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(add));
    }

    @PutMapping(path = "/persona/{id}")
    public Single<ResponseEntity<Single<Persona>>> actualizar(@PathVariable String id, @RequestBody Persona persona)
    {
        Maybe<Persona> add = Maybe.just(persona);
        Maybe<Persona> idpersona = personaService.listarPorId(id);

        return idpersona.zipWith(add, (idPer, addPl) -> {
            idPer.setId(id);
            idPer.setNombre(addPl.getNombre());
            idPer.setEmail(addPl.getEmail());
            return idPer;
        }).flatMap(personaService::actualizar)
                .map(p -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_STREAM_JSON)
                        .body(p))
                .defaultIfEmpty(new ResponseEntity<Persona>(HttpStatus.NOT_FOUND))
                .doOnError(p -> System.out.println("ocurrió un error: " + p));
    }

}
