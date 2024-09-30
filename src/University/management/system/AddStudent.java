package University.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class AddStudent extends JFrame
{
    Random r=new Random();
    int n=Math.abs(r.nextInt() % 100);
    JButton back,submit;
    JComboBox tquota,tstd,tgender;
    public int random()
    {
        r = new Random();
        int n = (Math.abs(r.nextInt() % 100));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universe", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id FROM Faculty WHERE id='"+n+"' ");
            if (rs.next())
            {
                int val= random();
                return val;
            } else
            {
                return n;
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }


        return 0;

    }
    AddStudent()
    {
        setLayout(null);
        getContentPane().setBackground(new Color(50,130,246));

        JLabel heading=new JLabel("New Student Details");
        heading.setBounds(250,30,400,40);
        heading.setForeground(Color.BLACK);
        heading.setFont(new Font("serif", Font.BOLD, 35));
        add(heading);

        JLabel name=new JLabel("Name:");
        name.setBounds(50,100,150,30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        name.setForeground(Color.BLACK);
        add(name);

        JTextField tname=new JTextField();
        tname.setBounds(200,100,150,30);
        tname.setFont(new Font( "serif",Font.BOLD,20));
        tname.setForeground(Color.BLACK);
        add(tname);

        JLabel fname=new JLabel("Father Name:");
        fname.setBounds(400,100,150,30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        fname.setForeground(Color.BLACK);
        add(fname);

        JTextField tfname=new JTextField();
        tfname.setBounds(600,100,150,30);
        tfname.setFont(new Font( "serif",Font.BOLD,20));
        tfname.setForeground(Color.BLACK);
        add(tfname);

        JLabel roll=new JLabel("Roll NO:");
        roll.setBounds(50,150,150,30);
        roll.setFont(new Font("serif", Font.BOLD, 20));
        roll.setForeground(Color.BLACK);
        add(roll);

        JLabel troll=new JLabel(""+random());
        troll.setBounds(200,150,150,30);
        troll.setFont(new Font( "serif",Font.BOLD,20));
        troll.setForeground(Color.RED);
        add(troll);

        JLabel dob=new JLabel("Date Of Birth:");
        dob.setBounds(400,150,150,30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        dob.setForeground(Color.BLACK);
        add(dob);

        JDateChooser cdob=new JDateChooser();
        cdob.setBounds(600,150,150,30);
        cdob.setFont(new Font( "serif",Font.BOLD,20));
        cdob.setForeground(Color.BLACK);
        add(cdob);

        JLabel address=new JLabel("Address:");
        address.setBounds(50,200,150,30);
        address.setFont(new Font("serif", Font.BOLD, 20));
        address.setForeground(Color.BLACK);
        add(address);

        JTextField taddress=new JTextField();
        taddress.setBounds(200,200,150,30);
        taddress.setFont(new Font( "serif",Font.BOLD,20));
        taddress.setForeground(Color.BLACK);
        add(taddress);

        JLabel phone=new JLabel("Phone:");
        phone.setBounds(400,200,150,30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        phone.setForeground(Color.BLACK);
        add(phone);

        JTextField tphone=new JTextField();
        tphone.setBounds(600,200,150,30);
        tphone.setFont(new Font( "serif",Font.BOLD,20));
        tphone.setForeground(Color.BLACK);
        add(tphone);

        JLabel bgroup=new JLabel("Blood Group:");
        bgroup.setBounds(50,250,150,30);
        bgroup.setFont(new Font("serif", Font.BOLD, 20));
        bgroup.setForeground(Color.BLACK);
        add(bgroup);

        JTextField tbgroup=new JTextField();
        tbgroup.setBounds(200,250,150,30);
        tbgroup.setFont(new Font( "serif",Font.BOLD,20));
        tbgroup.setForeground(Color.BLACK);
        add(tbgroup);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(400,250,150,30);
        gender.setFont(new Font("serif", Font.BOLD, 20));
        gender.setForeground(Color.BLACK);
        add(gender);

        String str[]={"Male","Female",};
        tgender=new JComboBox(str);
        tgender.setBounds(600,250,150,30);
        tgender.setFont(new Font("serif", Font.BOLD, 15));
        tgender.setForeground(Color.BLACK);
        add(tgender);


        JLabel aadhar=new JLabel("Aadhar:");
        aadhar.setBounds(50,300,150,30);
        aadhar.setFont(new Font("serif", Font.BOLD, 20));
        aadhar.setForeground(Color.BLACK);
        add(aadhar);

        JTextField taadhar=new JTextField();
        taadhar.setBounds(200,300,150,30);
        taadhar.setFont(new Font( "serif",Font.BOLD,20));
        taadhar.setForeground(Color.BLACK);
        add(taadhar);

        JLabel quota=new JLabel("Cource:");
        quota.setBounds(400,300,150,30);
        quota.setFont(new Font("serif", Font.BOLD, 20));
        quota.setForeground(Color.BLACK);
        add(quota);

        String str1[]={"Sport","Normal","Other"};
        tquota=new JComboBox(str1);
        tquota.setBounds(600,300,150,30);
        tquota.setFont(new Font("serif", Font.BOLD, 15));
        tquota.setForeground(Color.BLACK);
        add(tquota);

        JLabel std=new JLabel("Standerd:");
        std.setBounds(50,350,150,30);
        std.setFont(new Font("serif", Font.BOLD, 20));
        std.setForeground(Color.BLACK);
        add(std);

        String str2[]={"V","VI","VII","VIII","IX","X"};
        tstd=new JComboBox(str2);
        tstd.setBounds(200,350,150,30);
        tstd.setFont(new Font("serif", Font.BOLD, 15));
        tstd.setForeground(Color.BLACK);
        add(tstd);

        /*JButton submit=new JButton("Submit");
        submit.setBounds(300,450,100,30);
        submit.setFont(new Font("serif", Font.BOLD, 20));
        submit.setForeground(Color.BLACK);
        submit.setBackground(Color.WHITE);
        add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String name=tname.getText();
                String father=tfname.getText();
                String rollno=troll.getText();
                String dob=((JTextField)cdob.getDateEditor().getUiComponent()).getText();
                String address=taddress.getText();
                String phone=tphone.getText();
                String blood=tbgroup.getText();
                String gender=(String)tgender.getSelectedItem();
                String aadhar=taadhar.getText();
                String quota=(String)tquota.getSelectedItem();
                String std=(String) tstd.getSelectedItem();

                String name1=name.toLowerCase();
                for(int i=0;i<name1.length();i++)
                {
                    char ch=name1.charAt(i);

//                    if(ch>='a' && ch<='z')
//                    {

                        try {
                            new Conn().st.executeUpdate("insert into student values('" + name + "','" + father + "','" + rollno + "','" + dob + "','" + address + "','" + phone + "','" + blood + "','" + gender + "','" + aadhar + "','" + quota + "','" + std + "')");
                            JOptionPane.showMessageDialog(null, "Informaion Added Successfully");
                            tname.setText("");
                            tfname.setText("");
                            troll.setText("" + random());
                            taddress.setText("");
                            tphone.setText("");
                            tgender = new JComboBox(str);
                            taadhar.setText("");
                            tbgroup.setText("");
                            tquota = new JComboBox(str1);
                            tstd = new JComboBox(str2);

                        } catch (Exception e1) {e1.printStackTrace();}
//                    }else
//                        JOptionPane.showMessageDialog(null, "Enter Valid Name");

                }
            });*/

        submit=new JButton("Submit");
        submit.setBounds(300,450,100,30);
        submit.setFont(new Font("serif", Font.BOLD, 20));
        submit.setForeground(Color.BLACK);
        submit.setBackground(Color.WHITE);
        add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name=tname.getText();
                String father=tfname.getText();
                String rollno=troll.getText();
                String dob=((JTextField)cdob.getDateEditor().getUiComponent()).getText();
                String address=taddress.getText();
                String phone=tphone.getText();
                String blood=tbgroup.getText();
                String gender=(String)tgender.getSelectedItem();
                String aadhar=taadhar.getText();
                String quota=(String)tquota.getSelectedItem();
                String std=(String) tstd.getSelectedItem();

                try {
                    new Conn().st.executeUpdate("insert into student values('" + name + "','" + father + "','" + rollno + "','" + dob + "','" + address + "','" + phone + "','" + blood + "','" + gender + "','" + aadhar + "','" + quota + "','" + std + "')");
                    JOptionPane.showMessageDialog(null, "Informaion Added Successfully");
                    tname.setText("");
                    tfname.setText("");
                    troll.setText("" + random());
                    taddress.setText("");
                    tphone.setText("");
                    tgender = new JComboBox(str);
                    taadhar.setText("");
                    tbgroup.setText("");
                    tquota = new JComboBox(str1);
                    tstd = new JComboBox(str2);

                } catch (Exception e1) {e1.printStackTrace();}
            }
        });

        back=new JButton("Back");
        back.setBounds(500,450,100,30);
        back.setFont(new Font("serif", Font.BOLD, 20));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
            add(back);
        back.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e)
                {
                    new Main();
                    setVisible(false);
                }
            });






            setSize(900,700);
            setVisible(true);
            setLocationRelativeTo(null);
        }
        public static void main(String args[])
        {
            new AddStudent();
        }
    }
