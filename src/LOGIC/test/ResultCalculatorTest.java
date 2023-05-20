package LOGIC.test;

import LOGIC.buissneslogic.ResultCalculator;
import MODEL.Player;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultCalculatorTest {

    @Test
    public void testGetTore() {
        // Arrange
        HashMap<String, Player> playerMap = new HashMap<>();
        Player player1 = new Player("Jan", 2, false);
        player1.setGoalNine(2);
        player1.setGoalSeven(1);
        player1.setGoalSix(3);
        player1.setGoalWing(0);
        player1.setGoalBreakthrough(2);
        player1.setGoalCounterattack(1);
        playerMap.put("Player1", player1);

        Player player2 = new Player("David", 4, false);
        player2.setGoalNine(1);
        player2.setGoalSeven(2);
        player2.setGoalSix(0);
        player2.setGoalWing(1);
        player2.setGoalBreakthrough(1);
        player2.setGoalCounterattack(0);
        playerMap.put("Player2", player2);

        // Act
        int totalGoals = ResultCalculator.getTore(playerMap);

        // Assert
        assertEquals(13, totalGoals);
    }

    @Test
    public void testGetGegenTore() {
        // Arrange
        HashMap<String, Player> playerMap = new HashMap<>();
        Player player1 = new Player("Davis", 24, true);
        player1.setConcededNine(3);
        player1.setConcededSeven(2);
        player1.setConcededSix(1);
        player1.setConcededWing(0);
        player1.setConcededBreakthrough(2);
        player1.setConcededCounterattack(1);
        playerMap.put("Player1", player1);

        Player player2 = new Player("Tim", 12, true);
        player2.setConcededNine(2);
        player2.setConcededSeven(1);
        player2.setConcededSix(0);
        player2.setConcededWing(1);
        player2.setConcededBreakthrough(1);
        player2.setConcededCounterattack(0);
        playerMap.put("Player2", player2);

        // Act
        int totalGoalsConceded = ResultCalculator.getGegenTore(playerMap);

        // Assert
        assertEquals(10, totalGoalsConceded);
    }
}
