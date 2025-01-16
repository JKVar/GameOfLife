package state;

import game.CellGrid;

public abstract class PatternState {
    private CellGrid pattern;

    public PatternState() {
        pattern = new CellGrid(1, 1);
    }

    public PatternState(CellGrid pattern) {
        this.pattern = pattern;
    }

    public void placePattern(int x, int y, CellGrid grid) {
        int rows = grid.getRows();
        int columns = grid.getCols();

        for (int i = 0; i < pattern.getRows(); i++) {
            for (int j = 0; j < pattern.getCols(); j++) {
                grid.setState((x+i) % rows, (y+j) % columns, pattern.getState(i, j));
//                if (pattern.getState(i, j)) {
                    setNeighboursDirty((x+i) % rows, (y+j) % columns, grid);
//                }
            }
        }

        System.out.println(grid);
    }

    protected void setPattern(CellGrid pattern) {
        this.pattern = pattern;
    }

    protected void setNeighboursDirty(int x, int y, CellGrid grid) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                grid.setDirty((x+i+grid.getRows()) % grid.getRows(), (y+j+grid.getCols()) % grid.getCols(), true);
            }
        }
    }
}
