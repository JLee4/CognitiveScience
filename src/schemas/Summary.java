package schemas;

public class Summary {

    //Represents how comprehensive the summary in relation to the movie
    public enum Comprehensive {
        VERY_LITTLE,
        SOMEWHAT,
        MOSTLY,
        SPOILS_PLOT;

        public int getPointLevel() {
            switch (this) {
                case VERY_LITTLE:
                    return 80;
                case SOMEWHAT:
                    return 30;
                case MOSTLY:
                    return 0;
                case SPOILS_PLOT:
                    return 100;
            }
            return 0;
        }
    }
    //Represents how well the summary can hook a user into watching the movie
    public enum Hook {
        BAD,
        OKAY,
        GOOD;

        public int getPointLevel() {
            switch (this) {
                case GOOD:
                    return -20;
                case OKAY:
                    return 0;
                case BAD:
                    return 100;
            }
            return 0;
        }
    }
    public enum ReadingDifficulty {
        ELEMENTARY_LEVEL,
        MIDDLE_SCHOOL_LEVEL,
        HIGH_SCHOOL_LEVEL,
        COLLEGE_LEVEL,
        GRADUATE_LEVEL,
        INCOMPREHENSIBLE;

        public int getPointLevel() {
            switch (this) {
                case ELEMENTARY_LEVEL:
                    return 0;
                case MIDDLE_SCHOOL_LEVEL:
                    return 20;
                case COLLEGE_LEVEL:
                    return 30;
                case HIGH_SCHOOL_LEVEL:
                    return 40;
                case GRADUATE_LEVEL:
                    return 50;
                case INCOMPREHENSIBLE:
                    return 100;
            }
            return 0;
        }
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

    public int getPointLevel() {
        return comprehensive.getPointLevel() + hookLevel.getPointLevel() + readingDifficulty.getPointLevel();
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
