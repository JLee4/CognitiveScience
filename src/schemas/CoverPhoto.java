package schemas;

public class CoverPhoto {

    //Represents how many different elements are in the cover photo
    public enum Complexity {
        SIMPLE,
        MEDIUM,
        COMPLEX
    }
    public enum MovieRelation {
        REVEALS_ACTORS,
        REVEALS_ATTRACTIVE_ACTORS,
        REVEALS_PLOT,
        REVEALS_PLOT_ACTORS
    }

    private Complexity complexity;
    private MovieRelation movieRelation;

    public CoverPhoto(Complexity complexity, MovieRelation movieRelation) {
        this.complexity = complexity;
        this.movieRelation = movieRelation;
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
