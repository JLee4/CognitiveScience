package schemas;

public enum Rating {
    ONE_STAR,
    TWO_STARS,
    THREE_STARS,
    FOUR_STARS,
    FIVE_STARS;

    public int getRatingLevel() {
        return ordinal() + 1;
    }
}
