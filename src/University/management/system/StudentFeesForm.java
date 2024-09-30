package University.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeesForm extends JFrame
{
    Conn c;
    JComboBox tquota,tstd;
     StudentFeesForm()
     {
         setLayout(null);
         getContentPane().setBackground(new Color(210,252,251));

         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/fee.png"));
         Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel img=new JLabel(i3);
         img.setBounds(400,50,500,300);
         add(img);

         JLabel rollno=new JLabel("Select RollNO:");
         rollno.setBounds(40,60,150,20);
         rollno.setFont(new Font("Tahoma",Font.BOLD,16));
         add(rollno);

         Choice ch=new Choice();
         ch.setBounds(200,60,150,20);
         add(ch);

         try
         {
             c=new Conn();
             ResultSet rs=c.st.executeQuery("Select * from Student");
             while(rs.next())
             {
                 ch.add(""+rs.getInt("rollno"));
             }
         }catch (Exception e){e.printStackTrace();}

         JLabel name=new JLabel("Name:");
         name.setBounds(40,100,50,20);
         add(name);

         JLabel tname=new JLabel();
         tname.setBounds(200,100,150,20);
         tname.setForeground(Color.red);
         add(tname);

         JLabel fname=new JLabel("Father Name:");
         fname.setBounds(40,140,100,20);
         add(fname);

         JLabel tfname=new JLabel();
         tfname.setBounds(200,140,150,20);
         tfname.setForeground(Color.red);
         add(tfname);
         JLabel quota=new JLabel("Quota:");
         quota.setBounds(40,180,150,20);
         quota.setForeground(Color.BLACK);
         add(quota);

         JLabel tquota=new JLabel();
         tquota.setBounds(200,180,150,20);
         tquota.setForeground(Color.red);
         add(tquota);

         JLabel std=new JLabel("Standerd:");
         std.setBounds(40,220,150,20);
         std.setForeground(Color.BLACK);
         add(std);

         JLabel tstd=new JLabel();
         tstd.setBounds(200,220,150,20);
         tstd.setForeground(Color.red);
         add(tstd);


         try
         {
             ResultSet rs=c.st.executeQuery("Select * from student where rollno='"+ch.getSelectedItem()+"'");
             while(rs.next())
             {
                 tname.setText(rs.getString("name"));
                 tfname.setText(rs.getString("fname"));
                 tquota.setText(rs.getString("quota"));
                 tstd.setText(rs.getString("std"));
             }
         }catch (Exception e1){e1.printStackTrace();}
         ch.addItemListener(new ItemListener() {
             @Override
             public void itemStateChanged(ItemEvent e) {
                 try
                 {
                     ResultSet rs=c.st.executeQuery("Select * from student where rollno='"+ch.getSelectedItem()+"'");
                     while(rs.next())
                     {
                         tname.setText(rs.getString("name"));
                         tfname.setText(rs.getString("fname"));
                         tquota.setText(rs.getString("quota"));
                         tstd.setText(rs.getString("std"));
                     }
                 }catch (Exception e1){e1.printStackTrace();}
             }
         });


         JLabel total=new JLabel("Total Payable");
         total.setBounds(40,270,150,20);
         add(total);

         JLabel totalamount=new JLabel();
         totalamount.setBounds(200,270,150,20);
         add(totalamount);

         JButton update=new JButton("Update");
          update.setBounds(30,380,100,25);
         add(update);
         update.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String quota=(String)tquota.getText();
                 String std=(String)tstd.getText();
                 try
                 {
                     ResultSet rs=c.st.executeQuery("select * from fees where quota='"+quota+"'");
                    while(rs.next())
                     {
                          totalamount.setText(rs.getString(std));
                     }
                 }catch (Exception e3){e3.printStackTrace();}
             }
         });

         JButton pay=new JButton("Pay");
         pay.setBounds(150,380,100,25);
         add(pay);
         pay.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {

                 String roll_no=ch.getSelectedItem();
                 String quota=tquota.getText();
                 String std1=tstd.getText();
                 String total=totalamount.getText();

                 try
                 {
                     c.st.executeUpdate("insert into payfees values('"+Integer.parseInt(roll_no)+"','"+quota+"','"+std1+"','"+total+"')");
                     JOptionPane.showMessageDialog(null, "Fees Submited Successfully");
                 }catch (Exception e1)
                 {

                 }
             }
         });

         JButton back=new JButton("Back");
         back.setBounds(270,380,100,25);
         add(back);
         back.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                   new Main();
                   setVisible(false);
             }
         });

         setSize(900,500);
         setLocationRelativeTo(null);
         setVisible(true);
     }

    public static void main(String[] args) {
        new StudentFeesForm();
    }
}
