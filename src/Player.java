public class Player {
    private String name;
    private int number;
    private boolean isGoalkeeper;
    private int goals;
    private int misses;
    private int assists;

    public Player(String name, int number, boolean isGoalkeeper) {
        this.name = name;
        this.number = number;
        this.isGoalkeeper = isGoalkeeper;
        this.goals = 0;
        this.misses = 0;
        this.assists = 0;
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

    public int getGoals() {
        return goals;
    }

    public int getMisses() {
        return misses;
    }

    public int getAssists() {
        return assists;
    }

    public void incrementGoals() {
        goals++;
    }

    public void incrementMisses() {
        misses++;
    }

    public void incrementAssists() {
        assists++;
    }
}
