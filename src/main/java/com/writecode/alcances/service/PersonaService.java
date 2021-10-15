package com.writecode.alcances.service;

import com.writecode.alcances.model.Persona;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import reactor.core.publisher.Flux;

public interface PersonaService {

    Flowable<Persona> listarPersona();
    Single<Persona> addPersona(Persona per);
    Maybe actualizar(Persona per);
    Maybe<Persona> listarPorId(String id);
}
