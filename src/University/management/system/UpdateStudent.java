package University.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateStudent extends JFrame
{
    Conn con;
    public UpdateStudent(String rno)
    {
        setLayout(null);
        getContentPane().setBackground((new Color(20,227,179)));

        JLabel heading=new JLabel("Update Student Details !");
        heading.setBounds(300,50,500,40);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel name=new JLabel("Name:");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("arial",Font.BOLD,20));
        add(name);

        JLabel tname=new JLabel();
        tname.setBounds(230,150,150,30);
        tname.setFont(new Font("arial", Font.BOLD, 20));
        tname.setBackground(new Color(177,252,197));
        tname.setForeground(Color.red);
        add(tname);

        JLabel fname=new JLabel("FName:");
        fname.setBounds(450,150,150,30);
        fname.setFont(new Font("arial", Font.BOLD, 20));
        add(fname);

        JLabel tfname=new JLabel();
        tfname.setBounds(650,150,150,30);
        tfname.setFont(new Font("arial", Font.BOLD, 20));
        tfname.setBackground(new Color(177,252,197));
        tfname.setForeground(Color.red);
        add(tfname);

        JLabel rollno=new JLabel("Roll No:");
        rollno.setBounds(50,200,150,30);
        rollno.setFont(new Font("arial", Font.BOLD, 20));
        add(rollno);

        JLabel trollno=new JLabel();
        trollno.setBounds(230,200,150,30);
        trollno.setFont(new Font("arial", Font.BOLD, 20));
        trollno.setBackground(new Color(177,252,197));
        trollno.setForeground(Color.red);
        add(trollno);

        JLabel dob=new JLabel("DOB:");
        dob.setBounds(450,200,150,30);
        dob.setFont(new Font("arial", Font.BOLD, 20));
        add(dob);

        JLabel tdob=new JLabel();
        tdob.setBounds(650,200,150,30);
        tdob.setFont(new Font("arial", Font.BOLD, 20));
        tdob.setBackground(new Color(177,252,197));
        tdob.setForeground(Color.red);
        add(tdob);

        JLabel blood=new JLabel("Blood Group:");
        blood.setBounds(50,250,150,30);
        blood.setFont(new Font("arial", Font.BOLD, 20));
        add(blood);

        JLabel tblood=new JLabel();
        tblood.setBounds(230,250,150,30);
        tblood.setFont(new Font("arial", Font.BOLD, 20));
        tblood.setBackground(new Color(177,252,197));
        tblood.setForeground(Color.red);
        add(tblood);

        JLabel gender=new JLabel("Gender:");
        gender.setBounds(450,250,150,30);
        gender.setFont(new Font("arial", Font.BOLD, 20));
        add(gender);

        JLabel tgender=new JLabel();
        tgender.setBounds(650,250,150,30);
        tgender.setFont(new Font("arial", Font.BOLD, 20));
        tgender.setForeground(Color.red);
        tgender.setBackground(new Color(177,252,197));
        add(tgender);

        JLabel quota=new JLabel("Quota:");
        quota.setBounds(50,300,150,30);
        quota.setFont(new Font("arial", Font.BOLD, 20));
        add(quota);

        JLabel tquota=new JLabel();
        tquota.setBounds(230,300,150,30);
        tquota.setFont(new Font("arial", Font.BOLD, 20));
        tquota.setBackground(new Color(177,252,197));
        tquota.setForeground(Color.red);
        add(tquota);

        JLabel std=new JLabel("Standerd:");
        std.setBounds(450,300,150,30);
        std.setFont(new Font("arial", Font.BOLD, 20));
        add(std);

        JLabel tstd=new JLabel();
        tstd.setBounds(650,300,150,30);
        tstd.setFont(new Font("arial", Font.BOLD, 20));
        tstd.setForeground(Color.red);
        tstd.setBackground(new Color(177,252,197));
        add(tstd);

        JLabel address=new JLabel("Address:");
        address.setBounds(50,350,150,30);
        address.setFont(new Font("arial", Font.BOLD, 20));
        add(address);

        JTextField taddress=new JTextField();
        taddress.setBounds(230,350,150,30);
        taddress.setFont(new Font("arial", Font.BOLD, 20));
        taddress.setBackground(new Color(177,252,197));
        add(taddress);

        JLabel phone=new JLabel("Phone:");
        phone.setBounds(450,350,150,30);
        phone.setFont(new Font("arial", Font.BOLD, 20));
        add(phone);

        JTextField tphone=new JTextField();
        tphone.setBounds(650,350,150,30);
        tphone.setFont(new Font("arial", Font.BOLD, 20));
        tphone.setBackground(new Color(177,252,197));
        add(tphone);

        JLabel aadhar=new JLabel("Aadhar:");
        aadhar.setBounds(50,400,150,30);
        aadhar.setFont(new Font("arial", Font.BOLD, 20));
        add(aadhar);

        JTextField taadhar=new JTextField();
        taadhar.setBounds(230,400,150,30);
        taadhar.setFont(new Font("arial", Font.BOLD, 20));
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);


        try
        {
            con=new Conn();
            ResultSet rs=con.st.executeQuery("SELECT * FROM student WHERE rollno='"+Integer.parseInt(rno)+"'");

            while(rs.next())
            {
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                trollno.setText(""+rs.getInt("rollno"));
                tdob.setText(rs.getString("dob"));
                tblood.setText(rs.getString("blood"));
                tgender.setText(rs.getString("gender"));
                tquota.setText(rs.getString("quota"));
                tstd.setText(rs.getString("std"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                taadhar.setText(rs.getString("aadhar"));

            }

        }catch (Exception e3){e3.printStackTrace();}

        JButton save=new JButton("Save");
        save.setBounds(250,500,150,30);
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String address=taddress.getText();
                String phone=tphone.getText();
                String aadhar=taadhar.getText();

               try
               {
                   con.st.executeUpdate("UPDATE Student SET address='"+address+"', phone='"+phone+"', aadhar='"+aadhar+"' WHERE rollno='"+Integer.parseInt(rno)+"'");
                   JOptionPane.showMessageDialog(null, "Details Saved Successfully");
                   new ViewStudent();
                   setVisible(false);
               }catch (Exception e4){e4.printStackTrace();}
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(450,500,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewStudent();
                setVisible(false);
            }
        });

        setSize(900,700);
        setVisible(true);
        setLocationRelativeTo(null);

    }
    public static void main(String[] args)
    {
        String str = "1000";
        new UpdateStudent(str);
    }
}
