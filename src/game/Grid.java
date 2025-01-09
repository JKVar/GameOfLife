package game;

import strategy.OriginalStrategy;
import strategy.Strategy;

// this will be the context in the case of the strategy pattern
public class Grid implements GridInterface {
    private boolean[][] grid;
    private final int rows;
    private final int columns;
    private int generation = 0;
    private boolean started = false;
    private Strategy strategy;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new boolean[rows][columns];
        this.strategy = new OriginalStrategy();
    }

    private boolean isOnGrid(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public boolean getCellState(int x, int y) {
        return this.grid[x][y];
    }

    public void toggleCellState(int x, int y) {
        if (isOnGrid(x, y)) {
            this.grid[x][y] = !this.grid[x][y];
        }
    }

    public int countLiveNeighbors(int x, int y) {
        int liveNeighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = (x + rows + i) % rows;
                int c = (y + columns +j) % columns;
                if (isOnGrid(r, c) && grid[r][c]) {
                    liveNeighbors++;
                }
            }
        }
        return liveNeighbors;
    }

    public boolean nextGeneration() {
//        boolean[][] newGrid = new boolean[rows][columns];
//        boolean hasChanged = false;
//        this.generation++;
//
//        for (int row = 0; row < rows; row++) {
//            for (int col = 0; col < columns; col++) {
//                int liveNeighbors = countLiveNeighbors(row, col);
//                if (grid[row][col]) {
//                    newGrid[row][col] = (liveNeighbors == 2 || liveNeighbors == 3);
//                } else {
//                    newGrid[row][col] = liveNeighbors == 3;
//                }
//                if (grid[row][col] != newGrid[row][col]) {
//                    hasChanged = true;
//                }
//            }
//        }
//
//        grid = newGrid;

        return strategy.nextGeneration(this);
    }

    public void clearGrid() {
        this.generation = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.grid[i][j] = false;
            }
        }
    }

    public int getGeneration() {
        return this.generation;
    }

    @Override
    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isStarted() {
        return this.started;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setGrid(boolean[][] grid) {
        this.grid = grid;
    }

    public void increaseGeneration() {
        this.generation++;
    }
}
