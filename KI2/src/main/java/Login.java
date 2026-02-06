import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Arrays;

public class Login extends JFrame {
    // Các thành phần UI
    private JPanel mainPanel, formPanel, headerPanel, footerPanel;
    private JLabel titleLabel, subtitleLabel, usernameLabel, passwordLabel,
            logoLabel, registerLabel, forgotPasswordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheck, rememberMeCheck;
    private JButton loginButton, cancelButton;
    private JProgressBar loadingBar;

    // Màu sắc
    private final Color PRIMARY_COLOR = new Color(41, 128, 185);
    private final Color SECONDARY_COLOR = new Color(52, 152, 219);
    private final Color BACKGROUND_COLOR = new Color(236, 240, 241);
    private final Color TEXT_COLOR = new Color(44, 62, 80);
    private final Color ERROR_COLOR = new Color(231, 76, 60);
    private final Color SUCCESS_COLOR = new Color(46, 204, 113);

    // Kết nối database
    private Connection connection;

    public Login() {
        initUI();
        setupDatabase();
        setupEventListeners();
    }

    private void initUI() {
        // Cài đặt cửa sổ chính
        setTitle("Hệ Thống Đăng Nhập");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setMinimumSize(new Dimension(800, 500));
        setLocationRelativeTo(null);

        // Tạo main panel với BorderLayout
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(BACKGROUND_COLOR);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Tạo header panel
        createHeaderPanel();

        // Tạo form panel
        createFormPanel();

        // Tạo footer panel
        createFooterPanel();

        // Thêm các panel vào main panel
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        // Thêm main panel vào frame
        add(mainPanel);

        // Hiển thị loading bar
        showLoading(false);
    }

