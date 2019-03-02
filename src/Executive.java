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

        if (user.getGroup().getGroupSize() > 1 && !user.getGroup().isWithFamily()) {
            System.out.println("Since I'm with friends, I'll choose a comedy or a horror.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getGenre() != Genre.COMEDY && movie.getGenre() != Genre.HORROR) {
                    iterator.remove();
                }
            }
        }

        if (user.getGroup().getGroupSize() > 1 && user.getGroup().isWithFamily()) {
            System.out.println("Since I'm with family, I will choose a movie with less dark themes.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getAtmosphere() == Film.Atmosphere.OFFENSIVE || movie.getAtmosphere() == Film.Atmosphere.GRIM || movie.getAtmosphere() == Film.Atmosphere.MELANCHOLIC) {
                    iterator.remove();
                }
            }
        }

        if (user.getGroup().getGroupSize() == 2 && user.getGroup().isWithSignificantOther()) {
            System.out.println("Since I'm with my significant other, I will choose a romantic movie.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getGenre() != Genre.ROMANTIC_COMEDY && movie.getGenre() != Genre.ROMANTIC) {
                    iterator.remove();
                }
            }
        }

        if (user.getGroup().getGroupSize() == 1) {
            System.out.println("Since I'm alone, I will prefer a " + user.preferredGeneresToString() + " movie.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (!user.getPreferredGenres().contains(movie.getGenre())) {
                    iterator.remove();
                }
            }
        }

        if (user.getAttention() == User.Attention.LITTLE) {
            System.out.println("I won't be paying much attention to the movie so I'll put on a lighthearted movie.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getAtmosphere() != Film.Atmosphere.CHEERFUL && movie.getAtmosphere() != Film.Atmosphere.HUMOROUS) {
                    iterator.remove();
                }
            }
        }

        if (user.getMood() == User.Mood.HAPPY) {
            System.out.println("I'm feeling happy right now, so I'll put on something romantic, lighthearted, or maybe idyllic.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getAtmosphere() != Film.Atmosphere.CHEERFUL && movie.getAtmosphere() != Film.Atmosphere.HUMOROUS
                        && movie.getAtmosphere() != Film.Atmosphere.IDYLLIC) {
                    iterator.remove();
                }
            }
        }

        if (user.getMood() == User.Mood.BORED) {
            System.out.println("I'm feeling particularly bored. I really wanna watch something that makes me feel emotional in some way.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getAtmosphere() != Film.Atmosphere.MELANCHOLIC) {
                    iterator.remove();
                }
            }
        }

        if (user.getMood() == User.Mood.SAD) {
            System.out.println("I feel pretty sad. I need to watch something to brighten up my day or something exciting.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getAtmosphere() == Film.Atmosphere.MELANCHOLIC || movie.getAtmosphere() == Film.Atmosphere.MYSTERIOUS
                        || movie.getAtmosphere() == Film.Atmosphere.OFFENSIVE || movie.getAtmosphere() == Film.Atmosphere.GRIM) {
                    iterator.remove();
                }
            }
        }

        if (user.getMood() == User.Mood.STRESSED) {
            System.out.println("I'm so stressed today, I need to watch something cathartic.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getAtmosphere() != Film.Atmosphere.IDYLLIC && movie.getAtmosphere() != Film.Atmosphere.CHEERFUL
                        && movie.getAtmosphere() != Film.Atmosphere.HUMOROUS) {
                    iterator.remove();
                }
            }
        }

        if (user.getMood() == User.Mood.USUAL) {
            System.out.println("My mood is like usual, I don't need to watch anything to change my mood. I'll just stick with my favorite genres");
        }


    }

    private static boolean hasFreeTime() {
        return user.getFreeTime().getHours() != 0 && user.getFreeTime().getMinutes() != 0;
    }

    private static void chooseMovieBasedOnRecommendation() {
        // the system will isolate movies that align with the constraints
        // printed below based on recommendation

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
