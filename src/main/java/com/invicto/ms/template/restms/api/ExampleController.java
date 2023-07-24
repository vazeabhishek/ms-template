package com.invicto.ms.template.restms.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.util.Map;

import com.invicto.ms.template.restms.aspects.LogExecutionTime;

@Path("/example")
public class ExampleController {

    @GET
    @LogExecutionTime
    public String get(@HeaderParam("Content-Type") String contentType) {
        return "Header parameter value is [" + contentType + "]";
    }

    @GET
    @LogExecutionTime
    @Path("/enviro")
    public Map<String,String> getEnvironments(@HeaderParam("Content-Type") String contentType) {
        return System.getenv();
    }

    @GET
    @Path("/{p}")
    public String getWithPathParam(@PathParam("p") String param) {
        return "Hello" + param;

    }

    @GET
    @Path("/query")
    public String getWithQueryParam(@QueryParam("name") String name) {
        return "Hello" + name;
    }

   
    @POST
    @Consumes("application/json")
    public String post() {
        return "Hello";

    }

    @PUT
    public String put() {
        return "Hello";

    }

    @PATCH
    public String patch() {
        return "Hello";

    }
}
