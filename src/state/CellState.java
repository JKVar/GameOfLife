package state;

import game.CellGrid;

public class CellState extends PatternState {
    @Override
    public void placePattern(int x, int y, CellGrid grid) {
        grid.setState(x, y, true);
        setNeighboursDirty(x, y, grid);
        System.out.println(grid);
    }
}
