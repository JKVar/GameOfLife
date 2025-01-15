package state;

import game.CellGrid;

public class GliderState implements PatternState {
    private final CellGrid pattern;

    public GliderState() {
        pattern = new CellGrid(3, 3);
        pattern.setState(0, 1, true);
        pattern.setState(1, 2, true);
        pattern.setState(2, 0, true);
        pattern.setState(2, 1, true);
        pattern.setState(2, 2, true);
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
