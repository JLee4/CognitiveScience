import schemas.User;

public class Rules {

    public static boolean hasFreeTime(User user) {
        return user.getFreeTime() != User.FreeTime.NONE;
    }

    public static void chooseMovieBasedOnGroupSize(User user) {
        
    }

    public static void chooseMovieBasedOnRecommendation(User user) {

    }

    public static void chooseMoviedOnSavedList(User user) {

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
}
