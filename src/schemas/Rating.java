package schemas;

public enum Rating {

    ONE_STAR,
    TWO_STARS,
    THREE_STARS,
    FOUR_STARS,
    FIVE_STARS;

    public enum RatedBy {
        ROTTEN_TOMATOES,
        IMDB
    }

    private RatedBy ratedBy;

    public RatedBy getRatedBy() {
        return ratedBy;
    }

    public void setRatedBy(RatedBy ratedBy) {
        this.ratedBy = ratedBy;
    }

    public int getRatingLevel() {
        return ordinal() + 1;
    }
}
