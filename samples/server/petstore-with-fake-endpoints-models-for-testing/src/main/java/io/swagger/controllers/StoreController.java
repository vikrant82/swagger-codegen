package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import java.io.File;
import java.util.HashMap;
import java.util.List;

import io.swagger.model.*;

import java.util.Map;
import io.swagger.model.Order;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-02-29T02:28:40.316-05:00[America/Bogota]")
public class StoreController  {

    public static final Map<Long, Order> ORDER_MAP = new HashMap<>();

    public ResponseContext deleteOrder(RequestContext request, String orderId) {
        final long id = Long.parseLong(orderId);
        if (ORDER_MAP.remove(id) != null) {
            return new ResponseContext().status(Status.OK);
        }
        return new ResponseContext().status(Status.BAD_REQUEST);
    }

    public ResponseContext getInventory(RequestContext request) {
        return new ResponseContext().status(Status.INTERNAL_SERVER_ERROR).entity("{}");
    }

    public ResponseContext getOrderById(RequestContext request, Long orderId) {
        if (orderId == null) {
            return new ResponseContext().status(Status.BAD_REQUEST);
        }
        final Order order = ORDER_MAP.get(orderId);
        if (order == null) {
            return new ResponseContext().status(Status.NOT_FOUND);
        }
        return new ResponseContext().status(Status.OK).entity(order);
    }

    public ResponseContext placeOrder(RequestContext request , Order body) {
        ORDER_MAP.put(body.getId(), body);
        return new ResponseContext().status(Status.OK).entity(body);
    }
}

