public class Player {
    private final String name;
    private final int number;
    private final boolean isGoalkeeper;

    //Keeperaktion
    private int hitByKeeper = 0;
    private int missByKeeper = 0;
    private int saveNine = 0;
    private int saveSeven = 0;
    private int saveSix = 0;
    private int saveWing = 0;
    private int saveBreakthrough = 0;
    private int saveCounterattack = 0;
    private int concededNine = 0;
    private int concededSeven = 0;
    private int concededSix = 0;
    private int concededWing = 0;
    private int concededBreakthrough = 0;
    private int concededCounterattack = 0;

    //Feldspieleraktion
    private int goalNine = 0;
    private int goalSeven = 0;
    private int goalSix = 0;
    private int goalWing = 0;
    private int goalBreakthrough = 0;
    private int goalCounterattack = 0;
    private int missedNine = 0;
    private int missedSeven = 0;
    private int missedSix = 0;
    private int missedWing = 0;
    private int missedBreakthrough = 0;
    private int missedCounterattack = 0;

    //Spieleraktion
    private int lossOfBall = 0;
    private int ballWin = 0;
    private int assist = 0;
    private int fetchedSevenM = 0;
    private int causedSevenM = 0;
    private int fetchedTwoMinutes = 0;
    private int yellowCard = 0;
    private int twoMinutes = 0;
    private int redCard = 0;
    private int technicalMistake = 0;
    private int passCatchMistake = 0;



    public Player(String name, int number, boolean isGoalkeeper) {
        this.name = name;
        this.number = number;
        this.isGoalkeeper = isGoalkeeper;
    }


    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public boolean isGoalkeeper() {
        return isGoalkeeper;
    }

    public int getHitByKeeper() {
        return hitByKeeper;
    }

    public void setHitByKeeper(int hitByKeeper) {
        this.hitByKeeper = hitByKeeper;
    }

    public int getMissByKeeper() {
        return missByKeeper;
    }

    public void setMissByKeeper(int missByKeeper) {
        this.missByKeeper = missByKeeper;
    }

    public int getSaveNine() {
        return saveNine;
    }

    public void setSaveNine(int saveNine) {
        this.saveNine = saveNine;
    }

    public int getSaveSeven() {
        return saveSeven;
    }

    public void setSaveSeven(int saveSeven) {
        this.saveSeven = saveSeven;
    }

    public int getSaveSix() {
        return saveSix;
    }

    public void setSaveSix(int saveSix) {
        this.saveSix = saveSix;
    }

    public int getSaveWing() {
        return saveWing;
    }

    public void setSaveWing(int saveWing) {
        this.saveWing = saveWing;
    }

    public int getSaveBreakthrough() {
        return saveBreakthrough;
    }

    public void setSaveBreakthrough(int saveBreakthrough) {
        this.saveBreakthrough = saveBreakthrough;
    }

    public int getSaveCounterattack() {
        return saveCounterattack;
    }

    public void setSaveCounterattack(int saveCounterattack) {
        this.saveCounterattack = saveCounterattack;
    }

    public int getConcededNine() {
        return concededNine;
    }

    public void setConcededNine(int concededNine) {
        this.concededNine = concededNine;
    }

    public int getConcededSeven() {
        return concededSeven;
    }

    public void setConcededSeven(int concededSeven) {
        this.concededSeven = concededSeven;
    }

    public int getConcededSix() {
        return concededSix;
    }

    public void setConcededSix(int concededSix) {
        this.concededSix = concededSix;
    }

    public int getConcededWing() {
        return concededWing;
    }

    public void setConcededWing(int concededWing) {
        this.concededWing = concededWing;
    }

    public int getConcededBreakthrough() {
        return concededBreakthrough;
    }

    public void setConcededBreakthrough(int concededBreakthrough) {
        this.concededBreakthrough = concededBreakthrough;
    }

    public int getConcededCounterattack() {
        return concededCounterattack;
    }

