package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-02-29T02:28:40.316-05:00[America/Bogota]")
public class AllPetsController  {

    public ResponseContext getAllPets(RequestContext request ) {
        return new ResponseContext().status(Status.OK).entity(PetController.PET_MAP.values());
    }

}

