package polytech.unice.fr.polynews.model;

/**
 * @version 03/04/16.
 */
public class Event {
    private int id;
    private String title;
    private String description;
    private String datatime;
    private String local;

    public Event() {
        this.title = "title";
        this.description = "description";
        this.datatime = "10/10/10 00:00:00";
        this.local = "Nice";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDatatime(String datatime) {
        this.datatime = datatime;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
