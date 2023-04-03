public class Player {
    private final String name;
    private final int number;
    private final boolean isGoalkeeper;

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
}
