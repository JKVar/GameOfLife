package factory;

import game.CellGrid;

import java.util.Random;

public class RandomGridFactory implements GridFactory {
    private final int rows, cols;

    public RandomGridFactory(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public CellGrid createGrid() {
        Random random = new Random();
        CellGrid grid = new CellGrid(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean rand = random.nextDouble() < 0.25;
                grid.setState(i, j, rand);
            }
        }

        return grid;
    }
}
