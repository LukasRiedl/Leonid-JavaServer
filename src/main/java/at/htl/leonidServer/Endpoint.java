package at.htl.leonidServer;

import at.htl.leonidServer.database.Database;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Lukas on 29.09.2017.
 */

@Path("leonidserver")
public class Endpoint {

    Message m;
    Database db = new Database();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequest() throws SQLException {


        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(db.getAllMessages()).build();
    }

    


    @GET
    @Path("/query")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("msg") String message) throws SQLException {
        Message m= new Message(1, message);
        return Response.status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .entity(db.insert(m)).build();
    }

    public static boolean alexaResponse = false;
    public static String videoname = "";
    @GET
    @Path("animation")
    @Produces({MediaType.APPLICATION_JSON})
    public Response response1(@QueryParam("name") String name)
    {
        videoname = name + ".mp4";
        alexaResponse = true;
        return Response.ok().entity("Animation " + name + " activated").build();
    }



    @GET
    @Path("startWebUntis")
    @Produces({MediaType.APPLICATION_JSON})
    public Response startWebUntis() throws IOException {



            return  Response.ok().entity(Controller.startWeb()).build();




    }
}
