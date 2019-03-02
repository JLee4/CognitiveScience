package personas;

// Persona 3 does not watch many movies a lot, when he/she does, he/she prioritizes the RATING and PLOT SUMMARY of the movie. 

// Persona 3 cares about their MOOD and enjoys all movie GENRES except for "drama" and "thriller"

// Persona 3 is typically in a "sad" mood and will only watch movies if the cast members are well known. 

// Persona 3 will only watch movies alone. 

import java.util.ArrayList;
import java.util.List;
import schemas.FreeTime;
import schemas.Genre;
import schemas.Group;
import schemas.User;

public class Persona3 extends Persona {

    public static User createUser() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.ROMANTIC_COMEDY);
        preferredGenres.add(Genre.ACTION);
        preferredGenres.add(Genre.HORROR);

        return new User(User.Mood.SAD, new FreeTime(3, 0), new Group(1, false, false), User.Attention.MEDIUM,  new ArrayList<>(), false, null, preferredGenres, new ArrayList<>(), 3);
    }
}
