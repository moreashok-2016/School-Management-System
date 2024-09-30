package University.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame
{
    Main()
    {
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/main.gif"));
        Image i2=i1.getImage().getScaledInstance(1400,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,1440,800);
        add(img);

        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);

       //new Information
        JMenu newInfo=new JMenu("New Information");
        newInfo.setForeground(Color.BLACK);
        mb.add(newInfo);

        JMenuItem facultyInfo=new JMenuItem("New Faculty Information");
        facultyInfo.setForeground(Color.BLACK);
        newInfo.add(facultyInfo);
        facultyInfo.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AddFaculty();
                setVisible(false);
            }
        });

        JMenuItem studentInfo=new JMenuItem("New Student Information");
        studentInfo.setForeground(Color.BLACK);
        newInfo.add(studentInfo);
        studentInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               new AddStudent();
                setVisible(false);

            }
        });


        //Details

        JMenu details=new JMenu("View Details");
        details.setForeground(Color.BLACK);
        mb.add(details);

        JMenuItem facultyDetails=new JMenuItem("View Faculty Details");
        facultyDetails.setForeground(Color.BLACK);
        details.add(facultyDetails);
        facultyDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewFaculty();
                setVisible(false);
            }
        });

        JMenuItem studentDetails=new JMenuItem("View student Details");
        studentDetails.setForeground(Color.BLACK);
        details.add(studentDetails);
        studentDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewStudent();
                setVisible(false);
            }
        });

       //Leave

        JMenu leave=new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        mb.add(leave);

        JMenuItem fleave=new JMenuItem("Faculty Leave");
        fleave.setForeground(Color.BLACK);
        leave.add(fleave);
        fleave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FacultyLeave();
                setVisible(false);
            }
        });

        JMenuItem sleave=new JMenuItem("student Leave");
        sleave.setForeground(Color.BLACK);
        leave.add(sleave);
        sleave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentLeave();
                setVisible(false);
            }
        });

        //Leave Details

        JMenu lDetails=new JMenu("Leave Details");
        lDetails.setForeground(Color.BLACK);
        mb.add(lDetails);

        JMenuItem fld=new JMenuItem("Faculty Leave Details");
        fld.setForeground(Color.BLACK);
        lDetails.add(fld);
        fld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewFacultyLeave();
                setVisible(false);
            }
        });

        JMenuItem sld=new JMenuItem("student Leave Details");
        sld.setForeground(Color.BLACK);
        lDetails.add(sld);
        sld.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewStudentLeave();
                setVisible(false);
            }
        });

        //Exam

        JMenu exam=new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        mb.add(exam);


        JMenuItem edetails=new JMenuItem("Examination Result");
        edetails.setForeground(Color.BLACK);
        exam.add(edetails);
        edetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExaminationDetails();
                setVisible(false);
            }
        });

        JMenuItem entermarks=new JMenuItem("Enter Marks");
        entermarks.setForeground(Color.BLACK);
        exam.add(entermarks);
        entermarks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EnterMarks();
            }
        });


        //Fees

        JMenu fees=new JMenu("Fee Details");
        fees.setForeground(Color.BLACK);
        mb.add(fees);

        JMenuItem feestru=new JMenuItem("Fee Structure");
        feestru.setForeground(Color.BLACK);
        fees.add(feestru);
        feestru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FeesStructure();
            }
        });

        JMenuItem feeForm=new JMenuItem("Student Fee Form");
        feeForm.setForeground(Color.BLACK);
        fees.add(feeForm);
        feeForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new StudentFeesForm();
            }
        });


        //Utility

        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        mb.add(utility);

        JMenuItem ca=new JMenuItem("Calculator");
        ca.setForeground(Color.BLACK);
        utility.add(ca);
        ca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Runtime.getRuntime().exec("calc.exe");

                }catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JMenuItem nt=new JMenuItem("NotePad");
        nt.setForeground(Color.BLACK);
        utility.add(nt);
        nt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                     Runtime.getRuntime().exec("notepad.exe");
                }catch (Exception e2)
                {
                    e2.printStackTrace();
                }
            }
        });

        //About

        JMenu about=new JMenu("About");
        about.setForeground(Color.BLACK);
        mb.add(about);


       JMenuItem ab =new JMenuItem("about");
        ab.setForeground(Color.BLACK);
        about.add(ab);
        ab.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new About();
            }
        });

        //Exit

        JMenu exit=new JMenu("Exit");
        exit.setForeground(Color.BLACK);
        mb.add(exit);

        JMenuItem ex =new JMenuItem("exit");
        ex.setForeground(Color.BLACK);
        exit.add(ex);
        ex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        setSize(1540,850);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public static void main(String args[])
    {
        new Main();
    }
}
