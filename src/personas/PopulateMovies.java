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
        movies.add(new Film("Coco", Media.Type.FILM, "English", Duration.ZERO.plusSeconds(6300),
                Rating.FOUR_STARS, AgeRating.PG, Genre.ANIMATED, GoreAmount.NONE, "Light",
                Film.Age.SOMEWHAT_NEW, new Preview(Duration.ZERO.plusSeconds(60)),
                new Summary(100, Summary.Comprehensive.VERY_LITTLE, Summary.Hook.GOOD,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Size.MEDIUM, CoverPhoto.Complexity.MEDIUM, CoverPhoto.MovieRelation.REVEALS_PLOT),
                new Cast(new CastMember(CastMember.CastType.DIRECTOR, CastMember.Reputation.NEUTRAL,
                        CastMember.Fame.B_LIST))));

        movies.add(new Film("Coco", Media.Type.FILM, "English", Duration.ZERO.plusSeconds(6300),
                Rating.FOUR_STARS, AgeRating.PG, Genre.ANIMATED, GoreAmount.NONE, "Light",
                Film.Age.SOMEWHAT_NEW, new Preview(Duration.ZERO.plusSeconds(60)),
                new Summary(100, Summary.Comprehensive.VERY_LITTLE, Summary.Hook.GOOD,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Size.MEDIUM, CoverPhoto.Complexity.MEDIUM, CoverPhoto.MovieRelation.REVEALS_PLOT),
                new Cast(new CastMember(CastMember.CastType.DIRECTOR, CastMember.Reputation.NEUTRAL,
                        CastMember.Fame.B_LIST))));


        return movies;
    }
}
