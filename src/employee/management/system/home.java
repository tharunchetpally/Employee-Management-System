
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class home extends JFrame implements ActionListener{
    
    JButton add,   view,update,remove;
    home(){
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 650, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1200,650);
        add(image);
        
        JLabel heading =new JLabel("Employee Management System");
        heading.setBounds(620,20,400,40);
        heading.setFont(new Font ("TAHOMA",Font.BOLD,25));
        image.add(heading);
        
         add =new JButton("ADD EMPLOYEE");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        image.add(add);
        
          view =new JButton("VIEW EMPLOYEE");
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        image.add(view);
        
          update =new JButton("UPDATE EMPLOYEE");
        update.setBounds(650,140,170,40);
        update.addActionListener(this);
        image.add(update);

        
          remove =new JButton("REMOVE EMPLOYEE");
        remove.setBounds(830,140,180,40);
        remove.addActionListener(this);
        image.add(remove);
        
                
        setSize(1200,650);
        setLocation(200,80);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            setVisible(false);
            new addemployee();
            
        }else if(ae.getSource()==view){
            setVisible(false);
            new viewemployee();
            
        }else if (ae.getSource()==update){
            setVisible(false);
            new viewemployee();
            
        }else{/*remove*/
            setVisible(false);
            new removeemployee();
        }
        
    }
    
    public static void main(String args[]){
        new home();
    }
       
}
