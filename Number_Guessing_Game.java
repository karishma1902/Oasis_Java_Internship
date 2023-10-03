import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class NumberGuessing extends JFrame{
    int guess, RandomNumber;
    private JButton b1;
    private JTextField t1;
    private JLabel p1;
    private JLabel r1;
    private JLabel r2;

    public NumberGuessing(){
                setLayout(new FlowLayout());
                RandomNumber = 1 + (int)(100* Math.random());
                p1 = new JLabel("Enter A Random Number Between 1-100");
                add(p1);
                t1= new JTextField(5);
                add(t1);
                b1 = new JButton("Guess");
                add(b1);
                r1 = new JLabel("");
                add(r1);
                r2 = new JLabel("");
                add(r2);
                event e = new event();
                b1.addActionListener(e);
                }

public class event implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                    guess = (int) (Double.parseDouble(t1.getText()));
                    if(guess == RandomNumber){
                        r2.setText("Congratulations! You won the game.");
                    }
                    else if(guess < RandomNumber){
                        r2.setText("The number is "+ "greater than " + guess);
                    }
                        else if(guess > RandomNumber){
                    r2.setText("The number is "+ "lesser than " + guess);
                    }
                }
                 catch(Exception ex)
                {
                   r1.setText("PLEASE ENTER NUMBERS ONLY");
                }
            }
        }

    public static void main(String args[]){
        NumberGuessing gui = new NumberGuessing();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.setSize(400,250);
        gui.setTitle("Number Guessing Game");
    }
}
