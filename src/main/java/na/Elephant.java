package na;

public class Elephant extends Animal {
    private Double trunkLength;
    public Elephant(String name, int age, Double trunkLength) {
        super(name, age);
        this.trunkLength = trunkLength;
    }

    public String Elephant(Double trunkLength) {
        return("Độ dài vòi: " + trunkLength);
    }
    public void showInfo() {

    }
    public void makeSound() {
        System.out.println("eeeeeeee");
    }
    public void move(){

    }
}
