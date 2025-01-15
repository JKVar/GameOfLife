package state;

import game.CellGrid;

public interface PatternState {
    void placePattern(int x, int y, CellGrid grid);
}
