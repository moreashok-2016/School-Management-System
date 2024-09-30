package University.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateFaculty extends JFrame
{
    Conn con;
    public UpdateFaculty(String fid)
    {
        setLayout(null);
        getContentPane().setBackground(new Color(37,229,250));

        JLabel heading=new JLabel("Update Faculty Details !");
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

        JLabel id=new JLabel("Id:");
        id.setBounds(50,200,150,30);
        id.setFont(new Font("arial", Font.BOLD, 20));
        add(id);

        JLabel tid=new JLabel();
        tid.setBounds(230,200,150,30);
        tid.setFont(new Font("arial", Font.BOLD, 20));
        tid.setBackground(new Color(177,252,197));
        tid.setForeground(Color.red);
        add(tid);

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

        JLabel X=new JLabel("X:");
        X.setBounds(50,250,150,30);
        X.setFont(new Font("arial", Font.BOLD, 20));
        add(X);

        JLabel tX=new JLabel();
        tX.setBounds(230,250,150,30);
        tX.setFont(new Font("arial", Font.BOLD, 20));
        tX.setBackground(new Color(177,252,197));
        tX.setForeground(Color.red);
        add(tX);

        JLabel XII=new JLabel("XII:");
        XII.setBounds(450,250,150,30);
        XII.setFont(new Font("arial", Font.BOLD, 20));
        add(XII);

        JLabel tXII=new JLabel();
        tXII.setBounds(650,250,150,30);
        tXII.setFont(new Font("arial", Font.BOLD, 20));
        tXII.setForeground(Color.red);
        tXII.setBackground(new Color(177,252,197));
        add(tXII);

        JLabel course=new JLabel("Course:");
        course.setBounds(50,300,150,30);
        course.setFont(new Font("arial", Font.BOLD, 20));
        add(course);

        JLabel tCourse=new JLabel();
        tCourse.setBounds(230,300,150,30);
        tCourse.setFont(new Font("arial", Font.BOLD, 20));
        tCourse.setBackground(new Color(177,252,197));
        tCourse.setForeground(Color.red);
        add(tCourse);

        JLabel department=new JLabel("DepartMent:");
        department.setBounds(450,300,150,30);
        department.setFont(new Font("arial", Font.BOLD, 20));
        add(department);

        JLabel tdepartment=new JLabel();
        tdepartment.setBounds(650,300,150,30);
        tdepartment.setFont(new Font("arial", Font.BOLD, 20));
        tdepartment.setForeground(Color.red);
        tdepartment.setBackground(new Color(177,252,197));
        add(tdepartment);

        JLabel address=new JLabel("Address:");
        address.setBounds(50,350,150,30);
        address.setFont(new Font("arial", Font.BOLD, 20));
        add(address);

        JTextField taddress=new JTextField();
        taddress.setBounds(230,350,150,30);
        taddress.setFont(new Font("arial", Font.BOLD, 20));
        taddress.setBackground(new Color(250,246,191));
        add(taddress);

        JLabel phone=new JLabel("Phone:");
        phone.setBounds(450,350,150,30);
        phone.setFont(new Font("arial", Font.BOLD, 20));
        add(phone);

        JTextField tphone=new JTextField();
        tphone.setBounds(650,350,150,30);
        tphone.setFont(new Font("arial", Font.BOLD, 20));
        tphone.setBackground(new Color(250,246,191));
        add(tphone);

        JLabel email=new JLabel("Email:");
        email.setBounds(50,400,150,30);
        email.setFont(new Font("arial", Font.BOLD, 20));
        add(email);

        JTextField temail=new JTextField();
        temail.setBounds(230,400,150,30);
        temail.setFont(new Font("arial", Font.BOLD, 20));
        temail.setBackground(new Color(250,246,191));
        add(temail);

        JLabel aadhar=new JLabel("Aadhar:");
        aadhar.setBounds(450,400,150,30);
        aadhar.setFont(new Font("arial", Font.BOLD, 20));
        add(aadhar);

        JTextField taadhar=new JTextField();
        taadhar.setBounds(650,400,150,30);
        taadhar.setFont(new Font("arial", Font.BOLD, 20));
        taadhar.setBackground(new Color(250,246,191));
        add(taadhar);

        try
        {
            con=new Conn();
            ResultSet rs=con.st.executeQuery("SELECT * FROM Faculty WHERE id='"+fid+"'");

            while(rs.next())
            {
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tid.setText(""+rs.getInt("id"));
                tdob.setText(rs.getString("dob"));
                tX.setText(rs.getString("X"));
                tXII.setText(rs.getString("XII"));
                tCourse.setText(rs.getString("course"));
                tdepartment.setText(rs.getString("department"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
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
                String email=temail.getText();
                String aadhar=taadhar.getText();
                try
                {
                    con.st.executeUpdate("UPDATE Faculty SET address='"+address+"', phone='"+phone+"', email='"+email+"', aadhar='"+aadhar+"' WHERE id='"+fid+"'");
                    JOptionPane.showMessageDialog(null, "Details Saved Successfully");
                    new ViewFaculty();
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
                new ViewFaculty();
                setVisible(false);
            }
        });



        setSize(900,700);
        setVisible(true);
        setLocationRelativeTo(null);

    }
    public static void main(String[] args) {
        new UpdateFaculty(" ");
    }
}
