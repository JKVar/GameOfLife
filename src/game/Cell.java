package game;

public class Cell {
    private boolean state;

    public Cell() {
        this.state = false;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
