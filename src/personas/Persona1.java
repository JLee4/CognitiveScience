package personas;

// Persona 1 is focused on the high-level aspects of movie selection. 

// Persona 1 cares about MOOD and GENRE of a potential movie. 

// Persona 1 does looks at the cover photo but only that

// Persona 1 is typically in a "happy" mood and enjoys the genres "comedy" and "drama".

import java.util.ArrayList;
import java.util.List;
import schemas.FreeTime;
import schemas.Genre;
import schemas.Group;
import schemas.User;

public class Persona1 extends Persona {

    public static User createUser() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.DRAMA);
        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO); //TODO: add this for all personas
        return new User(User.Mood.HAPPY, new FreeTime(2, 0), new Group(1, false, false), User.Attention.MEDIUM, new ArrayList<>(), false, null, preferredGenres, checks);
    }
}
