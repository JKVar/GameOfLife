package strategy.rules.survival;

import strategy.rules.CellRule;

public class S345 implements CellRule {
    @Override
    public boolean apply(boolean state, int aliveNeighbours) {
        return state && (aliveNeighbours == 3 || aliveNeighbours == 4 || aliveNeighbours == 5);
    }
}
