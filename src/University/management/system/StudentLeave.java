package University.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame
{
    Choice ch,ch1;
    String str;
    Conn con;
    StudentLeave()
    {
        setLayout(null);
        getContentPane().setBackground(new Color(210,232,252));

        JLabel heading=new JLabel("Aply Student Leave!");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel search=new JLabel("Search by Roll Number:");
        search.setBounds(60,100,200,20);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(search);

         ch=new Choice();
         ch.setBounds(60,130,200,20);
         add(ch);
        try
        {
            con=new Conn();
            ResultSet rs=con.st.executeQuery("SELECT * FROM Student");
            while(rs.next())
            {
                ch.add(""+rs.getInt("rollno"));
            }
        }catch (Exception e){e.printStackTrace();}

        JLabel name=new JLabel("Name:");
        name.setBounds(60,170,70,20);
        name.setForeground(Color.RED);
        name.setFont(new Font("arial",Font.PLAIN , 18));
        add(name);

        JLabel tname=new JLabel();
        tname.setBounds(140,170,100,20);
        tname.setForeground(Color.RED);
        tname.setFont(new Font("arial",Font.PLAIN,18));
        add(tname);

        JLabel date=new JLabel("Date:");
        date.setBounds(60,210,200,20);
        date.setFont(new Font("arial", Font.PLAIN, 18));
        add(date);

        JDateChooser tdate=new JDateChooser();
        tdate.setBounds(60,240,200,25);
        add(tdate);

        JLabel time=new JLabel("Time Duration:");
        time.setBounds(60,280,200,20);
        time.setFont(new Font("arial", Font.PLAIN,18));
        add(time);

        ch1=new Choice();
        ch1.setBounds(60,310,200,20);
        ch1.add("Full Day");
        ch1.add("Half Day");
        add(ch1);


         try {
             con=new Conn();
             ResultSet rs=con.st.executeQuery("SELECT * FROM Student WHERE rollno='"+ch.getSelectedItem()+"'");
             rs.next();
              str=rs.getString("name");
              tname.setText(str);
             }catch (Exception e3){e3.printStackTrace();}


         ch.addItemListener(new ItemListener()
         {
             @Override
             public void itemStateChanged(ItemEvent e4)
             {
                 try {
                     con=new Conn();
                     ResultSet rs=con.st.executeQuery("SELECT * FROM Student WHERE rollno='"+ch.getSelectedItem()+"'");
                     while(rs.next())
                     {
                         tname.setText(rs.getString("name"));
                     }
                 }catch (Exception e5)
                 {
                     e5.printStackTrace();
                 }
             }
            } );

         JButton submit=new JButton("Submit");
         submit.setBounds(60,350,100,25);
         submit.setBackground(Color.BLACK);
         submit.setForeground(Color.WHITE);
         add(submit);

         submit.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 int roll=Integer.parseInt(ch.getSelectedItem());
                 String name=tname.getText();
                 String date=((JTextField)tdate.getDateEditor().getUiComponent()).getText();
                 String time=ch1.getSelectedItem();

                 try
                 {
                     con.st.executeUpdate("INSERT INTO SLeave VALUES('"+roll+"','"+name+"','"+date+"','"+time+"')");
                     JOptionPane.showMessageDialog(null, "Leave Confirmed");
                     setVisible(false);
                     new Main();
                 }catch (Exception e5){e5.printStackTrace();}
             }
         });

         JButton cancel=new JButton("Cancel");
         cancel.setBounds(170,350,100,25);
         cancel.setBackground(Color.BLACK);
         cancel.setForeground(Color.WHITE);
         add(cancel);
         cancel.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 setVisible(false);
                 new Main();
             }
         });



        setSize(500,550);
        setVisible(true);
        setLocationRelativeTo(null);

    }
    public static void main(String[] args)
    {
       new StudentLeave();
    }
}
