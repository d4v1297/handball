package LOGIC.test;


import LOGIC.buissneslogic.UpdateAndIncrement;
import MODEL.Player;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UpdateAndIncrementTest {
    @Test
    void testUpdateGoalkeeperAction() {
        Player player = new Player("Test Goalkeeper", 1, true);
        String action = "saveNine";

        UpdateAndIncrement.updatePlayerStats(player, action);

        assertEquals(1, player.getSaveNine());
    }

    @Test
    void testUpdateFieldPlayerAction() {
        Player player = new Player("Test Field Player", 2, false);
        String action = "goalNine";

        UpdateAndIncrement.updatePlayerStats(player, action);

        assertEquals(1, player.getGoalNine());
    }

    @Test
    void testUpdatePlayerAction() {
        Player player = new Player("Test Player", 3, false);
        String action = "assist";

        UpdateAndIncrement.updatePlayerStats(player, action);

        assertEquals(1, player.getAssist());
    }

    @Test
    void testUnknownActionException() {
        Player player = new Player("Test Player", 4, false);
        String action = "unknownAction";

        assertThrows(IllegalArgumentException.class, () -> UpdateAndIncrement.updatePlayerStats(player, action));
    }

    @Test
    void testMissingGetterAndSetterException() {
        Player player = new Player("Test Player", 5, false);
        String action = "missingGetterAndSetter";

        assertThrows(RuntimeException.class, () -> UpdateAndIncrement.updatePlayerStats(player, action));
    }
    @Test
    void testUpdatePlayerActionWithMock() {
        Player mockPlayer = Mockito.mock(Player.class);

        when(mockPlayer.getAssist()).thenReturn(0);

        String action = "assist";
        UpdateAndIncrement.updatePlayerStats(mockPlayer, action);

        verify(mockPlayer, times(1)).getAssist();
        verify(mockPlayer, times(1)).setAssist(1);
    }
}
