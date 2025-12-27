package model;

public class Student {
    private int id;
    private String name;
    private int age;
    private String code_std;
    private String department;
    private String class_std;

    public Student() {}

    public Student(int id, String name, int age, String code_std, String department, String class_std) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.code_std = code_std;
        this.department = department;
        this.class_std = class_std;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCode_std() {
        return code_std;
    }

    public void setCode_std(String code_std) {
        this.code_std = code_std;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getClass_std() {
        return class_std;
    }

    public void setClass_std(String class_std) {
        this.class_std = class_std;
    }
}
