package BOOK_AUTHOR;

public class a extends Author{
    public a(String name, String email, String gender) {
        super(name, email, gender);
    }

    public a() {}

    private String address;
    private String phone;
    private String website;

    public static void main(String[] args) {
        a a = new a();

        a.display();
    }
}
