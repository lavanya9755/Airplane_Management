import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Cancel extends JFrame implements ActionListener {
    
    JTextField tfpnr;
    JLabel tfname, labledate,labelfcode,cancelno;
    JButton  fetchButton,cancelbutton;
    
    
    public Cancel() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Random rm = new Random();
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(250, 20, 500, 40);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/cancel.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,100,250,250);
        add(image); 

        
        JLabel lblpnr = new JLabel("PNR");
        lblpnr.setBounds(60, 80, 150, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        JLabel cancel = new JLabel("Cancel number");
        cancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        cancel.setBounds(60, 180, 150, 25);
        add(cancel);

        cancelno = new JLabel(""+rm.nextInt(100000));
        cancelno.setBounds(220, 180, 150, 25);
        add(cancelno);

        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 230, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 230, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 280, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        labledate = new JLabel();
        labledate.setBounds(220, 280, 150, 25);
        add(labledate);
       
        
        
        cancelbutton = new JButton("Cancel");
        cancelbutton.setBackground(Color.BLACK);
        cancelbutton.setForeground(Color.WHITE);
        cancelbutton.setBounds(220, 330, 150, 25);
        cancelbutton.addActionListener(this);
        add(cancelbutton);
        
        setSize(800, 500);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== fetchButton ){
            String pnr = tfpnr.getText();
            try{
                Conn conn = new Conn();
                String query = "select * from reservation where PNR = '"+pnr+"' ";
                ResultSet rs = conn.s.executeQuery(query);

                if(rs.next()){

                  tfname.setText(rs.getString("name"));
                  labelfcode.setText(rs.getString("flightcode"));
                  labledate.setText(rs.getString("ddate"));
                }else{
                    JOptionPane.showMessageDialog(null,"Please enter correct aadhar number");
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        
        }else if(ae.getSource() == cancelbutton){
            String name = tfname.getText();
            String pnr = tfpnr.getText();
            String cancelnumber = cancelno.getText();
            String fcode = labelfcode.getText();
            String ddate = labledate.getText();
            try{
                Conn conn = new Conn();
                String query2 = "insert into cancel values('"+name+"','"+pnr+"','"+cancelnumber+"','"+fcode+"','"+ddate+"')";
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"' ");

                JOptionPane.showMessageDialog(null,"Ticket cancellled");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Cancel();
    }
}