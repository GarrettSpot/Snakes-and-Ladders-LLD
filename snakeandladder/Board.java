package snakeandladder;

import java.util.*;

public class Board {
    private int size;
    private Cell[] cells;
    private Map<Integer, Jumpable> jumps;

    public Board(int n) {
        this.size = n * n;
        cells = new Cell[size + 1]; // 1 to size
        for (int i = 1; i <= size; i++) {
            cells[i] = new Cell(i);
        }
        jumps = new HashMap<>();
        Set<Integer> used = new HashSet<>();
        Random random = new Random();
        // Create n snakes
        for (int i = 0; i < n; i++) {
            int head, tail;
            do {
                head = random.nextInt(size - 1) + 2; // 2 to size
                int length = random.nextInt(5) + 1; // 1 to 5
                tail = head - length;
            } while (used.contains(head) || used.contains(tail) || tail < 1);
            Snake snake = new Snake(head, tail);
            cells[head].setJumpable(snake);
            jumps.put(head, snake);
            used.add(head);
            used.add(tail);
        }
        // Create n ladders
        for (int i = 0; i < n; i++) {
            int start, end;
            do {
                start = random.nextInt(size - 1) + 1; // 1 to size-1
                int length = random.nextInt(5) + 1; // 1 to 5
                end = start + length;
            } while (used.contains(start) || used.contains(end) || end > size);
            Ladder ladder = new Ladder(start, end);
            cells[start].setJumpable(ladder);
            jumps.put(start, ladder);
            used.add(start);
            used.add(end);
        }
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int pos) {
        return cells[pos];
    }

    public int getNewPosition(int pos) {
        if (jumps.containsKey(pos)) {
            return jumps.get(pos).getEnd();
        }
        return pos;
    }
}