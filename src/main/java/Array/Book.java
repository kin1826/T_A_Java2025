package Array;

public class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("Name: " + name + "\n" + "Price: " + price + "\n");
    }

    public Book() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




    //Viết chương trình tạo ra 1 ArrayList
    // chứa các Học sinh có các tham số: Tên; tuổi;
    //lần lượt thực hiện các yêu cầu sau:
    //1. Thêm học sinh vào ArrayList
    //2. Hiển thị tất cả các học sinh trong ArrayList
    //3. Nhập Tên sinh viên muốn đổi, nhập tên đổi, đổi tên cho 1 sinh viên
    //4. Hiển thị lại
    //5. Xoá 1 sinh viên bằng cách nhập tên sinh viên muốn xoá
}
