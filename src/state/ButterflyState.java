package state;

import game.CellGrid;

public class ButterflyState extends PatternState {

    public ButterflyState() {
        CellGrid pattern = new CellGrid(5, 5);
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

        setPattern(pattern);
    }
}
