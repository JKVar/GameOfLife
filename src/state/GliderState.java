package state;

import game.CellGrid;

public class GliderState extends PatternState {

    public GliderState() {
        CellGrid pattern = new CellGrid(3, 3);
        pattern.setState(0, 1, true);
        pattern.setState(1, 2, true);
        pattern.setState(2, 0, true);
        pattern.setState(2, 1, true);
        pattern.setState(2, 2, true);

        setPattern(pattern);
    }
}
