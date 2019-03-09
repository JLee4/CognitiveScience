package personas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import schemas.Actor;
import schemas.Book;
import schemas.Director;
import schemas.Fame;
import schemas.FreeTime;
import schemas.Genre;
import schemas.Group;
import schemas.Reputation;
import schemas.User;

public class Persona {

    // Persona 1 is focused on the high-level aspects of movie selection.

    // Persona 1 cares about MOOD and GENRE of a potential movie.

    // Persona 1 does looks at the cover photo but only that

    // Persona 1 is typically in a "happy" mood and enjoys the genres "comedy" and "drama".
    public static User createUser1() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.DRAMA);
        preferredGenres.add(Genre.ANIMATED);
        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.HAPPY, new FreeTime(2, 0), new Group(1,
                false, false), User.Attention.MEDIUM, new ArrayList<>(),
                false, null, preferredGenres, checks, 3, likedActors, readBooks,
                likedDirectors);
    }


    // Persona 2 is focused on the high-level aspects of movie selection.

    // Persona 2 cares about their MOOD and enjoys all movie GENRES except for "horror".

    // Persona 2 also cares about low-level aspects such as RATING and PLOT SUMMARY.

    // Persona 2 is typically in a "bored" mood and will only watch movies if their rating is over 3 stars.

    // Persona 2 will only watch movies alone.
    public static User createUser2() {
        List<Genre> preferredGenres = new ArrayList<>();
        for (Genre genre : Genre.values()) {
            if (genre != Genre.HORROR) {
                preferredGenres.add(genre);
            }
        }

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.RATING);
        checks.add(User.Checks.SUMMARY);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.BORED, new FreeTime(2, 0), new Group(1,
                false, false), User.Attention.FULL, new ArrayList<>(),
                false, null, preferredGenres, checks, 3, likedActors, readBooks,
                likedDirectors);
    }


    // Persona 3 does not watch many movies, when he/she does, he/she prioritizes the RATING and PLOT SUMMARY of the movie.

    // Persona 3 cares about their MOOD and enjoys all movie GENRES except for "drama" and "thriller"

    // Persona 3 is typically in a "sad" mood and will only watch movies if the cast members are well known.

    // Persona 3 will only watch movies alone.
    public static User createUser3() {
        List<Genre> preferredGenres = new ArrayList<>();
        for (Genre genre : Genre.values()) {
            if (genre != Genre.DRAMA && genre != Genre.THRILLER) {
                preferredGenres.add(genre);
            }
        }

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.RATING);
        checks.add(User.Checks.SUMMARY);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.SAD, new FreeTime(3, 0), new Group(1,
                false, false), User.Attention.MEDIUM,  new ArrayList<>(),
                false, null, preferredGenres, checks, 3, likedActors, readBooks,
                likedDirectors);
    }

    // Persona 4 is very social, and will only watch movies in a large group setting. Even then, he/she pays little attention to the movie.

    // Persona 4 enjoys the GENRES "comedy" and "romantic comedy".

    // Persona 4 also cares about well known actors and actresses, and will watch a movie if it has a cover photo that reveals an attractive cast member.

    // Persona 4 does not pay attention to plot summaries.
    public static User createUser4() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.ROMANTIC_COMEDY);

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.ACTORS_FAME);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.BORED, new FreeTime(2, 0), new Group(6,
                false, false), User.Attention.LITTLE,  new ArrayList<>(),
                false, null, preferredGenres, checks, 3, likedActors, readBooks,
                likedDirectors);
    }

    // Persona 5 loves to watch movies of all kind and spends several hours a day watching movies.

    // Persona 5 watches all GENRES but specifically likes "science fiction" and classics.

    // Persona 5 watches movies that have been recommended to him/her.

    // Persona 5 cares about low-level aspects such as RATING and PLOT SUMMARY

    // Persona 5 is typically in a "bored" mood and will only watch movies if the plot summary has a good hook.
    public static User createUser5() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.SCIFI);
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.ROMANTIC_COMEDY);
        preferredGenres.add(Genre.DRAMA);
        preferredGenres.add(Genre.ACTION);
        preferredGenres.add(Genre.THRILLER);

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.RATING);
        checks.add(User.Checks.SUMMARY);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.BORED, new FreeTime(5, 0), new Group(1,
                false, false), User.Attention.FULL,  new ArrayList<>(), false,
                null, preferredGenres, checks, 3, likedActors, readBooks, likedDirectors);
    }

    // Persona 6 loves to watch movies of all kind and spends several hours a day watching movies.

    // Persona 6 is typically with their significant other.

    // Persona 6 watches all GENRES but specifically likes "science fiction" and classics.

    // Persona 6 cares about low-level aspects such as RATING, PLOT SUMMARY, and the ACTORS' FAME

    // Persona 6 is typically in their usual mood meaning they will watch a movie that has their preferred genres
    public static User createUser6() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.SCIFI);
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.ROMANTIC_COMEDY);
        preferredGenres.add(Genre.DRAMA);
        preferredGenres.add(Genre.ACTION);
        preferredGenres.add(Genre.THRILLER);

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.ACTORS_FAME);
        checks.add(User.Checks.SUMMARY);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.USUAL, new FreeTime(5, 0), new Group(2,
                true, false), User.Attention.FULL,  new ArrayList<>(), false,
                null, preferredGenres, checks, 3, likedActors, readBooks, likedDirectors);
    }

    // Persona 7 only watches in their peripheral when they do homework

    // Persona 7 only watches comedy movies because they're constantly stressed

    // Persona 7 only looks at the cover photo since they don't pay too much attention to the plot
    public static User createUser7() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.COMEDY);

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.STRESSED, new FreeTime(5, 0), new Group(1,
                false, false), User.Attention.LITTLE,  new ArrayList<>(), false,
                null, preferredGenres, checks, 3, likedActors, readBooks, likedDirectors);
    }

    // Persona 8 is a big reader and only watches movies if they have a book counterpart and he/she has read it

    // Persona 8 doesn't care much about the other aspects. If he/she read the book, then they assume they'll like the movie
    public static User createUser8() {
        List<Genre> preferredGenres = new ArrayList<>(Arrays.asList(Genre.values()));

        List<User.Checks> checks = new ArrayList<>();
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        readBooks.add(new Book("A Wrinkle in Time", 10, 1000, Book.ReadingDifficulty.MIDDLE_SCHOOL_LEVEL));
        readBooks.add(new Book("Ready Player One", 10, 1000, Book.ReadingDifficulty.MIDDLE_SCHOOL_LEVEL));
        readBooks.add(new Book("Gone with the Wind", 10, 1000, Book.ReadingDifficulty.HIGH_SCHOOL_LEVEL));
        readBooks.add(new Book("The Godfather", 10, 1000, Book.ReadingDifficulty.HIGH_SCHOOL_LEVEL));
        readBooks.add(new Book("Twilight", 10, 1000, Book.ReadingDifficulty.MIDDLE_SCHOOL_LEVEL));
        readBooks.add(new Book("Lord of the Rings", 10, 1000, Book.ReadingDifficulty.HIGH_SCHOOL_LEVEL));
        readBooks.add(new Book("The Hobbit", 10, 1000, Book.ReadingDifficulty.HIGH_SCHOOL_LEVEL));
        readBooks.add(new Book("Harry Potter and the Sorcerer's Stone", 10, 1000, Book.ReadingDifficulty.MIDDLE_SCHOOL_LEVEL));
        readBooks.add(new Book("The Princess Bride", 10, 1000, Book.ReadingDifficulty.MIDDLE_SCHOOL_LEVEL));
        readBooks.add(new Book("Jurassic Park", 10, 1000, Book.ReadingDifficulty.HIGH_SCHOOL_LEVEL));
        readBooks.add(new Book("The Hunger Games", 10, 1000, Book.ReadingDifficulty.HIGH_SCHOOL_LEVEL));
        readBooks.add(new Book("1984", 10, 1000, Book.ReadingDifficulty.COLLEGE_LEVEL));
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.BORED, new FreeTime(5, 0), new Group(1,
                false, false), User.Attention.FULL,  new ArrayList<>(), false,
                null, preferredGenres, checks, 3, likedActors, readBooks, likedDirectors);
    }


    // Persona 9 watches featured and recommended movies

    // Persona 9 cares about the cast most of all and watches the ones that have a famous director and/or actors

    // Persona 9 is typically in their usual mood
    public static User createUser9() {
        List<Genre> preferredGenres = new ArrayList<>();

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.ACTORS_FAME);
        checks.add(User.Checks.DIRECTOR);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();
        likedDirectors.add(new Director("Steven Spielberg", Reputation.GOOD, Fame.A_LIST));
        likedDirectors.add(new Director("Quentin Tarantino", Reputation.GOOD, Fame.A_LIST));
        likedDirectors.add(new Director("Wes Anderson", Reputation.GOOD, Fame.A_LIST));
        likedDirectors.add(new Director("Ridley Scott", Reputation.GOOD, Fame.A_LIST));
        likedDirectors.add(new Director("Christopher Nolan", Reputation.GOOD, Fame.A_LIST));
        likedDirectors.add(new Director("James Cameron", Reputation.GOOD, Fame.A_LIST));
        likedDirectors.add(new Director("George Lucas", Reputation.GOOD, Fame.A_LIST));

        return new User(User.Mood.USUAL, new FreeTime(5, 0), new Group(1,
                false, false), User.Attention.FULL,  new ArrayList<>(), false,
                null, preferredGenres, checks, 3, likedActors, readBooks, likedDirectors);
    }


    // Persona 10 watches movies with family frequently so decisions are always considered with family in mind

    public static User createUser10() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.SCIFI);
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.ROMANTIC_COMEDY);
        preferredGenres.add(Genre.DRAMA);
        preferredGenres.add(Genre.ACTION);
        preferredGenres.add(Genre.ADVENTURE);

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.RATING);
        checks.add(User.Checks.SUMMARY);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.BORED, new FreeTime(5, 0), new Group(1,
                false, true), User.Attention.FULL,  new ArrayList<>(), false,
                null, preferredGenres, checks, 3, likedActors, readBooks, likedDirectors);
    }

    // Persona 11 doesn't have any free time.

    public static User createUser11() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.SCIFI);
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.ROMANTIC_COMEDY);
        preferredGenres.add(Genre.DRAMA);
        preferredGenres.add(Genre.ACTION);
        preferredGenres.add(Genre.ADVENTURE);

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.RATING);
        checks.add(User.Checks.SUMMARY);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.BORED, new FreeTime(0, 0), new Group(1,
                false, true), User.Attention.FULL,  new ArrayList<>(), false,
                null, preferredGenres, checks, 3, likedActors, readBooks, likedDirectors);
    }

    // Persona 12 likes the more non-mainstream movies

    // Persona 12 only cares about the cover photo and rating

    // Persona 12 has watched so many movies that only the new movies are what's considered

    public static User createUser12() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.SCIFI);
        preferredGenres.add(Genre.DOCUMENTARY);
        preferredGenres.add(Genre.COMEDY);
        preferredGenres.add(Genre.FANTASY);
        preferredGenres.add(Genre.HISTORICAL_FICTION);

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.RATING);
        checks.add(User.Checks.NEW_MOVIES);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.BORED, new FreeTime(5, 0), new Group(1,
                false, true), User.Attention.FULL,  new ArrayList<>(), false,
                null, preferredGenres, checks, 3, likedActors, readBooks, likedDirectors);
    }

    // Persona 13 likes romantic or drama movies

    // Persona 13 only cares about the cover photo and the famous actors in the movie

    // Persona 13 considers recommended movies since she likes the recommendation algorithm

    public static User createUser13() {
        List<Genre> preferredGenres = new ArrayList<>();
        preferredGenres.add(Genre.ROMANTIC_COMEDY);
        preferredGenres.add(Genre.ROMANTIC);
        preferredGenres.add(Genre.DRAMA);

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.ACTORS_FAME);
        checks.add(User.Checks.RECOMMENDED_MOVIES);
        List<Actor> likedActors = new ArrayList<>();
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.USUAL, new FreeTime(5, 0), new Group(1,
                false, true), User.Attention.FULL,  new ArrayList<>(), false,
                null, preferredGenres, checks, 3, likedActors, readBooks, likedDirectors);
    }

    // Persona 14 likes all genres

    // Persona 14 only cares about the cover photo and preview

    // Persona 14 only considers the movies that has actors he/she likes

    public static User createUser14() {
        List<Genre> preferredGenres = new ArrayList<>(Arrays.asList(Genre.values()));

        List<User.Checks> checks = new ArrayList<>();
        checks.add(User.Checks.COVER_PHOTO);
        checks.add(User.Checks.PREVIEW);
        checks.add(User.Checks.LIKED_ACTORS);
        List<Actor> likedActors = new ArrayList<>();
        likedActors.add(new Actor("Johnny Depp", Reputation.GOOD, Fame.A_LIST));
        likedActors.add(new Actor("Brad Pitt", Reputation.GOOD, Fame.A_LIST));
        likedActors.add(new Actor("Will Smith", Reputation.GOOD, Fame.A_LIST));
        likedActors.add(new Actor("Jennifer Lawrence", Reputation.GOOD, Fame.A_LIST));
        likedActors.add(new Actor("Jennifer Aniston", Reputation.GOOD, Fame.A_LIST));
        likedActors.add(new Actor("Natalie Portman", Reputation.GOOD, Fame.A_LIST));
        likedActors.add(new Actor("Leonardo DiCaprio", Reputation.GOOD, Fame.A_LIST));
        likedActors.add(new Actor("Kate Winslet", Reputation.GOOD, Fame.A_LIST));
        likedActors.add(new Actor("Sandra Bullock", Reputation.GOOD, Fame.A_LIST));
        likedActors.add(new Actor("Reese Witherspoon", Reputation.GOOD, Fame.A_LIST));
        List<Book> readBooks = new ArrayList<>();
        List<Director> likedDirectors = new ArrayList<>();

        return new User(User.Mood.USUAL, new FreeTime(5, 0), new Group(1,
                false, true), User.Attention.FULL,  new ArrayList<>(), false,
                null, preferredGenres, checks, 3, likedActors, readBooks, likedDirectors);
    }
}
