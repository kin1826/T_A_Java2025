package StudentManager;

public class Students {
    private String name;
    private int ID;
    private int age;
    private String major;
    private int GPA;

    public Students(String name, int id, int age, String major, int GPA) {
        this.name = name;
        this.ID = id;
        this.age = age;
        this.major = major;
        this.GPA = GPA;
    }

    public Students() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGPA() {
        return GPA;
    }

    public void setGPA(int GPA) {
        this.GPA = GPA;
    }

    public void display() {
        System.out.println("Name: " + name + "\n" + "ID: " + ID + "\n" + "Age: " + age + "\n" + "Major: " + major + "\n" + "GPA" + GPA +"\n");
    }
}
