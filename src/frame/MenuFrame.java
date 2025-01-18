package frame;

import mediators.Mediator;
import panels.GamePanel;
import panels.MenuPanel;
import panels.SidePanel;
import panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {
    private final Mediator mediator;

    public MenuFrame(Mediator mediator) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(400, 300));
        setTitle("Game of life");
        setVisible(true);

        this.mediator = mediator;
        this.mediator.addMenuFrame(this);
        MenuPanel panel = new MenuPanel(this.mediator);
        add(panel);
    }

    public void close(){
        GamePanel gamePanel = new GamePanel(mediator);
        TopPanel topPanel = new TopPanel(mediator);
        SidePanel sidePanel = new SidePanel(mediator);
        mediator.addGamePanel(gamePanel);
        mediator.addTopPanel(topPanel);

        gamePanel.calculateCellSize();
        MainFrame mainFrame = new MainFrame(mediator);
        mainFrame.add(gamePanel, BorderLayout.CENTER);
        mainFrame.add(topPanel, BorderLayout.NORTH);
        mainFrame.add(sidePanel, BorderLayout.EAST);
        setVisible(false);
    }
}
