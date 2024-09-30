package University.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.*;

public class ViewStudent extends JFrame
{
    Conn con;
    public ViewStudent()
    {
        setLayout(null);
        getContentPane().setBackground(new Color(247,255,9));


        JButton search=new JButton("Search by Student RollNO:");
        search.setBounds(20,20,190,20);
        add(search);

        Choice ch=new Choice();
        ch.setBounds(220,20,150,20);
        add(ch);


        try
        {
           con=new Conn();
           ResultSet rs=con.st.executeQuery("SELECT rollno FROM Student");
           while(rs.next())
           {
               ch.add(""+rs.getInt("rollno"));
           }
        }catch (Exception e){e.printStackTrace();}

        JTable table=new JTable();

        try
        {
           ResultSet rs=con.st.executeQuery("SELECT * FROM Student");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           JScrollPane js=new JScrollPane(table);
           js.setBounds(0,100,930,600);
           add(js);
        }catch (Exception e){e.printStackTrace();}


        JButton search1=new JButton("Search");
        search1.setBounds(20,70,80,20);
        add(search1);
        search1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                       ResultSet rs=con.st.executeQuery("SELECT * FROM Student WHERE rollno='"+ch.getSelectedItem()+"'");
                       table.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch (Exception e1){e1.printStackTrace();}
            }
        });

        JButton print = new JButton("Print");
        print.setBounds(120,70,80,20);
        add(print);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    table.print();
                } catch (PrinterException ex) {throw new RuntimeException(ex);}
            }
        });

        JButton update=new JButton("Update");
        update.setBounds(220,70,80,25);
        add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateStudent(ch.getSelectedItem());
                setVisible(false);
            }
        });


        JButton back=new JButton("Back");
        back.setBounds(320,70,80,25);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main();
                setVisible(false);
            }
        });

        JButton exit=new JButton("Exit");
        exit.setBounds(420,70,80,20);
        add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setSize(950,700);
        setVisible(true);
        setLocationRelativeTo(null);
    }



    public static void main(String args[])throws Exception
    {
        new ViewStudent();
    }
}

