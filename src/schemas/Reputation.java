package schemas;

import java.util.ArrayList;
import java.util.List;

public enum Reputation {
    EXCELLENT,
    GOOD,
    NEUTRAL,
    BAD,
    AWFUL;

    private List<String> knownScandals = new ArrayList<>();

    public List<String> getKnownScandals() {
        return knownScandals;
    }

    public void setKnownScandals(List<String> knownScandals) {
        this.knownScandals = knownScandals;
    }

    public int getPointLevel() {
        switch(this) {
            case EXCELLENT:
                return -20;
            case GOOD:
                return 30;
            case NEUTRAL:
                return 50;
            case BAD:
                return 80;
            case AWFUL:
                return 100;
        }
        return 0;
    }
}
