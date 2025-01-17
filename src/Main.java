import frame.MainFrame;
import mediators.Mediator;
import panels.GamePanel;
import panels.SidePanel;
import panels.TopPanel;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        final int rows = 20;
        final int cols = 20;

        Mediator mediator = new Mediator();
        GamePanel gamePanel = new GamePanel(mediator, rows, cols);
        TopPanel topPanel = new TopPanel(mediator);
        SidePanel sidePanel = new SidePanel(mediator);
        mediator.addGamePanel(gamePanel);
        mediator.addTopPanel(topPanel);

        gamePanel.calculateCellSize();
        MainFrame mainFrame = new MainFrame(mediator);
        mainFrame.add(gamePanel, BorderLayout.CENTER);
        mainFrame.add(topPanel, BorderLayout.NORTH);
        mainFrame.add(sidePanel, BorderLayout.EAST);
    }
}