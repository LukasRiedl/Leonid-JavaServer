package at.htl.leonidServer;

import at.htl.leonidServer.database.Database;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by Lukas on 29.09.2017.
 */

@Path("leonidserver")
public class Endpoint {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRequest()
    {

        Database db = new Database();

//        db.onEnable();
//        try {
//            db.insert();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        db.onDisable();
        return Response
                .status(200)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").entity(new Entity(1,"Hallo Laura")).build();
    }
}
