import frame.MainFrame;
import mediators.Mediator;
import panels.GamePanel;
import panels.TopPanel;

public class Main {
    public static void main(String[] args) {
        final int rows = 40;
        final int cols = 40;

        Mediator mediator = new Mediator();
        MainFrame mainFrame = new MainFrame(mediator);
        GamePanel gamePanel = new GamePanel(mediator, rows, cols);
        TopPanel topPanel = new TopPanel(mediator);
        mediator.addGamePanel(gamePanel);
        mediator.addTopPanel(topPanel);


        gamePanel.calculateCellSize();

        mainFrame.add(gamePanel);
        mainFrame.add(topPanel);
    }
}