package personas;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import schemas.AgeRating;
import schemas.Cast;
import schemas.CastMember;
import schemas.CoverPhoto;
import schemas.Film;
import schemas.Genre;
import schemas.GoreAmount;
import schemas.Media;
import schemas.Preview;
import schemas.Rating;
import schemas.Summary;

public class PopulateMovies {

    public static List<Film> populateMovies(boolean isVerbose) {
        List<Film> movies = new ArrayList<>();
        //Coco
        Film coco = new Film("Coco", Media.Type.FILM, "English", Duration.ZERO.plusSeconds(6300),
                Rating.FOUR_STARS, AgeRating.PG, Genre.ANIMATED, GoreAmount.NONE, "Light",
                Film.Age.SOMEWHAT_NEW, new Preview(Duration.ZERO.plusSeconds(60)),
                new Summary(100, Summary.Comprehensive.VERY_LITTLE, Summary.Hook.GOOD,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.MEDIUM, CoverPhoto.MovieRelation.REVEALS_PLOT),
                new Cast(new CastMember("Lee Unkrich", CastMember.CastType.DIRECTOR, CastMember.Reputation.NEUTRAL,
                        CastMember.Fame.B_LIST)));
        coco.getCast().addActor(new CastMember("Anthony Gonzalez", CastMember.CastType.ACTOR, CastMember.Reputation.GOOD, CastMember.Fame.C_LIST));
        coco.getCast().addActor(new CastMember( "Gael Garcia Bernal",CastMember.CastType.ACTOR, CastMember.Reputation.GOOD, CastMember.Fame.B_LIST));
        coco.getCast().addActor(new CastMember("Benjamin Bratt", CastMember.CastType.ACTOR, CastMember.Reputation.GOOD, CastMember.Fame.B_LIST));
        movies.add(coco);

        //Use this as a template for more movie objects (i.e. replace the field with another movie)
        Film template = new Film("Coco", Media.Type.FILM, "English", Duration.ZERO.plusSeconds(6300),
                Rating.FOUR_STARS, AgeRating.PG, Genre.ANIMATED, GoreAmount.NONE, "Light",
                Film.Age.SOMEWHAT_NEW, new Preview(Duration.ZERO.plusSeconds(60)),
                new Summary(100, Summary.Comprehensive.VERY_LITTLE, Summary.Hook.GOOD,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.MEDIUM, CoverPhoto.MovieRelation.REVEALS_PLOT),
                new Cast(new CastMember("Lee Unkrich", CastMember.CastType.DIRECTOR, CastMember.Reputation.NEUTRAL,
                        CastMember.Fame.B_LIST)));
        template.getCast().addActor(new CastMember("Anthony Gonzalez", CastMember.CastType.ACTOR, CastMember.Reputation.GOOD, CastMember.Fame.C_LIST));
        template.getCast().addActor(new CastMember( "Gael Garcia Bernal",CastMember.CastType.ACTOR, CastMember.Reputation.GOOD, CastMember.Fame.B_LIST));
        template.getCast().addActor(new CastMember("Benjamin Bratt", CastMember.CastType.ACTOR, CastMember.Reputation.GOOD, CastMember.Fame.B_LIST));
        movies.add(coco);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (isVerbose) {
            int i = 1;
            for (Film movie: movies) {
                System.out.println("Movie " + i + ":");
                System.out.println("Name: " + movie.getName());
                System.out.println("Language: " + movie.getLanguage());
                System.out.println("Duration: " + LocalTime.MIDNIGHT.plus(movie.getLength()).format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                System.out.println("Rating: " + movie.getRating().name());
                System.out.println("Age Rating: " + movie.getAgeRating().name());
                System.out.println("Genre: " + movie.getGenre().name());
                System.out.println("Gore Amount: " + movie.getGoreAmount().name());
                System.out.println("Atmosphere: " + movie.getAtmosphere());
                System.out.println("Movie Age: " + movie.getAge().name());
                System.out.println("Summary: ");
                System.out.println("    Words: " + movie.getSummary().getSummaryWordLength());
                System.out.println("    Comprehensive: " + movie.getSummary().getComprehensive().name());
                System.out.println("    Hook Quality: " + movie.getSummary().getHookLevel().name());
                System.out.println("    Reading Difficulty: " + movie.getSummary().getReadingDifficulty().name());
                System.out.println("Cover Photo: ");
                System.out.println("    Complexity: " + movie.getCoverPhoto().getComplexity().name());
                System.out.println("    Relation to Movie: " + movie.getCoverPhoto().getMovieRelation().name());
                System.out.println("Cast: ");
                System.out.println("    Director: " + movie.getCast().getDirector().getName() + ", Reputation: "
                        + movie.getCast().getDirector().getReputation().name() + ", "
                        + movie.getCast().getDirector().getFame());
                System.out.println("    Actors:");
                for (CastMember actor : movie.getCast().getActors()) {
                    System.out.println(actor.getName() + ", Reputation: " + actor.getReputation().name() + ", " + actor.getFame().name());
                }
                System.out.println();
                i++;
            }
        }
        return movies;
    }
}
