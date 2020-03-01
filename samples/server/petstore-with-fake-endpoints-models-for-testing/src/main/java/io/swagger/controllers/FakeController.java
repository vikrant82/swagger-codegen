package io.swagger.controllers;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import java.io.File;
import java.util.List;

import io.swagger.model.*;

import java.math.BigDecimal;
import java.util.Map;

import io.swagger.model.Body2;
import io.swagger.model.Body3;
import io.swagger.model.Body4;
import io.swagger.model.Body5;
import io.swagger.model.Client;
import io.swagger.model.OuterComposite;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaInflectorServerCodegen", date = "2020-02-29T02:28:40.316-05:00[America/Bogota]")
public class FakeController  {

    public ResponseContext fakeOuterBooleanSerialize(RequestContext request, Boolean body) {
        return new ResponseContext().status(Status.OK).entity(body);
    }

    public ResponseContext fakeOuterCompositeSerialize(RequestContext request, OuterComposite body) {
        return new ResponseContext().status(Status.OK).entity(body);
    }

    public ResponseContext fakeOuterNumberSerialize(RequestContext request, BigDecimal body) {
        return new ResponseContext().status(Status.OK).entity(body);
    }

    public ResponseContext fakeOuterStringSerialize(RequestContext request, String body) {
        return new ResponseContext().status(Status.OK).entity(body);
    }

    public ResponseContext testClientModel(RequestContext request, Client body) {
        return new ResponseContext().status(Status.OK).entity(body);
    }

    public ResponseContext testEndpointParameters(RequestContext request, Body2 body) {
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext testEnumParameters(RequestContext request, List<String> enumHeaderStringArray, String enumHeaderString, List<String> enumQueryStringArray, String enumQueryString, Integer enumQueryInteger) {
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext testEnumRequestBody(RequestContext request, Body4 body) {
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext testInlineAdditionalProperties(RequestContext request, Map<String, String> body) {
        return new ResponseContext().status(Status.OK);
    }

    public ResponseContext testJsonFormData(RequestContext request, Body5 body) {
        return new ResponseContext().status(Status.OK);
    }
}

