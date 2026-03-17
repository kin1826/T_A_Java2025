package na;

abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void makeSound();
    abstract void move();
}
