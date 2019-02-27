package personas;

// Persona 1 is focused on the high-level aspects of movie selection. 

// Persona 1 cares about MOOD and GENRE of a potential movie. 
// Persona 1 does not care about low-level aspects such as RATING and PLOT SUMMARY. 

// Persona 1 is typically in a "happy" mood and enjoys the genres "comedy" and "drama".

import java.util.List;
import schemas.Film;
import schemas.User;

public class Persona1 extends Persona {

    public static User createUser() {
        User persona1 = new User(Mood.HAPPY, FreeTime.TWO_HOURS, GroupSize.ALONE, Attention.FULL);
        return persona1;
    }

    public static List<Film> createMovies() {
        return null;
    }
}
