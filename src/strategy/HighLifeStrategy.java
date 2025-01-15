package strategy;

public class HighLifeStrategy extends Strategy {

    @Override
    protected boolean survivalRule(int liveNeighbors) {
        return super.survivalRule(liveNeighbors);
    }

    @Override
    protected boolean creationRule(int liveNeighbors) {
        return (liveNeighbors == 3 || liveNeighbors == 6);
    }
}
