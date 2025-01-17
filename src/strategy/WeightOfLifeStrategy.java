package strategy;

import game.Grid;
import strategy.rules.CombinedRule;
import strategy.rules.creation.B467;
import strategy.rules.survival.S345;

public class WeightOfLifeStrategy extends Strategy {
    public WeightOfLifeStrategy() {
        combinedRule = new CombinedRule(new B467(), new S345());
    }
    @Override
    protected int countAliveNeighbours(Grid grid, int x, int y) {
        int rows = grid.getRows();
        int columns = grid.getColumns();
        int liveNeighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = (x + rows + i) % rows;
                int c = (y + columns +j) % columns;
                if (grid.getCellState(r, c)) {
                    liveNeighbors++;
                    if (Math.abs(i+j) == 1) {
                        liveNeighbors++;
                    }
                }
            }
        }
        return liveNeighbors;
    }
}
