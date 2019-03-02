package schemas;

public class CoverPhoto {

    //Represents how many different elements are in the cover photo
    public enum Complexity {
        SIMPLE,
        MEDIUM,
        COMPLEX
    }
    public enum Iconography {
        REVEALS_THEME,
        REVEALS_ACTORS,
        REVEALS_PLOT,
        REVEALS_PLOT_ACTORS
    }

    private Complexity complexity;
    private Iconography iconography;
    private Appeal appeal;

    public CoverPhoto(Complexity complexity, Iconography iconography, Appeal appeal) {
        this.complexity = complexity;
        this.iconography = iconography;
        this.appeal = appeal;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    public Iconography getIconography() {
        return iconography;
    }

    public void setIconography(Iconography iconography) {
        this.iconography = iconography;
    }

    public Appeal getAppeal() {
        return appeal;
    }

    public void setAppeal(Appeal appeal) {
        this.appeal = appeal;
    }
}
