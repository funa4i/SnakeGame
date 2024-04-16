import javax.swing.*;
import java.awt.*;

public class DrawingField extends JComponent {

    enum Direction{
        None(0),
        Up(1),
        Down(2),
        Right(3),
        Left(4);

        private final int value;

        Direction(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }





    @Override
    public void paintComponent(Graphics g){

    }
}
