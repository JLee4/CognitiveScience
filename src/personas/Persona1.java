package personas;

// Persona 1 is focused on the high-level aspects of movie selection. 

// Persona 1 cares about MOOD and GENRE of a potential movie. 

// Persona 1 does not care about low-level aspects such as RATING and PLOT SUMMARY as the persona doesn't have much attention

// Persona 1 is typically in a "happy" mood and enjoys the genres "comedy" and "drama".

import java.util.ArrayList;
import java.util.List;
import schemas.Group;
import schemas.User;

public class Persona1 extends Persona {

    public static User createUser() {
        List<String> preferredGenres = new ArrayList<>();
        preferredGenres.add("COMEDY");
        preferredGenres.add("DRAMA");
        return new User(User.Mood.HAPPY, User.FreeTime.TWO_HOURS, new Group(1, false, false), User.Attention.MEDIUM, preferredGenres);
    }
}
