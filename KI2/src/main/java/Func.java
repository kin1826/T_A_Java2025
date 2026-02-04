import javax.swing.*;
import java.io.*;

public class Func {
    public static void main(String[] args) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file = fileChooser.getSelectedFile();
            if (file == null) {
                System.out.println("Ko");
                return;
            }

            FileInputStream fileOutputStream = new FileInputStream(file);
            int ch;

            while ((ch = fileOutputStream.read()) !=  -1) {
                System.out.print((char) ch);
            }

            fileOutputStream.close();

//            FileOutputStream fileOutputStream1 = new FileOutputStream(file);
//            String dataText = "Chao cac ban.";
//
//            fileOutputStream1.write(dataText.getBytes());
//            fileOutputStream1.close();
//            System.out.println("Ghi file thanh cong");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
