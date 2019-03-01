package personas;

// Persona 5 loves to watch movies of all kind and spends several hours a day watching movies. 

// Persona 5 watches all GENRES but specifically likes "science fiction" and classics.

// Persona 5 watches movies that have been recommended to him/her and have been Oscar nominated. 

// Persona 5 cares about low-level aspects such as RATING and PLOT SUMMARY

// Persona 5 is typically in a "cathartic" mood and will only watch movies if the plot summary has a good hook.

import java.util.ArrayList;
import java.util.List;
import schemas.Film;
import schemas.Group;
import schemas.User;

public class Persona5 extends Persona {

    public static User createUser() {
        List<String> preferredGenres = new ArrayList<>();
        preferredGenres.add("SCIFI"); 
        preferredGenres.add("COMEDY");
        preferredGenres.add("ROMCOM");
        preferredGenres.add("DRAMA");
        preferredGenres.add("ACTION");
        preferredGenres.add("THRILLER");

        return new User(User.Mood.CATHARTIC, User.FreeTime.MORE_THAN_THREE_HOURS, new Group(1, false, false), User.Attention.FULL,  new ArrayList<>(), false, null, preferredGenres, new ArrayList<>());
    }
}
