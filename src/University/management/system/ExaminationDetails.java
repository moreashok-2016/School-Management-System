package University.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ExaminationDetails extends JFrame
{
    ExaminationDetails()
    {
        getContentPane().setBackground(new Color(241,252,210));
        setLayout(null);

        JLabel heading=new JLabel("Check Result!");
        heading.setBounds(350,15,400,50);
        heading.setFont(new Font("Tahoma", Font.BOLD,24));
        add(heading);

        JTextField search=new JTextField();
        search.setBounds(80,90,200,18);
        search.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(search);

        JButton result=new JButton("Result");
        result.setBounds(300,90,120,30);
        result.setBackground(Color.BLACK);
        result.setForeground(Color.WHITE);
        add(result);
        result.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Marks(search.getText());
                setVisible(false);
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(450,90,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                new Main();
            }
        });


        JTable table=new JTable();
        try
        {
           Conn con=new Conn();
           ResultSet rs=con.st.executeQuery("Select * from student");
           table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){e.printStackTrace();}
        JScrollPane sc=new JScrollPane(table);
        sc.setBounds(0,130,1000,310);
        add(sc);

        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e)
        {
            int row=table.getSelectedRow();
            search.setText(table.getModel().getValueAt(row,2).toString());
        }
    });

        setSize(1000,475);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new ExaminationDetails();
    }
}
