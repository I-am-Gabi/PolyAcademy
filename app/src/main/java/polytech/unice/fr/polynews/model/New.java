package polytech.unice.fr.polynews.model;

/**
 * @version 03/04/16.
 */
public class New {
    private int id;
    private String title;
    private String content;
    private String datetime;
    private String media_path;
    private String organization;

    public New() {
        this.title = "title";
        this.content = "content";
        this.datetime = "10/10/10 00:00:00";
        this.organization = "Polytech";
        this.media_path = "http://static1.squarespace.com/static/55ae7d08e4b0d41522af009e/t/564e2656e4b01cc50dbc59a5/1447962198944/New-icon.png";
    }

    public String getMedia_path() {
        return media_path;
    }

    public void setMedia_path(String media_path) {
        this.media_path = media_path;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getDateTime() {
        return datetime;
    }
}
