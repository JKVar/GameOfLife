package strategy.rules.creation;

import strategy.rules.CellRule;

public class B36 implements CellRule {
    @Override
    public boolean apply(boolean state, int aliveNeighbours) {
        return !state && (aliveNeighbours == 3 || aliveNeighbours == 6);
    }
}
