import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPage extends JFrame 
{
    public LoginPage() 
    {
        setTitle("Login - Hospital Patient Record");
        setBounds(200, 30, 1200, 800);
        getContentPane().setBackground(new Color(230, 140, 140));
        Font poppinsFont = new Font("Sans Serif", Font.PLAIN, 20);
        Color darkPink = new Color(120, 0, 55);

        JPanel one=new JPanel();
        one.setBounds(0,0, 1200,800);
        one.setBackground(new Color(255, 203, 223));
        ImageIcon imageIcon = new ImageIcon("loginback.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        one.setLayout(null);
        one.add(imageLabel);

        JLabel top = new JLabel("STAFF LOGIN");
        top.setBounds(670, 280, 300, 30);
        top.setFont(new Font("Sans Serif", Font.BOLD, 30));
        top.setForeground(darkPink);
        imageLabel.add(top);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(600, 350, 200, 30);
        usernameLabel.setFont(poppinsFont);
        usernameLabel.setForeground(darkPink);
        imageLabel.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(750, 350, 200, 30);
        imageLabel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(600, 400, 200, 30);
        passwordLabel.setFont(poppinsFont);
        passwordLabel.setForeground(darkPink);
        imageLabel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(750, 400, 200, 30);
        imageLabel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(700, 470, 120, 50);
        loginButton.setBackground(new Color(120, 0, 55));
        loginButton.setBorderPainted(false);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Poppins", Font.PLAIN, 18));
        loginButton.setForeground(Color.WHITE);
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change color when mouse enters
                loginButton.setBackground(new Color(255, 169, 189)); // Change to desired hover color
                loginButton.setForeground(new Color(120, 0, 55));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change color back when mouse exits
                loginButton.setBackground(new Color(120, 0, 55)); // Change to the original color
                loginButton.setForeground(Color.WHITE);
            }
        });
        loginButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String enteredUsername = usernameField.getText();
                char[] enteredPassword = passwordField.getPassword();
                String storedUsername = "hospital";
                String storedPassword = "12345";

                if (enteredUsername.equals(storedUsername) && new String(enteredPassword).equals(storedPassword))
                {
                    new home();
                    dispose();

                    // Open the main application window or perform any other action
                } 
                else if (enteredUsername.equals(docUsername) && new String(enteredPassword).equals(docPassword)) 
                {
                    new dochome();
                    dispose();
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }
            }
        });
        imageLabel.add(loginButton);
        add(one);

        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new LoginPage();
    }
}
