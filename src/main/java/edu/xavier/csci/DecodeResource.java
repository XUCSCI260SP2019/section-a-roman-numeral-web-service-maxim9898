
package com.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 */
@Path("decode")
public class DecodeResource {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response encodeMultiple(String content) {
        try {
            JSONObject request = new JSONObject(content);
            JSONArray numbers = request.getJSONArray("romanNumerals");

            JSONObject response = new JSONObject();
            JSONArray responseNumbers = new JSONArray();
            response.put("numbers", responseNumbers);
            for (Object obj : numbers) {
                String num = (String) obj;
                Integer decoded = RomanNumeralApplication.decode(num);
                responseNumbers.put(decoded);
            }
            return Response.status(Response.Status.OK).entity(response.toString()).build();
        } catch (Exception exc) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input!").build();
        }
    }

    @GET
    @Path("/{romanNumeral}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encodeSingle(@PathParam("romanNumeral") String romanNumeral) {
        try {
            JSONObject response = new JSONObject();

            Integer decoded = RomanNumeralApplication.decode(romanNumeral);
            response.put("number", decoded);

            return Response.status(Response.Status.OK).entity(response.toString()).build();
        } catch (Exception exc) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input!").build();
        }
    }
}
/**
 *
 */
@Path("decode")
public class DecodeResource {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response encodeMultiple(String content) {
        try {
            JSONObject request = new JSONObject(content);
            JSONArray numbers = request.getJSONArray("romanNumerals");

            JSONObject response = new JSONObject();
            JSONArray responseNumbers = new JSONArray();
            response.put("numbers", responseNumbers);
            for (Object obj : numbers) {
                String num = (String) obj;
                Integer decoded = RomanNumeralApplication.decode(num);
                responseNumbers.put(decoded);
            }
            return Response.status(Response.Status.OK).entity(response.toString()).build();
        } catch (Exception exc) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input!").build();
        }
    }

    @GET
    @Path("/{romanNumeral}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encodeSingle(@PathParam("romanNumeral") String romanNumeral) {
        try {
            JSONObject response = new JSONObject();

            Integer decoded = RomanNumeralApplication.decode(romanNumeral);
            response.put("number", decoded);

            return Response.status(Response.Status.OK).entity(response.toString()).build();
        } catch (Exception exc) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input!").build();
        }
    }
}

