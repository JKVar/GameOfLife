package game;

public class CellGrid implements Prototype {
    private final Cell[][] grid;
    int rows, cols;

    public CellGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                this.grid[i][j] = new Cell();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean getState(int x, int y) {
        return this.grid[x][y].getState();
    }

    public void setState(int x, int y, boolean state) {
        this.grid[x][y].setState(state);
    }

    @Override
    public Prototype clone() {
        CellGrid clonedGrid = new CellGrid(this.rows, this.cols);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                clonedGrid.setState(i, j, this.grid[i][j].getState());
            }
        }
        
        return clonedGrid;
    }
}
