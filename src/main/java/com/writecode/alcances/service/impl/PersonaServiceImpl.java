package com.writecode.alcances.service.impl;

import com.writecode.alcances.model.Persona;
import com.writecode.alcances.repository.PersonaRepository;
import com.writecode.alcances.service.PersonaService;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@AllArgsConstructor
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public Flowable<Persona> listarPersona() {
        return personaRepository.findAll();
    }

    @Override
    public Single<Persona> addPersona(Persona per) {
        return personaRepository.save(per);
    }

    @Override
    public Maybe actualizar(Persona per) {
        return personaRepository.save(per).toMaybe();
    }

    @Override
    public Maybe<Persona> listarPorId(String id) {
        return personaRepository.findById(id);
    }
}
