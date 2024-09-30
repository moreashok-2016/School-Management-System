package University.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame {

    Conn con;
    JComboBox cbox;

    JTextField marks1,marks2,marks3,marks4,marks5;
    JLabel sub1,sub2,sub3,sub4,sub5;
    EnterMarks()
    {
        setLayout(null);
        getContentPane().setBackground(new Color(252,245,210));

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/exam.png"));
        Image i2=i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(500,40,400,300);
        add(img);

        JLabel heading=new JLabel("Student  Marks Filling!:");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        add(heading);

        JLabel rollno=new JLabel("Select Roll Number:");
        rollno.setBounds(50,70,170,50);
        add(rollno);

        Choice ch=new Choice();
        ch.setBounds(230,85,150,20);
        add(ch);

        try
        {
            con=new Conn();
            ResultSet rs=con.st.executeQuery("SELECT * FROM Student");
            while (rs.next())
            {
                ch.add(""+rs.getInt("rollno"));
            }

        }catch (Exception e){e.printStackTrace();}

        JLabel semester=new JLabel("    Select Semester:");
        semester.setBounds(50,120,170,20);
        add(semester);

        String sem[]={"1st Semester","2nd Semester","1st Unit Test","2nd Unit Test"};
         cbox=new JComboBox(sem);
         cbox.setBounds(230,125,150,20);
         cbox.setBackground(Color.WHITE);
         add(cbox);


         JLabel entersub=new JLabel("Enter Subject");
         entersub.setBounds(100,150,200,40);
         add(entersub);

         JLabel entermarks=new JLabel("Enter Marks");
         entermarks.setBounds(320,150,200,40);
         add(entermarks);

         sub1=new JLabel("Mathematics");
         sub1.setBounds(100,200,200,20);
         add(sub1);

        sub2=new JLabel("Science");
        sub2.setBounds(100,230,200,20);
        add(sub2);

        sub3=new JLabel("Social Science");
        sub3.setBounds(100,260,200,20);
        add(sub3);

        sub4=new JLabel("English");
        sub4.setBounds(100,290,200,20);
        add(sub4);

        sub5=new JLabel("Hindi");
        sub5.setBounds(100,320,200,20);
        add(sub5);

        marks1=new JTextField();
        marks1.setBounds(270,200,200,20);
        add(marks1);

        marks2=new JTextField();
        marks2.setBounds(270,230,200,20);
        add(marks2);

        marks3=new JTextField();
        marks3.setBounds(270,260,200,20);
        add(marks3);

        marks4=new JTextField();
        marks4.setBounds(270,290,200,20);
        add(marks4);

        marks5=new JTextField();
        marks5.setBounds(270,320,200,20);
        add(marks5);

        JButton submit=new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    con.st.executeUpdate("INSERT INTO subject VALUES('"+Integer.parseInt(ch.getSelectedItem())+"','"+cbox.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')");
                    con.st.executeUpdate("INSERT INTO marks VALUES('"+Integer.parseInt(ch.getSelectedItem())+"','"+cbox.getSelectedItem()+"','"+marks1.getText()+"','"+marks2.getText()+"','"+marks3.getText()+"','"+marks4.getText()+"','"+marks5.getText()+"')");

                    JOptionPane.showMessageDialog(null, "Marks Inserted Successfully!");
                    new Main();
                    setVisible(false);

                }catch (Exception e6){e6.printStackTrace();}
            }
        });

        JButton cancel=new JButton("Cancel");
        cancel.setBounds(260,360,150,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main();
                setVisible(false);
            }
        });



        setSize(1000,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EnterMarks();
    }
}
