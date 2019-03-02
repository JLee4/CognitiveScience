import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import personas.Persona1;
import personas.Persona2;
import personas.Persona3;
import personas.Persona4;
import personas.Persona5;
import personas.PopulateMovies;
import schemas.Film;
import schemas.Genre;
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
            System.out.println("I don't have enough free time to even choose a movie....");
            exit(0);
        }

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

        for (Film movie : movies) {
            if (user.getChecks().contains(User.Checks.COVER_PHOTO)) {
                if (movie.getCoverPhoto().getAppeal().getLevel() > 0) {
                    System.out.println(movie.getName() + "'s cover photo is neat.");
                    user.setChosenFilm(movie);
                } else {
                    System.out.println(movie.getName() + "'s cover photo looks bad.");
                    continue;
                }
            }

            if (user.getChecks().contains(User.Checks.PREVIEW)) {
                if (movie.getPreview().getAppeal().getLevel() > 0) {
                    System.out.println("The preview is good.");
                    user.setChosenFilm(movie);
                } else {
                    System.out.println("Preview was " + movie.getPreview().getAppeal().toString());
                    user.setChosenFilm(null);
                }
            }

            if (user.getChecks().contains(User.Checks.SUMMARY)) {
                if (movie.getSummary().getHookLevel().ordinal() > 0) {
                    System.out.println("Summary is interesting too.");
                    user.setChosenFilm(movie);
                } else {
                    System.out.println("The summary is just not good.");
                    user.setChosenFilm(null);
                }
            }

            if (user.getChecks().contains(User.Checks.RATING)) {
                if (movie.getRating().getRatingLevel() >= user.getMinimumRating()) {
                    System.out.println("People seem to rate " + movie.getName() + " well.;");
                    user.setChosenFilm(movie);
                } else {
                    System.out.println(movie.getName() + " is rated too low.");
                    user.setChosenFilm(null);
                }
            }

            if (user.getChecks().contains(User.Checks.CAST)) {
                if (movie.getCast().getActors().retainAll(user.getLikedActors())) {
                    System.out.println("I like the actors in " + movie.getName());
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


        //TODO: So I’m thinking if the user uses the saved list of movies then we can create a scenario where the user
        // has saved the movie they were watching for later because they didn’t have enough free time then we can output
        // that some time has passed and the user wants to continue
//        if (user.usesSavedList() && user.getFreeTime().getHours() < 2 && user.hasChosenMovie()) {
//            System.out.println("I don't have time to watch all of " + user.getChosenFilm().getName() + " so I'll add it to my saved list");
//        }

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
