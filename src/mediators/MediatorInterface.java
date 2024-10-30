package mediators;

import panels.GamePanel;
import panels.TopPanel;

 interface MediatorInterface {

     void addGamePanel(GamePanel gamePanel);

     void addTopPanel(TopPanel topPanel);

     void start();

     void stop();

     void clear();

     void setSpeed(int speed);

     void displayGeneration(int generation);

     void next();

     void resizePanels(int width, int height);
}
