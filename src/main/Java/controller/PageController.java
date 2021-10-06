package controller;

import exception.NegativePageNumberException;
import tool.Executor;

import javax.ws.rs.*;

@Path("/reducedPageNumbers")

public class PageController  {
    Executor reducer = new Executor();

    @GET
    @Produces("application/json")
    @Consumes("text/plain")
    public String doGet(@QueryParam("rawPageNumbers") String rawPageNumbers){
        String reducedPageNumbersList = "";

        try {
            reducedPageNumbersList = reducer.toFormat(rawPageNumbers);
        } catch (NegativePageNumberException e) {
            return  e.getMessage();
        }catch (NumberFormatException e) {
            return e.getMessage();
        }

        return "{\"original\":" + "\""+ rawPageNumbers + "\", \"reduced\": \"" + reducedPageNumbersList+ "\"}";


    }

    @POST
    public void doPost(){

    }
}
