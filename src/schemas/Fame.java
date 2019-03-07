package schemas;

import java.util.ArrayList;
import java.util.List;

public enum Fame {
    D_LIST,
    C_LIST,
    B_LIST,
    A_LIST;

    private List<String> knownMovies = new ArrayList<>();

    public List<String> getKnownMovies() {
        return knownMovies;
    }

    public void setKnownMovies(List<String> knownMovies) {
        this.knownMovies = knownMovies;
    }

    public int getFameLevel() {
        return ordinal() + 1;
    }
}
