import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname,tfnationality,tfaadhar,tfaddress,tfphone;
    JRadioButton rbmale, rbfemale;




    public AddCustomer(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);

    JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
    heading.setFont(new Font("Arial", Font.BOLD, 35));
    heading.setForeground(Color.GRAY);
    heading.setBounds(220,20,500,35);
    add(heading);


    JLabel lblname  = new JLabel("NAME: ");
    lblname.setFont(new Font("Arial", Font.BOLD, 20));
    lblname.setForeground(Color.GRAY);
    lblname.setBounds(60,80,150,25);
    add(lblname);

    tfname = new JTextField();
    tfname.setBounds(220,80,150,25);
    add(tfname);

    JLabel lblnationality  = new JLabel("NATIONALITY: ");
    lblnationality.setFont(new Font("Arial", Font.BOLD, 20));
    lblnationality.setForeground(Color.GRAY);
    lblnationality.setBounds(60,130,150,25);
    add(lblnationality);

    tfnationality = new JTextField();
    tfnationality.setBounds(220,130,150,25);
    add(tfnationality);

    JLabel lblaadahr  = new JLabel("AADHAR NO.: ");
    lblaadahr.setFont(new Font("Arial", Font.BOLD, 20));
    lblaadahr.setForeground(Color.GRAY);
    lblaadahr.setBounds(60,180,150,25);
    add(lblaadahr);

    tfaadhar = new JTextField();
    tfaadhar.setBounds(220,180,150,25);
    add(tfaadhar);

    JLabel lbladdress  = new JLabel("ADDRESS: ");
    lbladdress.setFont(new Font("Arial", Font.BOLD, 20));
    lbladdress.setForeground(Color.GRAY);
    lbladdress.setBounds(60,230,150,25);
    add(lbladdress);

    tfaddress = new JTextField();
    tfaddress.setBounds(220,230,150,25);
    add(tfaddress);

    JLabel lblgender= new JLabel("Gender");
    lblgender.setFont(new Font("Arial", Font.BOLD, 20));
    lblgender.setForeground(Color.GRAY);
    lblgender.setBounds(60,280,150,25);
    add(lblgender);

    ButtonGroup gendergroup = new ButtonGroup();

    rbmale = new JRadioButton("Male");
    rbmale.setBounds(220,280,70,25);
    rbmale.setBackground(Color.WHITE); //as radio button takes gey bg
    add(rbmale);

    rbfemale = new JRadioButton("Female");
    rbfemale.setBounds(300,280,70,25);
    rbfemale.setBackground(Color.WHITE);
    add(rbfemale);


    gendergroup.add(rbmale);
    gendergroup.add(rbfemale);

    JLabel lblphone  = new JLabel("PHONE:: ");
    lblphone.setFont(new Font("Arial", Font.BOLD, 20));
    lblphone.setForeground(Color.GRAY);
    lblphone.setBounds(60,330,150,25);
    add(lblphone);

    tfphone = new JTextField();
    tfphone.setBounds(220,330,150,25);
    add(tfphone);

    JButton save = new JButton("SAVE");
    save.setBackground(Color.BLACK);
    save.setForeground(Color.WHITE);
    save.setBounds(220,380,150,30);
    save.addActionListener(this);
    add(save);


    ImageIcon i2 = new ImageIcon(getClass().getResource("/icons/emp.png"));
    JLabel image = new JLabel(i2);
    image.setBounds(450,80,280,400);
    add(image);

        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String national = tfnationality.getText();
        String aadhar = tfaadhar.getText();
        String address = tfaddress.getText();
        String phone = tfphone.getText();
        String gender = null;
        if (rbmale.isSelected()){
            gender = "Male";
        }else{
            gender = "Female";
        }

        try{
            Conn conn = new Conn();
            String query = "INSERT INTO passenger values('"+name+"','"+national+"', '"+phone+"','"+address+"', '"+aadhar+"', '"+gender+"')";

            conn.s.executeUpdate(query); //dml query we are using
            JOptionPane.showMessageDialog(null, "Customer Details Added suxessfully");
            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new AddCustomer();
    }
}
