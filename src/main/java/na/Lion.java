package na;

public class Lion extends Animal {
    private Double manelength;
    public Lion(String name, int age, Double manelength ) {
        super(name,age);
        this.manelength = manelength;
    }
    public String Lion(Double manelength) {
        return("Độ dài bờm: " + manelength);
    }
    public void showInfo() {

    }
    public void makeSound() {
        System.out.println("gr gr gr");
    }
    public void move() {

    }
}
