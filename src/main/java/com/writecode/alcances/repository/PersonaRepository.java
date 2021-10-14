package com.writecode.alcances.repository;

import com.writecode.alcances.model.Persona;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersonaRepository extends ReactiveCrudRepository<Persona, String> {

}
