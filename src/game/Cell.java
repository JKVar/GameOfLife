package game;

public class Cell {
    private boolean state;
    private boolean dirty;

    public Cell() {
        this.state = false;
        this.dirty = false;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
}
