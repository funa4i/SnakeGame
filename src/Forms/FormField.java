package Forms;

import Drawings.DrawingField;
import Enums.Direction;

import javax.swing.*;
import java.awt.event.*;

import static java.lang.Math.*;

public class FormField extends JFrame {
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

    private DrawingField field = new DrawingField();
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop();
            timer = new Timer(max(60, min(15 * field.fieldSize / (field.getSnake().getSnakePositions().size()), 400)), actionListener);
            timer.start();
            fieldPanel.repaint();
        }
    };
    Timer timer = new Timer(50, actionListener);





    KeyListener keyAdapter =  new KeyListener() {


        @Override
        public void keyTyped(KeyEvent e) {
            field.setDirection(Direction.Left);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            field.setDirection(Direction.Left);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            field.setDirection(Direction.Left);
        }
    };

    public FormField (){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timer.start();
        setContentPane(formPanel);
        setSize(1280, 720);
        setVisible(true);
        fieldPanel.add(field);
        addKeyListener(keyAdapter);
        
    }

}
