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

    public int getPointLevel() {
        switch (this) {
            case D_LIST:
                return 100;
            case C_LIST:
                return 80;
            case B_LIST:
                return 30;
            case A_LIST:
                return -20;
        }
        return 0;
    }
}
