import javax.swing.JFrame;
import javax.swing.JLabel;

public class rough extends JFrame {


    public rough(){

        setLayout(null);

        JLabel heading = new JLabel("BOOK FLIGHTS");
        heading.setBounds(40,20,500,20);
        add(heading);

        setVisible(true);
        setSize(900,600);
        setLocation(300,100);
    }
    public static void main(String[] args) {
        new rough();
    }
}
