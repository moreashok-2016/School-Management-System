package University.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame
{
    About()
    {
        setLayout(null);
        getContentPane().setBackground(new Color(252,228,210));

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/main.jpg"));
        Image i2=i1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(350,50,300,200);
        add(img);

        JLabel heading=new JLabel("<html> ITEP School<br>Pune</html>");
        heading.setBounds(70,20,300,130);
        heading.setFont(new Font("Tahoma", Font.BOLD,30));
        add(heading);

        JLabel name=new JLabel("Vishwas Kale");
        name.setBounds(60,250,300,20);
        name.setFont(new Font("Safari",Font.ITALIC,18));
        add(name);

        JLabel contact=new JLabel("vishwaskale420@gmail.com");
        contact.setBounds(60,290,300,20);
        contact.setFont(new Font("Safari",Font.ITALIC,18));
        add(contact);

        JLabel no=new JLabel("+91 7945786512");
        no.setBounds(60,330,300,20);
        no.setFont(new Font("Safari",Font.ITALIC,18));
        add(no);

        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new About();
    }
}
