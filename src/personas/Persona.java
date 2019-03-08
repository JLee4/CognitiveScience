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
