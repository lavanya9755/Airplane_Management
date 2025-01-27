import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{

    JTable table;
    JTextField pnr;
    JButton show;

public JourneyDetails(){

    setLayout(null);

    JLabel lblpnr = new JLabel("PNR Details");
    lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblpnr.setBounds(50,50,100,25);
    add(lblpnr);

    pnr = new JTextField();
    pnr.setBounds(160,50,120,25);
    add(pnr);
    table = new JTable();

    show = new JButton("Show Details");
    show.setForeground(Color.WHITE);
    show.setBackground(Color.BLACK);
    show.setBounds(290,50,120,25);
    show.addActionListener(this);
    add(show);




    //Jscrollpane will provide table base
    JScrollPane jsp = new JScrollPane(table);
    jsp.setBackground(Color.WHITE);
    jsp.setBounds(0, 100, 800, 150);
    add(jsp);


    setSize(800, 600);
    setLocation(300, 150);
    setVisible(true);
}

public void actionPerformed(ActionEvent ae) {
    
    try{
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"';");
        //net.proteatnit.sql.DButils;
        //DbUtils.resultSetToTableModel(rs);


        //The isBeforeFirst() method of the ResultSet interface is used to determine whether the cursor is at the default position of the ResultSet.
        if (!rs.isBeforeFirst()){
            JOptionPane.showMessageDialog(null, "PNR not found");
            setVisible(false);
            return;
        }
        table.setModel(DbUtils.resultSetToTableModel(rs));

    }catch(Exception e){
        System.out.println(e);
    }
}

    public static void main(String[] args) {
        new JourneyDetails();
    }
}
