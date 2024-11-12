package game;

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
}