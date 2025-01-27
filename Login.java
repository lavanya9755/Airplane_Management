import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
    //global decleration 
    JButton submit,close, reset;
    JTextField tfusername;
    JPasswordField tfpassword;
    public Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 20, 100, 20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20, 60, 100, 20);
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 60, 200, 20);
        add(tfpassword);

        //need to remove local description , such that they preffer global decleration
        reset = new JButton("Reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(190, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("Close");
        close.setBounds(120, 160, 120, 20);
        close.addActionListener(this);
        add(close);
        
        setSize(400, 250);
        setLocation(600, 250);
        setVisible(true);
    }
    //jdbc connectivity (interview questions most)
    public void actionPerformed(ActionEvent a){
        if(a.getSource() == submit){
                System.out.println("log in sucesfully");
        }else if(a.getSource() == close){
            setVisible(false);
        }else if(a.getSource() == reset){
            tfusername.setText("");
            tfpassword.setText("");
        }
    }

    public static void main(String[] args){
     new Login();   
    }
}
