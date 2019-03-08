import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import personas.Persona;
import personas.PopulateMovies;
import schemas.Actor;
import schemas.Fame;
import schemas.Film;
import schemas.Genre;
import schemas.User;

import static java.lang.System.exit;

class Executive {

    private static User user = null;
    private static List<Film> movies;
    private static final int NUM_PERSONAS = 5; //NOTE: NUM_PERSONAS should be updated every time a persona is added

    //Overloaded method that considers is runAll is true.
    public static void executive(int persona, boolean isVerbose, boolean runAll) {
        if (runAll) {
            for (int i = 1; i < NUM_PERSONAS + 1; i++) {
                executive(i, isVerbose);
            }
        } else {
            executive(persona, isVerbose);
        }
    }
    /**
     * executive provides the overall management of the task and makes decisions on current state
     * no other method/class should call this method except main() in Main.java
     * @param persona number of the persona invoked
     * @param isVerbose print verbose outputs including movie details and persona details
     */
    public static void executive(int persona, boolean isVerbose) {
        movies = PopulateMovies.populateMovies(isVerbose);
        switch (persona) {
            case 1:
                user = Persona.createUser1();
                break;
            case 2:
                user = Persona.createUser2();
                break;
            case 3:
                user = Persona.createUser3();
                break;
            case 4:
                user = Persona.createUser4();
                break;
            case 5:
                user = Persona.createUser5();
                break;
            default:
                System.out.println("You must input a valid number of a persona as an argument.");
                exit(0);
        }

        if (isVerbose) {
            int i = 1;
            for (Film movie: movies) {
                System.out.println("Movie " + i + ":");
                System.out.println(movie.toString());
                System.out.println();
                i++;
            }
            System.out.println(user.toString() + "\n");
        }

        //If user doesn't have free time
        if (!hasFreeTime()) {
            System.out.println("I don't have enough free time to even choose a movie....");
            exit(0);
        }

        //Narrows list of movies to only featured movies, meaning only movies seen by user are featured
        List<Film> categorizedMovies = new ArrayList<>();
        if (user.getChecks().contains(User.Checks.FEATURED_MOVIES)) {
            System.out.println("I'll check out the featured movies for something to watch.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getCategories().contains(Film.StreamingCategory.FEATURED)) {
                    categorizedMovies.add(movie);
                }
            }
        }

