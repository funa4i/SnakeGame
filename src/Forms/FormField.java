package Forms;

import javax.swing.*;

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


    public FormField (){
        setContentPane(formPanel);
        setSize(1280, 720);
        setVisible(true);
    }

}
