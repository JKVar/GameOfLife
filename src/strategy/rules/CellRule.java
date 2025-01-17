package strategy.rules;

public interface CellRule {
    boolean apply(boolean state, int aliveNeighbours);
}