        //Narrows list of movies to only recommended movies, meaning only movies seen by user are recommended
        if (user.getChecks().contains(User.Checks.RECOMMENDED_MOVIES)) {
            System.out.println("I'll check out the recommended movies for something to watch.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (!movie.getCategories().contains(Film.StreamingCategory.RECOMMENDED)) {
                    categorizedMovies.add(movie);
                }
            }
        }

        //Narrows list of movies to only new movies, meaning only movies seen by user are new
        if (user.getChecks().contains(User.Checks.NEW_MOVIES)) {
            System.out.println("I'll check out the new movies for something to watch.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (!movie.getCategories().contains(Film.StreamingCategory.NEW)) {
                    categorizedMovies.add(movie);
                }
            }
        }

        if (!categorizedMovies.isEmpty()) {
            movies = categorizedMovies;
        }

        //when the group is more than 2 (the user is not alone or with one person), the user starts looking at the horror or comedy movies
        if (user.getGroup().getGroupSize() > 2 && !user.getGroup().isWithFamily()) {
            System.out.println("Since I'm with friends, I'll choose a comedy or a horror.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getGenre() != Genre.COMEDY && movie.getGenre() != Genre.HORROR) {
                    iterator.remove();
                }
            }
        }

        //If user is with family, the user avoids choosing non-family-friendly movies
        if (user.getGroup().getGroupSize() > 1 && user.getGroup().isWithFamily()) {
            System.out.println("Since I'm with family, I will choose a movie with less dark themes.");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getAtmosphere() == Film.Atmosphere.OFFENSIVE || movie.getAtmosphere() == Film.Atmosphere.GRIM || movie.getAtmosphere() == Film.Atmosphere.MELANCHOLIC) {
                    iterator.remove();
                }
                if (movie.getGenre() != Genre.COMEDY || movie.getGenre() != Genre.FAMILY) {
                    iterator.remove();
                }
            }
        }

        //If user is only with significant other, then the user will choose something romantic
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

        //If the user is alone, then they will just narrow the movies down to their preferred genres.
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

        //When users don't pay much attention (e.g. background noise), they choose a lightheated movie.
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

        //If user is happy, then choose happy movies
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

        //If user is bored, then narrow to engaging movies that aren't sad
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

        //If user is sad, then they should decide on movies that uplifts their mood
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

        //If user is stressed, then they will choose a happy movie
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

        //If user's mood is neutral(their usual mood), then they will choose their preferred genres
        if (user.getMood() == User.Mood.USUAL) {
            System.out.println("My mood is like usual, I don't need to watch anything to change my mood. I'll just stick with my favorite genres");
        }

        //Since we are done with narrowing down the movies the user will choose, the user will start choosing a movie
        //based on cover photo, preview, etc.
        for (Film movie : movies) {
            //User checks the cover photo
            if (user.getChecks().contains(User.Checks.COVER_PHOTO)) {
                if (movie.getCoverPhoto().getAppeal().getLevel() > 0) {
                    System.out.println(movie.getName() + "'s cover photo is neat.");
                    user.setChosenFilm(movie);
                } else {
                    System.out.println(movie.getName() + "'s cover photo looks bad.");
                    continue;
                }
            }

            //User has read the book of the movie before
            if (user.getChecks().contains(User.Checks.BOOK)) {
                if (user.getReadBooks().contains(movie.getBook())) {
                    System.out.println("I've read the book for " + movie.getName());
                    user.setChosenFilm(movie);
                } else {
                    System.out.println("I'm a huge reader so I wanna watch the movies of books I've read.");
                    continue;
                }
            }

            //User watches the preview/trailer to see if it's appealing
            if (user.getChecks().contains(User.Checks.PREVIEW)) {
                if (movie.getPreview().getAppeal().getLevel() > 0) {
                    System.out.println("The preview is good.");
                    user.setChosenFilm(movie);
                } else {
                    System.out.println("Preview was " + movie.getPreview().getAppeal().toString());
                    user.setChosenFilm(null);
                }
            }

            //User reads the summary to see if the movie is interesting
            if (user.getChecks().contains(User.Checks.SUMMARY)) {
                if (movie.getSummary().getHookLevel().ordinal() > 0) {
                    System.out.println("Summary is interesting too.");
                    user.setChosenFilm(movie);
                } else {
                    System.out.println("The summary is just not good.");
                    user.setChosenFilm(null);
                }
            }

            //User checks the rating to see if it meets the minimum movie rating they will watch.
            if (user.getChecks().contains(User.Checks.RATING)) {
                if (movie.getRating().getRatingLevel() >= user.getMinimumRating()) {
                    System.out.println("People seem to rate " + movie.getName() + " well.;");
                    user.setChosenFilm(movie);
                } else {
                    System.out.println(movie.getName() + " is rated too low.");
                    user.setChosenFilm(null);
                }
            }

            //User sees if they like any of the actors in the movie
            if (user.getChecks().contains(User.Checks.LIKED_ACTORS)) {
                if (movie.getCast().getActors().retainAll(user.getLikedActors())) {
                    System.out.println("I like the actors in " + movie.getName());
                } else {
                    System.out.println("I don't like the actors.");
                    user.setChosenFilm(null);
                }
            }

            //User sees if there's any famous actors in the movie.
            if (user.getChecks().contains(User.Checks.ACTORS_FAME)) {
                boolean hasAtLeastOneFamousActor = false;
                for (Actor actor : movie.getCast().getActors()) {
                    if (actor.getFame() == Fame.A_LIST) {
                        hasAtLeastOneFamousActor = true;
                        break;
                    }
                }

                if (hasAtLeastOneFamousActor) {
                    System.out.println("They have at least one famous actor in " + movie.getName());
                } else {
                    System.out.println("I don't know any of the actors in " + movie.getName());
                    user.setChosenFilm(null);
                }
            }

            //User sees if they like the director
            if (user.getChecks().contains(User.Checks.DIRECTOR)) {
                if (user.getLikedDirectors().contains(movie.getCast().getDirector())) {
                    System.out.println("Ohhh... I like the director in " + movie.getName());
                } else {
                    System.out.println("I don't like the actors.");
                    user.setChosenFilm(null);
                }
            }

            if (user.getChosenFilm() != null) {
                user.setHasChosenMovie(true);
                break;
            } else {
                System.out.println("There's probably something better than " + movie.getName());
            }
        }

        if (user.hasChosenMovie()) {
            System.out.println("I'm watching " + user.getChosenFilm().getName() + ". It seems pretty entertaining.");
        } else {
            System.out.println("There's no movies I wanna watch, I'll just pick a show instead.");
        }
    }

    private static boolean hasFreeTime() {
        return user.getFreeTime().getHours() != 0 && (user.getFreeTime().getHours() != 0 || user.getFreeTime().getMinutes() != 0);
    }
}
