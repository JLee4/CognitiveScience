package schemas;

public class Appeal {
    //This is ordered from most appealing to least appealing
    public enum AppealLevel {
        DISTASTEFUL,
        BAD,
        WEIRD,
        UNINTERESTING,
        EYE_CATCHING,
        MEMORABLE,
        ICONIC
    }

    //level is defined by the place of the AppealLevel with UNINTERESTING as the base level (0)
//    ICONIC: 3
//    MEMORABLE: 2
//    EYE_CATCHING: 1
//    UNINTERESTING: 0
//    WEIRD: -1
//    BAD: -2
//    DISTASTEFUL: -3
    private int level;
    private AppealLevel appealLevel;

    public Appeal(AppealLevel appealLevel) {
        this.appealLevel = appealLevel;
        this.level = appealLevel.ordinal() - 3;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public AppealLevel getAppealLevel() {
        return appealLevel;
    }

    public void setAppealLevel(AppealLevel appealLevel) {
        this.appealLevel = appealLevel;
    }

    @Override
    public String toString() {
        return appealLevel.name().toLowerCase();
    }
}
