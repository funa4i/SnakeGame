package Drawings;

import Entity.Snake;
import Enums.Direction;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawingField extends JComponent {

    private Direction direction = Direction.None;

    public int fieldSize = 30;

    private Point appleCord = new Point(-1, -1);
    public DrawingField() {

    }
    private Snake snake = new Snake();

    public Snake getSnake(){
        return snake;
    }
    public void setDirection(Direction direction) {
        this.direction = direction;
   }

    public Direction getDirection() {
        return direction;
    }

    private void drawSnake(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        boolean appleIsEaten = snake.moveSnake(direction, appleCord, fieldSize);
        Random random = new Random();
        int x = random.nextInt(0, fieldSize + 1), y = random.nextInt(0, fieldSize + 1);
        if (appleIsEaten || appleCord.x == -1 || appleCord.y == -1){
            appleCord = new Point(x, y);
            if (snake.getSnakePositions().contains(appleCord)){
                appleCord.x = -1;
                appleCord.y = -1;
            }
        }
        // Отрисовка тела
        for (Point i: snake.getSnakePositions()){
            g2.setPaint(Color.black);
            g2.drawRect(i.x * 500 / fieldSize, i.y * 500 / fieldSize, 500 / fieldSize, 500 / fieldSize);
            g2.setPaint(new Color(2, 75, 21));
            g2.fillRect(i.x * 500 / fieldSize, i.y * 500 / fieldSize, 500 / fieldSize, 500 / fieldSize);
        }

        // Отрисовка головы
        Point head = snake.getSnakePositions().getFirst();
        g2.setPaint(Color.black);
        g2.drawRect(head.x * 500 / fieldSize, head.y * 500 / fieldSize, 500 / fieldSize, 500 / fieldSize);
        g2.setPaint(new Color(0, 0, 0));
        g2.fillRect(head.x * 500 / fieldSize, head.y * 500 / fieldSize, 500 / fieldSize, 500 / fieldSize);

        // Отрисовка яблока
        g2.setPaint(Color.black);
        g2.drawRect(appleCord.x * 500 / fieldSize, appleCord.y * 500 / fieldSize, 500 / fieldSize, 500 / fieldSize);
        g2.setPaint(Color.RED);
        g2.fillRect(appleCord.x * 500 / fieldSize, appleCord.y * 500 / fieldSize, 500 / fieldSize, 500 / fieldSize);
    }

    @Override
    public void paintComponent(Graphics g){
        drawSnake(g);
    }
}
