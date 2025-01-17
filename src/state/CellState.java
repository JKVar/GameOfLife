package state;

import game.CellGrid;

public class CellState implements PatternState {
    @Override
    public void placePattern(int x, int y, CellGrid grid) {
        grid.setState(x, y, !grid.getState(x, y));
    }
}
