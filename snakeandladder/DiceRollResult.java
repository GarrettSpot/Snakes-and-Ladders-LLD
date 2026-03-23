package snakeandladder;

public class DiceRollResult {
    private int totalMove;
    private boolean valid;

    public DiceRollResult(int totalMove, boolean valid) {
        this.totalMove = totalMove;
        this.valid = valid;
    }

    public int getTotalMove() {
        return totalMove;
    }

    public boolean isValid() {
        return valid;
    }
}