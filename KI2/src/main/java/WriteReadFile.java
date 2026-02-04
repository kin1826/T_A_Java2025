import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class WriteReadFile extends JFrame {

    private JTextArea textArea;
    private JButton btnOpen, btnSave;
    private JFileChooser fileChooser;
    private File currentFile;

    public WriteReadFile() {
        setTitle("Simple Text Editor");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Text Area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Buttons
        btnOpen = new JButton("Open");
        btnSave = new JButton("Save");

        JPanel panel = new JPanel();
        panel.add(btnOpen);
        panel.add(btnSave);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        fileChooser = new JFileChooser();

        // Sự kiện Open
        btnOpen.addActionListener(e -> openFile());

        // Sự kiện Save
        btnSave.addActionListener(e -> saveFile());
    }

    private void openFile() {
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();

            try (BufferedReader br = new BufferedReader(new FileReader(currentFile))) {
                textArea.setText("");
                String line;
                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi đọc file!");
            }
        }
    }

    private void saveFile() {
        if (currentFile == null) {
            JOptionPane.showMessageDialog(this, "Chưa mở file nào!");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(currentFile))) {
            bw.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "Lưu file thành công!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi lưu file!");
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new WriteReadFile().setVisible(true);
        });
    }
}
