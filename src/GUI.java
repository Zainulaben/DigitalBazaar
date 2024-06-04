import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    public static JFrame menu = new JFrame("Welcome to Digital Bazaar");
    public JLabel dig = new JLabel("DIGITAL BAZAAR");
    public JButton login = new JButton("LOGIN");
    public JLabel no_account = new JLabel("Don't have an account? Signup for Create account");
    public JButton signup = new JButton("SIGN UP");

    Font f1 = new Font(Font.SERIF, Font.BOLD, 35);

    public GUI() {

        frame_settings();
        digital_bazar();
        login_button();
        not_account();
        signup_button();
    }


    public void frame_settings() {
        menu.setBounds(500, 50, 500, 500);
        menu.setLayout(null);
        menu.getContentPane().setBackground(Color.lightGray);
        menu.setVisible(true);
        menu.setResizable(false);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void digital_bazar() {
        dig.setBounds(100, 0, 500, 150);
        dig.setFont(f1);
        menu.add(dig);
    }


    public void login_button() {
        login.setBounds(170, 200, 150, 40);
        login.setBackground(Color.GRAY);
        menu.add(login);
        login.addActionListener(this);
    }


    public void not_account() {
        no_account.setBounds(90, 250, 500, 50);
        menu.add(no_account);
    }


    public void signup_button() {
        signup.setBounds(170, 300, 150, 40);
        signup.setBackground(Color.gray);
        menu.add(signup);
        signup.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(login)) {
            new Login(this);
            menu.setVisible(false);

        } else if (e.getSource().equals(signup)) {
            new Signup(this);
            menu.setVisible(false);
        }
    }

}
