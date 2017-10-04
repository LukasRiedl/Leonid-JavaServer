package at.htl.leonidServer;

/**
 * Created by Lukas on 02.10.2017.
 */
public class Message {

    private int id;

    public Message(int id, String text) {
        this.setId(id);
        this.setText(text);
    }

    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
