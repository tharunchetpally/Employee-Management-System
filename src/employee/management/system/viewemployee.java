
package employee.management.system;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;



public class viewemployee extends JFrame implements ActionListener{
    JTable table;
        Choice cemployeeId;
        JButton search,print,update,back;

    
    viewemployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cemployeeId = new Choice();
        cemployeeId.setBounds(180, 20, 150, 20);
        add(cemployeeId);

        table= new JTable();
        
       try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while(rs.next()) {
                cemployeeId.add(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("SEARCH");
        search.setBounds(20, 70, 90, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("PRINT");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("UPDATE");
        update.setBounds(220, 70, 90, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("BACK");
        back.setBounds(320, 70, 80, 20);
        back.addActionListener(this);
        add(back);
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
        
        
    }
    
        public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
             String query = "select * from employee where empid = '"+cemployeeId.getSelectedItem()+"'";
            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else if(ae.getSource()==print){
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==update){
            setVisible(false);
            new updateemployee(cemployeeId.getSelectedItem());
            
        }else{
            setVisible(false);
            new home();
        }
        }

    
    
    public static void main (String args []){
        
        new viewemployee();
    }
    
}
