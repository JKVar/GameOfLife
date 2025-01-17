package strategy.rules;

public class CombinedRule implements CellRule {
    private final CellRule rule1;
    private final CellRule rule2;

    public CombinedRule(CellRule rule1, CellRule rule2) {
        this.rule1 = rule1;
        this.rule2 = rule2;
    }

    @Override
    public boolean apply(boolean state, int aliveNeighbours) {
        return rule1.apply(state, aliveNeighbours) || rule2.apply(state, aliveNeighbours);
    }
}
