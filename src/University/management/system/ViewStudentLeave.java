package University.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewStudentLeave extends JFrame
{
    Conn con;
    ViewStudentLeave()
    {
        setLayout(null);
        getContentPane().setBackground(new Color(250,172,206));

        JLabel search=new JLabel("search by Student Rollno:");
        search.setBounds(20,20,150,20);
        add(search);

        Choice ch=new Choice();
        ch.setBounds(180,20,150,20);
        add(ch);
        try
        {
            con=new Conn();
            ResultSet rs=con.st.executeQuery("SELECT * FROM SLeave");
            while(rs.next())
            {
                ch.add(""+rs.getInt("s_rollno"));
            }
        }catch (Exception e){e.printStackTrace();}

        JTable table=new JTable();

        try
        {
            ResultSet rs=con.st.executeQuery("SELECT * FROM SLeave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            JScrollPane js=new JScrollPane(table);
            js.setBounds(0,100,900,700);
            add(js);
        }catch (Exception e2){e2.printStackTrace();}

        JButton search1=new JButton("Search");
        search1.setBounds(20,70,80,20);
        add(search1);
        search1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ResultSet rs = con.st.executeQuery("SELECT * FROM SLeave WHERE s_rollno='" + ch.getSelectedItem() + "'");
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception e3){e3.printStackTrace();}
            }
        });

        JButton print=new JButton("Print");
        print.setBounds(120,70,80,20);
        add(print);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    table.print();
                }catch (Exception e4){e4.printStackTrace();}
            }
        });

        JButton cancel=new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main();
                setVisible(false);
            }
        });

        setSize(900,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ViewStudentLeave();
    }
}