    private void createHeaderPanel() {
        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                new EmptyBorder(20, 30, 20, 30)
        ));

        // Logo và tiêu đề bên trái
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        leftPanel.setBackground(Color.WHITE);

        // Logo (có thể thay bằng hình ảnh thực tế)
        logoLabel = new JLabel("🔐");
        logoLabel.setFont(new Font("Segoe UI", Font.BOLD, 36));

        // Tiêu đề
        JPanel titlePanel = new JPanel(new GridLayout(2, 1));
        titlePanel.setBackground(Color.WHITE);

        titleLabel = new JLabel("HỆ THỐNG ĐĂNG NHẬP");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(PRIMARY_COLOR);

        subtitleLabel = new JLabel("An toàn - Bảo mật - Hiệu quả");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setForeground(new Color(100, 100, 100));

        titlePanel.add(titleLabel);
        titlePanel.add(subtitleLabel);

        leftPanel.add(logoLabel);
        leftPanel.add(Box.createHorizontalStrut(20));
        leftPanel.add(titlePanel);

        // Thông tin phiên bản bên phải
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        rightPanel.setBackground(Color.WHITE);

        JLabel versionLabel = new JLabel("Phiên bản 2.0.1");
        versionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        versionLabel.setForeground(new Color(150, 150, 150));

        rightPanel.add(versionLabel);

        headerPanel.add(leftPanel, BorderLayout.WEST);
        headerPanel.add(rightPanel, BorderLayout.EAST);
    }

    private void createFormPanel() {
        formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(BACKGROUND_COLOR);
        formPanel.setBorder(new EmptyBorder(40, 100, 40, 100));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Panel chứa form đăng nhập
        JPanel loginCard = new JPanel(new GridBagLayout());
        loginCard.setBackground(Color.WHITE);
        loginCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                new EmptyBorder(40, 40, 40, 40)
        ));

        GridBagConstraints cardGbc = new GridBagConstraints();
        cardGbc.insets = new Insets(15, 10, 15, 10);
        cardGbc.fill = GridBagConstraints.HORIZONTAL;

        // Tiêu đề form
        JLabel formTitle = new JLabel("ĐĂNG NHẬP HỆ THỐNG", SwingConstants.CENTER);
        formTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        formTitle.setForeground(TEXT_COLOR);
        cardGbc.gridx = 0;
        cardGbc.gridy = 0;
        cardGbc.gridwidth = 2;
        loginCard.add(formTitle, cardGbc);

        // Phân cách
        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(200, 200, 200));
        cardGbc.gridy = 1;
        cardGbc.insets = new Insets(20, 0, 30, 0);
        loginCard.add(separator, cardGbc);

        // Tên đăng nhập
        usernameLabel = new JLabel("Tên đăng nhập:");
        usernameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cardGbc.gridx = 0;
        cardGbc.gridy = 2;
        cardGbc.gridwidth = 1;
        cardGbc.insets = new Insets(5, 0, 5, 10);
        loginCard.add(usernameLabel, cardGbc);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameField.setPreferredSize(new Dimension(250, 35));
        cardGbc.gridx = 1;
        cardGbc.gridy = 2;
        loginCard.add(usernameField, cardGbc);

        // Mật khẩu
        passwordLabel = new JLabel("Mật khẩu:");
        passwordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cardGbc.gridx = 0;
        cardGbc.gridy = 3;
        loginCard.add(passwordLabel, cardGbc);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setPreferredSize(new Dimension(250, 35));
        cardGbc.gridx = 1;
        cardGbc.gridy = 3;
        loginCard.add(passwordField, cardGbc);

        // Panel cho các checkbox
        JPanel checkboxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        checkboxPanel.setBackground(Color.WHITE);

        showPasswordCheck = new JCheckBox("Hiển thị mật khẩu");
        showPasswordCheck.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        showPasswordCheck.setBackground(Color.WHITE);

        rememberMeCheck = new JCheckBox("Ghi nhớ đăng nhập");
        rememberMeCheck.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        rememberMeCheck.setBackground(Color.WHITE);
        rememberMeCheck.setSelected(true);

        checkboxPanel.add(showPasswordCheck);
        checkboxPanel.add(rememberMeCheck);

        cardGbc.gridx = 0;
        cardGbc.gridy = 4;
        cardGbc.gridwidth = 2;
        cardGbc.insets = new Insets(10, 0, 20, 0);
        loginCard.add(checkboxPanel, cardGbc);

        // Panel cho các nút
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonPanel.setBackground(Color.WHITE);

        loginButton = new JButton("ĐĂNG NHẬP");
        styleButton(loginButton, PRIMARY_COLOR, Color.WHITE);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setPreferredSize(new Dimension(120, 40));

        cancelButton = new JButton("HỦY BỎ");
        styleButton(cancelButton, new Color(149, 165, 166), Color.WHITE);
        cancelButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cancelButton.setPreferredSize(new Dimension(120, 40));

        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);

        cardGbc.gridx = 0;
        cardGbc.gridy = 5;
        cardGbc.gridwidth = 2;
        loginCard.add(buttonPanel, cardGbc);

        // Loading bar (ẩn ban đầu)
        loadingBar = new JProgressBar();
        loadingBar.setIndeterminate(true);
        loadingBar.setVisible(false);
        loadingBar.setPreferredSize(new Dimension(300, 5));
        cardGbc.gridy = 6;
        cardGbc.insets = new Insets(20, 0, 0, 0);
        loginCard.add(loadingBar, cardGbc);

        // Quên mật khẩu và đăng ký
        JPanel linkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        linkPanel.setBackground(Color.WHITE);

        forgotPasswordLabel = new JLabel("<html><u>Quên mật khẩu?</u></html>");
        forgotPasswordLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        forgotPasswordLabel.setForeground(SECONDARY_COLOR);
        forgotPasswordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        registerLabel = new JLabel("<html><u>Chưa có tài khoản? Đăng ký ngay</u></html>");
        registerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        registerLabel.setForeground(SECONDARY_COLOR);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        linkPanel.add(forgotPasswordLabel);
        linkPanel.add(registerLabel);

        cardGbc.gridy = 7;
        cardGbc.insets = new Insets(25, 0, 0, 0);
        loginCard.add(linkPanel, cardGbc);

        // Thêm card vào form panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(loginCard, gbc);
    }

    private void createFooterPanel() {
        footerPanel = new JPanel(new BorderLayout());
        footerPanel.setBackground(Color.WHITE);
        footerPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(200, 200, 200)),
                new EmptyBorder(15, 30, 15, 30)
        ));

        // Thông tin bản quyền bên trái
        JLabel copyrightLabel = new JLabel("© 2023 Hệ Thống Đăng Nhập. Bảo lưu mọi quyền.");
        copyrightLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        copyrightLabel.setForeground(new Color(100, 100, 100));

        // Thông tin hỗ trợ bên phải
        JLabel supportLabel = new JLabel("Hỗ trợ: 1800-1234 | Email: support@system.com");
        supportLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        supportLabel.setForeground(new Color(100, 100, 100));

        footerPanel.add(copyrightLabel, BorderLayout.WEST);
        footerPanel.add(supportLabel, BorderLayout.EAST);
    }

    private void styleButton(JButton button, Color bgColor, Color textColor) {
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Hiệu ứng hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(bgColor.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });
    }

    private void setupDatabase() {
        try {
            // Sử dụng SQLite cho đơn giản
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:login_system.db");
            createTables();
            insertSampleData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Không thể kết nối cơ sở dữ liệu: " + e.getMessage(),
                    "Lỗi kết nối",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void createTables() {
        String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT UNIQUE NOT NULL," +
                "password TEXT NOT NULL," +
                "full_name TEXT NOT NULL," +
                "email TEXT," +
                "phone TEXT," +
                "role TEXT DEFAULT 'user'," +
                "created_at DATETIME DEFAULT CURRENT_TIMESTAMP," +
                "last_login DATETIME," +
                "is_active BOOLEAN DEFAULT 1" +
                ")";

        String createLoginHistoryTable = "CREATE TABLE IF NOT EXISTS login_history (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "user_id INTEGER," +
                "login_time DATETIME DEFAULT CURRENT_TIMESTAMP," +
                "ip_address TEXT," +
                "success BOOLEAN," +
                "FOREIGN KEY (user_id) REFERENCES users(id)" +
                ")";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createUsersTable);
            stmt.execute(createLoginHistoryTable);
        } catch (SQLException e) {
            System.err.println("Lỗi tạo bảng: " + e.getMessage());
        }
    }

    private void insertSampleData() {
        // Kiểm tra xem đã có dữ liệu mẫu chưa
        String checkQuery = "SELECT COUNT(*) FROM users WHERE username IN ('admin', 'user1', 'user2')";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(checkQuery)) {

            if (rs.next() && rs.getInt(1) == 0) {
                // Thêm dữ liệu mẫu
                String insertData = "INSERT INTO users (username, password, full_name, email, phone, role) VALUES " +
                        "('admin', 'admin123', 'Quản Trị Viên', 'admin@system.com', '0987654321', 'admin'), " +
                        "('user1', 'user123', 'Người Dùng 1', 'user1@system.com', '0912345678', 'user'), " +
                        "('user2', 'user123', 'Người Dùng 2', 'user2@system.com', '0923456789', 'user')";

                stmt.executeUpdate(insertData);
                System.out.println("Đã thêm dữ liệu mẫu vào database.");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi thêm dữ liệu mẫu: " + e.getMessage());
        }
    }

    private void setupEventListeners() {
        // Sự kiện hiển thị mật khẩu
        showPasswordCheck.addActionListener(e -> {
            if (showPasswordCheck.isSelected()) {
                passwordField.setEchoChar((char) 0); // Hiển thị mật khẩu
            } else {
                passwordField.setEchoChar('•'); // Ẩn mật khẩu
            }
        });

        // Sự kiện đăng nhập
        loginButton.addActionListener(e -> performLogin());

        // Sự kiện hủy bỏ
        cancelButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
            usernameField.requestFocus();
        });

        // Sự kiện quên mật khẩu
        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showForgotPasswordDialog();
            }
        });

        // Sự kiện đăng ký
        registerLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showRegistrationDialog();
            }
        });

        // Sự kiện phím Enter để đăng nhập
        usernameField.addActionListener(e -> passwordField.requestFocus());
        passwordField.addActionListener(e -> performLogin());

        // Sự kiện đóng cửa sổ
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeDatabaseConnection();
            }
        });
    }

    private void performLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        // Kiểm tra dữ liệu nhập
        if (username.isEmpty() || password.isEmpty()) {
            showError("Vui lòng nhập đầy đủ tên đăng nhập và mật khẩu!");
            return;
        }

        // Hiển thị loading
        showLoading(true);

        // Mô phỏng delay (trong thực tế sẽ là kết nối mạng/database)
        Timer timer = new Timer(1500, e -> {
            try {
                authenticateUser(username, password);
            } finally {
                showLoading(false);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void authenticateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND is_active = 1";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");

                if (storedPassword.equals(password)) {
                    // Cập nhật thời gian đăng nhập cuối
                    updateLastLogin(rs.getInt("id"));

                    // Ghi log đăng nhập thành công
                    logLoginAttempt(rs.getInt("id"), true);

                    // Hiển thị thông báo thành công
                    showSuccess("Đăng nhập thành công! Chào mừng " + rs.getString("full_name"));

                    // Mở giao diện chính (mô phỏng)
                    openMainApplication(rs);
                } else {
                    // Ghi log đăng nhập thất bại
                    logLoginAttempt(getUserIdByUsername(username), false);

                    showError("Mật khẩu không chính xác!");
                    passwordField.setText("");
                    passwordField.requestFocus();
                }
            } else {
                showError("Tên đăng nhập không tồn tại!");
                usernameField.requestFocus();
            }
        } catch (SQLException ex) {
            showError("Lỗi kết nối cơ sở dữ liệu: " + ex.getMessage());
        }
    }

    private int getUserIdByUsername(String username) {
        String query = "SELECT id FROM users WHERE username = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            // Không xử lý lỗi ở đây
        }

        return -1;
    }

    private void updateLastLogin(int userId) {
        String query = "UPDATE users SET last_login = CURRENT_TIMESTAMP WHERE id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Lỗi cập nhật last_login: " + e.getMessage());
        }
    }

    private void logLoginAttempt(int userId, boolean success) {
        String query = "INSERT INTO login_history (user_id, success, ip_address) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, userId);
            pstmt.setBoolean(2, success);
            pstmt.setString(3, "127.0.0.1"); // IP mô phỏng
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Lỗi ghi log đăng nhập: " + e.getMessage());
        }
    }

    private void openMainApplication(ResultSet userData) {
        try {
            String fullName = userData.getString("full_name");
            String role = userData.getString("role");

            // Tạo giao diện chính mô phỏng
            JFrame mainFrame = new JFrame("Hệ Thống Chính - " + fullName);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(1000, 700);
            mainFrame.setLocationRelativeTo(null);

            JPanel mainPanel = new JPanel(new BorderLayout());
            mainPanel.setBackground(new Color(245, 245, 245));

            // Header
            JPanel headerPanel = new JPanel(new BorderLayout());
            headerPanel.setBackground(PRIMARY_COLOR);
            headerPanel.setBorder(new EmptyBorder(15, 20, 15, 20));

            JLabel welcomeLabel = new JLabel("Xin chào, " + fullName + " (" + role.toUpperCase() + ")");
            welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
            welcomeLabel.setForeground(Color.WHITE);

            JButton logoutButton = new JButton("ĐĂNG XUẤT");
            styleButton(logoutButton, Color.WHITE, PRIMARY_COLOR);
            logoutButton.addActionListener(e -> {
                mainFrame.dispose();
                setVisible(true);
            });

            headerPanel.add(welcomeLabel, BorderLayout.WEST);
            headerPanel.add(logoutButton, BorderLayout.EAST);

            // Nội dung chính
            JPanel contentPanel = new JPanel(new GridBagLayout());
            contentPanel.setBackground(new Color(245, 245, 245));

            JLabel contentLabel = new JLabel("CHÀO MỪNG ĐẾN VỚI HỆ THỐNG");
            contentLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
            contentLabel.setForeground(TEXT_COLOR);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            contentPanel.add(contentLabel, gbc);

            // Thông tin người dùng
            JPanel infoPanel = new JPanel(new GridLayout(5, 1, 10, 10));
            infoPanel.setBackground(Color.WHITE);
            infoPanel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(200, 200, 200)),
                    new EmptyBorder(20, 30, 20, 30)
            ));

            infoPanel.add(createInfoLabel("Họ tên: " + fullName));
            infoPanel.add(createInfoLabel("Tên đăng nhập: " + userData.getString("username")));
            infoPanel.add(createInfoLabel("Email: " + userData.getString("email")));
            infoPanel.add(createInfoLabel("Số điện thoại: " + userData.getString("phone")));
            infoPanel.add(createInfoLabel("Vai trò: " + role));

            gbc.gridy = 1;
            gbc.insets = new Insets(30, 0, 0, 0);
            contentPanel.add(infoPanel, gbc);

            // Thêm các panel vào main panel
            mainPanel.add(headerPanel, BorderLayout.NORTH);
            mainPanel.add(contentPanel, BorderLayout.CENTER);

            mainFrame.add(mainPanel);

            // Ẩn cửa sổ đăng nhập và hiển thị cửa sổ chính
            this.setVisible(false);
            mainFrame.setVisible(true);

        } catch (SQLException ex) {
            showError("Lỗi khi lấy thông tin người dùng: " + ex.getMessage());
        }
    }

    private JLabel createInfoLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setForeground(TEXT_COLOR);
        return label;
    }

    private void showForgotPasswordDialog() {
        JDialog dialog = new JDialog(this, "Quên mật khẩu", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("KHÔI PHỤC MẬT KHẨU", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(PRIMARY_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        JLabel instructionLabel = new JLabel("Vui lòng nhập email đã đăng ký để nhận mật khẩu mới:");
        instructionLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        gbc.gridy = 1;
        panel.add(instructionLabel, gbc);

        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(250, 35));
        gbc.gridy = 2;
        panel.add(emailField, gbc);

        JButton submitButton = new JButton("GỬI YÊU CẦU");
        styleButton(submitButton, PRIMARY_COLOR, Color.WHITE);
        submitButton.addActionListener(e -> {
            String email = emailField.getText().trim();
            if (isValidEmail(email)) {
                // Mô phỏng gửi email
                JOptionPane.showMessageDialog(dialog,
                        "Yêu cầu đã được gửi đến " + email + "\nVui lòng kiểm tra hộp thư để nhận mật khẩu mới.",
                        "Thành công",
                        JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog,
                        "Email không hợp lệ!",
                        "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        gbc.gridy = 3;
        panel.add(submitButton, gbc);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.setVisible(true);
    }

    private void showRegistrationDialog() {
        JDialog dialog = new JDialog(this, "Đăng ký tài khoản mới", true);
        dialog.setSize(500, 500);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("ĐĂNG KÝ TÀI KHOẢN MỚI", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(PRIMARY_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Các trường đăng ký
        String[] labels = {"Họ và tên:", "Tên đăng nhập:", "Email:", "Số điện thoại:", "Mật khẩu:", "Xác nhận mật khẩu:"};
        JTextField[] fields = new JTextField[labels.length];
        fields[4] = new JPasswordField(); // Mật khẩu
        fields[5] = new JPasswordField(); // Xác nhận mật khẩu

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            gbc.gridwidth = 1;
            panel.add(label, gbc);

            if (fields[i] == null) {
                fields[i] = new JTextField();
            }
            fields[i].setPreferredSize(new Dimension(250, 30));
            gbc.gridx = 1;
            panel.add(fields[i], gbc);
        }

        // Nút đăng ký
        JButton registerButton = new JButton("ĐĂNG KÝ");
        styleButton(registerButton, SUCCESS_COLOR, Color.WHITE);
        registerButton.addActionListener(e -> {
            if (validateRegistration(fields)) {
                // Mô phỏng đăng ký thành công
                JOptionPane.showMessageDialog(dialog,
                        "Đăng ký thành công!\nVui lòng đăng nhập với tài khoản mới.",
                        "Thành công",
                        JOptionPane.INFORMATION_MESSAGE);
                dialog.dispose();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = labels.length + 2;
        gbc.gridwidth = 2;
        panel.add(registerButton, gbc);

        dialog.add(panel, BorderLayout.CENTER);
        dialog.setVisible(true);
    }

    private boolean validateRegistration(JTextField[] fields) {
        // Kiểm tra các trường bắt buộc
        for (int i = 0; i < fields.length - 1; i++) { // Không kiểm tra xác nhận mật khẩu ở đây
            if (fields[i].getText().trim().isEmpty()) {
                showError("Vui lòng điền đầy đủ thông tin!");
                fields[i].requestFocus();
                return false;
            }
        }

        // Kiểm tra email
        String email = fields[2].getText().trim();
        if (!isValidEmail(email)) {
            showError("Email không hợp lệ!");
            fields[2].requestFocus();
            return false;
        }

        // Kiểm tra mật khẩu
        String password = fields[4].getText();
        String confirmPassword = fields[5].getText();

        if (!password.equals(confirmPassword)) {
            showError("Mật khẩu xác nhận không khớp!");
            fields[5].setText("");
            fields[5].requestFocus();
            return false;
        }

        if (password.length() < 6) {
            showError("Mật khẩu phải có ít nhất 6 ký tự!");
            fields[4].setText("");
            fields[5].setText("");
            fields[4].requestFocus();
            return false;
        }

        return true;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this,
                message,
                "Lỗi đăng nhập",
                JOptionPane.ERROR_MESSAGE);
    }

    private void showSuccess(String message) {
        JOptionPane.showMessageDialog(this,
                message,
                "Thành công",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showLoading(boolean show) {
        loadingBar.setVisible(show);
        loginButton.setEnabled(!show);
        cancelButton.setEnabled(!show);
    }

    private void closeDatabaseConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Đã đóng kết nối database.");
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Sử dụng look and feel của hệ thống
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Khởi chạy ứng dụng
        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });
    }
}