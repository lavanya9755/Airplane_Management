import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener {
    
    JTextField tfpnr;
    JLabel tfname, tfnationality, tfsrc, tfdest , labelfcode,tfflname,labeldate;
    JButton fetchButton;
  
    
    public BoardingPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Boarding Pass");
        heading.setBounds(420, 20, 500, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(600,100,250,250);
        add(image); 

        
        JLabel lblpnr = new JLabel("PNR");
        lblpnr.setBounds(60, 80, 150, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);
        
        
        fetchButton = new JButton("ENTER");
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
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
    
        
    
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 230, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);

        tfsrc = new JLabel();
        tfsrc.setBounds(220, 230, 150, 25);
        add(tfsrc);
        
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(380, 230, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        tfdest = new JLabel();
        tfdest.setBounds(540,230,250,25);
        add(tfdest);

        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 280, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);

        tfflname = new JLabel();
        tfflname.setBounds(220, 280, 150, 25);
        add(tfflname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380, 280, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540, 280, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 330, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220,330,150,25);
        add(labeldate);
        
    
        setSize(1100, 700);
        setLocation(200, 50);
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
                    tfnationality.setText(rs.getString("nationality"));
                    tfsrc.setText(rs.getString("src"));
                    tfdest.setText(rs.getString("des"));
                    tfflname.setText(rs.getString("flightname"));
                    labelfcode.setText(rs.getString("flightcode"));
                    labeldate.setText(rs.getString("ddate"));
                   
                }else{
                    JOptionPane.showMessageDialog(null,"Please enter correct aadhar number");
                }

            }catch (Exception e){
                e.printStackTrace();
            }
          
        }else {
            JOptionPane.showMessageDialog(null,"Enter correct PNR");
        }
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}