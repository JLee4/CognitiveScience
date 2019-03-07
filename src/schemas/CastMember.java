package schemas;

import java.util.Objects;

public class CastMember {

    public enum CastType {
        DIRECTOR,
        ACTOR,
        PRODUCER,
        PRODUCTION_STAFF,
        CORPORATE_STAFF
    }

    private String name;
    private CastType castType;
    private Reputation reputation;
    private Fame fame;

    public CastMember(String name, CastType castType, Reputation reputation, Fame fame) {
        this.name = name;
        this.castType = castType;
        this.reputation = reputation;
        this.fame = fame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CastType getCastType() {
        return castType;
    }

    public void setCastType(CastType castType) {
        this.castType = castType;
    }

    public Reputation getReputation() {
        return reputation;
    }

    public void setReputation(Reputation reputation) {
        this.reputation = reputation;
    }

    public Fame getFame() {
        return fame;
    }

    public void setFame(Fame fame) {
        this.fame = fame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CastMember)) return false;
        CastMember that = (CastMember) o;
        return Objects.equals(getName(), that.getName()) &&
                getCastType() == that.getCastType() &&
                getReputation() == that.getReputation() &&
                getFame() == that.getFame();
    }
}
