package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import java.util.HashMap;
import java.util.Map;

import io.swagger.model.Dog;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-02-29T02:28:40.316-05:00[America/Bogota]")
public class DogController  {

    public static final Map<Long, Dog> DOG_MAP = new HashMap<>();

    public ResponseContext addDog(RequestContext request , Dog body) {
        DOG_MAP.put(body.getId(), body);
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext deleteDog(RequestContext request , Long dogId, String apiKey) {
        if (DOG_MAP.remove(dogId) != null) {
            return new ResponseContext().status(Status.OK);
        }
        return new ResponseContext().status(Status.BAD_REQUEST);
    }

    public ResponseContext getDogById(RequestContext request , Long dogId) {
        if (dogId == null) {
            return new ResponseContext().status(Status.BAD_REQUEST);
        }
        final Dog dog = DOG_MAP.get(dogId);
        if (dog == null) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        return new ResponseContext().status(Status.OK).entity(dog);
    }

    public ResponseContext updateDog(RequestContext request , Dog body) {
        DOG_MAP.put(body.getId(), body);
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext updateDogWithForm(RequestContext request , Long id, String name, String status) {
        final Dog dog = DOG_MAP.get(id);
        if (dog == null) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        return new ResponseContext().status(Status.OK);
    }
}

