package schemas;

public class Media {
    private String name;
    private MediaType type;
    private String language;

    Media(String name, MediaType type, String language) {
        this.name = name;
        this.type = type;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MediaType getType() {
        return type;
    }

    public void setType(MediaType type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
