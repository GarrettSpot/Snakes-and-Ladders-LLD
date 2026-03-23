package snakeandladder;

public interface IDifficultyStrategy {
    DiceRollResult rollDice(IDice dice);
}