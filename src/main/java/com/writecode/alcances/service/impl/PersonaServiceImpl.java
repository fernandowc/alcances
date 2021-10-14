package com.writecode.alcances.service.impl;

import com.writecode.alcances.model.Persona;
import com.writecode.alcances.repository.PersonaRepository;
import com.writecode.alcances.service.PersonaService;
import io.reactivex.rxjava3.core.Single;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Single<String> listarPersona(Persona per) {
        return null;
    }

    private Single<String> guardarPersona(Persona persona){
        return Single.create(personaSubscriber -> {
            Optional<Persona> optionalPersona = personaRepository.findAllById();
        });
    }
}
