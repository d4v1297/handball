import java.util.HashMap;
import java.util.Map;

public class Player {
    public enum Action {
        HIT_BY_KEEPER,
        MISS_BY_KEEPER,
        SAVE_NINE,
        SAVE_SEVEN,
        SAVE_SIX,
        SAVE_WING,
        SAVE_BREAKTHROUGH,
        SAVE_COUNTERATTACK,
        CONCEDED_NINE,
        CONCEDED_SEVEN,
        CONCEDED_SIX,
        CONCEDED_WING,
        CONCEDED_BREAKTHROUGH,
        CONCEDED_COUNTERATTACK,
        GOAL_NINE,
        GOAL_SEVEN,
        GOAL_SIX,
        GOAL_WING,
        GOAL_BREAKTHROUGH,
        GOAL_COUNTERATTACK,
        MISSED_NINE,
        MISSED_SEVEN,
        MISSED_SIX,
        MISSED_WING,
        MISSED_BREAKTHROUGH,
        MISSED_COUNTERATTACK,
        LOSS_OF_BALL,
        BALL_WIN,
        ASSIST,
        FETCHED_SEVEN_M,
        CAUSED_SEVEN_M,
        FETCHED_TWO_MINUTES,
        YELLOW_CARD,
        TWO_MINUTES,
        RED_CARD,
        TECHNICAL_MISTAKE,
        PASS_CATCH_MISTAKE
    }

    private final String name;
    private final int number;
    private final boolean isGoalkeeper;
    private final Map<Action, Integer> actionStats;

    public Player(String name, int number, boolean isGoalkeeper) {
        this.name = name;
        this.number = number;
        this.isGoalkeeper = isGoalkeeper;
        this.actionStats = new HashMap<>();

        for (Action action : Action.values()) {
            actionStats.put(action, 0);
        }
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
        return actionStats.get(Action.HIT_BY_KEEPER);
    }

    public void setHitByKeeper(int value) {
        actionStats.put(Action.HIT_BY_KEEPER, value);
    }

    public int getMissByKeeper() {
        return actionStats.get(Action.MISS_BY_KEEPER);
    }

    public void setMissByKeeper(int value) {
        actionStats.put(Action.MISS_BY_KEEPER, value);
    }

    public int getSaveNine() {
        return actionStats.get(Action.SAVE_NINE);
    }

    public void setSaveNine(int value) {
        actionStats.put(Action.SAVE_NINE, value);
    }

    public int getSaveSeven() {
        return actionStats.get(Action.SAVE_SEVEN);
    }

    public void setSaveSeven(int value) {
        actionStats.put(Action.SAVE_SEVEN, value);
    }

    public int getSaveSix() {
        return actionStats.get(Action.SAVE_SIX);
    }

    public void setSaveSix(int value) {
        actionStats.put(Action.SAVE_SIX, value);
    }

    public int getSaveWing() {
        return actionStats.get(Action.SAVE_WING);
    }

    public void setSaveWing(int value) {
        actionStats.put(Action.SAVE_WING, value);
    }

    public int getSaveBreakthrough() {
        return actionStats.get(Action.SAVE_BREAKTHROUGH);
    }

    public void setSaveBreakthrough(int value) {
        actionStats.put(Action.SAVE_BREAKTHROUGH, value);
    }

    public int getSaveCounterattack() {
        return actionStats.get(Action.SAVE_COUNTERATTACK);
    }

    public void setSaveCounterattack(int value) {
        actionStats.put(Action.SAVE_COUNTERATTACK, value);
    }


    public int getConcededNine() {
        return actionStats.get(Action.CONCEDED_NINE);
    }

    public void setConcededNine(int value) {
        actionStats.put(Action.CONCEDED_NINE, value);
    }

    public int getConcededSeven() {
        return actionStats.get(Action.CONCEDED_SEVEN);
    }

    public void setConcededSeven(int value) {
        actionStats.put(Action.CONCEDED_SEVEN, value);
    }

    public int getConcededSix() {
        return actionStats.get(Action.CONCEDED_SIX);
    }

    public void setConcededSix(int value) {
        actionStats.put(Action.CONCEDED_SIX, value);
    }

    public int getConcededWing() {
        return actionStats.get(Action.CONCEDED_WING);
    }

    public void setConcededWing(int value) {
        actionStats.put(Action.CONCEDED_WING, value);
    }

    public int getConcededBreakthrough() {
        return actionStats.get(Action.CONCEDED_BREAKTHROUGH);
    }

    public void setConcededBreakthrough(int value) {
        actionStats.put(Action.CONCEDED_BREAKTHROUGH, value);
    }

    public int getConcededCounterattack() {
        return actionStats.get(Action.CONCEDED_COUNTERATTACK);
    }

    public void setConcededCounterattack(int value) {
        actionStats.put(Action.CONCEDED_COUNTERATTACK, value);
    }


