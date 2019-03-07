package personas;

// Persona 3 does not watch many movies a lot, when he/she does, he/she prioritizes the RATING and PLOT SUMMARY of the movie. 

// Persona 3 cares about their MOOD and enjoys all movie GENRES except for "drama" and "thriller"

// Persona 3 is typically in a "sad" mood and will only watch movies if the cast members are well known. 

// Persona 3 will only watch movies alone. 

import java.util.ArrayList;
import java.util.List;
import schemas.Actor;
import schemas.Book;
import schemas.Director;
import schemas.FreeTime;
import schemas.Genre;
import schemas.Group;
import schemas.User;

public class Persona3 extends Persona {

    public static User createUser() {
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
}
