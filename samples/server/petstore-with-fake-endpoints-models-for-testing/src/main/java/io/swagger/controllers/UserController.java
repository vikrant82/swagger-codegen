package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import io.swagger.model.*;

import io.swagger.model.User;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-02-29T02:28:40.316-05:00[America/Bogota]")
public class UserController  {

    public static final Map<Long, User> USER_MAP = new HashMap<>();

    public ResponseContext createUser(RequestContext request , User body) {
        USER_MAP.put(body.getId(), body);
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext createUsersWithArrayInput(RequestContext request, List<User> body) {
        if (body == null || body.isEmpty()) {
            return new ResponseContext().status(Status.OK);
        }
        for (User user : body) {
            createUser(request, user);
        }
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext createUsersWithListInput(RequestContext request, List<User> body) {
        return createUsersWithArrayInput(request, body);
    }

    public ResponseContext deleteUser(RequestContext request, String username) {
        if (USER_MAP.isEmpty()) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        final Optional<User> userOptional = USER_MAP.values()
                .stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst();
        if (!userOptional.isPresent()) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        USER_MAP.remove(userOptional.get().getId());

        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext getUserByName(RequestContext request, String username) {
        if (USER_MAP.isEmpty()) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        final Optional<User> userOptional = USER_MAP.values()
                .stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst();
        if (!userOptional.isPresent()) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        return new ResponseContext().status(Status.OK).entity(userOptional.get());
    }

    public ResponseContext loginUser(RequestContext request, String username, String password) {
        if (USER_MAP.isEmpty()) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        final Optional<User> userOptional = USER_MAP.values()
                .stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst();
        if (!userOptional.isPresent()) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        final User user = userOptional.get();
        if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
            return new ResponseContext().status(Status.OK);
        }
        return new ResponseContext().status(Status.UNAUTHORIZED);
    }

    public ResponseContext logoutUser(RequestContext request ) {
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext updateUser(RequestContext request, User body, String username) {
        USER_MAP.put(body.getId(), body);
        return new ResponseContext().status(Status.OK);
    }
}

