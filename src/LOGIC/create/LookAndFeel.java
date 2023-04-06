package LOGIC.create;

import javax.swing.*;

public class LookAndFeel {
    /**
     * Setzt das Look and Feel der Anwendung auf das System-Look and Feel.
     */
    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
