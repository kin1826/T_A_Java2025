package Array;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        //tạo một ArrayList chứa các Book
        ArrayList<Book> books_list = new ArrayList<>();

        //tạo 2 Book và thêm vào ArrayList
        Book book1 = new Book("Java Programming", 100);
        //Thêm book1 vào ArrayList
        books_list.add(book1);

        Book book2 = new Book("C Programming", 200);
        books_list.add(book2);

        book2.setName("b");

        //Hiển thị tất cả các Book trong ArrayList
        int price = 0;
        int quantity = 2;
        for (Book book : books_list) {
            if (book.getName().equalsIgnoreCase("Java Programming")) {
                price = book.getPrice() * quantity;
            }
        }
        System.out.println("Total price: " + price);
    }

}
