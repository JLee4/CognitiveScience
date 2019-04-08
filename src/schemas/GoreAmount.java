package schemas;

public enum GoreAmount {
    NONE,
    LITTLE,
    MEDIUM,
    LARGE;

    public int getPointLevel() {
        switch(this) {
            case NONE:
                return 0;
            case LITTLE:
                return 50;
            case MEDIUM:
                return 100;
            case LARGE:
                return 200;
        }
        return 0;
    }
}
