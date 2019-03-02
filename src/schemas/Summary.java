package schemas;

public class Summary {

    //Represents how comprehensive the summary in relation to the movie
    public enum Comprehensive {
        VERY_LITTLE,
        SOMEWHAT,
        MOSTLY,
        SPOILS_PLOT
    }
    //Represents how well the summary can hook a user into watching the movie
    public enum Hook {
        BAD,
        OKAY,
        GOOD
    }
    public enum ReadingDifficulty {
        ELEMENTARY_LEVEL,
        MIDDLE_SCHOOL_LEVEL,
        HIGH_SCHOOL_LEVEL,
        COLLEGE_LEVEL,
        GRADUATE_LEVEL,
        INCOMPREHENSIBLE
    }
    private int SummaryWordLength;
    private Comprehensive comprehensive;
    private Hook hookLevel;
    private ReadingDifficulty readingDifficulty;

    public Summary(int summaryWordLength, Comprehensive comprehensive, Hook hookLevel, ReadingDifficulty readingDifficulty) {
        SummaryWordLength = summaryWordLength;
        this.comprehensive = comprehensive;
        this.hookLevel = hookLevel;
        this.readingDifficulty = readingDifficulty;
    }

    public int getSummaryWordLength() {
        return SummaryWordLength;
    }

    public void setSummaryWordLength(int summaryWordLength) {
        SummaryWordLength = summaryWordLength;
    }

    public Comprehensive getComprehensive() {
        return comprehensive;
    }

    public void setComprehensive(Comprehensive comprehensive) {
        this.comprehensive = comprehensive;
    }

    public Hook getHookLevel() {
        return hookLevel;
    }

    public void setHookLevel(Hook hookLevel) {
        this.hookLevel = hookLevel;
    }

    public ReadingDifficulty getReadingDifficulty() {
        return readingDifficulty;
    }

    public void setReadingDifficulty(ReadingDifficulty readingDifficulty) {
        this.readingDifficulty = readingDifficulty;
    }
}
