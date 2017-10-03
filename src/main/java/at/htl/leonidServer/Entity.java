package at.htl.leonidServer;

/**
 * Created by Lukas on 02.10.2017.
 */
public class Entity {

    private int id;

    public Entity(int id, String message) {
        this.setId(id);
        this.setMessage(message);
    }

    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
