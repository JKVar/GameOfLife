package state;

import game.CellGrid;

public class RocketPredecessorState extends PatternState {

    public RocketPredecessorState() {
        CellGrid pattern = new CellGrid(5, 8);
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

        setPattern(pattern);
    }
}
