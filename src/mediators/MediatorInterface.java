package mediators;

import frame.MenuFrame;
import panels.GamePanel;
import panels.TopPanel;
import state.StateEnum;
import strategy.StrategyEnum;

interface MediatorInterface {

     void addGamePanel(GamePanel gamePanel);

     void addTopPanel(TopPanel topPanel);

     void addMenuFrame(MenuFrame menuFrame);

     void start();

     void stop();

     void clear();

     void setSpeed(int speed);

     void displayGeneration(int generation);

     void next();

     void resizePanels(int width, int height);

     void changeStrategy(StrategyEnum strategyType);

     void changePattern(StateEnum patternType);

     void closeMenu();

     void createGrid(int gridType, int rows, int cols);

     void saveGrid();
}
