package Forms;

import Drawings.DrawingField;
import Enums.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class FormField extends JFrame {
    private JPanel formPanel;
    private JLabel scoreLabel;
    private JLabel squareLabel;
    private JPanel fieldPanel;
    private JLabel labelStatus;


    private final DrawingField field = new DrawingField();
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            timerFieldGame.setDelay(max(100, min(45 * field.fieldSize / (field.getSnake().getSnakePositions().size()), 400)));
            fieldPanel.repaint();
            String score = "Score: ";
            String status = "Status: ";
            String squares = "Squares count: ";
            squareLabel.setText(squares + field.fieldSize * field.fieldSize);

            if (field.getSnake().getAlive()){
                labelStatus.setText(status + "Alive");
            }
            else{
                labelStatus.setText(status + "Die");
            }
            scoreLabel.setText(score + " " + field.getSnake().getSnakePositions().size());
            setFocusable(true);
        }
    };
    Timer timerFieldGame = new Timer(50, actionListener);



    public FormField (){

        setFocusable(true);
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_D:
                        field.setDirection(Direction.Right);
                        break;
                    case KeyEvent.VK_W:
                        if (field.getDirection() == Direction.None) {
                            return;
                        }
                        field.setDirection(Direction.Up);
                        break;
                    case KeyEvent.VK_A:
                        field.setDirection(Direction.Left);
                        break;
                    case KeyEvent.VK_S:
                        field.setDirection(Direction.Down);
                        break;
                    case KeyEvent.VK_SPACE:
                        field.setDirection(Direction.None);
                        break;
                    case KeyEvent.VK_R:
                        field.reCreateSnake();
                        field.setDirection(Direction.None);
                        break;
                    case KeyEvent.VK_Q:
                        if (field.fieldSize <= 10){
                            return;
                        }
                        field.fieldSize--;
                        field.reCreateSnake();
                        field.reCrateApple();
                        field.setDirection(Direction.None);
                        break;
                    case KeyEvent.VK_E:
                        if (field.fieldSize >= 50){
                            return;
                        }
                        field.fieldSize++;
                        field.reCreateSnake();
                        field.setDirection(Direction.None);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        addKeyListener(keyListener);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timerFieldGame.start();
        setContentPane(formPanel);
        setSize(1280, 720);
        setVisible(true);
        fieldPanel.add(field);


    }
}
