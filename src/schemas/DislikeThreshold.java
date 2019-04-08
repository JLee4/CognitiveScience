package schemas;

public class DislikeThreshold {

    private int maxPointValue;
    private String castMemberName;
    private User.Checks movieCharacteristic;

    public DislikeThreshold(User.Checks movieCharacteristic, String castMemberName, int maxPointValue) {
        this.movieCharacteristic = movieCharacteristic;
        this.maxPointValue = maxPointValue;
        this.castMemberName = castMemberName;
    }

    public int getMaxPointValue() {
        return maxPointValue;
    }

    public void setMaxPointValue(int maxPointValue) {
        this.maxPointValue = maxPointValue;
    }

    public String getCastMemberName() {
        return castMemberName;
    }

    public void setCastMemberName(String castMemberName) {
        this.castMemberName = castMemberName;
    }

    public User.Checks getMovieCharacteristic() {
        return movieCharacteristic;
    }

    public void setMovieCharacteristic(User.Checks movieCharacteristic) {
        this.movieCharacteristic = movieCharacteristic;
    }

    public boolean equalsCheck(User.Checks movieCharacteristic) {
        return getMovieCharacteristic() == movieCharacteristic;
    }

    public boolean isIncreasedThreshold(DislikeThreshold dislikeThreshold) {
        return this.getMaxPointValue() < dislikeThreshold.getMaxPointValue();
    }

    @Override
    public String toString() {
        return movieCharacteristic.name().toLowerCase().replaceAll("[_+]", " ");
    }
}
