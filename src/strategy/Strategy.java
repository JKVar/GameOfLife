package strategy;

import game.Grid;

public interface Strategy {
    boolean nextGeneration(Grid grid);
}
