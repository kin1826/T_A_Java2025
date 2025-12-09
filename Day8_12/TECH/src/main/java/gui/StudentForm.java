package gui;

import dao.StudentDAO;
import model.Student;

import javax.swing.*;
import java.awt.*;

public class StudentForm extends JFrame {
    JLabel lbAdd = new JLabel("Add Student");

    JLabel lbName = new JLabel("Student Name:");
    JLabel lbAge = new JLabel("Student Age:");
    JLabel lbCode = new JLabel("Student Code:");
    JLabel lbDepartment = new JLabel("Student Department:");
    JLabel lbClass = new JLabel("Student Class:");

    JTextField tbName = new JTextField();
    JTextField tbAge = new JTextField();
    JTextField tbCode = new JTextField();
    JTextField tbDepartment = new JTextField();
    JComboBox<String> cbDepartment;
    JTextField tbClass = new JTextField();

    JButton btnAddStudent = new JButton("Add Student");

    StudentDAO stdDao = new StudentDAO();

    public StudentForm() {
        setTitle("Add Student");
        init();

        btnAddStudent.addActionListener(e -> {
            Student student = new Student(
                    0,
                    tbName.getText(),
                    Integer.parseInt(tbAge.getText()),
                    tbCode.getText(),
                    tbDepartment.getText(),
                    tbClass.getText()
            );

            if (stdDao.addStudent(student)) {
                JOptionPane.showMessageDialog(this, "Student Added Successfully");
            } else JOptionPane.showMessageDialog(this, "Student Added Failed");
        });
    }

    public StudentForm(Student student) {
        setTitle("Edit Student");
        init();

        btnAddStudent.setText("Edit Student");

        //Set sẵn giá trị của student muốn sửa
        tbName.setText(student.getName());
        tbAge.setText(String.valueOf(student.getAge()));
        tbCode.setText(student.getCode_std());
        tbDepartment.setText(student.getDepartment());
        tbClass.setText(student.getClass_std());

        btnAddStudent.addActionListener(e -> {
            Student studentEdit = new Student(
                    student.getId(),
                    tbName.getText(),
                    Integer.parseInt(tbAge.getText()),
                    tbCode.getText(),
                    tbDepartment.getText(),
                    tbClass.getText()
            );

            if (stdDao.updateStudent(studentEdit)) {
                JOptionPane.showMessageDialog(this, "Student Updated Successfully");
            } else JOptionPane.showMessageDialog(this, "Student Updated Failed");
        });
    }

    public void init() {
        setSize(400, 300);
        setLocationRelativeTo(null);

        String[] comboString = {"Khoa học máy tính", "Kĩ thuật máy tính", "Kinh tế"};
        cbDepartment = new JComboBox<>(comboString);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        panel.add(lbName);        panel.add(tbName);
        panel.add(lbAge);         panel.add(tbAge);
        panel.add(lbCode);        panel.add(tbCode);
        panel.add(lbDepartment);  panel.add(tbDepartment);
        panel.add(lbClass);       panel.add(tbClass);

        panel.add(new JLabel());
        panel.add(btnAddStudent);

        add(panel);
    }

}
