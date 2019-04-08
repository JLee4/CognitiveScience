import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import personas.Persona;
import personas.PopulateMovies;
import schemas.Actor;
import schemas.DislikeThreshold;
import schemas.Fame;
import schemas.Film;
import schemas.Genre;
import schemas.GroupMember;
import schemas.User;

class Executive {

    private static User user = null;
    private static List<Film> movies;
    private static Map<Genre, Integer> groupPreferenceCounts;
//    private static final int NUM_PERSONAS = 14; //NOTE: NUM_PERSONAS should be updated every time a persona is added

    //Overloaded method that considers is runAll is true.
    public static void executive(int persona, boolean isVerbose, boolean runAll) {
        movies = PopulateMovies.populateMovies();
        if (isVerbose) {
            int i = 1;
            for (Film movie: movies) {
                System.out.println("Movie " + i + ":");
                System.out.println(movie.toString());
                System.out.println();
                i++;
            }
        }
        user = Persona.createUser();
        Persona.createAgentGroupMembers();
        for (int i = 1; i < 11; i++) {
            user = Persona.changeUserGroup();
            executive(i, isVerbose);
        }
//        if (runAll) {
//            for (int i = 1; i < NUM_PERSONAS + 1; i++) {
//                executive(i, isVerbose);
//            }
//        } else {
//            executive(persona, isVerbose);
//        }
    }
    /**
     * executive provides the overall management of the task and makes decisions on current state
     * no other method/class should call this method except main() in Main.java
     * @param persona number of the persona invoked
     * @param isVerbose print verbose outputs including movie details and persona details
     */
    public static void executive(int persona, boolean isVerbose) {
        movies = PopulateMovies.populateMovies();
        Collections.shuffle(movies);
//        switch (persona) {
//            case 1:
//                user = Persona.createUser1();
//                break;
//            case 2:
//                user = Persona.createUser2();
//                break;
//            case 3:
//                user = Persona.createUser3();
//                break;
//            case 4:
//                user = Persona.createUser4();
//                break;
//            case 5:
//                user = Persona.createUser5();
//                break;
//            case 6:
//                user = Persona.createUser6();
//                break;
//            case 7:
//                user = Persona.createUser7();
//                break;
//            case 8:
//                user = Persona.createUser8();
//                break;
//            case 9:
//                user = Persona.createUser9();
//                break;
//            case 10:
//                user = Persona.createUser10();
//                break;
//            case 11:
//                user = Persona.createUser11();
//                break;
//            case 12:
//                user = Persona.createUser12();
//                break;
//            case 13:
//                user = Persona.createUser13();
//                break;
//            case 14:
//                user = Persona.createUser14();
//                break;
//            default:
//                System.out.println("You must input a valid number of a persona as an argument.");
//                exit(0);
//        }

        if (isVerbose) {
            System.out.println("Run " + persona + ":\n");
            System.out.println(user.toString() + "\n");
        }

        //If user doesn't have free time
        if (!hasFreeTime()) {
            System.out.println("I don't have enough free time to even choose a movie....\n");
            return;
        }

        //Narrows list of movies to only featured movies, meaning only movies seen by user are featured
        List<Film> categorizedMovies = new ArrayList<>();
        if (user.getChecks().contains(User.Checks.FEATURED_MOVIES)) {
            System.out.println("I'll check out the featured movies for something to watch.");
            System.out.println("[COGNITION SYSTEM] Adding featured movies to considered movies");
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
            System.out.println("[COGNITION SYSTEM] Adding recommended movies to considered movies");
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
            System.out.println("[COGNITION SYSTEM] Adding new movies to considered movies");
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

        //If the user is alone, then they will just narrow the movies down to their preferred genres.
        if (user.getGroup().getGroupSize() == 1) {
            System.out.println("Since I'm alone, I will prefer a " + user.preferredGeneresToString() + " movie.");
            System.out.println("[COGNITION SYSTEM] Narrowing movies to only movies with preferred genres");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (Collections.disjoint(movie.getGenres(), user.getPreferredGenres())) {
                    iterator.remove();
                }
            }
        }

        if (user.getGroup().getGroupSize() > 1) {
            Map<String, Set<Genre>> groupPreferences = user.getGroupMemberPreferences();
            Random rand = new Random();
            for (GroupMember groupMember : user.getGroup().getMembers()) {
                List<Genre> preferredGenres = groupMember.getPreferredGenres();
                int randomElementIndex = rand.nextInt(preferredGenres.size());
                int randomElementIndex2 = rand.nextInt(preferredGenres.size());
                while (randomElementIndex == randomElementIndex2) {
                    randomElementIndex2 = rand.nextInt(preferredGenres.size());
                }
                System.out.println("I now know " + groupMember.getName() + " likes " + preferredGenres.get(randomElementIndex));
                System.out.println("[COGNITION SYSTEM] User has learned " + groupMember.getName() + " likes " + preferredGenres.get(randomElementIndex));
                groupPreferences.putIfAbsent(groupMember.getName(), new HashSet<>());
                groupPreferences.get(groupMember.getName()).add(preferredGenres.get(randomElementIndex));
                groupPreferences.get(groupMember.getName()).add(preferredGenres.get(randomElementIndex2));
            }

            groupPreferenceCounts = new HashMap<>();
            for (GroupMember groupMember : user.getGroup().getMembers()) {
                for (Genre genre : groupPreferences.get(groupMember.getName())) {
                    groupPreferenceCounts.putIfAbsent(genre, 0);
                    groupPreferenceCounts.put(genre, groupPreferenceCounts.get(genre) + 1);
                }
                System.out.println("I know " + groupMember.getName() + " does like " + groupPreferences.get(groupMember.getName()));
                System.out.println("[COGNITION SYSTEM] User is cognitively merging group member preferences");
            }

            List<Genre> mergedGenrePreferences = new ArrayList<>();
            for (Map.Entry<Genre, Integer> entry : groupPreferenceCounts.entrySet()) {
                if (entry.getValue() > 1) {
                    mergedGenrePreferences.add(entry.getKey());
                }
            }
            if (!mergedGenrePreferences.isEmpty()) {
                System.out.println("So, I know at least one person likes " + mergedGenrePreferences + " movies.");
                System.out.println("[COGNITION SYSTEM] Most of group has genre preferences in common so the user narrows the movies by genre.");
                Iterator<Film> iterator = movies.iterator();
                while (iterator.hasNext()) {
                    Film movie = iterator.next();
                    if (Collections.disjoint(movie.getGenres(), mergedGenrePreferences)) {
                        iterator.remove();
                    }
                }
            } else {
                System.out.println("No one has any genre preferences in common so I will choose according to my preferences");
                System.out.println("[COGNITION SYSTEM] Narrowing movies to movie genres preferable only to the user");
            }
        }

        //When users don't pay much attention (e.g. background noise), they choose a lightheated movie.
        if (user.getAttention() == User.Attention.LITTLE) {
            System.out.println("I won't be paying much attention to the movie so I'll put on a lighthearted movie.");
            System.out.println("[COGNITION SYSTEM] Narrowing movies to only cheerful or humorous movies");
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
            System.out.println("[COGNITION SYSTEM] Narrowing movies to only cheerful, humorous, or idyllic movies");
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
            System.out.println("[COGNITION SYSTEM] Narrowing movies to exclude melancholic movies");
            Iterator<Film> iterator = movies.iterator();
            while (iterator.hasNext()) {
                Film movie = iterator.next();
                if (movie.getAtmosphere() == Film.Atmosphere.MELANCHOLIC) {
                    iterator.remove();
                }
            }
        }

        //If user is sad, then they should decide on movies that uplifts their mood
        if (user.getMood() == User.Mood.SAD) {
            System.out.println("I feel pretty sad. I need to watch something to brighten up my day or something exciting.");
            System.out.println("[COGNITION SYSTEM] Narrowing movies to exclude melancholic, mysterious, offensive, or grim movies");
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
            System.out.println("[COGNITION SYSTEM] Narrowing movies to only cheerful, humorous, or idyllic movies");
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
            user.setChosenFilm(movie);
            if (user.getBadMovies().contains(movie)) {
                System.out.println("I remember watching " + movie.getName() + ". It was bad.");
                System.out.println("[COGNITION SYSTEM] Moving onto other movies because user remembers it as bad.");
                continue;
            }

            if (hasBadMovieCharacteristic(movie)) {
                System.out.println("[COGNITION SYSTEM] User rejected movie because of a learned bad movie characteristic.");
                continue;
            }

            //User checks the cover photo
            if (user.getChecks().contains(User.Checks.COVER_PHOTO)) {
                if (movie.getCoverPhoto().getAppeal().getLevel() > 0) {
                    System.out.println(movie.getName() + "'s cover photo is neat.");
                    System.out.println("[COGNITION SYSTEM] Moving onto other checks with " + movie.getName() + " because of the cover photo");
                } else {
                    System.out.println(movie.getName() + "'s cover photo looks bad.");
                    System.out.println("[COGNITION SYSTEM] Ignoring " + movie.getName() + " because of the cover photo");
                    continue;
                }
            }

            //User has read the book of the movie before
            if (user.getChecks().contains(User.Checks.BOOK)) {
                if (user.getReadBooks().contains(movie.getBook())) {
                    System.out.println("I've read the book for " + movie.getName());
                    System.out.println("[COGNITION SYSTEM] Moving onto other checks with " + movie.getName() + " because of the book");

                } else {
                    System.out.println("I'm a huge reader so I wanna watch the movies of books I've read.");
                    System.out.println("[COGNITION SYSTEM] Ignoring " + movie.getName() + " because it doesn't have a book");
                    continue;
                }
            }

            //User watches the preview/trailer to see if it's appealing
            if (user.getChecks().contains(User.Checks.PREVIEW)) {
                if (movie.getPreview().getAppeal().getLevel() > 0) {
                    System.out.println("The preview is good.");
                    System.out.println("[COGNITION SYSTEM] Moving onto other checks with " + movie.getName() + " because of the preview/trailer");

                } else {
                    System.out.println("Preview was " + movie.getPreview().getAppeal().toString());
                    System.out.println("[COGNITION SYSTEM] Ignoring " + movie.getName() + " because the preview/trailer wasn't good");
                    user.setChosenFilm(null);
                }
            }

            //User reads the summary to see if the movie is interesting
            if (user.getChecks().contains(User.Checks.SUMMARY)) {
                if (movie.getSummary().getHookLevel().ordinal() > 0) {
                    System.out.println("Summary is interesting too.");
                    System.out.println("[COGNITION SYSTEM] Moving onto other checks with " + movie.getName() + " because of the summary");

                } else {
                    System.out.println("The summary is just not good.");
                    System.out.println("[COGNITION SYSTEM] Ignoring " + movie.getName() + " because the summary wasn't good");
                    user.setChosenFilm(null);
                }
            }

            //User checks the rating to see if it meets the minimum movie rating they will watch.
            if (user.getChecks().contains(User.Checks.RATING)) {
                if (movie.getRating().getRatingLevel() >= user.getMinimumRating()) {
                    System.out.println("People seem to rate " + movie.getName() + " well.");
                    System.out.println("[COGNITION SYSTEM] Moving onto other checks with " + movie.getName() + " because of the rating");
                    user.setChosenFilm(movie);
                } else {
                    System.out.println(movie.getName() + " is rated too low.");
                    System.out.println("[COGNITION SYSTEM] Ignoring " + movie.getName() + " because the rating isn't good");
                    user.setChosenFilm(null);
                }
            }

            //User sees if they like any of the actors in the movie
            if (user.getChecks().contains(User.Checks.ACTORS)) {
                if (!Collections.disjoint(movie.getCast().getActors(), user.getLikedActors())) {
                    System.out.println("I like the actors in " + movie.getName());
                    System.out.println("[COGNITION SYSTEM] Moving onto other checks with " + movie.getName() + " because of the actors");
                } else {
                    System.out.println("I don't like the actors.");
                    System.out.println("[COGNITION SYSTEM] Ignoring " + movie.getName() + " because the actors aren't liked");
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
                    System.out.println("[COGNITION SYSTEM] Moving onto other checks with " + movie.getName() + " because of the actors' fame");
                } else {
                    System.out.println("I don't know any of the actors in " + movie.getName());
                    System.out.println("[COGNITION SYSTEM] Ignoring " + movie.getName() + " because the actors aren't known");
                    user.setChosenFilm(null);
                }
            }

            //User sees if they like the director
            if (user.getChecks().contains(User.Checks.DIRECTOR)) {
                if (user.getLikedDirectors().contains(movie.getCast().getDirector())) {
                    System.out.println("Ohhh... I like the director in " + movie.getName());
                    System.out.println("[COGNITION SYSTEM] Moving onto other checks with " + movie.getName() + " because of the director");
                } else {
                    System.out.println("I don't know the director.");
                    System.out.println("[COGNITION SYSTEM] Ignoring " + movie.getName() + " because the director isn't known");
                    user.setChosenFilm(null);
                }
            }

            if (user.getChosenFilm() != null) {
                user.setHasChosenMovie(true);
                break;
            } else {
                System.out.println("There's probably something better than " + movie.getName());
                System.out.println("[COGNITION SYSTEM] Ignoring " + movie.getName() + " because the user doesn't like what they checked.");
            }
        }

        if (user.hasChosenMovie()) {
            System.out.println("I'm watching \"" + user.getChosenFilm().getName() + "\". It seems pretty entertaining.");
            System.out.println("[COGNITION SYSTEM] The user chose a movie");
            watchMovie();
        } else {
            System.out.println("There's no movies I wanna watch, I'll just pick a show instead.");
            System.out.println("[COGNITION SYSTEM] User finished looking through the list of movies and doesn't like any movie");
        }
        System.out.println("\n");
    }

