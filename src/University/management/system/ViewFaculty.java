package University.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.*;

public class ViewFaculty extends JFrame
{
    Conn con;
    public ViewFaculty()
    {
        setLayout(null);
        getContentPane().setBackground(new Color(84,213,253));

        JLabel search=new JLabel("Search by Teacher Id:");
        search.setBounds(20,20,150,20);
        add(search);

        Choice ch=new Choice();
        ch.setBounds(180,20,150,20);
        ch.setBackground(Color.WHITE);
        add(ch);

        try
        {
            con=new Conn();
           ResultSet rs= con.st.executeQuery("SELECT * FROM Faculty");
           while(rs.next())
           {
               ch.add(rs.getString("id"));
           }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        JTable table=new JTable();
        try
        {
             ResultSet rs=con.st.executeQuery("SELECT * FROM Faculty");
             table.setModel(DbUtils.resultSetToTableModel(rs));
             JScrollPane js=new JScrollPane(table);
             js.setBounds(0,100,900,600);
             add(js);
        }catch(Exception e)
        {
            e.printStackTrace();
        }



        JButton search1=new JButton("Search");
        search1.setBounds(20, 70,80 ,20 );
        add(search1);
        search1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                       ResultSet rs = con.st.executeQuery("SELECT * FROM Faculty WHERE id='" + ch.getSelectedItem() + "'");
                       table.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch (Exception e1)
                {
                    e1.printStackTrace();
                }

            }
        });


        JButton print=new JButton("Print");
        print.setBounds(120,70,80,20);
        add(print);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    table.print();
                } catch (PrinterException e2) {
                    throw new RuntimeException(e2);
                }
            }
        });

        JButton update=new JButton("Update");
        update.setBounds(220,70,80,20);
        add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateFaculty(""+ch.getSelectedItem());
                setVisible(false);
            }
        });


        JButton back=new JButton("Back");
        back.setBounds(320,70,80,20);
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
                setVisible(false);
            }
        });

        setSize(900,700);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
    }



    public static void main(String args[])throws Exception
    {
        new ViewFaculty();
    }
}
