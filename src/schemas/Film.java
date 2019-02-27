package schemas;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Film extends Media {

    public enum Age {
        NEW,
        SOMEWHAT_NEW,
        SOMEWHAT_OLD,
        OLD
    }
    public enum StreamingCategory {
        FEATURED,
        RECOMMENDED,
        NEW
    }

    private Duration length;
    private Rating rating;
    private AgeRating ageRating;
    private Genre genre;
    private GoreAmount goreAmount;
    private String atmosphere;
    private Age age;
    private List<StreamingCategory> categories;
    private Preview preview;
    private Summary summary;
    private CoverPhoto coverPhoto;
    private Cast cast;

    public Film(String name, Type type, String language, Duration length, Rating rating, AgeRating ageRating, Genre genre, GoreAmount goreAmount, String atmosphere, Age age, Preview preview, Summary summary, CoverPhoto coverPhoto, Cast cast) {
        super(name, type, language);
        this.length = length;
        this.rating = rating;
        this.ageRating = ageRating;
        this.genre = genre;
        this.goreAmount = goreAmount;
        this.atmosphere = atmosphere;
        this.age = age;
        this.categories = new ArrayList<>();
        this.preview = preview;
        this.summary = summary;
        this.coverPhoto = coverPhoto;
        this.cast = cast;
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

    public AgeRating getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(AgeRating ageRating) {
        this.ageRating = ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public List<StreamingCategory> getCategories() {
        return categories;
    }

    public void addCategory(StreamingCategory category) {
        this.categories.add(category);
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public CoverPhoto getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(CoverPhoto coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public Cast getCast() {
        return cast;
    }

    public void setCast(Cast cast) {
        this.cast = cast;
    }
}
