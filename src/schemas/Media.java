package schemas;

public class Media {
    public enum Type {
        FILM,
        SHOW,
        MUSIC,
        ART
    }

    private String name;
    private Type type;
    private String language;

    public Media(String name, Type type, String language) {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
