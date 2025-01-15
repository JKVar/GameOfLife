package strategy;

import game.CellGrid;
import game.Grid;

public abstract class Strategy {
    public boolean nextGeneration(Grid grid) {
        int rows = grid.getRows();
        int columns = grid.getColumns();
        CellGrid newGrid = new CellGrid(rows, columns);
        boolean hasChanged = false;
        grid.increaseGeneration();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int liveNeighbors = grid.countLiveNeighbors(row, col);
                if (grid.getCellState(row, col)) {
                    newGrid.setState(row, col, survivalRule(liveNeighbors));
                } else {
                    newGrid.setState(row, col, creationRule(liveNeighbors));
                }
                if (grid.getCellState(row, col) != newGrid.getState(row, col)) {
                    hasChanged = true;
                }
            }
        }

        grid.setGrid(newGrid);

        return hasChanged;
    }

    protected boolean survivalRule(int liveNeighbors) {
        return (liveNeighbors == 2 || liveNeighbors == 3);
    }

    protected boolean creationRule(int liveNeighbors) {
        return (liveNeighbors == 3);
    }
}
