package University.management.system;

import javax.swing.*;

public class Demo extends JFrame
{
    Demo()
    {
        JMenuBar mb=new JMenuBar();

        JMenu menu1=new JMenu("Menu 1");
       // menu1.setForeground(Color.BLACK);

        JMenuItem item1=new JMenuItem("Item 1");
        menu1.add(item1);

        JMenu submenu=new JMenu("SubMenu");

        JMenuItem submenu1=new JMenuItem("Sub Item 1");
        JMenuItem submenu2=new JMenuItem("sub Item 2");

        submenu.add(submenu1);
        submenu.add(submenu2);
        menu1.add(submenu);

        mb.add(menu1);
        setJMenuBar(mb);
    }
    public static void main(String[] args) {
        Demo d=new Demo();
        d.setSize(400,400);
        d.setVisible(true);
        d.setLocationRelativeTo(null);


    }
}
