package BOOK_AUTHOR;

public class Book {
    private String name;
    private Author author;
    private int price;
    private int qty = 0;

    public Book(String name, Author author, int price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public Book() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public static void main(String[] args) {
        Author author = new Author("John", "<EMAIL>", "Male");
        Book book = new Book("Java Programming", author, 100);
        System.out.println(book.getName());
        System.out.println(book.getAuthor().getName());
        System.out.println(book.getPrice());
        System.out.println(book.getAuthor().getEmail());
    }
}
