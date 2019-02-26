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
        if (user.getGroupSize() != User.GroupSize.ALONE) {
            System.out.println("Watch a comedy or horror movie");
        }
    }

    public static void chooseMovieBasedOnRecommendation(User user) {

    }

    public static void chooseMovieBasedOnSavedList(User user) {

    }

    public static void chooseMovieBasedOnAttention(User user) {
        // based on attention level the system will isolate the movies 
        // that align with the constraints printed below
        if (user.getAttention() == User.Attention.LITTLE) {
            System.out.println("Watch a comedy or rom-com movie");
        } else if (user.getAttention() == User.Attention.FULL) {
             System.out.println("Watch a drama or action movie");
        }
    }

    public static void addMovieToSavedList(User user) {

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
