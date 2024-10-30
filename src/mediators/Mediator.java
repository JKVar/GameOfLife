package mediators;

import panels.GamePanel;
import panels.TopPanel;

public class Mediator implements MediatorInterface {
    private GamePanel gamePanel;
    private TopPanel topPanel;

    public void addGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void addTopPanel(TopPanel topPanel) {
        this.topPanel = topPanel;
    }

    public void start() {
        gamePanel.start();
    }

    public void stop() {
        gamePanel.stop();
    }

    public void clear() {
        gamePanel.clear();
    }

    public void setSpeed(int speed) {
        gamePanel.changeDelay(speed);
    }

    public void displayGeneration(int generation) {
        topPanel.displayGeneration(generation);
    }

    public void next() {
        gamePanel.nextGeneration();
    }

    public void resizePanels(int width, int height) {
        final int topPanelHeight = 75;
        final int gpp = 5; // gamePanel padding
        topPanel.setBounds(0, 0, width, topPanelHeight);
        gamePanel.setBounds(gpp, topPanelHeight + gpp, width - 2 * gpp, height - topPanelHeight - 2 * gpp);
        gamePanel.calculateCellSize();
    }
}
