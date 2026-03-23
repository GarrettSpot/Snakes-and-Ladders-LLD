package snakeandladder;

import java.util.*;

public class HardStrategy implements IDifficultyStrategy {
    @Override
    public DiceRollResult rollDice(IDice dice) {
        int totalMove = 0;
        boolean valid = true;
        int rolls = 0;
        while (rolls < 3) {
            int roll = dice.roll();
            totalMove += roll;
            rolls++;
            if (roll != 6) break;
            if (rolls == 3) {
                valid = false;
                totalMove = 0;
            }
        }
        return new DiceRollResult(totalMove, valid);
    }
}