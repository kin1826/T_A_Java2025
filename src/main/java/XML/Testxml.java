package XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;

public class Testxml {
    static Student student;
    static String content;
    static ArrayList<Student> students = new  ArrayList<>();

    public static void main(String[] args) {
        try {
            // Cấu trúc cần có
            // Tạo đối tượng File trỏ đến file XML cần đọc
            File file = new File("E:\\T_A\\Example_Code\\src\\main\\java\\students.xml");

            // Tạo factory để tạo SAXParser
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // Tạo parser dùng để phân tích file XML
            SAXParser saxParser = factory.newSAXParser();

            // Tạo handler để xử lý các sự kiện khi đọc XML
            DefaultHandler handler = new DefaultHandler() {
                // Hàm này được gọi khi parser gặp thẻ mở
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equals("student")) {
                        student = new Student();
                        student.setId(attributes.getValue("id"));
                    }
                }

                // Hàm này được gọi khi parser đọc được nội dung nằm giữa 2 thẻ
                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {

                    content = new String(ch, start, length);
                }

                // Hàm này được gọi khi parser gặp thẻ đóng
                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {

                    // Nếu gặp thẻ đóng </student> thì in dòng phân cách
                    switch (qName) {
                        case "student":
                            students.add(student);
                            break;
                        case "name":
                            student.setName(content);
                            break;
                        case "age":
                            student.setAge(content);
                    }
                }
            };

            // Bắt đầu đọc file XML và xử lý bằng handler
            saxParser.parse(file, handler);

            for (Student s : students) {
                s.display();
            }

        } catch (Exception e) {
            // Nếu có lỗi thì in thông báo lỗi
            e.printStackTrace();
        }
    }
}