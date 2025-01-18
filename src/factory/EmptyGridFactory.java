package factory;

import game.CellGrid;

public class EmptyGridFactory implements GridFactory {
    private final int rows, cols;

    public EmptyGridFactory(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public CellGrid createGrid() {
        return new CellGrid(rows, cols);
    }
}
