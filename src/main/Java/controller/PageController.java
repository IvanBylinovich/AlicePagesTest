package controller;

import exception.NegativePageNumberException;
import tool.Executor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/")

public class PageController  {
    Executor reducer = new Executor();
    Logger logger;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response doGet(@QueryParam("rawPageNumbers") String rawPageNumbers){
        String reducedPageNumbersList = "";
        logger.info("reducedPageNumbers GET controller run");

        try {
            reducedPageNumbersList = reducer.toFormat(rawPageNumbers);
        } catch (NegativePageNumberException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("The page cannot be less than 1!").build();

        }catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("A non-numeric value has been entered!").build();
        }

        return Response.ok("{\"original\":" + "\""+ rawPageNumbers + "\", \"reduced\": \"" + reducedPageNumbersList+ "\"}").build();


    }

    @POST
    public void doPost(){

    }
}
