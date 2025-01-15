package state;

import game.CellGrid;

public class EraserState implements PatternState {
    private final CellGrid pattern;

    public EraserState(int size) {
        pattern = new CellGrid(size, size);
    }

    @Override
    public void placePattern(int x, int y, CellGrid grid) {
        int rows = grid.getRows();
        int columns = grid.getCols();

        for (int i = 0; i < pattern.getRows(); i++) {
            for (int j = 0; j < pattern.getCols(); j++) {
                grid.setState((x+i) % rows, (y+j) % columns, pattern.getState(i, j));
            }
        }
    }
}
