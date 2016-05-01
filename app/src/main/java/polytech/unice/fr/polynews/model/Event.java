package polytech.unice.fr.polynews.model;

/**
 * @version 03/04/16.
 */
public class Event {
    private int id;
    private String title;
    private String description;
    private String datetime;
    private String local;

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    private String organization;

    public Event() {
        this.title = "title";
        this.description = "content";
        this.datetime = "10/10/10 00:00:00";
        this.local = "Nice";
        this.organization = "Polytech";
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

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDateTime() {
        return datetime;
    }

    public String getLocal() {
        return local;
    }
}
