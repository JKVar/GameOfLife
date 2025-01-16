package state;

import game.CellGrid;

public class ReplicatorState extends PatternState {
    private final CellGrid pattern;

    public ReplicatorState() {
        pattern = new CellGrid(5, 5);
        pattern.setState(0, 4, true);
        pattern.setState(0, 3, true);
        pattern.setState(0, 2, true);
        pattern.setState(1, 4, true);
        pattern.setState(2, 4, true);

        pattern.setState(1, 1, true);
        pattern.setState(3, 3, true);

        pattern.setState(4, 0, true);
        pattern.setState(3, 0, true);
        pattern.setState(2, 0, true);
        pattern.setState(4, 1, true);
        pattern.setState(4, 2, true);

        setPattern(pattern);
    }
}
