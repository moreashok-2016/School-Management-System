package University.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame
{
    JTextField tname;
    JPasswordField tpass;
    JButton login,back;

    Conn con;
    Login()
    {
        setLayout(null);

        JLabel lname=new JLabel("UserName");
        lname.setBounds(40,20,100,20);
        add(lname);

        tname=new JTextField();
        tname.setBounds(150,20,150,20);
        add(tname);

        JLabel lpass=new JLabel("Password");
        lpass.setBounds(40,70,100,20);
        add(lpass);

        tpass=new JPasswordField();
        tpass.setBounds(150,70,150,20);
        add(tpass);

        login=new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        add(login);
        login.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name=tname.getText();
                String pass=tpass.getText();
                try
                {
                    con=new Conn();
                   ResultSet rs=con.st.executeQuery("select * from login where name='"+name+"' and pass='"+pass+"'");
                   if(rs.next())
                   {
                      JOptionPane.showMessageDialog(null,"Login SuccessFull");
                      new Main();
                      setVisible(false);
                   }else
                   {
                       JOptionPane.showMessageDialog(null,"Wrong UserName and Password!");
                       tname.setText("");
                       tpass.setText("");

                   }
                }catch(Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        back=new JButton("Back");
        back.setBounds(180,140,120,30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
                setVisible(false);
            }
        });

                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/second.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(350,20,200,200);
        add(img);

        ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icon/loginback.png"));
        Image i22=i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i33=new ImageIcon(i22);
        JLabel image=new JLabel(i33);
        image.setBounds(0,0,600,300);
        add(image);




        setSize(600,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String args[])
    {
         new Login();
    }
}
