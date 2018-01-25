package at.htl.leonidServer;

import javax.websocket.Session;


        import javax.websocket.OnMessage;
        import javax.websocket.OnOpen;
        import javax.websocket.Session;
        import javax.websocket.server.ServerEndpoint;
        import java.io.IOException;

@ServerEndpoint("/ws")
public class SocketController{
    private Session session;

    @OnOpen
    public void onCreateSession(Session session){
        this.session = session;
    }

    @OnMessage
    public void onRequest(String message){
        try {
            if(Endpoint.alexaResponse == true){
                Endpoint.alexaResponse = false;
                this.session.getBasicRemote().sendText(Endpoint.videoname);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

