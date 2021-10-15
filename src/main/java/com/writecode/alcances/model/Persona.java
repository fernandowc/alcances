package com.writecode.alcances.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "persona")
public class Persona {

    @Id
    private String id;
    private String nombre;
    private String email;

    public Persona(){}
}
