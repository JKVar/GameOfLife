package mediators;

import frame.MenuFrame;
import panels.GamePanel;
import panels.TopPanel;
import state.StateEnum;
import strategy.StrategyEnum;

public class Mediator implements MediatorInterface {
    private GamePanel gamePanel;
    private TopPanel topPanel;
    private MenuFrame menuFrame;

    @Override
    public void addGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void addTopPanel(TopPanel topPanel) {
        this.topPanel = topPanel;
    }

    @Override
    public void addMenuFrame(MenuFrame menuFrame) {
        this.menuFrame = menuFrame;
    }

    @Override
    public void start() {
        gamePanel.start();
    }

    @Override
    public void stop() {
        gamePanel.stop();
    }

    @Override
    public void clear() {
        gamePanel.clear();
    }

    @Override
    public void setSpeed(int speed) {
        gamePanel.changeDelay(speed);
    }

    @Override
    public void displayGeneration(int generation) {
        topPanel.displayGeneration(generation);
    }

    @Override
    public void next() {
        gamePanel.nextGeneration();
    }

    @Override
    public void resizePanels(int width, int height) {
        gamePanel.calculateCellSize();
    }

    @Override
    public void changeStrategy(StrategyEnum strategyType) {
        gamePanel.changeStrategy(strategyType);
    }

    @Override
    public void changePattern(StateEnum patternType) {
        gamePanel.changePattern(patternType);
    }

    @Override
    public void closeMenu(){
        menuFrame.close();
    }

    @Override
    public void createGrid(int gridType, int rows, int cols) {
        gamePanel.createGrid(gridType, rows, cols);
    }
}
