package schemas;

public class CoverPhoto {
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }
    //Represents how many different elements are in the cover photo
    public enum Complexity {
        SIMPLE,
        MEDIUM,
        COMPLEX
    }
    public enum MovieRelation {
        REVEALS_ACTORS,
        REVEALS_PLOT,
        REVEALS_PLOT_ACTORS
    }

    private Size size;
    private Complexity complexity;
    private MovieRelation movieRelation;

    public CoverPhoto(Size size, Complexity complexity, MovieRelation movieRelation) {
        this.size = size;
        this.complexity = complexity;
        this.movieRelation = movieRelation;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }

    public MovieRelation getMovieRelation() {
        return movieRelation;
    }

    public void setMovieRelation(MovieRelation movieRelation) {
        this.movieRelation = movieRelation;
    }
}
