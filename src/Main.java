import frame.MenuFrame;
import mediators.Mediator;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        new MenuFrame(mediator);
//        GamePanel gamePanel = new GamePanel(mediator, rows, cols);
//        TopPanel topPanel = new TopPanel(mediator);
//        SidePanel sidePanel = new SidePanel(mediator);
//        mediator.addGamePanel(gamePanel);
//        mediator.addTopPanel(topPanel);
//
//        gamePanel.calculateCellSize();
//        MainFrame mainFrame = new MainFrame(mediator);
//        mainFrame.add(gamePanel, BorderLayout.CENTER);
//        mainFrame.add(topPanel, BorderLayout.NORTH);
//        mainFrame.add(sidePanel, BorderLayout.EAST);
    }
}