import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home extends JFrame implements ActionListener{
    
    public Home(){
        setLayout(null);
       
        ImageIcon i1 = new ImageIcon(getClass().getResource("/icons/front.jpg"));
        //add(i1); cant add image directly to frame , as add() doesnt have parameter  , we will use Jlable 
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1000,600);
        add(image);


        JLabel heading = new JLabel("AirIndia welcome u");
        heading.setBounds(350,40,1000,40);
        
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("Tahoma",Font.PLAIN,36));
        //add(heading); nope because we are adding image wrt. to image not frame 
        image.add(heading);


        JMenuBar menubar =  new JMenuBar();
        setJMenuBar(menubar);
        JMenu details = new JMenu("Details");
        menubar.add(details);

        JMenuItem flightdetails = new JMenuItem("Flight Details");
        flightdetails.addActionListener(this);
        details.add(flightdetails);

        JMenuItem customerdetails = new JMenuItem("ADD Customer Details");
        customerdetails.addActionListener(this);
        details.add(customerdetails);
        
        JMenuItem bookflights = new JMenuItem("Book Flights");
        bookflights.addActionListener(this);
        details.add(bookflights);

        JMenuItem journeydetails = new JMenuItem("Journey Details");
        journeydetails.addActionListener(this);
        details.add(journeydetails);

        JMenuItem ticketcancel = new JMenuItem("Ticket Cancellation");
        ticketcancel.addActionListener(this);
        details.add(ticketcancel);

        JMenu ticket = new JMenu("|| Current- Ticket");
        menubar.add(ticket);

        JMenuItem boardingpass = new JMenuItem("Boarcding Pass");
        boardingpass.addActionListener(this);
        ticket.add(boardingpass);
        

        setSize(1000, 600);
        setLocation(100, 80);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String input = ae.getActionCommand();
        if(input.equals("ADD Customer Details")){
            new AddCustomer();
        }else if(input.equals("Flight Details")){
            new FlightInfo();
        }else if(input.equals("Book Flights")){
            new BookFlight();
        }else if(input.equals("Journey Details")){
            new JourneyDetails();
        }else if(input.equals("Boarcding Pass")){
            new BoardingPass();
        }else if(input.equals("Ticket Cancellation")){
            new Cancel();
        }
    }
    public static void main(String[] args) {
        new Home();
    }
}
