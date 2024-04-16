package Entity;

import Enums.Direction;
import Enums.Status;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {

    private Status status = Status.Alive;

    public Status getStatus() {
        return status;
    }

    public Snake(){
        snakePositions.addLast(new Point(1, 3));
        snakePositions.addLast(new Point(1, 2));
        snakePositions.addLast(new Point(1, 1));
    }
    private final Deque<Point> snakePositions = new ArrayDeque<>(){};
    public boolean moveSnake(Direction direction, Point appleCord, int fieldSize){
        if (status == Status.Die){
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
        if (!snakePositions.contains(buf)) {
            if (!buf.equals(appleCord)) {
                snakePositions.pollLast();
            }
            snakePositions.addFirst(buf);
            return buf.equals(appleCord);
        }
        status = Status.Die;
        return false;
    }

    public Deque<Point> getSnakePositions() {
        return snakePositions;
    }
}
