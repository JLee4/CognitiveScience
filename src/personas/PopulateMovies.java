package personas;

import java.time.Duration;
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

    public static List<Film> populateMovies() {
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

        return movies;
    }
}
