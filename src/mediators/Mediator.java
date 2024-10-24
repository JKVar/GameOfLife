package mediators;

import panels.GamePanel;
import panels.TopPanel;

import javax.swing.*;

public class Mediator {
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
}
