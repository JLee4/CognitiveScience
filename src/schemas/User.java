package schemas;

import java.util.Arrays;
import java.util.List;

public class User {

    public enum Mood {
        USUAL,
        SAD,
        HAPPY,
        STRESSED,
        BORED
    }

    public enum Attention {
        LITTLE,
        MEDIUM,
        FULL
    }

    //Determines whether or not the user checks this streaming category or element of the movie
    public enum Checks {
        PREVIEW,
        RATING,
        COVER_PHOTO,
        SUMMARY,
        LIKED_ACTORS,
        ACTORS_FAME,
        DIRECTOR,
        FEATURED_MOVIES,
        NEW_MOVIES,
        RECOMMENDED_MOVIES,
        BOOK
    }

    private Mood mood;
    private FreeTime freeTime;
    private Group group;
    private Attention attention;
    private List<Film> seenMovies;
    private boolean usesSavedList;
    private List<Film> savedMovies;
    private List<Genre> preferredGenres;
    private List<Checks> checks;
    private boolean hasChosenMovie;
    private Film chosenFilm;
    private List<Actor> likedActors;
    private List<Director> likedDirectors;
    private int minimumRating;
    private List<Book> readBooks;

    public User(Mood mood, FreeTime freeTime, Group group, Attention attention, List<Film> seenMovies,
                boolean usesSavedList, List<Film> savedMovies, List<Genre> preferredGenres, List<Checks> checks,
                int minimumRating, List<Actor> likedActors, List<Book> readBooks, List<Director> likedDirectors) {
        this.mood = mood;
        this.freeTime = freeTime;
        this.group = group;
        this.attention = attention;
        this.seenMovies = seenMovies;
        this.usesSavedList = usesSavedList;
        this.savedMovies = savedMovies;
        this.preferredGenres = preferredGenres;
        this.checks = checks;
        this.hasChosenMovie = false;
        this.minimumRating = minimumRating;
        this.likedActors = likedActors;
        this.readBooks = readBooks;
        this.likedDirectors = likedDirectors;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public FreeTime getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(FreeTime freeTime) {
        this.freeTime = freeTime;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Attention getAttention() {
        return attention;
    }

    public void setAttention(Attention attention) {
        this.attention = attention;
    }

    public List<Film> getSeenMovies() {
        return seenMovies;
    }

    public void addSeenMovie(Film seenMovie) {
        seenMovies.add(seenMovie);
    }

    public void addPreferredGenre(Genre preferredGenre) {
        preferredGenres.add(preferredGenre);
    }

    public List<Film> getSavedMovies() {
        return savedMovies;
    }

    public void addsSavedMovie(Film savedMovie) {
        this.savedMovies.add(savedMovie);
    }

    public void setSeenMovies(List<Film> seenMovies) {
        this.seenMovies = seenMovies;
    }

    public boolean usesSavedList() {
        return usesSavedList;
    }

    public void setUsesSavedList(boolean usesSavedList) {
        this.usesSavedList = usesSavedList;
    }

    public List<Genre> getPreferredGenres() {
        return preferredGenres;
    }

    public void setPreferredGenres(List<Genre> preferredGenres) {
        this.preferredGenres = preferredGenres;
    }

    public void setSavedMovies(List<Film> savedMovies) {
        this.savedMovies = savedMovies;
    }

    public List<Checks> getChecks() {
        return checks;
    }

    public void setChecks(List<Checks> checks) {
        this.checks = checks;
    }

    public boolean hasChosenMovie() {
        return hasChosenMovie;
    }

    public void setHasChosenMovie(boolean hasChosenMovie) {
        this.hasChosenMovie = hasChosenMovie;
    }

    public Film getChosenFilm() {
        return chosenFilm;
    }

    public void setChosenFilm(Film currentFilm) {
        this.chosenFilm = currentFilm;
    }

    public List<Actor> getLikedActors() {
        return likedActors;
    }

    public void setLikedActors(List<Actor> LikedActors) {
        this.likedActors = LikedActors;
    }

    public int getMinimumRating() {
        return minimumRating;
    }

    public void setMinimumRating(int minimumRating) {
        this.minimumRating = minimumRating;
    }

    public List<Book> getReadBooks() {
        return readBooks;
    }

    public void setReadBooks(List<Book> readBooks) {
        this.readBooks = readBooks;
    }

    public List<Director> getLikedDirectors() {
        return likedDirectors;
    }

    public void setLikedDirectors(List<Director> likedDirectors) {
        this.likedDirectors = likedDirectors;
    }

    @Override
    public String toString() {
        String chosenFilmName = (chosenFilm != null) ? chosenFilm.getName() : "null";
        return
            "User:" +
            "\n    Mood: " + mood +
            ",\n    Free Time: " + freeTime.toString() +
            ",\n    Group Size: " + group.getGroupSize() +
            ",\n    With Significant Other: " + group.isWithSignificantOther() +
            ",\n    With Family: " + group.isWithFamily() +
            ",\n    Attention: " + attention +
            ",\n    Movies Seen: [" + seenMoviesToString() +
            "],\n    Uses Saved List: " + usesSavedList +
            ",\n    Saved Movies: [" + savedMoviesToString() +
            "],\n    Preferred Genres: [" + preferredGeneresToString()  +
            "],\n    User Checks : " + Arrays.toString(checks.toArray()) +
            ",\n    Has Chosen Movie: " + hasChosenMovie +
            ",\n    Chosen Film: " + chosenFilmName +
            ",\n    Liked Actors: [" + likedActorsToString() +
            "],\n    Minimum Rating: " +  minimumRating +
            ",\n    Liked Directors: [" + likedDirectorsToString() +
            "],\n    Books Read: [" + readBooksToString() + "]";

    }

    private String likedActorsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Actor actor : likedActors) {
            stringBuilder.append(actor.getName());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    private String likedDirectorsToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Director director : likedDirectors) {
            stringBuilder.append(director.getName());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    private String readBooksToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : readBooks) {
            stringBuilder.append(book.getName());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }


    private String seenMoviesToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Film movie : seenMovies) {
            stringBuilder.append(movie.getName());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    private String savedMoviesToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Film movie : seenMovies) {
            stringBuilder.append(movie.getName());
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    public String preferredGeneresToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < preferredGenres.size(); i++) {
            Genre genre = preferredGenres.get(i);
            if (i == preferredGenres.size() - 1 && preferredGenres.size() != 1) {
                stringBuilder.append("or ");
                stringBuilder.append(genre.name());
            } else {
                stringBuilder.append(genre.name());
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString().toLowerCase();
    }
}
