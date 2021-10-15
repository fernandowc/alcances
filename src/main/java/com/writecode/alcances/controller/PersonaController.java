package com.writecode.alcances.controller;

import com.writecode.alcances.model.Persona;
import com.writecode.alcances.service.PersonaService;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.net.URI;

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

    @PostMapping(path = "/persona")
    public Single<ResponseEntity<Single<Persona>>> agregar(@RequestBody Persona persona, final ServerHttpRequest req)
    {
        Single<Persona> add = personaService.addPersona(persona);
        return Single.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(add));
    }

}
