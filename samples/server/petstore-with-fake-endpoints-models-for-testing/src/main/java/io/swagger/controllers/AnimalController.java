package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import java.util.HashMap;
import java.util.Map;

import io.swagger.model.Animal;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-02-29T02:28:40.316-05:00[America/Bogota]")
public class AnimalController  {

    public static final Map<Long, Animal> ANIMAL_MAP = new HashMap<>();

    public ResponseContext addAnimal(RequestContext request, Animal body) {
        ANIMAL_MAP.put(body.getId(), body);
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext deleteAnimal(RequestContext request, Long animalId, String apiKey) {
        if (ANIMAL_MAP.remove(animalId) != null) {
            return new ResponseContext().status(Status.OK);
        }
        return new ResponseContext().status(Status.BAD_REQUEST);
    }

    public ResponseContext getAnimalById(RequestContext request, Long animalId) {
        if (animalId == null) {
            return new ResponseContext().status(Status.BAD_REQUEST);
        }
        final Animal animal = ANIMAL_MAP.get(animalId);
        if (animal == null) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        return new ResponseContext().status(Status.OK).entity(animal);
    }

    public ResponseContext updateAnimal(RequestContext request, Animal body) {
        ANIMAL_MAP.put(body.getId(), body);
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext updateAnimalWithForm(RequestContext request, Long animalId, String name, String status) {
        final Animal animal = ANIMAL_MAP.get(animalId);
        if (animal == null) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        return new ResponseContext().status(Status.OK);
    }
}

