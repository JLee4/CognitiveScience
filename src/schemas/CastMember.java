package schemas;

public class CastMember {

    public enum CastType {
        DIRECTOR,
        ACTOR,
        PRODUCER,
        PRODUCTION_STAFF,
        CORPORATE_STAFF
    }
    public enum Reputation {
        EXCELLENT,
        GOOD,
        NEUTRAL,
        BAD,
        AWFUL
    }
    public enum Fame {
        A_LIST,
        B_LIST,
        C_LIST,
        D_LIST
    }
    private CastType castType;
    private Reputation reputation;
    private Fame fame;

    public CastMember(CastType castType, Reputation reputation, Fame fame) {
        this.castType = castType;
        this.reputation = reputation;
        this.fame = fame;
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
}
