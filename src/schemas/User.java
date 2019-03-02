package schemas;

import java.util.List;

public class User {

    public enum Mood {
        USUAL,
        SAD,
        HAPPY,
        STRESSED,
        CATHARTIC
    }

    public enum Attention { //TODO: pull this out and make it a class with preferred genres on the level of attention
        LITTLE,
        MEDIUM,
        FULL
    }

    //Determines whether or not the user checks this element of the movie
    public enum Checks {
        PREVIEW,
        COVER_PHOTO,
        SUMMARY,
        CAST
    }

    private Mood mood;
    private FreeTime freeTime;
    private Group group;
    private Attention attention;
    private List<Film> seenMovies;
    private boolean usesSavedList;
    private List<Film> savedMovies;
    //private Film currentFilm;
    private List<Genre> preferredGenres;
    private List<Checks> checks;

    public User(Mood mood, FreeTime freeTime, Group group, Attention attention, List<Film> seenMovies, boolean usesSavedList, List<Film> savedMovies, List<Genre> preferredGenres, List<Checks> checks) {
        this.mood = mood;
        this.freeTime = freeTime;
        this.group = group;
        this.attention = attention;
        this.seenMovies = seenMovies;
        this.usesSavedList = usesSavedList;
        this.savedMovies = savedMovies;
        this.preferredGenres = preferredGenres;
        this.checks = checks;
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
    
    public List<Genre> getPreferredGenre() {
        return preferredGenres;
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

    public boolean isUsesSavedList() {
        return usesSavedList;
    }

    public void setUsesSavedList(boolean usesSavedList) {
        this.usesSavedList = usesSavedList;
    }

    public void setsavedMovies(List<Film> savedMovies) {
        this.savedMovies = savedMovies;
    }

    public List<Genre> getPreferredGenres() {
        return preferredGenres;
    }

    public void setPreferredGenres(List<Genre> preferredGenres) {
        this.preferredGenres = preferredGenres;
    }

    @Override
    public String toString() {
        return
            "User: \n" +
            "\nMood: " + mood +
            ",\nFree Time: " + freeTime.toString() +
            ",\nGroup Size: " + group.getGroupSize() +
            ",\nWith Significant Other: " + group.isWithSignificantOther() +
            ",\nWith Family: " + group.isWithFamily() +
            ",\nAttention: " + attention +
            ",\nMovies Seen: [" + seenMoviesToString() +
            "],\nUses Saved List: " + usesSavedList +
            ",\nSaved Movies: [" + savedMoviesToString() +
            "],\nPreferred Genres: [" + preferredGeneresToString() + "]\n";
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
        for (int i = 0; i < preferredGenres.size() - 1; i++) {
            Genre genre = preferredGenres.get(i);
            if (i == preferredGenres.size() - 2) {
                stringBuilder.append("or ");
                stringBuilder.append(genre.name());
            } else {
                stringBuilder.append(genre.name());
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
