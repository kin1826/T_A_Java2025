package gui;

import dao.*;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class StudentManager extends JFrame {
    JLabel lbTitle = new JLabel("Student Manager");
    JTable tbStudent = new JTable();
    DefaultTableModel model;

    JButton btnReload = new  JButton("Reload");
    JButton btnNewStudent = new JButton("New Student");
    JButton btnUpdateStudent = new JButton("Update Student");
    JButton btnDeleteStudent = new JButton("Delete Student");

    ArrayList<Student> students = new ArrayList<Student>();
    StudentDAO dao = new StudentDAO();

    public StudentManager() {
        setTitle("Student Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 400);
        setLayout(new BorderLayout(5, 5));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(btnReload);
        topPanel.add(lbTitle);
        topPanel.add(btnNewStudent);
        topPanel.add(btnUpdateStudent);
        topPanel.add(btnDeleteStudent);

        String[] column = {"ID", "Name", "Age", "Code", "Department", "Class"};
        model = new DefaultTableModel(column, 0);
        tbStudent.setModel(model);
        tbStudent.setFillsViewportHeight(true);

        showStudent();

        btnReload.addActionListener(e -> {
            showStudent();
        });
        btnNewStudent.addActionListener(e -> {
            new StudentForm().setVisible(true);
        });
        btnUpdateStudent.addActionListener(e -> {
            //Lấy số của hàng
            int row = tbStudent.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please Select Student");
                return;
            }

            Student std = dao.getStudentById(Integer.parseInt(tbStudent.getValueAt(row, 0).toString()));

            new StudentForm(std).setVisible(true);
        });
        btnDeleteStudent.addActionListener(e -> {
            //Lấy số của hàng
            int row = tbStudent.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please Select Student");
                return;
            }

            String idDelete = tbStudent.getValueAt(row, 0).toString();
            if (dao.deleteStudentById(Integer.parseInt(idDelete))) JOptionPane.showMessageDialog(this, "Student Deleted Successfully");
            else JOptionPane.showMessageDialog(this, "Student Deleted Failed");
        });

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(tbStudent), BorderLayout.CENTER);
    }

    private void showStudent() {
        //Lấy dữ liệu từ hàm getStudent trong DAO
        model.setRowCount(0);
        this.students = dao.getStudent();

        for (Student student : students) {
            model.addRow(new Object[]{
                    student.getId(),
                    student.getName(),
                    student.getAge(),
                    student.getCode_std(),
                    student.getDepartment(),
                    student.getClass_std()
            });
        }
    }

}
