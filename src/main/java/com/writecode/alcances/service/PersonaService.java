package com.writecode.alcances.service;

import com.writecode.alcances.model.Persona;
import io.reactivex.rxjava3.core.Single;

public interface PersonaService {

    Single<String> listarPersona(Persona per);
}
