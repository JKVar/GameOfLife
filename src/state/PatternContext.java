package state;

import game.CellGrid;

public class PatternContext {
    private PatternState currentState;

    public PatternContext() {
        currentState = new CellState();
    }

    public void setPatternState(PatternState state) {
        currentState = state;
    }

    public  void placePattern(int x, int y, CellGrid grid) {
        if (currentState != null) {
            currentState.placePattern(x, y, grid);
        }
    }
}
