package io.swagger.controllers;

import io.swagger.model.ModelApiResponse;
import io.swagger.model.Pet;
import io.swagger.model.Tag;
import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response.Status;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-02-29T02:28:40.316-05:00[America/Bogota]")
public class PetController {

    public static final Map<Long, Pet> PET_MAP = new HashMap<>();

    public ResponseContext addPet(RequestContext request , Pet body) {
        PET_MAP.put(body.getId(), body);
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext deletePet(RequestContext request, Long petId, String apiKey) {
        if (PET_MAP.remove(petId) != null) {
            return new ResponseContext().status(Status.OK);
        }
        return new ResponseContext().status(Status.BAD_REQUEST);
    }

    public ResponseContext findPetsByStatus(RequestContext request , List<String> status) {
        if (PET_MAP.isEmpty()) {
            return new ResponseContext().status(Status.OK).entity(PET_MAP.values());
        }
        final List<Pet> pets = PET_MAP.values()
                .stream()
                .filter(pet -> {
                    for (String st : status) {
                        Pet.StatusEnum statusEnum = Pet.StatusEnum.fromValue(st);
                        if (statusEnum == null) {
                            continue;
                        }
                        if (pet.getStatus().equals(statusEnum)) {
                            return true;
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
        return new ResponseContext().status(Status.OK).entity(pets);
    }

    public ResponseContext findPetsByTags(RequestContext request , List<String> tags) {
        if (PET_MAP.isEmpty()) {
            return new ResponseContext().status(Status.OK).entity(PET_MAP.values());
        }
        final List<Pet> pets = PET_MAP.values()
                .stream()
                .filter(pet -> {
                    if (pet.getTags() == null || pet.getTags().isEmpty()) {
                        return false;
                    }
                    for (Tag petTag : pet.getTags()) {
                        for (String tag : tags) {
                            if (tag.equalsIgnoreCase(petTag.getName())) {
                                return true;
                            }
                        }
                    }
                    return false;
                })
                .collect(Collectors.toList());
        return new ResponseContext().status(Status.OK).entity(pets);
    }

    public ResponseContext getPetById(RequestContext request , Long petId) {
        if (petId == null) {
            return new ResponseContext().status(Status.BAD_REQUEST);
        }
        final Pet pet = PET_MAP.get(petId);
        if (pet == null) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        return new ResponseContext().status(Status.OK).entity(pet);
    }

    public ResponseContext updatePet(RequestContext request, Pet body) {
        PET_MAP.put(body.getId(), body);
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext updatePetWithForm(RequestContext request, Long petId, String name, String status) {
        final Pet pet = PET_MAP.get(petId);
        if (pet == null) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        pet.setName(name);
        final Pet.StatusEnum statusEnum = Pet.StatusEnum.fromValue(status);
        if (statusEnum != null) {
            pet.setStatus(statusEnum);
        }
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext uploadFile(RequestContext request , Long petId, String additionalMetadata , FormDataContentDisposition fileDetail) {
        return new ResponseContext().status(Status.OK)
                .entity(new ModelApiResponse().code(200));
    }
}

