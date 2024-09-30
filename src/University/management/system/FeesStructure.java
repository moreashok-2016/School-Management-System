package University.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class FeesStructure extends JFrame
{
    FeesStructure()
    {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading= new JLabel("Fees Stucture!");
        heading.setBounds(400,10,400,30);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        add(heading);

        JTable table=new JTable();
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.st.executeQuery("SELECT * FROM fees");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane js=new JScrollPane(table);
        js.setBounds(0,60,1000,700);
        add(js);

        setSize(1000,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new FeesStructure();
    }
}
