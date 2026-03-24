# Snakes and Ladders (LLD, Java)

A clean, SOLID, extensible low-level design implementation of a Snakes and Ladders game in Java.

## Features

- `n x n` board with cells from `1` to `n^2`
- Exactly `n` snakes and `n` ladders randomly placed
- Strategy-based difficulty:
  - `easy`: consecutive 6s stack and keep moving
  - `hard`: three consecutive 6s invalidates the turn
- Turn-based play with multiple players
- Movement with dice roll, boundaries, snakes, and ladders
- In-code extensibility for new dice and strategies

## Project Structure

- `snakeandladder/`
  - `Game.java` — main entrypoint
  - `GameManager.java` — game loop, player move, win check
  - `Board.java` — board and jumps
  - `Cell.java` — cell state container
  - `Player.java` — player position and identity
  - `IDice.java`, `Dice.java` — dice abstraction and default six-sided dice
  - `Jumpable.java`, `Snake.java`, `Ladder.java` — board obstacles
  - `IDifficultyStrategy.java`, `EasyStrategy.java`, `HardStrategy.java` — dice behavior strategy
  - `DiceRollResult.java` — holds aggregated roll outcome


```
cd snakeandladder
javac *.java
java -cp .. snakeandladder.Game
```

## Configuring game input

Inside `Game.java`, set:
- `n` (board dimension)
- `difficulty` (`easy` or `hard`)
- `playerNames` list
