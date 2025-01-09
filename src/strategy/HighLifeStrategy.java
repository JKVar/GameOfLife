package strategy;

import game.Grid;

public class HighLifeStrategy implements Strategy {
    @Override
    public boolean nextGeneration(Grid grid) {
        int rows = grid.getRows();
        int columns = grid.getColumns();
        boolean[][] newGrid = new boolean[rows][columns];
        boolean hasChanged = false;
        grid.increaseGeneration();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int liveNeighbors = grid.countLiveNeighbors(row, col);
                if (grid.getCellState(row, col)) {
                    newGrid[row][col] = (liveNeighbors == 2 || liveNeighbors == 3);
                } else {
                    newGrid[row][col] = (liveNeighbors == 3 || liveNeighbors == 6);
                }
                if (grid.getCellState(row, col) != newGrid[row][col]) {
                    hasChanged = true;
                }
            }
        }

        grid.setGrid(newGrid);

        return hasChanged;
    }
}
