package game;

import strategy.Strategy;

public interface GridInterface {
    int getRows();

    int getColumns();

    boolean getCellState(int x, int y);

    void toggleCellState(int x, int y);

    int countLiveNeighbors(int x, int y);

    boolean nextGeneration();

    boolean isStarted();

    void clearGrid();

    int getGeneration();

    void setStarted(boolean started);

    void setStrategy(Strategy strategy);

    void increaseGeneration();

    void setGrid(boolean[][] grid);
}