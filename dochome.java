import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class dochome extends JFrame
{
    public dochome()
    {
        
        setTitle("Doctor's Homepage");
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(new Color(255,223,243));
        Font poppinsFont = new Font("Poppins", Font.BOLD, 20);
        Color darkPink = new Color(120, 0, 55);

        JPanel back=new JPanel();
        back.setBounds(0,0, 1920,1080);
        ImageIcon imageIcon = new ImageIcon("homeback.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        back.setLayout(null);
        back.add(imageLabel);
        back.setComponentZOrder(imageLabel, 0);

        // Creating JLabel for the logo
        JLabel logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon("logo.png");
        logoLabel.setIcon(logoIcon);
        int logoWidth = logoIcon.getIconWidth();
        int logoHeight = logoIcon.getIconHeight();
        logoLabel.setBounds(getWidth() - logoWidth - 50, 20, logoWidth, logoHeight);
        imageLabel.add(logoLabel);

        JLabel l1 = new JLabel("Enter Patient Details");
        l1.setBounds(700, 20, 400, 50);
        l1.setFont(poppinsFont);
        l1.setForeground(darkPink);
        imageLabel.add(l1);

        JLabel j1 = new JLabel("Name of the patient:");
        j1.setBounds(480, 80, 250, 50);
        j1.setFont(poppinsFont);
        j1.setForeground(darkPink);
        imageLabel.add(j1);

        JTextField Tf = new JTextField();
        Tf.setBounds(700, 90, 200, 30);
        imageLabel.add(Tf);

        JLabel j2 = new JLabel("Age:");
        j2.setBounds(645, 160, 200, 50);
        j2.setFont(poppinsFont);
        j2.setForeground(darkPink);
        imageLabel.add(j2);

        JTextField Tp = new JTextField();
        Tp.setBounds(700, 170, 200, 30);
        imageLabel.add(Tp);

        JLabel j3 = new JLabel("Blood Group:");
        j3.setBounds(560, 240, 200, 50);
        j3.setFont(poppinsFont);
        j3.setForeground(darkPink);
        imageLabel.add(j3);

        // Creating a dropdown list for blood groups
        String[] bloodGroups = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        JComboBox<String> bloodGroupComboBox = new JComboBox<>(bloodGroups);
        bloodGroupComboBox.setBounds(700, 250, 200, 30);
        imageLabel.add(bloodGroupComboBox);

        JLabel j4 = new JLabel("Detected Disease:");
        j4.setBounds(510, 320, 200, 50);
        j4.setFont(poppinsFont);
        j4.setForeground(darkPink);
        imageLabel.add(j4);

        JTextField Tr = new JTextField();
        Tr.setBounds(700, 330, 200, 30);
        imageLabel.add(Tr);

        JLabel j5 = new JLabel("Prescribed Medicines:");
        j5.setBounds(465, 400, 250, 50);
        j5.setFont(poppinsFont);
        j5.setForeground(darkPink);
        imageLabel.add(j5);

        JTextField Tq = new JTextField();
        Tq.setBounds(700, 410, 200, 30);
        imageLabel.add(Tq);

        JLabel j6 = new JLabel("Next visit Schedule:");
        j6.setBounds(490, 480, 200, 50);
        j6.setFont(poppinsFont);
        j6.setForeground(darkPink);
        imageLabel.add(j6);

        JTextField Ts = new JTextField();
        Ts.setBounds(700, 490, 200, 30);
        imageLabel.add(Ts);

        JButton insertButton = new JButton("Insert");
        insertButton.setBounds(720, 560, 150, 60);
        insertButton.setBackground(new Color(120, 0, 55));
        insertButton.setBorderPainted(false);
        insertButton.setFocusPainted(false);// Dark pink background color
        insertButton.setFont(new Font("Poppins", Font.PLAIN, 30)); // Poppins font, bold, size 14
        insertButton.setForeground(Color.WHITE);
        insertButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change color when mouse enters
                insertButton.setBackground(new Color(250, 81, 121)); // Change to desired hover color
                insertButton.setForeground(new Color(120, 0, 55));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color back when mouse exits
                insertButton.setBackground(new Color(120, 0, 55)); // Change to the original color
                insertButton.setForeground(Color.WHITE);
            }
        });
        imageLabel.add(insertButton);

        insertButton.addActionListener(e -> {
            String patientName = Tf.getText();
            int patientAge = Integer.parseInt(Tp.getText());
            String bloodGroup = (String) bloodGroupComboBox.getSelectedItem();
            String History = Tr.getText();
            String Contact = Tq.getText();
            String Time = Ts.getText();

            try
            {
                //Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital", "root", "@r18a1j10");
                String insertQuery = "INSERT INTO doctor (Name, Age, BloodGroup, Disease, Medicines, Visit) VALUES (?, ?, ?, ?, ?, ?)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery))
                {
                    preparedStatement.setString(1, patientName);
                    preparedStatement.setInt(2, patientAge);
                    preparedStatement.setString(3, bloodGroup);
                    preparedStatement.setString(4, History);
                    preparedStatement.setString(5, Contact);
                    preparedStatement.setString(6, Time);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0)
                    {
                        JOptionPane.showMessageDialog(null, "Patient data inserted successfully!");
                        // Additional handling after successful insertion (clear fields, update UI, etc.)
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Failed to insert patient data.");
                    }
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        });
        add(back);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) 
    {
        new dochome();
    }
}