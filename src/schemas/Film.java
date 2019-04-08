package schemas;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Film extends Media {

    public enum Age {
        NEW,
        SOMEWHAT_NEW,
        SOMEWHAT_OLD,
        OLD;

        public int getPointLevel() {
            switch(this) {
                case NEW:
                    return 0;
                case SOMEWHAT_NEW:
                    return 50;
                case SOMEWHAT_OLD:
                    return 70;
                case OLD:
                    return 80;
            }
            return 0;
        }
    }

    public enum StreamingCategory {
        FEATURED,
        RECOMMENDED,
        NEW
    }

    public enum Atmosphere {
        CHEERFUL,
        HUMOROUS,
        IDYLLIC,
        CHAOTIC,
        MELANCHOLIC,
        MYSTERIOUS,
        OFFENSIVE,
        GRIM
    }

    private Duration length;
    private Rating rating;
    private AgeRating ageRating;
    private List<Genre> genres;
    private GoreAmount goreAmount;
    private Atmosphere atmosphere;
    private Age age;
    private List<StreamingCategory> categories;
    private Preview preview;
    private Summary summary;
    private CoverPhoto coverPhoto;
    private Cast cast;
    private Book book;

    public Film(String name, MediaType type, String language, Duration length, Rating rating, AgeRating ageRating,
                List<Genre> genres, GoreAmount goreAmount, Atmosphere atmosphere, Age age, Preview preview, Summary summary,
                CoverPhoto coverPhoto, Cast cast, Book book) {
        super(name, type, language);
        this.length = length;
        this.rating = rating;
        this.ageRating = ageRating;
        this.genres = genres;
        this.goreAmount = goreAmount;
        this.atmosphere = atmosphere;
        this.age = age;
        this.categories = new ArrayList<>();
        this.preview = preview;
        this.summary = summary;
        this.coverPhoto = coverPhoto;
        this.cast = cast;
        this.book = book;
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

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public GoreAmount getGoreAmount() {
        return goreAmount;
    }

    public void setGoreAmount(GoreAmount goreAmount) {
        this.goreAmount = goreAmount;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
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

    public boolean hasBook() {
        return book != null;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        String book = null;
        if (getBook() != null) {
            book = "\n    Name: " + getBook().getName() +
                    "\n    Popularity Rank: " + getBook().getPopularityRank() +
                    "\n    Reading Difficulty: " + getBook().getReadingDifficulty() +
                    "\n    Word Length: " + getBook().getWordLength();
        }
        return
            "\nName: " + getName() +
            "\nLanguage: " + getLanguage() +
            "\nDuration: " + LocalTime.MIDNIGHT.plus(getLength()).format(DateTimeFormatter.ofPattern("HH:mm")) + //This is really hacky btw
            "\nRating: " + getRating().name() +
            "\nAge Rating: " + getAgeRating().name() +
            "\nGenre: [" + genresToString() +
            "]\nGore Amount: " + getGoreAmount().name() +
            "\nAtmosphere: " + getAtmosphere() +
            "\nMovie Age: " + getAge().name() +
            "\nMovie Categories: " + categoriesToString() +
            "\nPreview: " +
            "\n    Duration: " + LocalTime.MIDNIGHT.plus(getPreview().getLength()).format(DateTimeFormatter.ofPattern("HH:mm")) +
            "\n    Appeal: " + getPreview().getAppeal().getAppealLevel().toString() +
            "\nSummary: " +
            "\n    Word Length: " + getSummary().getSummaryWordLength() +
            "\n    Comprehensive: " + getSummary().getComprehensive().name() +
            "\n    Hook Quality: " + getSummary().getHookLevel().name() +
            "\n    Reading Difficulty: " + getSummary().getReadingDifficulty().name() +
            "\nCover Photo: " +
            "\n    Complexity: " + getCoverPhoto().getComplexity().name() +
            "\n    Iconography: " + getCoverPhoto().getIconography().name() +
            "\n    Appeal Level: " + getCoverPhoto().getAppeal().toString() +
            "\nCast: " +
            "\n    Director: " + getCast().getDirector().getName() + ", Reputation: "
                    + getCast().getDirector().getReputation().name() + ", "
                    + getCast().getDirector().getFame() +
            "\n    Actors: " + actorsToString() +
            "\nBook: " + book;


    }

    private String actorsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Actor actor : getCast().getActors()) {
            stringBuilder.append(actor.getName());
            stringBuilder.append(", Reputation: ");
            stringBuilder.append(actor.getReputation().name());
            stringBuilder.append(", ");
            stringBuilder.append(actor.getFame().name());
            stringBuilder.append("; ");
        }
        return stringBuilder.toString();
    }

    public String actorNamesToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Actor actor : getCast().getActors()) {
            stringBuilder.append(actor.getName());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    public String categoriesToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (StreamingCategory category : categories) {
            stringBuilder.append(category.name());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    public String genresToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Genre genre : genres) {
            stringBuilder.append(genre.name());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Film)) return false;
        Film film = (Film) o;
        return Objects.equals(getName(), film.getName());
    }
}
