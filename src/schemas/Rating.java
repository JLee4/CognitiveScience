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

    public int getPointLevel() {
        switch(this) {
            case ONE_STAR:
                return 250;
            case TWO_STARS:
                return 150;
            case THREE_STARS:
                return 80;
            case FOUR_STARS:
                return 0;
            case FIVE_STARS:
                return -50;
        }
        return 0;
    }
}
