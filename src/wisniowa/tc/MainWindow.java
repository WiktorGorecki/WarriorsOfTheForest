package wisniowa.tc;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow(int width, int height, Team team) {
        setSize(width + 16, height + 40);
        setResizable(false);
        add(new GamePanel(team));
        setVisible(true);
    }
}
