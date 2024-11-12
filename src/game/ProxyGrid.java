package game;

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

    public boolean isStarted() {
        return this.started;
    }
}
