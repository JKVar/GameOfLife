package strategy;

import game.CellGrid;
import game.Grid;
import strategy.rules.CellRule;
import strategy.rules.CombinedRule;
import strategy.rules.creation.B3;
import strategy.rules.survival.S23;

public abstract class Strategy {
    protected CellRule combinedRule;

    public Strategy() {
        combinedRule = new CombinedRule(new B3(), new S23());
    }

    public boolean nextGeneration(Grid grid) {
        int rows = grid.getRows();
        int columns = grid.getColumns();
        boolean hasChanged = false;
        CellGrid newGrid = new CellGrid(rows, columns);

        grid.increaseGeneration();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int aliveNeighbours = countAliveNeighbours(grid, row, col);
                boolean state = grid.getCellState(row, col);
                boolean nextState = combinedRule.apply(state, aliveNeighbours);

                newGrid.setState(row, col, nextState);

                if (state != nextState) {
                    hasChanged = true;
                }
            }
        }

        grid.setGrid(newGrid);

        return hasChanged;
    }

    protected int countAliveNeighbours(Grid grid, int x, int y) {
        return grid.countAliveNeighbors(x, y);
    }
}
