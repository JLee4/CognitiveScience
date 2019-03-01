package personas;

// Persona 2 is focused on the high-level aspects of movie selection. 

// Persona 2 cares about their MOOD and enjoys all movie GENRES except for "horror". 

// Persona 2 also cares about low-level aspects such as RATING and PLOT SUMMARY. 

// Persona 2 is typically in a "cathartic" mood and will only watch movies if their rating is over 3 stars.

// Persona 2 will only watch movies alone. 

import java.util.ArrayList;
import java.util.List;
import schemas.Film;
import schemas.Group;
import schemas.User;

public class Persona2 extends Persona {

    public static User createUser() {
        List<String> preferredGenres = new ArrayList<>();
        preferredGenres.add("COMEDY");
        preferredGenres.add("ROMCOM");
        preferredGenres.add("DRAMA");
        preferredGenres.add("ACTION");
        preferredGenres.add("THRILLER");

        return new User(User.Mood.CATHARTIC, User.FreeTime.TWO_HOURS, new Group(1, false, false), User.Attention.FULL, preferredGenres);
    }
}
