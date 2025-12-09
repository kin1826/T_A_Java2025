package dao;

import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
    Connect_DB con = new Connect_DB();

    public ArrayList<Student> getStudent() {
        ArrayList<Student> students = new ArrayList<>();

        String query = "SELECT * FROM student";

        ResultSet rs = con.getDB(query);
        try {
            while (rs.next()) {
                Student student = new Student();

                student.setId(rs.getInt("ID_Std"));
                student.setName(rs.getString("Name_std"));
                student.setAge(rs.getInt("Age"));
                student.setCode_std(rs.getString("Code_std"));
                student.setDepartment(rs.getString("Department"));
                student.setClass_std(rs.getString("Class"));

                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public boolean addStudent(Student student) {
        int result = 0;

        String query = "INSERT INTO student (Name_std, Age, Code_std, Department, Class) VALUES ('"
                + student.getName() + "',"
                + student.getAge() + ",'"
                + student.getCode_std() + "','"
                + student.getDepartment() + "','"
                + student.getClass_std() + "')";

        try {
            result = con.executeDB(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result > 0;
    }

    public boolean updateStudent(Student student) {
        int result = 0;

        String query = "UPDATE student SET Name_std = '"
                + student.getName()
                + "', Age = " + student.getAge()
                + ", Code_std = '" + student.getCode_std()
                + "', Department = '" + student.getDepartment()
                + "', Class = '" + student.getClass_std()
                + "' WHERE ID_Std = " + student.getId();

        try {
            result = con.executeDB(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result > 0;
    }

    public Student getStudentById(int id) {
        String query = "SELECT * FROM student WHERE ID_Std = " + id;
        ResultSet rs = con.getDB(query);

        try {
            if (rs.next()) {
                Student student = new Student();

                student.setId(rs.getInt("ID_Std"));
                student.setName(rs.getString("Name_std"));
                student.setAge(rs.getInt("Age"));
                student.setCode_std(rs.getString("Code_std"));
                student.setDepartment(rs.getString("Department"));
                student.setClass_std(rs.getString("Class"));
                return student;
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean deleteStudentById(int id) {
        int result = 0;
        String query = "DELETE FROM student WHERE ID_Std = " + id;

        try {
            result = con.executeDB(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result > 0;
    }
}
