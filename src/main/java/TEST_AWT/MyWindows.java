package TEST_AWT;

import javax.swing.*;
import java.awt.*;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class MyWindows extends JFrame {

    private JTextField display;
    private ScriptEngine engine;

    public MyWindows() {
        setTitle("Calculator Full Expression");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Script Engine để tính biểu thức
        engine = new ScriptEngineManager().getEngineByName("JavaScript");

        // Display
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 28));
        add(display, BorderLayout.NORTH);

        // Panel nút
        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));

        // Các nút số
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "(", ")", "C"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 22));

            btn.addActionListener(e -> {
                String val = btn.getText();

                if (val.equals("=")) {
                    try {
                        String expr = display.getText();
                        Object result = engine.eval(expr); // TÍNH TOÁN CẢ CHUỖI !!!
                        display.setText(result.toString());
                    } catch (Exception ex) {
                        display.setText("Error");
                    }
                    return;
                }

                if (val.equals("C")) {
                    display.setText("");
                    return;
                }

                // Thêm ký tự vào biểu thức
                display.setText(display.getText() + val);
            });

            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyWindows().setVisible(true));
    }
}
