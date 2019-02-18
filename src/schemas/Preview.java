package schemas;

import java.time.Duration;

public class Preview {
    private Duration length;
    private Rating rating;
    private GoreAmount goreAmount;
    private String atmosphere;
    private AgeRating ageRating;

    public Preview(Duration length, Rating rating, GoreAmount goreAmount, String atmosphere, AgeRating ageRating) {
        this.length = length;
        this.rating = rating;
        this.goreAmount = goreAmount;
        this.atmosphere = atmosphere;
        this.ageRating = ageRating;
    }

    public Duration getLength() {
        return length;
    }

    public void setLength(Duration length) {
        this.length = length;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public GoreAmount getGoreAmount() {
        return goreAmount;
    }

    public void setGoreAmount(GoreAmount goreAmount) {
        this.goreAmount = goreAmount;
    }

    public String getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(String atmosphere) {
        this.atmosphere = atmosphere;
    }

    public AgeRating getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }
}
