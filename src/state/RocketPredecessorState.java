package state;

import game.CellGrid;

public class RocketPredecessorState implements PatternState {
    private final CellGrid pattern;

    public RocketPredecessorState() {
        pattern = new CellGrid(5, 8);
        for (int i = 0; i < 8; i++)
            pattern.setState(2, i, true);

        pattern.setState(0, 1, true);
        pattern.setState(0, 2, true);
        pattern.setState(1, 0, true);
        pattern.setState(1, 2, true);
        pattern.setState(1, 3, true);

        pattern.setState(4, 1, true);
        pattern.setState(4, 2, true);
        pattern.setState(3, 0, true);
        pattern.setState(3, 2, true);
        pattern.setState(3, 3, true);
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