    public int getGoalNine() {
        return actionStats.get(Action.GOAL_NINE);
    }

    public void setGoalNine(int value) {
        actionStats.put(Action.GOAL_NINE, value);
    }

    public int getGoalSeven() {
        return actionStats.get(Action.GOAL_SEVEN);
    }

    public void setGoalSeven(int value) {
        actionStats.put(Action.GOAL_SEVEN, value);
    }

    public int getGoalSix() {
        return actionStats.get(Action.GOAL_SIX);
    }

    public void setGoalSix(int value) {
        actionStats.put(Action.GOAL_SIX, value);
    }

    public int getGoalWing() {
        return actionStats.get(Action.GOAL_WING);
    }

    public void setGoalWing(int value) {
        actionStats.put(Action.GOAL_WING, value);
    }

    public int getGoalBreakthrough() {
        return actionStats.get(Action.GOAL_BREAKTHROUGH);
    }

    public void setGoalBreakthrough(int value) {
        actionStats.put(Action.GOAL_BREAKTHROUGH, value);
    }

    public int getGoalCounterattack() {
        return actionStats.get(Action.GOAL_COUNTERATTACK);
    }

    public void setGoalCounterattack(int value) {
        actionStats.put(Action.GOAL_COUNTERATTACK, value);
    }


    public int getMissedNine() {
        return actionStats.get(Action.MISSED_NINE);
    }

    public void setMissedNine(int value) {
        actionStats.put(Action.MISSED_NINE, value);
    }

    public int getMissedSeven() {
        return actionStats.get(Action.MISSED_SEVEN);
    }

    public void setMissedSeven(int value) {
        actionStats.put(Action.MISSED_SEVEN, value);
    }

    public int getMissedSix() {
        return actionStats.get(Action.MISSED_SIX);
    }

    public void setMissedSix(int value) {
        actionStats.put(Action.MISSED_SIX, value);
    }

    public int getMissedWing() {
        return actionStats.get(Action.MISSED_WING);
    }

    public void setMissedWing(int value) {
        actionStats.put(Action.MISSED_WING, value);
    }

    public int getMissedBreakthrough() {
        return actionStats.get(Action.MISSED_BREAKTHROUGH);
    }

    public void setMissedBreakthrough(int value) {
        actionStats.put(Action.MISSED_BREAKTHROUGH, value);
    }

    public int getMissedCounterattack() {
        return actionStats.get(Action.MISSED_COUNTERATTACK);
    }

    public void setMissedCounterattack(int value) {
        actionStats.put(Action.MISSED_COUNTERATTACK, value);
    }


    public int getLossOfBall() {
        return actionStats.get(Action.LOSS_OF_BALL);
    }

    public void setLossOfBall(int value) {
        actionStats.put(Action.LOSS_OF_BALL, value);
    }

    public int getBallWin() {
        return actionStats.get(Action.BALL_WIN);
    }

    public void setBallWin(int value) {
        actionStats.put(Action.BALL_WIN, value);
    }

    public int getAssist() {
        return actionStats.get(Action.ASSIST);
    }

    public void setAssist(int value) {
        actionStats.put(Action.ASSIST, value);
    }

    public int getFetchedSevenM() {
        return actionStats.get(Action.FETCHED_SEVEN_M);
    }

    public void setFetchedSevenM(int value) {
        actionStats.put(Action.FETCHED_SEVEN_M, value);
    }

    public int getCausedSevenM() {
        return actionStats.get(Action.CAUSED_SEVEN_M);
    }

    public void setCausedSevenM(int value) {
        actionStats.put(Action.CAUSED_SEVEN_M, value);
    }

    public int getFetchedTwoMinutes() {
        return actionStats.get(Action.FETCHED_TWO_MINUTES);
    }

    public void setFetchedTwoMinutes(int value) {
        actionStats.put(Action.FETCHED_TWO_MINUTES, value);
    }


    public int getYellowCard() {
        return actionStats.get(Action.YELLOW_CARD);
    }

    public void setYellowCard(int value) {
        actionStats.put(Action.YELLOW_CARD, value);
    }

    public int getTwoMinutes() {
        return actionStats.get(Action.TWO_MINUTES);
    }

    public void setTwoMinutes(int value) {
        actionStats.put(Action.TWO_MINUTES, value);
    }

    public int getRedCard() {
        return actionStats.get(Action.RED_CARD);
    }

    public void setRedCard(int value) {
        actionStats.put(Action.RED_CARD, value);
    }

    public int getTechnicalMistake() {
        return actionStats.get(Action.TECHNICAL_MISTAKE);
    }

    public void setTechnicalMistake(int value) {
        actionStats.put(Action.TECHNICAL_MISTAKE, value);
    }

    public int getPassCatchMistake() {
        return actionStats.get(Action.PASS_CATCH_MISTAKE);
    }

    public void setPassCatchMistake(int value) {
        actionStats.put(Action.PASS_CATCH_MISTAKE, value);
    }

}