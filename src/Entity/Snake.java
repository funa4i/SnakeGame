package Entity;

import Enums.Direction;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {

    private boolean alive = true;

    public boolean getAlive() {
        return alive;
    }

    public Snake(){
        snakePositions.addLast(new Point(1, 3));
        snakePositions.addLast(new Point(1, 2));
        snakePositions.addLast(new Point(1, 1));
    }
    private final Deque<Point> snakePositions = new ArrayDeque<>(){};
    public boolean moveSnake(Direction direction, Point appleCord, int fieldSize){
        if (!alive){
            return false;
        }
        Point buf = (Point) snakePositions.getFirst().clone();
        switch (direction){
            case None -> {return false;}
            case Up -> {--buf.y;}
            case Down -> {++buf.y;}
            case Left -> {--buf.x;}
            case Right -> {++buf.x;}
        }
        if (!snakePositions.contains(buf) && !(buf.x >= fieldSize || buf.x < 0 || buf.y >= fieldSize || buf.y < 0)) {
            if (!buf.equals(appleCord)) {
                snakePositions.pollLast();
            }
            snakePositions.addFirst(buf);
            return buf.equals(appleCord);
        }
        alive = false;
        return false;
    }

    public Deque<Point> getSnakePositions() {
        return snakePositions;
    }
}
