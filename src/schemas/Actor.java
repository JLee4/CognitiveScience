package schemas;

import java.util.Objects;

public class Actor extends CastMember {

    public Actor(String name, Reputation reputation, Fame fame) {
        super(name, CastType.ACTOR, reputation, fame);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Actor)) return false;
        Actor actor = (Actor) o;
        return Objects.equals(getName(), actor.getName()) &&
                getReputation() == actor.getReputation() &&
                getFame() == actor.getFame();
    }
}
