package strategy;

import game.CellGrid;
import game.Grid;

public class OriginalStrategy implements Strategy{
    @Override
    public boolean nextGeneration(Grid grid) {
        int rows = grid.getRows();
        int columns = grid.getColumns();
//        [][] newGrid = new boolean[rows][columns];
        CellGrid newGrid = new CellGrid(rows, columns);
        boolean hasChanged = false;
        grid.increaseGeneration();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int liveNeighbors = grid.countLiveNeighbors(row, col);
                if (grid.getCellState(row, col)) {
                    newGrid.setState(row, col, (liveNeighbors == 2 || liveNeighbors == 3));
                } else {
                    newGrid.setState(row, col, liveNeighbors == 3);
                }
                if (grid.getCellState(row, col) != newGrid.getState(row, col)) {
                    hasChanged = true;
                }
            }
        }

        grid.setGrid(newGrid);

        return hasChanged;
    }
}
