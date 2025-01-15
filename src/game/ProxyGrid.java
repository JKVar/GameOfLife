package game;

import state.PatternState;
import strategy.Strategy;

public class ProxyGrid implements GridInterface {
    private final Grid realGrid;
    private boolean started;

    public ProxyGrid(int rows, int columns) {
        this.realGrid = new Grid(rows,columns);
        this.started = false;
    }

    @Override
    public int getRows() {
        return realGrid.getRows();
    }

    @Override
    public int getColumns() {
        return realGrid.getColumns();
    }

    @Override
    public boolean getCellState(int x, int y) {
        return realGrid.getCellState(x, y);
    }

    @Override
    public void toggleCellState(int x, int y) {
        if (!started) {
            realGrid.toggleCellState(x, y);
        }
    }

    @Override
    public int countLiveNeighbors(int x, int y) {
        return realGrid.countLiveNeighbors(x, y);
    }

    @Override
    public boolean nextGeneration() {
        return realGrid.nextGeneration();
    }

    @Override
    public void clearGrid() {
        realGrid.clearGrid();
    }

    @Override
    public int getGeneration() {
        return realGrid.getGeneration();
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    @Override
    public void setStrategy(Strategy strategy) {
        this.realGrid.setStrategy(strategy);
    }

    @Override
    public void increaseGeneration() {
        this.realGrid.increaseGeneration();
    }

    @Override
    public void setGrid(CellGrid grid) {
        this.realGrid.setGrid(grid);
    }

    @Override
    public CellGrid getGrid() {
        return realGrid.getGrid();
    }

    @Override
    public void setPatternState(PatternState state) {
        this.realGrid.setPatternState(state);
    }

    public boolean isStarted() {
        return this.started;
    }

    @Override
    public void placePatternOnGrid(int x, int y) {
        if (!started) {
            this.realGrid.placePatternOnGrid(x, y);
        }
    }


}
