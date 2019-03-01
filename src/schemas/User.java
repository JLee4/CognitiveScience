package schemas;

import java.util.ArrayList;
import java.util.List;

public class User {

    public enum Mood {
        USUAL,
        SAD,
        HAPPY,
        STRESSED,
        CATHARTIC
    }
    public enum FreeTime {
        NONE,
        ONE_HOUR,
        TWO_HOURS,
        THREE_HOURS,
        MORE_THAN_THREE_HOURS
    }

    public enum Attention {
        LITTLE,
        MEDIUM,
        FULL
    }

    private Mood mood;
    private FreeTime freeTime;
    private Group group;
    private Attention attention;
    private List<Film> seenMovies;
    private List<String> moviePreferences;
    private List<Film> savedFilms;
    //private Film currentFilm;
    private List<String> preferredGenres;

    public User(Mood mood, FreeTime freeTime, Group group, Attention attention, List<String> genres) {
        this.mood = mood;
        this.freeTime = freeTime;
        this.group = group;
        this.attention = attention;
        this.seenMovies = new ArrayList<>();
        this.moviePreferences = new ArrayList<>();
        this.savedFilms = new ArrayList<>();
        //this.currentFilm = currentFilm;
        this.preferredGenres = genres;
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

    public List<String> getMoviePreferences() {
        return moviePreferences;
    }

    public void addPreferredGenre(String preferredGenre) {
        preferredGenres.add(preferredGenre);
    }
    
    public List<String> getPreferredGenre() {
        return preferredGenres;
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
}
