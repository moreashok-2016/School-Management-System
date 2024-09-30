package University.management.system;

import javax.swing.*;
import java.awt.*;

public class Sample extends JFrame
{

    Sample()
    {
        setSize(400,400);
        setVisible(true);
        setLocationRelativeTo(null);

        Container c=getContentPane();
        c.setLayout(null);

        JMenuBar mb=new JMenuBar();

        JMenu menu1=new JMenu("Menu 1");

        JMenuItem item1=new JMenuItem("Item 1");
        menu1.add(item1);

        JMenu submenu=new JMenu("SubMenu");

        JMenuItem submenu1=new JMenuItem("Sub Item 1");
        JMenuItem submenu2=new JMenuItem("sub Item 2");

        submenu.add(submenu1);
        submenu.add(submenu2);
        menu1.add(submenu);

        mb.add(menu1);
        c.add(mb);
    }
    public void main(String args[])throws Exception
    {
       new Sample();
    }
}
