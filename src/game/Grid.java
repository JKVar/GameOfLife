package game;

import state.PatternContext;
import state.PatternState;
import strategy.OriginalStrategy;
import strategy.Strategy;

// this will be the context in the case of the strategy pattern
public class Grid implements GridInterface {
    private CellGrid grid;
    private final int rows;
    private final int columns;
    private int generation = 0;
    private boolean started = false;
    private Strategy strategy;
    private final PatternContext patternContext;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new CellGrid(rows, columns);
        this.strategy = new OriginalStrategy();
        this.patternContext = new PatternContext();
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
        return this.grid.getState(x, y);
    }

    public void toggleCellState(int x, int y) {
        if (isOnGrid(x, y)) {
            this.grid.setState(x, y, !this.grid.getState(x, y));
        }
    }

    public int countLiveNeighbors(int x, int y) {
        int liveNeighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = (x + rows + i) % rows;
                int c = (y + columns +j) % columns;
                if (isOnGrid(r, c) && grid.getState(r, c)) {
                    liveNeighbors++;
                }
            }
        }
        return liveNeighbors;
    }

    public boolean nextGeneration() {
        return strategy.nextGeneration(this);
    }

    public void clearGrid() {
        this.generation = 0;
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.grid.setState(i, j, false);
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

    public void setGrid(CellGrid grid) {
        this.grid = grid;
    }

    public CellGrid getGrid() {
        return this.grid;
    }

    @Override
    public void setPatternState(PatternState state) {
        patternContext.setPatternState(state);
    }

    public void increaseGeneration() {
        this.generation++;
    }

    @Override
    public void placePatternOnGrid(int x, int y) {
//        for (int i = 0; i < pattern.getRows(); i++) {
//            for (int j = 0; j < pattern.getRows(); j++) {
//                grid.setState((x+i) % rows, (y+j) % columns, pattern.getState(i, j));
//            }
//        }
        patternContext.placePattern(x, y, this.grid);
    }
}
