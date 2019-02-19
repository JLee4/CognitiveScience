import java.util.List;
import schemas.Film;
import schemas.User;

public class Executive {

    private static User user;
    private static List<Film> movies;

    public static boolean hasFreeTime(User user) {
        return user.getFreeTime() != User.FreeTime.NONE;
    }

    public static void chooseMovieBasedOnGroupSize(User user) {
        
    }

    public static void chooseMovieBasedOnRecommendation(User user) {

    }

    public static void chooseMovieBasedOnSavedList(User user) {

    }

    public static void chooseMovieBasedOnAttention(User user) {

    }

    public static void AddMovieToSavedList(User user) {

    }

    public static void rewatchMovie(User user) {

    }

    public static void quitMovie(User user) {
        user.setCurrentFilm(null);
    }

    public static void initializePersona1() {

    }

    public static void initializePersona2() {

    }

    public static void initializePersona3() {

    }

    public static void initializePersona4() {

    }
}
