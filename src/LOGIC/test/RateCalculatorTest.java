package LOGIC.test;

import LOGIC.buissneslogic.RateCalculator;
import MODEL.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RateCalculatorTest {

    @Test
    public void testGetThrowQuote() {
        // Arrange
        Player player = new Player("Timo", 3, false);
        player.setGoalNine(5);
        player.setGoalSeven(2);
        player.setGoalSix(6);
        player.setGoalBreakthrough(1);
        player.setGoalCounterattack(3);
        player.setMissedNine(5);
        player.setMissedSeven(2);
        player.setMissedSix(6);
        player.setMissedBreakthrough(1);
        player.setMissedCounterattack(3);

        // Act
        double throwQuote = RateCalculator.getThrowQuote(player);

        // Assert
        assertEquals(50.00, throwQuote, 0.01);
    }

    @Test
    public void testGetParadeRate() {
        // Arrange
        Player player = new Player("Davis", 24, true);
        player.setSaveNine(5);
        player.setSaveSeven(5);
        player.setSaveSix(5);
        player.setSaveWing(5);
        player.setSaveBreakthrough(5);
        player.setSaveCounterattack(5);
        player.setConcededNine(5);
        player.setConcededSeven(5);
        player.setConcededSix(5);
        player.setConcededWing(5);
        player.setConcededBreakthrough(5);
        player.setConcededCounterattack(5);

        // Act
        double paradeRate = RateCalculator.getParadeRate(player);

        // Assert
        assertEquals(50.00, paradeRate, 0.01);
    }
}