    private static void watchMovie() {
        Map<User.Checks, DislikeThreshold> dislikes = new HashMap<>();

        int points = calculateDislikePoints(dislikes);

        List<Integer> randomInts = new ArrayList<>();
        for (int i = 0; i < dislikes.size(); i++) {
            randomInts.add(i);
        }
        Collections.shuffle(randomInts);
        DislikeThreshold[] values =  dislikes.values().toArray(new DislikeThreshold[0]);
        if (points > 900) {
            System.out.println("I loved \"" + user.getChosenFilm().getName() + "\". I don't have any complaints about it.");
            System.out.println("[COGNITION SYSTEM] The user loved a movie with no problems.");
        } else if (points > 800) {
            System.out.println("I enjoyed \"" + user.getChosenFilm().getName() + "\". I don't have any complaints about it.");
            System.out.println("[COGNITION SYSTEM] The user enjoyed a movie with no problems.");
        } else if (points > 700 && values.length > 0) {
            System.out.println("I enjoyed \"" + user.getChosenFilm().getName() + "\". It was okay but the "
                    + values[0] + " was bad.");
            System.out.println("[COGNITION SYSTEM] The user enjoyed a movie but had a problem with a movie element");
            user.getBadMoviesCharacteristics().put(values[0].getMovieCharacteristic(), values[0]);
        } else if (points > 600 && values.length > 1) {
            System.out.println(user.getChosenFilm().getName() + " was average. The " + values[0]
                    + " and " + values[1] + " were not good.");
            System.out.println("[COGNITION SYSTEM] The user thought the movie was average with two bad elements.");
            user.getBadMoviesCharacteristics().put(values[0].getMovieCharacteristic(), values[0]);
            user.getBadMoviesCharacteristics().put(values[1].getMovieCharacteristic(), values[1]);
        } else if (points > 500 && values.length > 2) {
            System.out.println("Eh. \"" + user.getChosenFilm().getName() + "\" was below average. The "
                            + values[0] + ", " + values[1] + ", and "
                            + values[2] + " were bad.");
            System.out.println("[COGNITION SYSTEM] The user thought the movie was below average with three problems");
            user.getBadMoviesCharacteristics().put(values[0].getMovieCharacteristic(), values[0]);
            user.getBadMoviesCharacteristics().put(values[1].getMovieCharacteristic(), values[1]);
            user.getBadMoviesCharacteristics().put(values[2].getMovieCharacteristic(), values[2]);
        } else if (points > 400 && values.length > 3) {
            System.out.println("Well. \"" + user.getChosenFilm().getName() + "\" was kind of bad. The "
                    + values[0] + ", " + values[1] + ", "
                    + values[2] + ", and " + values[3] + " were bad.");
            System.out.println("[COGNITION SYSTEM] The user disliked the movie because of 4 movie elements.");
            user.getBadMoviesCharacteristics().put(values[0].getMovieCharacteristic(), values[0]);
            user.getBadMoviesCharacteristics().put(values[1].getMovieCharacteristic(), values[1]);
            user.getBadMoviesCharacteristics().put(values[2].getMovieCharacteristic(), values[2]);
            user.getBadMoviesCharacteristics().put(values[3].getMovieCharacteristic(), values[3]);
            user.getBadMovies().add(user.getChosenFilm());
        } else if (points > 300 && values.length > 4) {
            System.out.println("I didn't think I could make it through \"" + user.getChosenFilm().getName() + "\" The "
                    + values[0] + ", " + values[1] + ", "
                    + values[2] + ", " + values[3] + ", and "
                    + values[4] + " were horrendous.");
            System.out.println("[COGNITION SYSTEM] The user thinks the movie is awful from 4 movie elements.");
            user.getBadMoviesCharacteristics().put(values[0].getMovieCharacteristic(), values[0]);
            user.getBadMoviesCharacteristics().put(values[1].getMovieCharacteristic(), values[1]);
            user.getBadMoviesCharacteristics().put(values[2].getMovieCharacteristic(), values[2]);
            user.getBadMoviesCharacteristics().put(values[3].getMovieCharacteristic(), values[3]);
            user.getBadMoviesCharacteristics().put(values[4].getMovieCharacteristic(), values[4]);
            user.getBadMovies().add(user.getChosenFilm());
        } else if (points > 200 && values.length > 5) {
            System.out.println("Wow. I didn't think it would be that bad." + user.getChosenFilm().getName()
                    + " was truly awful. The "
                    + values[0] + ", " + values[1] + ", "
                    + values[2] + ", " + values[3] + ", "
                    + values[4] + ", and " + values[5] + " were atrocious.");
            System.out.println("[COGNITION SYSTEM] The user hated the movie because of 6 bad movie elements");
            user.getBadMoviesCharacteristics().put(values[0].getMovieCharacteristic(), values[0]);
            user.getBadMoviesCharacteristics().put(values[1].getMovieCharacteristic(), values[1]);
            user.getBadMoviesCharacteristics().put(values[2].getMovieCharacteristic(), values[2]);
            user.getBadMoviesCharacteristics().put(values[3].getMovieCharacteristic(), values[3]);
            user.getBadMoviesCharacteristics().put(values[4].getMovieCharacteristic(), values[4]);
            user.getBadMoviesCharacteristics().put(values[5].getMovieCharacteristic(), values[5]);
            user.getBadMovies().add(user.getChosenFilm());
        } else {
            System.out.println("I can't handle \"" + user.getChosenFilm().getName() + "\". Everything is awful about it.");
            System.out.println("[COGNITION SYSTEM] The user hated the movie and every element of it.");
            user.setBadMoviesCharacteristics(dislikes);
            user.getBadMovies().add(user.getChosenFilm());
        }
    }

