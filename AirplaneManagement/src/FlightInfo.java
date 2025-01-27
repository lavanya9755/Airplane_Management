import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame{

public FlightInfo(){

    setLayout(null);
    JTable table = new JTable();


    try{
        Conn conn = new Conn();
        ResultSet rs = conn.s.executeQuery("select * from flight;");
        //net/proteatnit.sql.DButils;
        //DbUtils.resultSetToTableModel(rs);
        table.setModel(DbUtils.resultSetToTableModel(rs));

    }catch(Exception e){
        System.out.println(e);
    }

    //Jscrollpane will provide table base
    JScrollPane jsp = new JScrollPane(table);
    jsp.setBounds(0, 0, 700, 600);
    add(jsp);


    setSize(700, 600);
    setLocation(300, 150);
    setVisible(true);
}


    public static void main(String[] args) {
        new FlightInfo();
    }
}
