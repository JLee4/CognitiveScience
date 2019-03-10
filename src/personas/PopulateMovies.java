package personas;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import schemas.Actor;
import schemas.AgeRating;
import schemas.Appeal;
import schemas.Book;
import schemas.Cast;
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

    public static List<Film> populateMovies(boolean isVerbose) {
        List<Film> movies = new ArrayList<>();

        // Film 1: Coco
        List<Genre> genres = new ArrayList<>();
        genres.add(Genre.ANIMATED);
        genres.add(Genre.ADVENTURE);
        genres.add(Genre.COMEDY);
        Film coco = new Film("Coco", MediaType.FILM, "English", Duration.ZERO.plusSeconds(6300),
                Rating.FOUR_STARS, AgeRating.PG, genres, GoreAmount.NONE, Film.Atmosphere.CHEERFUL,
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

        // Film 2: Shrek
        genres = new ArrayList<>();
        genres.add(Genre.ANIMATED);
        genres.add(Genre.COMEDY);
        Film shrek = new Film("Shrek", MediaType.FILM, "English", Duration.ZERO.plusSeconds(5400),
                Rating.FOUR_STARS, AgeRating.PG, genres, GoreAmount.NONE, Film.Atmosphere.HUMOROUS,
                Film.Age.OLD, new Preview(Duration.ZERO.plusSeconds(120), new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Summary(200, Summary.Comprehensive.MOSTLY, Summary.Hook.OKAY,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.MEDIUM, CoverPhoto.Iconography.REVEALS_ACTORS, new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Cast(new Director("Andrew Adamson", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        shrek.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        shrek.getCast().addActor(new Actor("Mike Meyers", Reputation.GOOD, Fame.B_LIST));
        skrek.getCast().addActor(new Actor("Eddie Murphy", Reputation.GOOD, Fame.A_LIST));
        shrek.getCast().addActor(new Actor("Cameron Diaz", Reputation.GOOD, Fame.A_LIST));
        movies.add(shrek);

        // Film 3: High School Musical
        genres = new ArrayList<>();
        genres.add(Genre.DRAMA);
        genres.add(Genre.COMEDY);
        Film high_school_musical = new Film("High School Musical", MediaType.FILM, "English", Duration.ZERO.plusSeconds(5880),
                Rating.THREE_STARS, AgeRating.G, genres, GoreAmount.NONE, Film.Atmosphere.HUMOROUS,
                Film.Age.SOMEWHAT_OLD, new Preview(Duration.ZERO.plusSeconds(48), new Appeal(Appeal.AppealLevel.MEMORABLE)),
                new Summary(250, Summary.Comprehensive.MOSTLY, Summary.Hook.OKAY,
                        Summary.ReadingDifficulty.MIDDLE_SCHOOL_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.MEDIUM, CoverPhoto.Iconography.REVEALS_ACTORS, new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Cast(new Director("Kenny Ortega", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        high_school_musical.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        high_school_musical.getCast().addActor(new Actor("Zac Efron", Reputation.GOOD, Fame.A_LIST));
        high_school_musical.getCast().addActor(new Actor("Vanessa Hudgens", Reputation.GOOD, Fame.B_LIST));
        high_school_musical.getCast().addActor(new Actor("Ashley Tisdale", Reputation.GOOD, Fame.B_LIST));
        high_school_musical.getCast().addActor(new Actor("Corbin Bleu", Reputation.GOOD, Fame.C_LIST));
        movies.add(high_school_musical);

        // Film 4: The 40-Year-Old Virgin
        genres = new ArrayList<>();
        genres.add(Genre.ROMANCE);
        genres.add(Genre.COMEDY);
        Film the_40_year_old_virgin = new Film("The 40-Year-Old Virgin", MediaType.FILM, "English", Duration.ZERO.plusSeconds(7980),
                Rating.THREE_STARS, AgeRating.R, genres, GoreAmount.NONE, Film.Atmosphere.HUMOROUS,
                Film.Age.SOMEWHAT_OLD, new Preview(Duration.ZERO.plusSeconds(119), new Appeal(Appeal.AppealLevel.ICONIC)),
                new Summary(156, Summary.Comprehensive.VERY_LITTLE, Summary.Hook.BAD,
                        Summary.ReadingDifficulty.MIDDLE_SCHOOL_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.SIMPLE, CoverPhoto.Iconography.REVEALS_ACTOR, new Appeal(Appeal.AppealLevel.WEIRD)),
                new Cast(new Director("Judd Apatow", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        the_40_year_old_virgin.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        the_40_year_old_virgin.getCast().addActor(new Actor("Steve Carell", Reputation.GOOD, Fame.A_LIST));
        the_40_year_old_virgin.getCast().addActor(new Actor("Catherine Keener", Reputation.GOOD, Fame.B_LIST));
        the_40_year_old_virgin.getCast().addActor(new Actor("Paul Rudd", Reputation.GOOD, Fame.A_LIST));
        movies.add(the_40_year_old_virgin);

        // Film 5: Insidious
        genres = new ArrayList<>();
        genres.add(Genre.HORROR);
        genres.add(Genre.THRILLER);
        Film insidious = new Film("Insidious", MediaType.FILM, "English", Duration.ZERO.plusSeconds(6180),
                Rating.THREE_STARS, AgeRating.PG_13, genres, GoreAmount.NONE, Film.Atmosphere.MYSTERIOUS,
                Film.Age.SOMEWHAT_OLD, new Preview(Duration.ZERO.plusSeconds(94), new Appeal(Appeal.AppealLevel.MEMORABLE)),
                new Summary(150, Summary.Comprehensive.MOSTLY, Summary.Hook.OKAY,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.MEDIUM, CoverPhoto.Iconography.REVEALS_THEME, new Appeal(Appeal.AppealLevel.MEMORABLE)),
                new Cast(new Director("James Wan", Reputation.NEUTRAL,
                        Fame.C_LIST)), null);
        insidious.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        insidious.getCast().addActor(new Actor("Patrick Wilson", Reputation.GOOD, Fame.C_LIST));
        insidious.getCast().addActor(new Actor("Rose Byrne", Reputation.GOOD, Fame.C_LIST));
        insidious.getCast().addActor(new Actor("Ty Simpkins", Reputation.GOOD, Fame.C_LIST));
        movies.add(insidious);

        // Film 6: The Incredibles
        genres = new ArrayList<>();
        genres.add(Genre.ANIMATED);
        genres.add(Genre.ADVENTURE);
        genres.add(Genre.ACTION);
        genres.add(Genre.FAMILY);
        Film the_incredibles = new Film("The Incredibles", MediaType.FILM, "English", Duration.ZERO.plusSeconds(6900),
                Rating.FOUR_STARS, AgeRating.PG, genres, GoreAmount.NONE, Film.Atmosphere.CHEERFUL,
                Film.Age.SOMEWHAT_OLD, new Preview(Duration.ZERO.plusSeconds(78), new Appeal(Appeal.AppealLevel.MEMORABLE)),
                new Summary(94, Summary.Comprehensive.MOSTLY, Summary.Hook.OKAY,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.COMPLEX, CoverPhoto.Iconography.REVEALS_PLOT_ACTORS, new Appeal(Appeal.AppealLevel.MEMORABLE)),
                new Cast(new Director("Brad Bird", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        the_incredibles.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        the_incredibles.getCast().addActor(new Actor("Craig T. Nelson", Reputation.NEUTRAL, Fame.C_LIST));
        the_incredibles.getCast().addActor(new Actor("Samuel L. Jackson", Reputation.GOOD, Fame.C_LIST));
        the_incredibles.getCast().addActor(new Actor("Holly Hunter", Reputation.GOOD, Fame.C_LIST));
        movies.add(the_incredibles);

        // Film 7: Harry Potter and the Sorcerer's Stone
        // NOTE: did not add book aspects
        genres = new ArrayList<>();
        genres.add(Genre.FAMILY);
        genres.add(Genre.ADVENTURE);
        genres.add(Genre.FANTASY);
        Film harry_potter = new Film("Harry Potter and the Sorcerer's Stone", MediaType.FILM, "English", Duration.ZERO.plusSeconds(9120),
                Rating.FOUR_STARS, AgeRating.PG, genres, GoreAmount.NONE, Film.Atmosphere.MELANCHOLIC,
                Film.Age.SOMEWHAT_OLD, new Preview(Duration.ZERO.plusSeconds(61), new Appeal(Appeal.AppealLevel.ICONIC)),
                new Summary(156, Summary.Comprehensive.MOSTLY, Summary.Hook.GOOD,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.COMPLEX, CoverPhoto.Iconography.REVEALS_PLOT_ACTORS, new Appeal(Appeal.AppealLevel.MEMORABLE)),
                new Cast(new Director("Chris Columbus", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        harry_potter.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        harry_potter.getCast().addActor(new Actor("Daniel Radcliffe", Reputation.GOOD, Fame.A_LIST));
        harry_potter.getCast().addActor(new Actor("Rupert Grint", Reputation.GOOD, Fame.A_LIST));
        harry_potter.getCast().addActor(new Actor("Emma Watson", Reputation.GOOD, Fame.A_LIST));
        movies.add(harry_potter);

        // Film 8: Twilight
        // NOTE: did not add book aspects
        genres = new ArrayList<>();
        genres.add(Genre.DRAMA);
        genres.add(Genre.FANTASY);
        genres.add(Genre.ROMANCE);
        Film twilight = new Film("Twilight", MediaType.FILM, "English", Duration.ZERO.plusSeconds(7320),
                Rating.THREE_STARS, AgeRating.PG_13, genres, GoreAmount.NONE, Film.Atmosphere.MELANCHOLIC,
                Film.Age.SOMEWHAT_OLD, new Preview(Duration.ZERO.plusSeconds(32), new Appeal(Appeal.AppealLevel.MEMORABLE)),
                new Summary(97, Summary.Comprehensive.VERY_LITTLE, Summary.Hook.BAD,
                        Summary.ReadingDifficulty.MIDDLE_SCHOOL_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.SIMPLE, CoverPhoto.Iconography.REVEALS_ACTORS, new Appeal(Appeal.AppealLevel.WEIRD)),
                new Cast(new Director("Catherine Hardwicke", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        twilight.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        twilight.getCast().addActor(new Actor("Kristen Stewart", Reputation.GOOD, Fame.C_LIST));
        twilight.getCast().addActor(new Actor("Robert Pattinson", Reputation.GOOD, Fame.B_LIST));
        movies.add(twilight);

        // Film 9: The Spongebob Squarepants Movie
        genres = new ArrayList<>();
        genres.add(Genre.ANIMATED);
        genres.add(Genre.ADVENTURE);
        genres.add(Genre.FAMILY);
        genres.add(Genre.COMEDY);
        Film spongebob = new Film("The Spongebob Squarepants Movie", MediaType.FILM, "English", Duration.ZERO.plusSeconds(5220),
                Rating.THREE_STARS, AgeRating.PG, genres, GoreAmount.NONE, Film.Atmosphere.HUMOROUS,
                Film.Age.SOMEWHAT_OLD, new Preview(Duration.ZERO.plusSeconds(145), new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Summary(56, Summary.Comprehensive.MOSTLY, Summary.Hook.GOOD,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.SIMPLE, CoverPhoto.Iconography.REVEALS_THEME, new Appeal(Appeal.AppealLevel.WEIRD)),
                new Cast(new Director("Steven Hillenburg", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        spongebob.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        spongebob.getCast().addActor(new Actor("Tom Kenny", Reputation.GOOD, Fame.C_LIST));
        spongebob.getCast().addActor(new Actor("Jeffrey Tambor", Reputation.NEUTRAL, Fame.C_LIST));
        spongebob.getCast().addActor(new Actor("Rodger Bumpass", Reputation.NEUTRAL, Fame.C_LIST));
        movies.add(spongebob);

        // Film 10: Isn't It Romantic
        genres = new ArrayList<>();
        genres.add(Genre.ROMANTIC);
        genres.add(Genre.FANTASY);
        genres.add(Genre.COMEDY);
        Film isnt_it_romantic = new Film("Isn't It Romantic", MediaType.FILM, "English", Duration.ZERO.plusSeconds(5340),
                Rating.THREE_STARS, AgeRating.PG_13, genres, GoreAmount.NONE, Film.Atmosphere.HUMOROUS,
                Film.Age.NEW, new Preview(Duration.ZERO.plusSeconds(65), new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Summary(85, Summary.Comprehensive.VERY_LITTLE, Summary.Hook.OKAY,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.SIMPLE, CoverPhoto.Iconography.REVEALS_ACTORS, new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Cast(new Director("Todd Strauss-Schulson", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        isnt_it_romantic.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        isnt_it_romantic.getCast().addActor(new Actor("Rebel Wilson", Reputation.GOOD, Fame.A_LIST));
        isnt_it_romantic.getCast().addActor(new Actor("Liam Hemsworth", Reputation.GOOD, Fame.A_LIST));
        isnt_it_romantic.getCast().addActor(new Actor("Adam Devine", Reputation.GOOD, Fame.B_LIST));
        isnt_it_romantic.getCast().addActor(new Actor("Priyanka Chopra", Reputation.GOOD, Fame.A_LIST));
        movies.add(isnt_it_romantic);

        // Film 11: What Men Want
        genres = new ArrayList<>();
        genres.add(Genre.FANTASY);
        genres.add(Genre.ROMANCE);
        genres.add(Genre.COMEDY);
        Film what_men_want = new Film("What Men Want", MediaType.FILM, "English", Duration.ZERO.plusSeconds(7020),
                Rating.TWO_STARS, AgeRating.R, genres, GoreAmount.NONE, Film.Atmosphere.CHAOTIC,
                Film.Age.NEW, new Preview(Duration.ZERO.plusSeconds(31), new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Summary(58, Summary.Comprehensive.VERY_LITTLE, Summary.Hook.OKAY,
                        Summary.ReadingDifficulty.MIDDLE_SCHOOL_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.SIMPLE, CoverPhoto.Iconography.REVEALS_ACTORS, new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Cast(new Director("Adam Shankman", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        what_men_want.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        what_men_want.getCast().addActor(new Actor("Taraji P. Henson", Reputation.GOOD, Fame.C_LIST));
        what_men_want.getCast().addActor(new Actor("Kristen Ledlow", Reputation.NEUTRAL, Fame.C_LIST));
        what_men_want.getCast().addActor(new Actor("Josh Brener", Reputation.GOOD, Fame.C_LIST));
        movies.add(what_men_want);

        // Film 12: Evil Dead
        genres = new ArrayList<>();
        genres.add(Genre.FANTASY);
        genres.add(Genre.HORROR);
        genres.add(Genre.THRILLER);
        Film evil_dead = new Film("Evil Dead", MediaType.FILM, "English", Duration.ZERO.plusSeconds(5460),
                Rating.THREE_STARS, AgeRating.R, genres, GoreAmount.LARGE, Film.Atmosphere.GRIM,
                Film.Age.SOMEWHAT_NEW, new Preview(Duration.ZERO.plusSeconds(127), new Appeal(Appeal.AppealLevel.MEMORABLE)),
                new Summary(67, Summary.Comprehensive.VERY_LITTLE, Summary.Hook.OKAY,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.COMPLEX, CoverPhoto.Iconography.REVEALS_THEME, new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Cast(new Director("Fede Alvarez", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        evil_dead.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        evil_dead.getCast().addActor(new Actor("Jane Levy", Reputation.NEUTRAL, Fame.C_LIST));
        evil_dead.getCast().addActor(new Actor("Shiloh Fernandez", Reputation.GOOD, Fame.C_LIST));
        evil_dead.getCast().addActor(new Actor("Jessica Lucas", Reputation.NEUTRAL, Fame.C_LIST));
        movies.add(evil_dead);

        // Film 13: Saw 3D: The Final Chapter
        genres = new ArrayList<>();
        genres.add(Genre.HORROR);
        genres.add(Genre.THRILLER);
        Film saw = new Film("Saw 3D: The Final Chapter", MediaType.FILM, "English", Duration.ZERO.plusSeconds(5400),
                Rating.TWO_STARS, AgeRating.R, genres, GoreAmount.LARGE, Film.Atmosphere.GRIM,
                Film.Age.SOMEWHAT_NEW, new Preview(Duration.ZERO.plusSeconds(85), new Appeal(Appeal.AppealLevel.MEMORABLE)),
                new Summary(102, Summary.Comprehensive.MOSTLY, Summary.Hook.GOOD,
                        Summary.ReadingDifficulty.MIDDLE_SCHOOL_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.COMPLEX, CoverPhoto.Iconography.REVEALS_THEME, new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Cast(new Director("Kevin Greutert", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        saw.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        saw.getCast().addActor(new Actor("Tobin Bell", Reputation.GOOD, Fame.C_LIST));
        saw.getCast().addActor(new Actor("Costas Mandylor", Reputation.GOOD, Fame.C_LIST));
        saw.getCast().addActor(new Actor("Betsy Russell", Reputation.GOOD, Fame.C_LIST));
        movies.add(saw);

        // Film 14: Mean Girls
        genres = new ArrayList<>();
        genres.add(Genre.COMEDY);
        Film mean_girls = new Film("Mean Girls", MediaType.FILM, "English", Duration.ZERO.plusSeconds(5820),
                Rating.FOUR_STARS, AgeRating.PG_13, genres, GoreAmount.NONE, Film.Atmosphere.HUMOROUS,
                Film.Age.SOMEWHAT_OLD, new Preview(Duration.ZERO.plusSeconds(60), new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Summary(154, Summary.Comprehensive.MOSTLY, Summary.Hook.GOOD,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.MEDIUM, CoverPhoto.Iconography.REVEALS_ACTORS, new Appeal(Appeal.AppealLevel.MEMORABLE)),
                new Cast(new Director("Mark Waters", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        mean_girls.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        mean_girls.getCast().addActor(new Actor("Lindsay Lohan", Reputation.BAD, Fame.A_LIST));
        mean_girls.getCast().addActor(new Actor("Jonathan Bennett", Reputation.NEUTRAL, Fame.B_LIST));
        mean_girls.getCast().addActor(new Actor("Rachel McAdams", Reputation.GOOD, Fame.A_LIST));
        movies.add(mean_girls);

        // Film 15: Jurassic Park
        genres = new ArrayList<>();
        genres.add(Genre.SCIFI);
        genres.add(Genre.ADVENTURE);
        genres.add(Genre.THRILLER);
        Film jurassic_park = new Film("Jurassic Park", MediaType.FILM, "English", Duration.ZERO.plusSeconds(7620),
                Rating.FOUR_STARS, AgeRating.PG_13, genres, GoreAmount.LITTLE, Film.Atmosphere.CHAOTIC,
                Film.Age.OLD, new Preview(Duration.ZERO.plusSeconds(135), new Appeal(Appeal.AppealLevel.ICONIC)),
                new Summary(149, Summary.Comprehensive.MOSTLY, Summary.Hook.GOOD,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.SIMPLE, CoverPhoto.Iconography.REVEALS_THEME, new Appeal(Appeal.AppealLevel.MEMORABLE)),
                new Cast(new Director("Steven Spielberg", Reputation.GOOD,
                        Fame.A_LIST)), null);
        jurassic_park.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        jurassic_park.getCast().addActor(new Actor("Sam Neill", Reputation.GOOD, Fame.C_LIST));
        jurassic_park.getCast().addActor(new Actor("Laura Dern", Reputation.NEUTRAL, Fame.B_LIST));
        jurassic_park.getCast().addActor(new Actor("Jeff Goldblum", Reputation.GOOD, Fame.B_LIST));
        movies.add(jurassic_park);

        //Use this as a template for more movie objects (i.e. replace the field with another movie)
        genres = new ArrayList<>();
        genres.add(Genre.ANIMATED);
        genres.add(Genre.ADVENTURE);
        genres.add(Genre.COMEDY);
        Film template = new Film("Coco", MediaType.FILM, "English", Duration.ZERO.plusSeconds(6300),
                Rating.FOUR_STARS, AgeRating.PG, genres, GoreAmount.NONE, Film.Atmosphere.CHEERFUL,
                Film.Age.SOMEWHAT_NEW, new Preview(Duration.ZERO.plusSeconds(60), new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Summary(100, Summary.Comprehensive.VERY_LITTLE, Summary.Hook.GOOD,
                        Summary.ReadingDifficulty.ELEMENTARY_LEVEL),
                new CoverPhoto(CoverPhoto.Complexity.MEDIUM, CoverPhoto.Iconography.REVEALS_PLOT, new Appeal(Appeal.AppealLevel.EYE_CATCHING)),
                new Cast(new Director("Lee Unkrich", Reputation.NEUTRAL,
                        Fame.B_LIST)), null);
        template.getRating().setRatedBy(Rating.RatedBy.ROTTEN_TOMATOES);
        template.getCast().addActor(new Actor("Anthony Gonzalez", Reputation.GOOD, Fame.C_LIST));
        template.getCast().addActor(new Actor("Gael Garcia Bernal", Reputation.GOOD, Fame.B_LIST));
        template.getCast().addActor(new Actor("Benjamin Bratt", Reputation.GOOD, Fame.B_LIST));
        //movies.add(template);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

        return movies;
    }
}
