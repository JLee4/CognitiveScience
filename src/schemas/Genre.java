package schemas;

public enum Genre {
    DOCUMENTARY,
    ANIMATED,
    FAMILY,
    COMEDY,
    ROMANTIC,
    FANTASY,
    SCIFI,
    DRAMA,
    ACTION,
    HORROR,
    THRILLER,
    HISTORICAL_FICTION,
    ADVENTURE,
    MYSTERY;

    //This sees if a genre is related to another genre e.g. COMEDY is related to ROMANTIC_COMEDY
    //This is determined by ordinal distance.
    public boolean relatedGenre(Genre genre) {
        return (this.ordinal() - genre.ordinal()) < 2;
    }
}
