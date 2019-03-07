package personas;

// Persona 2 is focused on the high-level aspects of movie selection. 

// Persona 2 cares about their MOOD and enjoys all movie GENRES except for "horror". 

// Persona 2 also cares about low-level aspects such as RATING and PLOT SUMMARY. 

// Persona 2 is typically in a "bored" mood and will only watch movies if their rating is over 3 stars.

// Persona 2 will only watch movies alone. 

import java.util.ArrayList;
import java.util.List;
import schemas.Actor;
import schemas.Book;
import schemas.Director;
import schemas.Fame;
import schemas.Film;
import schemas.FreeTime;
import schemas.Genre;
import schemas.Group;
import schemas.Reputation;
import schemas.User;

public class Persona2 extends Persona {

    public static User createUser() {
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
}
