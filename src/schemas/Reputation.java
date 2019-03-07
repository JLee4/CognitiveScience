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
}
