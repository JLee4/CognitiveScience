package personas;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import schemas.Actor;
import schemas.AgeRating;
import schemas.Appeal;
import schemas.Book;
import schemas.Cast;
import schemas.CastMember;
import schemas.CoverPhoto;
import schemas.Director;
import schemas.Fame;
import schemas.Film;
import schemas.Genre;
import schemas.GoreAmount;
import schemas.MediaType;
import schemas.Preview;
import schemas.Rating;
import schemas.Reputation;
import schemas.Summary;

public class PopulateMovies {

    //TODO: add more movies
    public static List<Film> populateMovies(boolean isVerbose) {
        List<Film> movies = new ArrayList<>();
        //Coco
        Film coco = new Film("Coco", MediaType.FILM, "English", Duration.ZERO.plusSeconds(6300),
                Rating.FOUR_STARS, AgeRating.PG, Genre.ANIMATED, GoreAmount.NONE, Film.Atmosphere.CHEERFUL,
                Film.Age.SOMEWHAT_NEW, new Preview(Duration.ZERO.plusSeconds(60), new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Summary(100, Summary.Comprehensive.VERY_LITTLE, Summary.Hook.GOOD,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.MEDIUM, CoverPhoto.Iconography.REVEALS_PLOT, new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Cast(new Director("Lee Unkrich", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        coco.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        coco.getCast().addActor(new Actor("Anthony Gonzalez", Reputation.GOOD, Fame.C_LIST));
        coco.getCast().addActor(new Actor("Gael Garcia Bernal", Reputation.GOOD, Fame.B_LIST));
        coco.getCast().addActor(new Actor("Benjamin Bratt", Reputation.GOOD, Fame.B_LIST));
        movies.add(coco);

        //Use this as a template for more movie objects (i.e. replace the field with another movie)
        Film template = new Film("Coco", MediaType.FILM, "English", Duration.ZERO.plusSeconds(6300),
                Rating.FOUR_STARS, AgeRating.PG, Genre.ANIMATED, GoreAmount.NONE, Film.Atmosphere.CHEERFUL,
                Film.Age.SOMEWHAT_NEW, new Preview(Duration.ZERO.plusSeconds(60), new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Summary(100, Summary.Comprehensive.VERY_LITTLE, Summary.Hook.GOOD,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.MEDIUM, CoverPhoto.Iconography.REVEALS_PLOT, new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Cast(new Director("Lee Unkrich", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        coco.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        template.setBook(new Book("example book", 100, 500, Book.ReadingDifficulty.ELEMENTARY_LEVEL));
        template.getCast().addActor(new Actor("Anthony Gonzalez", Reputation.GOOD, Fame.C_LIST));
        template.getCast().addActor(new Actor("Gael Garcia Bernal", Reputation.GOOD, Fame.B_LIST));
        template.getCast().addActor(new Actor("Benjamin Bratt", Reputation.GOOD, Fame.B_LIST));
        //movies.add(template);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        return movies;
    }
}
