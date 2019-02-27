package personas;

// Persona 5 loves to watch movies of all kind and spends several hours a day watching movies. 

// Persona 5 specifically likes the "science fiction" GENRE and classic movies, but watches all genres. 

// Persona 5 watches movies that have been recommended to him/her and have been Oscar nominated. 

// Persona 5 cares about low-level aspects such as RATING and PLOT SUMMARY

// Persona 5 is typically in a "cathartic" mood and will only watch movies if the plot summary has a good hook.

import java.util.List;
import schemas.Film;
import schemas.User;

public class Persona5 extends Persona {

    public static User createUser() {
        List<String> preferredGenres = new ArrayList<String>();
        preferredGenres.add("SCIFI"); 
        preferredGenres.add("COMEDY");
        preferredGenres.add("ROMCOM");
        preferredGenres.add("DRAMA");
        preferredGenres.add("ACTION");
        preferredGenres.add("THRILLER");
  
        User persona5 = new User(Mood.CATHARTIC, FreeTime.MORE_THAN_THREE_HOURS, GroupSize.ALONE, Attention.FULL, preferredGenres);
    }

    public static List<Film> createMovies() {
        return null;
    }
}
