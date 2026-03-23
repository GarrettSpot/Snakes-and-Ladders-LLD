package snakeandladder;

import java.util.Arrays;
import java.util.List;

public class Game {
    public static void main(String[] args) {
        // For demonstration, hardcoded inputs
        int n = 5; // board size n x n
        int x = 2; // number of players
        String difficulty = "easy";
        List<String> playerNames = Arrays.asList("Player1", "Player2");

        GameManager manager = new GameManager(n, x, difficulty, playerNames);
        manager.playGame();
    }
}