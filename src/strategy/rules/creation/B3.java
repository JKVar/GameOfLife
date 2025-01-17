package strategy.rules.creation;

import strategy.rules.CellRule;

public class B3 implements CellRule {
    @Override
    public boolean apply(boolean state, int aliveNeighbours) {
        return !state && (aliveNeighbours == 3);
    }
}
