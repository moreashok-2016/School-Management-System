package University.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame
{
    String rollno;
    Conn c;
    Marks(String rollno)
    {
       this.rollno=rollno;

       setLayout(null);
       getContentPane().setBackground(new Color(210,252,248));

       JLabel heading=new JLabel("ITEP School Pune");
       heading.setBounds(100,10,500,25);
       heading.setFont(new Font("Tahoma",Font.BOLD,20));
       add(heading);

       JLabel subheading=new JLabel("Result Of Examination '2024'");
       subheading.setBounds(100,50,500,20);
       subheading.setFont(new Font("Tahoma",Font.BOLD,18));
       add(subheading);

       JLabel roll=new JLabel("Roll No:"+rollno);
       roll.setBounds(60,100,500,20);
       roll.setFont(new Font("Tahoma",Font.PLAIN,18));
       add(roll);

       JLabel sem=new JLabel();
       sem.setBounds(60,130,500,20);
       sem.setFont(new Font("Tahoma",Font.PLAIN,18));
       add(sem);

       JLabel sub1=new JLabel();
       sub1.setBounds(100,200,500,20);
       sub1.setFont(new Font("Tahoma", Font.PLAIN,18));
       add(sub1);

        JLabel sub2=new JLabel();
        sub2.setBounds(100,230,500,20);
        sub2.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(sub2);

        JLabel sub3=new JLabel();
        sub3.setBounds(100,260,500,20);
        sub3.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(sub3);

        JLabel sub4=new JLabel();
        sub4.setBounds(100,290,500,20);
        sub4.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(sub4);

        JLabel sub5=new JLabel();
        sub5.setBounds(100,320,500,20);
        sub5.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(sub5);

        try
        {
            c=new Conn();
            ResultSet rs=c.st.executeQuery("select * from subject where rollno='"+rollno+"'");
            while(rs.next())
            {
                sub1.setText(rs.getString("sub1"));
                sub2.setText(rs.getString("sub2"));
                sub3.setText(rs.getString("sub3"));
                sub4.setText(rs.getString("sub4"));
                sub5.setText(rs.getString("sub5"));
            }
        }catch (Exception e){e.printStackTrace();}

        try
        {
           ResultSet rs1=c.st.executeQuery("select * from marks where rollno='"+rollno+"'");
           while(rs1.next())
           {
               sub1.setText(sub1.getText()+"---------------"+rs1.getString("marks1"));
               sub2.setText(sub2.getText()+"---------------------"+rs1.getString("marks2"));
               sub3.setText(sub3.getText()+"-------------"+rs1.getString("marks3"));
               sub4.setText(sub4.getText()+"--------------------"+rs1.getString("marks4"));
               sub5.setText(sub5.getText()+"-----------------------"+rs1.getString("marks5"));

               sem.setText("Semester"+rs1.getString("semester"));
           }

        }catch (Exception e){e.printStackTrace();}

        JButton cancel=new JButton("Cancel");
        cancel.setBounds(250,500,120,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main();
                setVisible(false);
            }
        });



       setSize(500,600);
       setLocationRelativeTo(null);
       setVisible(true);

    }
    public static void main(String[] args)
    {
        new Marks("");
    }
}
