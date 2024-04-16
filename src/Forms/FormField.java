package Forms;

import Drawings.DrawingField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            timer = new Timer(100, actionListener);
            timer.start();
            fieldPanel.repaint();
        }
    };
    Timer timer = new Timer(100, actionListener);

    public FormField (){
        timer.start();
        setContentPane(formPanel);
        setSize(1280, 720);
        setVisible(true);
        fieldPanel.add(field);
    }

}
