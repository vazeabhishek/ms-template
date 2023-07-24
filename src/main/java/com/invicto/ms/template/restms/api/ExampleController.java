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
import java.util.*;
import java.time.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invicto.ms.template.restms.aspects.LogExecutionTime;
import org.springframework.beans.factory.annotation.*;
import com.invicto.ms.template.restms.repo.*;
import com.invicto.ms.template.restms.entity.*;

@Path("/example")
public class ExampleController {

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public LogsRepo repo;

    @GET
    @LogExecutionTime
    public String get(@HeaderParam("Content-Type") String contentType) {
        return "Header parameter value is [" + contentType + "]";
    }

    @GET
    @LogExecutionTime
    @Path("/enviro")
    public String getEnvironments(@HeaderParam("Content-Type") String contentType) {
        Map<String,String> envMap = new HashMap<String,String>();
        envMap.putAll(System.getenv());
        try{
        return objectMapper.writeValueAsString(envMap);
        }
        catch(Exception e){
            System.out.println(e);
            return "";
        }
    }

    @GET
    @Path("/{p}")
    public String getWithPathParam(@PathParam("p") String param) {
        Logs log = build("GETWITHPARAM "+param);
        repo.save(log);
        return "Hello" + param;

    }

    @GET
    @Path("/logs")
    public String getAllLogs() {

        List<Logs> allLogs = new LinkedList();
        repo.findAll().forEach(l -> allLogs.add(l));
        try
        {
        String r = objectMapper.writeValueAsString(allLogs);
        return r;
        }
        catch(Exception e){
            return "";
        } 

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

    public Logs build(String api){
        Logs lg = new Logs();
        lg.id = String.valueOf(System.currentTimeMillis())+ Math.random();
        lg.api = api;
        lg.localDateTime = LocalDateTime.now();
        return lg;
    }


}
