package state;

import game.CellGrid;

public class ButterflyState implements PatternState {
    private final CellGrid pattern;

    public ButterflyState() {
        pattern = new CellGrid(5, 5);
        pattern.setState(0, 1, true);
        pattern.setState(0, 2, true);
        pattern.setState(0, 3, true);
        pattern.setState(1, 4, true);
        pattern.setState(2, 4, true);
        pattern.setState(3, 4, true);

        pattern.setState(1, 0, true);
        pattern.setState(1, 1, true);
        pattern.setState(1, 2, true);
        pattern.setState(2, 3, true);
        pattern.setState(3, 3, true);
        pattern.setState(4, 3, true);
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
