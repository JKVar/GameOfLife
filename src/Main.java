import frame.MainFrame;
import mediators.Mediator;
import panels.GamePanel;
import panels.TopPanel;

public class Main {
    public static void main(String[] args) {
        final int topPanelHeight = 75;
        final int gpp = 5; // gamePanel padding
        final int rows = 25;
        final int cols = 25;

        MainFrame mainFrame = new MainFrame();
        Mediator mediator = new Mediator();
        GamePanel gamePanel = new GamePanel(mediator, rows, cols);
        TopPanel topPanel = new TopPanel(mediator);
        mediator.addGamePanel(gamePanel);
        mediator.addTopPanel(topPanel);


        topPanel.setBounds(0, 0, mainFrame.getWidth(), topPanelHeight);
        gamePanel.setBounds(gpp, topPanelHeight + gpp, mainFrame.getWidth() - 2 * gpp, mainFrame.getHeight() - topPanelHeight - 2 * gpp);
        gamePanel.calculateCellSize();

        mainFrame.add(gamePanel);
        mainFrame.add(topPanel);

    }
}