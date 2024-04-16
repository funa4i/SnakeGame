package Drawings;

import Entity.Snake;
import Enums.Direction;
import Enums.Status;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class DrawingField extends JComponent {

    private Direction direction = Direction.None;

    public int fieldSize = 10;

    private Point appleCord = new Point();
    public DrawingField() {
    }
    Snake snake = new Snake();
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void drawSnake(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        boolean appleIsEaten = snake.moveSnake(direction, appleCord, 10);



    }

    @Override
    public void paintComponent(Graphics g){
        drawSnake(g);
    }
}
