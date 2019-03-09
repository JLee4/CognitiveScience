package schemas;

import java.util.Objects;

public class Director extends CastMember {

    public Director(String name, Reputation reputation, Fame fame) {
        super(name, CastMember.CastType.DIRECTOR, reputation, fame);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Director)) return false;
        Director director = (Director) o;
        return Objects.equals(getName().toLowerCase(), director.getName().toLowerCase());
    }
}