    public void setConcededCounterattack(int concededCounterattack) {
        this.concededCounterattack = concededCounterattack;
    }

    public int getGoalNine() {
        return goalNine;
    }

    public void setGoalNine(int goalNine) {
        this.goalNine = goalNine;
    }

    public int getGoalSeven() {
        return goalSeven;
    }

    public void setGoalSeven(int goalSeven) {
        this.goalSeven = goalSeven;
    }

    public int getGoalSix() {
        return goalSix;
    }

    public void setGoalSix(int goalSix) {
        this.goalSix = goalSix;
    }

    public int getGoalWing() {
        return goalWing;
    }

    public void setGoalWing(int goalWing) {
        this.goalWing = goalWing;
    }

    public int getGoalBreakthrough() {
        return goalBreakthrough;
    }

    public void setGoalBreakthrough(int goalBreakthrough) {
        this.goalBreakthrough = goalBreakthrough;
    }

    public int getGoalCounterattack() {
        return goalCounterattack;
    }

    public void setGoalCounterattack(int goalCounterattack) {
        this.goalCounterattack = goalCounterattack;
    }

    public int getMissedNine() {
        return missedNine;
    }

    public void setMissedNine(int missedNine) {
        this.missedNine = missedNine;
    }

    public int getMissedSeven() {
        return missedSeven;
    }

    public void setMissedSeven(int missedSeven) {
        this.missedSeven = missedSeven;
    }

    public int getMissedSix() {
        return missedSix;
    }

    public void setMissedSix(int missedSix) {
        this.missedSix = missedSix;
    }

    public int getMissedWing() {
        return missedWing;
    }

    public void setMissedWing(int missedWing) {
        this.missedWing = missedWing;
    }

    public int getMissedBreakthrough() {
        return missedBreakthrough;
    }

    public void setMissedBreakthrough(int missedBreakthrough) {
        this.missedBreakthrough = missedBreakthrough;
    }

    public int getMissedCounterattack() {
        return missedCounterattack;
    }

    public void setMissedCounterattack(int missedCounterattack) {
        this.missedCounterattack = missedCounterattack;
    }

    public int getLossOfBall() {
        return lossOfBall;
    }

    public void setLossOfBall(int lossOfBall) {
        this.lossOfBall = lossOfBall;
    }

    public int getBallWin() {
        return ballWin;
    }

    public void setBallWin(int ballWin) {
        this.ballWin = ballWin;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public int getFetchedSevenM() {
        return fetchedSevenM;
    }

    public void setFetchedSevenM(int fetchedSevenM) {
        this.fetchedSevenM = fetchedSevenM;
    }

    public int getCausedSevenM() {
        return causedSevenM;
    }

    public void setCausedSevenM(int causedSevenM) {
        this.causedSevenM = causedSevenM;
    }

    public int getFetchedTwoMinutes() {
        return fetchedTwoMinutes;
    }

    public void setFetchedTwoMinutes(int fetchedTwoMinutes) {
        this.fetchedTwoMinutes = fetchedTwoMinutes;
    }

    public int getYellowCard() {
        return yellowCard;
    }

    public void setYellowCard(int yellowCard) {
        this.yellowCard = yellowCard;
    }

    public int getTwoMinutes() {
        return twoMinutes;
    }

    public void setTwoMinutes(int twoMinutes) {
        this.twoMinutes = twoMinutes;
    }

    public int getRedCard() {
        return redCard;
    }

    public void setRedCard(int redCard) {
        this.redCard = redCard;
    }

    public int getTechnicalMistake() {
        return technicalMistake;
    }

    public void setTechnicalMistake(int technicalMistake) {
        this.technicalMistake = technicalMistake;
    }

    public int getPassCatchMistake() {
        return passCatchMistake;
    }

    public void setPassCatchMistake(int passCatchMistake) {
        this.passCatchMistake = passCatchMistake;
    }
}
