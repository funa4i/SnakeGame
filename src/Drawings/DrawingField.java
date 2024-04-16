package Drawings;

import Entity.Snake;
import Enums.Direction;
import Enums.Status;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class DrawingField extends JComponent {

    private Direction direction = Direction.Down;

    public int fieldSize = 25;

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

        // Отрисовка тела
        for (Point i: snake.getSnakePositions()){
            g2.setPaint(Color.black);
            g2.drawRect(i.x * 500 / fieldSize, i.y * 500 / fieldSize, 500 / fieldSize, 500 / fieldSize);
            g2.setPaint(new Color(255, 75, 75));
            g2.fillRect(i.x * 500 / fieldSize, i.y * 500 / fieldSize, 500 / fieldSize, 500 / fieldSize);
        }

        // Отрисовка головы
        Point head = snake.getSnakePositions().getFirst();
        g2.setPaint(Color.black);
        g2.drawRect(head.x * 500 / fieldSize, head.y * 500 / fieldSize, 500 / fieldSize, 500 / fieldSize);
        g2.setPaint(new Color(0, 111, 255));
        g2.fillRect(head.x * 500 / fieldSize, head.y * 500 / fieldSize, 500 / fieldSize, 500 / fieldSize);
    }

    @Override
    public void paintComponent(Graphics g){
        drawSnake(g);
    }
}
