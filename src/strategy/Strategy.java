package strategy;

import game.CellGrid;
import game.Grid;

public abstract class Strategy {
    public boolean nextGeneration(Grid grid) {
        int rows = grid.getRows();
        int columns = grid.getColumns();
        int liveNeighbors;
        CellGrid newGrid = new CellGrid(rows, columns);
        boolean hasChanged = false;
        grid.increaseGeneration();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (grid.getGrid().isDirty(row, col)) {
                    liveNeighbors = grid.countLiveNeighbors(row, col);
                    newGrid.setDirty(row, col, newGrid.isDirty(row, col));
                    if (grid.getCellState(row, col)) {
                        newGrid.setState(row, col, survivalRule(liveNeighbors));
                    } else {
                        newGrid.setState(row, col, creationRule(liveNeighbors));
                    }
                    if (grid.getCellState(row, col) != newGrid.getState(row, col)) {
                        setNeighboursDirty(row, col, newGrid);
                        newGrid.setDirty(row, col, true);
                        hasChanged = true;
                    }
                }
            }
        }

        System.out.println(newGrid);
        grid.setGrid(newGrid);

        return hasChanged;
    }

    private void setNeighboursDirty(int x, int y, CellGrid grid) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                grid.setDirty((x+i+grid.getRows()) % grid.getRows(), (y+j+grid.getCols()) % grid.getCols(), true);
            }
        }
    }

    protected boolean survivalRule(int liveNeighbors) {
        return (liveNeighbors == 2 || liveNeighbors == 3);
    }

    protected boolean creationRule(int liveNeighbors) {
        return (liveNeighbors == 3);
    }
}
