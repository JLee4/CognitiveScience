package personas;

// Persona 4 is very social, and will only watch movies in a large group setting. Even then, he/she pays little attention to the movie.

// Persona 4 enjoys the GENRES "comedy" and "romantic comedy". 

// Persona 4 also cares about well known actors and actresses, and will watch a movie if it has a cover photo that reveals an attractive cast member.

// Persona 4 does not pay attention to plot summaries.

import java.util.List;
import java.util.ArrayList;
import schemas.Film;
import schemas.FreeTime;
import schemas.Genre;
import schemas.Group;
import schemas.User;

public class Persona4 extends Persona {

    public static User createUser() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.ROMANTIC_COMEDY);

        return new User(User.Mood.BORED, new FreeTime(2, 0), new Group(6, false, false), User.Attention.LITTLE,  new ArrayList<>(), false, null, preferredGenres, new ArrayList<>(), 3, null);
    }
}
