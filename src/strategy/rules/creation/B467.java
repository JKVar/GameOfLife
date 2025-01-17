package strategy.rules.creation;

import strategy.rules.CellRule;

public class B467 implements CellRule {
    @Override
    public boolean apply(boolean state, int aliveNeighbours) {
        return !state && (aliveNeighbours == 4 || aliveNeighbours == 7 || aliveNeighbours == 6);
    }
}
