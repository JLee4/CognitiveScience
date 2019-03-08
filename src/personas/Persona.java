package personas;

import java.util.ArrayList;
import java.util.List;
import schemas.Actor;
import schemas.Book;
import schemas.Director;
import schemas.Fame;
import schemas.FreeTime;
import schemas.Genre;
import schemas.Group;
import schemas.Reputation;
import schemas.User;

public class Persona {

    // Persona 1 is focused on the high-level aspects of movie selection.

    // Persona 1 cares about MOOD and GENRE of a potential movie.

    // Persona 1 does looks at the cover photo but only that

    // Persona 1 is typically in a "happy" mood and enjoys the genres "comedy" and "drama".
    public static User createUser1() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.DRAMA);
        preferredGenres.add(Genre.ANIMATED);
        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        List<Actor> likedActors = new ArrayList<>();
        likedActors.add(new Actor( "Gael Garcia Bernal", Reputation.GOOD, Fame.B_LIST));
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.HAPPY, new FreeTime(2, 0), new Group(1,
                false, false), User.Attention.MEDIUM, new ArrayList<>(),
                false, null, preferredGenres, checks, 3, likedActors, readBooks,
                likedDirectors);
    }


    // Persona 2 is focused on the high-level aspects of movie selection.

    // Persona 2 cares about their MOOD and enjoys all movie GENRES except for "horror".

    // Persona 2 also cares about low-level aspects such as RATING and PLOT SUMMARY.

    // Persona 2 is typically in a "bored" mood and will only watch movies if their rating is over 3 stars.

    // Persona 2 will only watch movies alone.
    public static User createUser2() {
        List<Genre> preferredGenres = new ArrayList<>();
        for (Genre genre : Genre.values()) {
            if (genre != Genre.HORROR) {
                preferredGenres.add(genre);
            }
        }

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.RATING);
        checks.add(User.Checks.SUMMARY);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.BORED, new FreeTime(2, 0), new Group(1,
                false, false), User.Attention.FULL, new ArrayList<>(),
                false, null, preferredGenres, checks, 3, likedActors, readBooks,
                likedDirectors);
    }


    // Persona 3 does not watch many movies, when he/she does, he/she prioritizes the RATING and PLOT SUMMARY of the movie.

    // Persona 3 cares about their MOOD and enjoys all movie GENRES except for "drama" and "thriller"

    // Persona 3 is typically in a "sad" mood and will only watch movies if the cast members are well known.

    // Persona 3 will only watch movies alone.
    public static User createUser3() {
        List<Genre> preferredGenres = new ArrayList<>();
        for (Genre genre : Genre.values()) {
            if (genre != Genre.DRAMA && genre != Genre.THRILLER) {
                preferredGenres.add(genre);
            }
        }

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.RATING);
        checks.add(User.Checks.SUMMARY);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.SAD, new FreeTime(3, 0), new Group(1,
                false, false), User.Attention.MEDIUM,  new ArrayList<>(),
                false, null, preferredGenres, checks, 3, likedActors, readBooks,
                likedDirectors);
    }

    // Persona 4 is very social, and will only watch movies in a large group setting. Even then, he/she pays little attention to the movie.

    // Persona 4 enjoys the GENRES "comedy" and "romantic comedy".

    // Persona 4 also cares about well known actors and actresses, and will watch a movie if it has a cover photo that reveals an attractive cast member.

    // Persona 4 does not pay attention to plot summaries.
    public static User createUser4() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.ROMANTIC_COMEDY);

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.ACTORS_FAME);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.BORED, new FreeTime(2, 0), new Group(6,
                false, false), User.Attention.LITTLE,  new ArrayList<>(),
                false, null, preferredGenres, checks, 3, likedActors, readBooks,
                likedDirectors);
    }

    // Persona 5 loves to watch movies of all kind and spends several hours a day watching movies.

    // Persona 5 watches all GENRES but specifically likes "science fiction" and classics.

    // Persona 5 watches movies that have been recommended to him/her.

    // Persona 5 cares about low-level aspects such as RATING and PLOT SUMMARY

    // Persona 5 is typically in a "bored" mood and will only watch movies if the plot summary has a good hook.
    public static User createUser5() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.SCIFI);
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.ROMANTIC_COMEDY);
        preferredGenres.add(Genre.DRAMA);
        preferredGenres.add(Genre.ACTION);
        preferredGenres.add(Genre.THRILLER);

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.RATING);
        checks.add(User.Checks.SUMMARY);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.BORED, new FreeTime(5, 0), new Group(1,
                false, false), User.Attention.FULL,  new ArrayList<>(), false,
                null, preferredGenres, checks, 3, likedActors, readBooks, likedDirectors);
    }
}
