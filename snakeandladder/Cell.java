package snakeandladder;

public class Cell {
    private int position;
    private Jumpable jumpable;

    public Cell(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Jumpable getJumpable() {
        return jumpable;
    }

    public void setJumpable(Jumpable jumpable) {
        this.jumpable = jumpable;
    }
}