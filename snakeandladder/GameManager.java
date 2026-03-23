package snakeandladder;

import java.util.*;

public class GameManager {
    private Board board;
    private List<Player> players;
    private IDice dice;
    private int currentPlayerIndex;
    private IDifficultyStrategy strategy;

    public GameManager(int n, int x, String difficulty, List<String> playerNames) {
        this.strategy = getStrategy(difficulty);
        board = new Board(n);
        players = new ArrayList<>();
        for (String name : playerNames) {
            players.add(new Player(name));
        }
        dice = new Dice();
        currentPlayerIndex = 0;
    }

    private IDifficultyStrategy getStrategy(String difficulty) {
        if ("easy".equalsIgnoreCase(difficulty)) {
            return new EasyStrategy();
        } else {
            return new HardStrategy();
        }
    }

    public void playGame() {
        boolean gameOver = false;
        while (!gameOver) {
            Player current = players.get(currentPlayerIndex);
            DiceRollResult result = strategy.rollDice(dice);
            if (!result.isValid()) {
                System.out.println(current.getName() + " rolled three 6s in a row, loses turn");
            } else {
                int newPos = current.getPosition() + result.getTotalMove();
                if (newPos > board.getSize()) {
                    System.out.println(current.getName() + " rolled " + result.getTotalMove() + " but exceeds board, stays at " + current.getPosition());
                } else {
                    newPos = board.getNewPosition(newPos);
                    current.setPosition(newPos);
                    System.out.println(current.getName() + " rolled " + result.getTotalMove() + " moved to " + newPos);
                    if (newPos == board.getSize()) {
                        System.out.println(current.getName() + " wins!");
                        gameOver = true;
                    }
                }
            }
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }
}