    private static boolean hasFreeTime() {
        return user.getFreeTime().getHours() != 0 && (user.getFreeTime().getHours() != 0 || user.getFreeTime().getMinutes() != 0);
    }

    private static boolean hasBadMovieCharacteristic(Film movie) {
        Map<User.Checks, DislikeThreshold> dislikes = user.getBadMoviesCharacteristics();

        System.out.println("[COGNITION SYSTEM] User is doing some research on " + movie.getName() + " for learned bad characteristics.");
        for (DislikeThreshold characteristic : dislikes.values()) {
            if (characteristic.equalsCheck(User.Checks.GORE_AMOUNT) && characteristic.getMaxPointValue() < movie.getGoreAmount().getPointLevel()) {
                System.out.println("The gore amount in \"" + user.getChosenFilm().getName() + "\" is too high");
                System.out.println("[COGNITION SYSTEM] The user dislikes the amount of gore.");
                return true;
            } else if (characteristic.equalsCheck(User.Checks.AGE) && characteristic.getMaxPointValue() < movie.getAge().getPointLevel()) {
                System.out.println(user.getChosenFilm().getName() + " is too old.");
                System.out.println("[COGNITION SYSTEM] The user dislikes the age of the movie.");
                return true;
            } else if (characteristic.equalsCheck(User.Checks.PREVIEW) && characteristic.getMaxPointValue() < movie.getPreview().getAppeal().getPointLevel()) {
                System.out.println("I don't like \"" + user.getChosenFilm().getName() + "\"'s preview.");
                System.out.println("[COGNITION SYSTEM] The user dislikes the movie preview");
                return true;
            } else if (characteristic.equalsCheck(User.Checks.RATING) && characteristic.getMaxPointValue() < movie.getRating().getPointLevel()) {
                System.out.println(user.getChosenFilm().getName() + "'s rating is too low.");
                System.out.println("[COGNITION SYSTEM] The user dislikes the movie's rating");
                return true;
            } else if (characteristic.equalsCheck(User.Checks.COVER_PHOTO) && characteristic.getMaxPointValue() < movie.getCoverPhoto().getAppeal().getPointLevel()) {
                System.out.println(user.getChosenFilm().getName() + "'s cover photo isn't appealing to me.");
                System.out.println("[COGNITION SYSTEM] The user dislikes the movie's cover photo");
                return true;
            } else if (characteristic.equalsCheck(User.Checks.SUMMARY) && characteristic.getMaxPointValue() < movie.getSummary().getPointLevel()) {
                System.out.println(user.getChosenFilm().getName() + "'s summary isn't appealing to me.");
                System.out.println("[COGNITION SYSTEM] The user dislikes the movie summary");
                return true;
            } else if (characteristic.equalsCheck(User.Checks.DIRECTOR) && characteristic.getMaxPointValue() < movie.getCast().getDirector().getPointLevel()) {
                System.out.println("I don't like the movies that " + user.getChosenFilm().getCast().getDirector().getName() + " directs.");
                System.out.println("[COGNITION SYSTEM] The user dislikes the director of the movie.");
                return true;
            } else if (characteristic.equalsCheck(User.Checks.ACTORS_FAME)) {
                for (Actor actor : movie.getCast().getActors()) {
                    if (characteristic.getMaxPointValue() < actor.getFame().getPointLevel()) {
                        System.out.println("I don't know " + actor.getName() + " and I've had bad experiences with unknown actors.");
                        System.out.println("[COGNITION SYSTEM] The user dislikes an actor's level of fame.");
                        return true;
                    }
                }
            } else if (characteristic.equalsCheck(User.Checks.ACTORS)) {
                for (Actor actor : movie.getCast().getActors()) {
                    if (characteristic.getMaxPointValue() < actor.getPointLevel()) {
                        System.out.println("I don't like the movies " + actor.getName() + " is in.");
                        System.out.println("[COGNITION SYSTEM] The user dislikes one of the actors in the movie.");
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private static int calculateDislikePoints(Map<User.Checks, DislikeThreshold> dislikes) {
        int points = 1000;

        Film movie = user.getChosenFilm();
        //Range is
        //1000 - 700: excellent
        //699 - 600: good
        //599 - 500: average
        //499 - 300: bad
        //299 - 0: awful
        int agePoints = movie.getAge().getPointLevel();
        points -= agePoints;
        if (agePoints > 50) {
            dislikes.put(User.Checks.AGE, new DislikeThreshold(User.Checks.AGE, null, agePoints));
        }
        int gorePoints = movie.getGoreAmount().getPointLevel();
        points -= gorePoints;
        if (gorePoints > 50) {
            dislikes.put(User.Checks.GORE_AMOUNT, new DislikeThreshold(User.Checks.GORE_AMOUNT, null, gorePoints));
        }
        int previewPoints = movie.getPreview().getAppeal().getPointLevel();
        points -= previewPoints;
        if (previewPoints > 100) {
            dislikes.put(User.Checks.PREVIEW, new DislikeThreshold(User.Checks.PREVIEW, null, previewPoints));
        }
        int ratingPoints = movie.getRating().getPointLevel();
        points -= ratingPoints;
        if (ratingPoints > 50) {
            dislikes.put(User.Checks.RATING, new DislikeThreshold(User.Checks.RATING, null, ratingPoints));
        }
        int coverPhotoPoints = movie.getCoverPhoto().getAppeal().getPointLevel();
        points -= coverPhotoPoints;
        if (coverPhotoPoints > 0) {
            dislikes.put(User.Checks.COVER_PHOTO, new DislikeThreshold(User.Checks.COVER_PHOTO, null, coverPhotoPoints));
        }
        int summaryPoints = movie.getSummary().getPointLevel();
        points -= summaryPoints;
        if (summaryPoints > 50) {
            dislikes.put(User.Checks.SUMMARY, new DislikeThreshold(User.Checks.SUMMARY, null, summaryPoints));
        }
        int directorPoints = movie.getCast().getDirector().getPointLevel();
        points -= directorPoints;
        if (directorPoints > 100) {
            dislikes.put(User.Checks.DIRECTOR, new DislikeThreshold(User.Checks.DIRECTOR, null, directorPoints));
        }
        for (Actor actor : movie.getCast().getActors()) {
            int actorFamePoints = actor.getFame().getPointLevel();
            points -= actorFamePoints;
            if (actorFamePoints > 50) {
                dislikes.put(User.Checks.ACTORS_FAME, new DislikeThreshold(User.Checks.ACTORS_FAME, null, actorFamePoints));
            }
            int actorPoints = actor.getPointLevel();
            points -= actorPoints;
            if (actorPoints > 50) {
                dislikes.put(User.Checks.ACTORS, new DislikeThreshold(User.Checks.ACTORS, null, actorPoints));
            }
        }
        return (points > 0) ? points : 1000 ;
    }
}
