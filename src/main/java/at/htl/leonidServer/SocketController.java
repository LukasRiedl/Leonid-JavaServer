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
                if(message.contains("LeonidSpeak")){
                    for (int i = 0; i < 2; i++){
                        this.session.getBasicRemote().sendText(Endpoint.videoname);
                        Thread.sleep(1041);
                    }
                }
                else
                    this.session.getBasicRemote().sendText(Endpoint.videoname);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

