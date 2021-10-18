package com.writecode.alcances.repository;

import com.writecode.alcances.model.Persona;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.RxJava3CrudRepository;

public interface PersonaRepository extends RxJava3CrudRepository<Persona, String> {



}
