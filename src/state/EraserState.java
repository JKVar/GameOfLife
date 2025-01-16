package state;

import game.CellGrid;

public class EraserState extends PatternState {

    public EraserState(int size) {
        CellGrid pattern = new CellGrid(size, size);
        setPattern(pattern);
    }
}
