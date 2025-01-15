package strategy;

import game.CellGrid;
import game.Grid;

public class DayAndNightStrategy implements Strategy{
    @Override
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
                    newGrid.setState(row, col, (liveNeighbors == 3 || liveNeighbors == 4 || liveNeighbors == 6 || liveNeighbors == 7 || liveNeighbors == 8));
                } else {
                    newGrid.setState(row, col, (liveNeighbors == 3 || liveNeighbors == 6 || liveNeighbors == 7 || liveNeighbors == 8));
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
