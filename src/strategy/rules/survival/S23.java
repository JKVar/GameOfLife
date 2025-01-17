package strategy.rules.survival;

import strategy.rules.CellRule;

public class S23 implements CellRule {
    @Override
    public boolean apply(boolean state, int aliveNeighbours) {
        return state && (aliveNeighbours == 2 || aliveNeighbours == 3);
    }
}
