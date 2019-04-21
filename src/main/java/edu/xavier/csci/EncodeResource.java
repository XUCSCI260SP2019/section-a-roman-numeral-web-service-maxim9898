package edu.xavier.csci;
//Encode class
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

@Path("encode")
public class EncodeResource {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response encodeMultiple(String content) {
        try {
            JSONObject request = new JSONObject(content);
            JSONArray numbers = request.getJSONArray("numbers");

            JSONObject response = new JSONObject();
            JSONArray responseNumbers = new JSONArray();
            response.put("romanNumerals", responseNumbers);
            for (Object obj : numbers) {
                int num = (int) obj;
                String encoded = RomanNumeralApplication.encode(num);
                responseNumbers.put(encoded);
            }
            return Response.status(Response.Status.OK).entity(response.toString()).build();
        } catch (Exception exc) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input!").build();
        }
    }

    @GET
    @Path("/{number}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response encodeSingle(@PathParam("number") int number) {
        try {
            JSONObject response = new JSONObject();

            String encoded = RomanNumeralApplication.encode(number);
            response.put("romanNumeral", encoded);

            return Response.status(Response.Status.OK).entity(response.toString()).build();
        } catch (Exception exc) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid input!").build();
        }
    }

}
