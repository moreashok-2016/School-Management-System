package University.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddFaculty extends JFrame
{
    Conn con;
    Random r=new Random();
    JLabel tempid;
    JDateChooser cdob;
    JComboBox jqualification,jdepartment;

    JButton submit,back;

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
    AddFaculty()
    {
        setLayout(null);

        getContentPane().setBackground(new Color(166,164,252));

        JLabel heading=new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);

        JLabel name=new JLabel("Name:");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        JTextField tname=new JTextField();
        tname.setBounds(200,150,200,30);
        tname.setFont(new Font("serif",Font.BOLD,20));
        add(tname);

        JLabel father=new JLabel("Father Name:");
        father.setBounds(450,150,200,30);
        father.setFont(new Font("serif",Font.BOLD,20));
        add(father);

        JTextField tfather=new JTextField();
        tfather.setBounds(600,150,200,30);
        tfather.setFont(new Font("serif",Font.BOLD,20));
        add(tfather);

        JLabel empid=new JLabel("Teacher Id:");
        empid.setBounds(50,200,150,30);
        empid.setFont(new Font("serif",Font.BOLD,20));
        add(empid);

        tempid=new JLabel(" "+random());
        tempid.setBounds(200,200,150,30);
        tempid.setForeground(Color.RED);
        tempid.setFont(new Font("serif",Font.BOLD,20));
        add(tempid);

        JLabel dob=new JLabel("Date of Birth:");
         dob.setBounds(450,200,200,30);
         dob.setFont(new Font("serif",Font.BOLD,20));
         add(dob);

         cdob=new JDateChooser();
        cdob.setBounds(600,200,200,30);
        cdob.setFont(new Font("serif",Font.BOLD,20));
        add(cdob);

        JLabel address=new JLabel("Address:");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        JTextField taddress=new JTextField();
        taddress.setBounds(200,250,200,30);
        taddress.setFont(new Font("serif",Font.BOLD,20));
        add(taddress);

        JLabel phone=new JLabel("Phone:");
        phone.setBounds(450,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        JTextField tphone=new JTextField();
        tphone.setBounds(600,250,200,30);
        tphone.setFont(new Font("serif",Font.BOLD,20));
        add(tphone);

        JLabel email=new JLabel("Email:");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        JTextField temil=new JTextField();
        temil.setBounds(200,300,200,30);
        temil.setFont(new Font("serif",Font.BOLD,20));
        add(temil);

        JLabel mark=new JLabel("Class X Marks:");
        mark.setBounds(450,300,200,30);
        mark.setFont(new Font("serif",Font.BOLD,20));
        add(mark);

        JTextField tmark=new JTextField();
        tmark.setBounds(600,300,200,30);
        tmark.setFont(new Font("serif",Font.BOLD,20));
        add(tmark);

        JLabel marks=new JLabel("Class XII Marks:");
        marks.setBounds(50,350,200,30);
        marks.setFont(new Font("serif",Font.BOLD,20));
        add(marks);

        JTextField tmarks=new JTextField();
        tmarks.setBounds(200,350,200,30);
        tmarks.setFont(new Font("serif",Font.BOLD,20));
        add(tmarks);

        JLabel aaddhar=new JLabel("Aadhar:");
        aaddhar.setBounds(450,350,200,30);
        aaddhar.setFont(new Font("serif",Font.BOLD,20));
        add(aaddhar);

        JTextField taadhar=new JTextField();
        taadhar.setBounds(600,350,200,30);
        taadhar.setFont(new Font("serif",Font.BOLD,20));
        add(taadhar);

        JLabel qualification=new JLabel("Qualification:");
        qualification.setBounds(50,400,200,30);
        qualification.setFont(new Font("serif",Font.BOLD,20));
        add(qualification);

        String str[]={"B.ED","D.ED","PHD"};
        jqualification=new JComboBox(str);
        jqualification.setBounds(200,400,200,30);
        jqualification.setFont(new Font("serif",Font.BOLD,20));
        jqualification.setBackground(Color.WHITE);
        add(jqualification);

        JLabel department=new JLabel("Department:");
        department.setBounds(450,400,200,30);
        department.setFont(new Font("serif",Font.BOLD,20));
        add(department);

        String str1[]={"Mathematics","Science","History","Geography","English","Hindi","Marathi"};

        jdepartment=new JComboBox(str1);
        jdepartment.setBounds(600,400,200,30);
        jdepartment.setFont(new Font("serif",Font.BOLD,20));
        add(jdepartment);

       submit =new JButton("Submit");
       submit.setBounds(250,450,100,30);
       submit.setForeground(Color.BLACK);
       submit.setBackground(Color.WHITE);
       submit.setFont(new Font("serif", Font.BOLD, 20));
       add(submit);
      submit.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e)
          {
              String name=tname.getText();
              String fname=tfather.getText();
              String empid=tempid.getText();
              String dob=((JTextField)cdob.getDateEditor().getUiComponent()).getText();
              String address=taddress.getText();
              String phone=tphone.getText();
              String email=temil.getText();
              String X=tmark.getText();
              String XII=tmarks.getText();
              String aadhar=taadhar.getText();
              String cource=(String)jqualification.getSelectedItem();
              String department=(String)jdepartment.getSelectedItem();

              try
              {
                  con=new Conn();
                  con.st.executeUpdate("insert into Faculty values('"+name+"','"+fname+"','"+empid+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+aadhar+"','"+X+"','"+XII+"','"+cource+"','"+department+"')");
                  JOptionPane.showMessageDialog(null, "Information Added Successfully");

                  tname.setText("");
                  tfather.setText("");
                  tempid.setText(""+random());
                  taddress.setText("");tphone.setText("");temil.setText("");tmark.setText("");tmarks.setText("");
                  taadhar.setText("");
                  jqualification=new JComboBox(str);
                  jdepartment=new JComboBox(str1);
                  //setVisible(false);
              }catch (Exception e1)
              {
                  e1.printStackTrace();
              }
          }
      });

        back =new JButton("Back");
        back.setBounds(400,450,100,30);
         back.setForeground(Color.BLACK);
         back.setBackground(Color.WHITE);
         back.setFont(new Font("serif", Font.BOLD, 20));
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                new Main();
            }
        });

        setSize(900,700);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args)
    {
       new AddFaculty();
    }
}
