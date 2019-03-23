package schemas;

public class DislikeThreshold {

    private int minimumValue;
    private String movieCharacteristic;

    public DislikeThreshold(int minimumValue, String movieCharacteristic) {
        this.minimumValue = minimumValue;
        this.movieCharacteristic = movieCharacteristic;
    }

    public int getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(int minimumValue) {
        this.minimumValue = minimumValue;
    }

    public String getMovieCharacteristic() {
        return movieCharacteristic;
    }

    public void setMovieCharacteristic(String movieCharacteristic) {
        this.movieCharacteristic = movieCharacteristic;
    }
}
