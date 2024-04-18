package Forms;

import Drawings.DrawingField;
import Enums.Direction;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import static java.lang.Math.*;

public class FormField extends JFrame implements KeyListener{
    private JButton buttonPause;
    private JPanel formPanel;
    private JLabel scoreLabel;
    private JLabel squareLabel;
    private JPanel buttonsMovementPanel;
    private JButton buttonToLeft;
    private JButton buttonToRight;
    private JButton buttonToUp;
    private JButton buttonDecreaseFieldSquares;
    private JButton buttonIncreaseFieldSquares;
    private JButton buttonRepeat;
    private JPanel fieldPanel;
    private JButton buttonToDown;

    private final DrawingField field = new DrawingField();
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.setDelay(max(60, min(15 * field.fieldSize / (field.getSnake().getSnakePositions().size()), 400)));
            fieldPanel.repaint();
        }
    };
    Timer timer = new Timer(50, actionListener);

    public FormField (){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer.start();
        setContentPane(formPanel);
        setSize(1280, 720);
        setVisible(true);
        fieldPanel.add(field);

        buttonToUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (field.getDirection() == Direction.None){
                    return;
                }
                field.setDirection(Direction.Up);

            }
        });
        buttonToDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setDirection(Direction.Down);

            }
        });

        buttonToLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setDirection(Direction.Left);

            }
        });

        buttonToRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setDirection(Direction.Right);

            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Dwadwa");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Dwadwa");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Dwadwa");
    }
}
