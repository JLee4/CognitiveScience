package personas;

// Persona 3 does not watch many movies a lot, when he/she does, he/she prioritizes the RATING and PLOT SUMMARY of the movie. 

// Persona 3 cares about their MOOD and enjoys all movie GENRES except for "drama" and "thriller"

// Persona 3 is typically in a "sad" mood and will only watch movies if the cast members are well known. 

// Persona 3 will only watch movies alone. 

import java.util.ArrayList;
import java.util.List;
import schemas.Film;
import schemas.User;

public class Persona3 extends Persona {

    public static User createUser() {
        List<String> preferredGenres = new ArrayList<String>();
        preferredGenres.add("COMEDY");
        preferredGenres.add("ROMCOM");
        preferredGenres.add("ACTION");
        preferredGenres.add("HORROR");
  
        User persona3 = new User(User.Mood.SAD, User.FreeTime.THREE_HOURS, User.GroupSize.ALONE, User.Attention.MEDIUM, preferredGenres);
        return persona3;
    }

    public static List<Film> createMovies() {
        return null;
    }
}
