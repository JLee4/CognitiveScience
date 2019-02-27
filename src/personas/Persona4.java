package personas;

// Persona 4 is very social, and will only watch movies in a large group setting. Even then, he/she pays little attention to the movie.

// Persona 4 enjoys the GENRES "comedy" and "romantic comedy". 

// Persona 4 also cares about well known actors and actresses, and will watch a movie if it has a coverphoto that reveals an attractive cast member.

// Persona 4 does not pay attention to plot summaries.

import java.util.List;
import schemas.Film;
import schemas.User;

public class Persona4 extends Persona {

    public static User createUser() {
        List<String> preferredGenres = new ArrayList<String>();
        preferredGenres.add("COMEDY");
        preferredGenres.add("ROMCOM");
  
        User persona4 = new User(Mood.CATHARTIC, FreeTime.TWO_HOURS, GroupSize.LARGE_GROUP, Attention.LITTLE, preferredGenres);
    }

    public static List<Film> createMovies() {
        return null;
    }
}
