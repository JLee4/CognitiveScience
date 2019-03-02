import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import personas.Persona1;
import personas.Persona2;
import personas.Persona3;
import personas.Persona4;
import personas.Persona5;
import personas.PopulateMovies;
import schemas.CastMember;
import schemas.CoverPhoto;
import schemas.Film;
import schemas.Genre;
import schemas.Rating;
import schemas.Summary;
import schemas.User;

import static java.lang.System.exit;

class Executive {

    private static User user = null;
    private static List<Film> movies;

    /**
     * executive provides the overall management of the task and makes decisions on current state
     * no other method/class should call this method except main() in Main.java
     * @param persona number of the persona invoked
     * @param isVerbose print verbose outputs including movie details and persona details
     */
    static void executive(int persona, boolean isVerbose) {
        movies = PopulateMovies.populateMovies(isVerbose);
        switch (persona) {
            case 1:
                user = Persona1.createUser();
                break;
            case 2:
                user = Persona2.createUser();
                break;
            case 3:
                user = Persona3.createUser();
                break;
            case 4:
                user = Persona4.createUser();
                break;
            case 5:
                user = Persona5.createUser();
                break;
            default:
                System.out.println("You must input a valid number of a persona as an argument.");
                exit(0);
        }

        if (isVerbose) {
            System.out.println(user.toString() + "\n");
            int i = 1;
            for (Film movie: movies) {
                System.out.println("Movie " + i + ":");
                System.out.println(movie.toString());
                System.out.println();
                i++;
            }
        }

        if (!hasFreeTime()) {
            System.out.println("I don't have enough free time to watch a movie....");
            exit(0);
        }

        //If with friends but not family
        if (user.getGroup().getGroupSize() > 1 && !user.getGroup().isWithFamily()) {
            System.out.println("Since I'm with friends, I'll choose a comedy or a horror.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getGenre() != Genre.COMEDY || movie.getGenre() != Genre.HORROR) {
                    iterator.remove();
                }
            }
        }

        if (user.getGroup().getGroupSize() == 1) {
            System.out.println("Since I'm alone, I will choose a " + user.preferredGeneresToString() + " movie");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getGenre() != Genre.COMEDY || movie.getGenre() != Genre.HORROR) {
                    iterator.remove();
                }
            }
        }

        if (user.getAttention() == User.Attention.LITTLE) {

        }
    }

    private static boolean hasFreeTime() {
        return user.getFreeTime().getHours() != 0 && user.getFreeTime().getMinutes() != 0;
    }

    private static void chooseMovieBasedOnRecommendation() {
        // the system will isolate movies that align with the constraints
        // printed below based on recommendation
        
    }

    private static void chooseMovieBasedOnAttention() {
        // based on attention level the system will isolate the movies 
        // that align with the constraints printed below
        if (user.getAttention() == User.Attention.LITTLE) {
            System.out.println("Watch a comedy or rom-com movie");
        } else if (user.getAttention() == User.Attention.FULL) {
             System.out.println("Watch a drama or action movie");
        }
    }
    
    private static void chooseMovieBasedOnPreferredGenre() {
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
    
    private static void chooseMovieBasedOnMood() {
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

    private static void chooseMovieBasedOnRating(Film film) {
        // the system will isolate movies that align with the constraints
        // printed below based on Rating
        if (film.getRating() == Rating.THREE_STARS || film.getRating() == Rating.TWO_STARS || film.getRating() == Rating.ONE_STAR) {
            System.out.println("Movies with 1, 2 or 3 stars will be eliminated from potential watch list.");
        }
    }
                   
    private static void chooseMovieBasedOnSummary(Film film) {
        // the system will isolate movies that align with the constraints
        // printed below based on the Summary
        if (film.getSummary().getHookLevel() == Summary.Hook.BAD) {
            System.out.println("movie with a bad hook will be eliminated from potential watch list.");
        } 
    }
                   
    private static void chooseMovieBasedOnCastMember(CastMember castMember) {
        // the system will isolate movies that align with the constraints
        // printed below based on the Cast Member
        if (castMember.getReputation() == CastMember.Reputation.BAD || castMember.getReputation() == CastMember.Reputation.AWFUL) {
            System.out.println("a movie that has a cast member whose reputation is bad or awful will be eliminate from potential watch list.");
        }
    }
    
    private static void chooseMovieBasedOnCoverPhoto(CoverPhoto coverPhoto) {
        // the system will isolate movies that align with the constraints
        // printed below based on the Cover Photo
        if (coverPhoto.getMovieRelation() == CoverPhoto.MovieRelation.REVEALS_ACTORS|| coverPhoto.getMovieRelation() == CoverPhoto.MovieRelation.REVEALS_PLOT 
                    || coverPhoto.getMovieRelation() == CoverPhoto.MovieRelation.REVEALS_PLOT_ACTORS) {
            System.out.println("a movie that has a coverphoto that does not reveal attractive actors will be eliminated from potential watch list.");
            System.out.println("DISCLAIMER: attraction is subjective!");
        }
        
    }

    private static void addMovieToSavedList() {

    }

    private static void chooseMovieBasedOnSavedList() {

    }
}
