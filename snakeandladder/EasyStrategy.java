package snakeandladder;

import java.util.*;

public class EasyStrategy implements IDifficultyStrategy {
    @Override
    public DiceRollResult rollDice(IDice dice) {
        int totalMove = 0;
        boolean valid = true;
        while (true) {
            int roll = dice.roll();
            totalMove += roll;
            if (roll != 6) break;
        }
        return new DiceRollResult(totalMove, valid);
    }
}