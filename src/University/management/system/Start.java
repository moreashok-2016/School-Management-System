package University.management.system;

import javax.swing.*;
import java.awt.*;
public class Start extends JFrame implements Runnable
{
    Thread t;
    Start()
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/download.gif"));
        Image i2=i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        add(img);

        t=new Thread(this);
        t.start();
        setVisible(true);

        int x=1;
        for(int i=2;i<=600;i+=4,x+=1)
        {
            //setLocation(600 - ((i + x) / 2), 350 - (i / 2));
            setLocationRelativeTo(null);
            setSize(i + 3 * x, i + x / 2);

            try
            {
                Thread.sleep(10);
            }catch(Exception e)
            {
                e.printStackTrace();
            }

        }


       setVisible(true);
    }
    public void run()
    {

        try
        {
            Thread.sleep(6000);
            setVisible(false);
            new Login();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args)
    {
        new Start();
    }


}
