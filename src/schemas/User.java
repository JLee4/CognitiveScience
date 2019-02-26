package schemas;

import java.util.ArrayList;
import java.util.List;

public class User {

    public enum Mood {
        USUAL,
        SAD,
        HAPPY,
        CATHARTIC
    }
    public enum FreeTime {
        NONE,
        ONE_HOUR,
        TWO_HOURS,
        THREE_HOURS,
        MORE_THAN_THREE_HOURS
    }
    public enum GroupSize {
        ALONE,
        PAIR,
        WITH_ROMANTIC_PARTNER,
        SMALL_GROUP,
        MEDIUM_GROUP,
        LARGE_GROUP
    }
    public enum Attention {
        NONE,
        LITTLE,
        MEDIUM,
        FULL
    }

    private Mood mood;
    private FreeTime freeTime;
    private GroupSize groupSize;
    private Attention attention;
    private List<Film> seenMovies;
    private List<String> moviePreferences;
    private List<Film> savedFilms;
    private Film currentFilm;

    public User(Mood mood, FreeTime freeTime, GroupSize groupSize, Attention attention, Film currentFilm) {
        this.mood = mood;
        this.freeTime = freeTime;
        this.groupSize = groupSize;
        this.attention = attention;
        this.seenMovies = new ArrayList<>();
        this.moviePreferences = new ArrayList<>();
        this.savedFilms = new ArrayList<>();
        this.currentFilm = currentFilm;
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

    public GroupSize getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(GroupSize groupSize) {
        this.groupSize = groupSize;
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

    public List<String> getMoviePreferences() {
        return moviePreferences;
    }

    public void addPreferredGenre(String preferredGenre) {
        preferredGenre.add(preferredGenre);
    }
    
    public List<String> getPreferredGenre() {
        return preferredGenre;
    }

    public void addMoviePreference(String moviePreference) {
        moviePreferences.add(moviePreference);
    }

    public List<Film> getSavedFilms() {
        return savedFilms;
    }

    public void addSavedFilms(Film savedFilm) {
        this.savedFilms.add(savedFilm);
    }

    public Film getCurrentFilm() {
        return currentFilm;
    }

    public void setCurrentFilm(Film currentFilm) {
        this.currentFilm = currentFilm;
    }
}
