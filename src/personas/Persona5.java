package personas;

// Persona 5 loves to watch movies of all kind and spends several hours a day watching movies. 

// Persona 5 watches all GENRES but specifically likes "science fiction" and classics.

// Persona 5 watches movies that have been recommended to him/her.

// Persona 5 cares about low-level aspects such as RATING and PLOT SUMMARY

// Persona 5 is typically in a "bored" mood and will only watch movies if the plot summary has a good hook.

import java.util.ArrayList;
import java.util.List;
import schemas.Actor;
import schemas.Book;
import schemas.Director;
import schemas.FreeTime;
import schemas.Genre;
import schemas.Group;
import schemas.User;

public class Persona5 extends Persona {

    public static User createUser() {
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
