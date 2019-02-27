import java.util.List;
import schemas.CastMember;
import schemas.Film;
import schemas.Rating;
import schemas.Summary;
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
        // the system will isolate movies that align with the constraints
        // printed below based on recommendation
        
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
    
    public static void chooseMovieBasedOnPreferredGenre(User user) {
        // based on the preferred genres of the user the system will 
        // isolate the movies that align with the constraints printed below
        if (user.getPreferredGenre().contains("Comedy")) {
            System.out.println("Watch a comedy movie");
        } else if (user.getPreferredGenre().contains("Drama")) {
            System.out.println("Watch a drama movie");
        } else if (user.getPreferredGenre().contains("Horror")) {
            System.out.println("Watch a horror movie");
        }
    }
    
    public static void chooseMovieBasedOnMood(User user) {
        // based on mood the system will isolate the movies 
        // that align with the constraints printed below
        if (user.getMood() == User.Mood.HAPPY) {
            System.out.println("Watch a comedy or rom-com movie");
        } else if (user.getMood() == User.Mood.SAD) {
             System.out.println("Watch a drama movie");
        }  else if (user.getMood() == User.Mood.STRESSED) {
             System.out.println("Watch a comedy or action movie");
        } 
    }               

    public static void chooseMovieBasedOnRating(Film film) {
        // the system will isolate movies that align with the constraints
        // printed below based on Rating
        if (film.getRating() == Rating.THREE_STARS || film.getRating() == Rating.TWO_STARS || film.getRating() == Rating.ONE_STAR) {
            System.out.println("Movies with 1, 2 or 3 stars will be eliminated from potential watch list.");
        }
    }
                   
    public static void chooseMovieBasedOnSummary(Film film) {
        // the system will isolate movies that align with the constraints
        // printed below based on the Summary
        if (film.getSummary().getHookLevel() == Summary.Hook.BAD) {
            System.out.println("movie with a bad hook will be eliminated from potential watch list.");
        } 
    }
                   
    public static void chooseMovieBasedOnCastMember(CastMember castMember) {
        // the system will isolate movies that align with the constraints
        // printed below based on the Cast Member
        if (castMember.getReputation() == CastMember.Reputation.BAD || castMember.getReputation() == CastMember.Reputation.AWFUL) {
            System.out.println("a movie that has a cast member whose reputation is bad or awful will be eliminate from potential watch list.");
        }
    }
    
    public static void chooseMovieBasedOnCoverPhoto(CoverPhoto coverPhoto) {
        // the system will isolate movies that align with the constraints
        // printed below based on the Cover Photo
        if (coverPhoto.getMovieRelation() == CoverPhoto.MovieRelation.REVEALS_ACTORS|| coverPhoto.getMovieRelation() == CoverPhoto.MovieRelation.REVEALS_PLOT 
                    || coverPhoto.getMovieRelation() == CoverPhoto.MovieRelation.REVEALS_PLOT_ACTORS) {
            System.out.println("a movie that has a coverphoto that does not reveal attractive actors will be eliminated from potential watch list.);
            System.out.println("DISCLAIMER: attraction is subjective!);
        }
        
    }
    public static void addMovieToSavedList(User user) {

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
