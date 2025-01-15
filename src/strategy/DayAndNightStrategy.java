package strategy;

public class DayAndNightStrategy extends Strategy {

    @Override
    protected boolean survivalRule(int liveNeighbors) {
        return (liveNeighbors == 3 || liveNeighbors == 4 || liveNeighbors == 6 || liveNeighbors == 7 || liveNeighbors == 8);
    }

    @Override
    protected boolean creationRule(int liveNeighbors) {
        return (liveNeighbors == 3 || liveNeighbors == 6 || liveNeighbors == 7 || liveNeighbors == 8);
    }
}
