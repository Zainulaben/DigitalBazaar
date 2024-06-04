import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public class Display_Pers_Info implements ActionListener {
    JFrame display = new JFrame("Personal Information");

    JLabel p_information = new JLabel("Personal Information");
    JLabel Id_l = new JLabel("ID : ");
    JLabel name_l = new JLabel("Name : ");
    JLabel u_name_l = new JLabel("User Name : ");
    JLabel password_l = new JLabel("Password : ");
    JLabel balance_l = new JLabel("Balance : ");
    JLabel address_l = new JLabel("Address : ");
    JLabel DOB_l = new JLabel("Date of Birth : ");

    JTextField Id_t = new JTextField(20);
    JTextField name_t = new JTextField(20);
    JTextField u_name_t = new JTextField(20);
    JTextField password_t = new JTextField(20);
    JTextField balance_t = new JTextField(20);
    JTextField address_t = new JTextField(20);
    JTextField DOB_t = new JTextField(20);

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

    GUI temp;

    JButton back_b;

    Display_Pers_Info(GUI temp) {
        this.temp = temp;

        frame_setting();
        labels();
        text_fields();
        back_button();

    }

    private void frame_setting() {
        display.setBounds(500, 50, 500, 500);
        display.setLayout(null);
        display.getContentPane().setBackground(Color.lightGray);
        display.setVisible(true);
        display.setResizable(false);
        display.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }


    private void labels() {
        p_information.setBounds(180, 0, 500, 50);
        p_information.setFont(f1);
        display.add(p_information);

        Id_l.setBounds(20, 40, 500, 50);
        display.add(Id_l);

        name_l.setBounds(20, 90, 500, 50);
        display.add(name_l);

        u_name_l.setBounds(20, 140, 500, 50);
        display.add(u_name_l);

        password_l.setBounds(20, 190, 500, 50);
        display.add(password_l);

        DOB_l.setBounds(20, 240, 500, 50);
        display.add(DOB_l);

        balance_l.setBounds(20, 290, 500, 50);
        display.add(balance_l);

        address_l.setBounds(20, 340, 500, 50);
        display.add(address_l);

    }

    private void text_fields() {


        Id_t.setBounds(120, 50, 330, 30);
        Id_t.setEditable(false);
        Id_t.setBackground(Color.LIGHT_GRAY);
        Id_t.setBorder(null);
        Id_t.setText(String.valueOf(Main.p[Main.index].ID));
        display.add(Id_t);

        name_t.setBounds(120, 100, 330, 30);
        name_t.setEditable(false);
        name_t.setBorder(null);
        name_t.setBackground(Color.LIGHT_GRAY);
        name_t.setText(Main.p[Main.index].a.getF_name() + " " + Main.p[Main.index].a.getL_name());
        display.add(name_t);

        u_name_t.setBounds(120, 150, 330, 30);
        u_name_t.setEditable(false);
        u_name_t.setBorder(null);
        u_name_t.setBackground(Color.LIGHT_GRAY);
        u_name_t.setText(Main.p[Main.index].a.getU_name());
        display.add(u_name_t);

        password_t.setBounds(120, 200, 330, 30);
        password_t.setEditable(false);
        password_t.setBorder(null);
        password_t.setBackground(Color.LIGHT_GRAY);
        password_t.setText(Main.p[Main.index].a.getPassword());
        display.add(password_t);

        DOB_t.setBounds(120, 250, 330, 30);
        DOB_t.setEditable(false);
        DOB_t.setBorder(null);
        DOB_t.setBackground(Color.LIGHT_GRAY);
        DOB_t.setText(String.valueOf(Main.p[Main.index].a.DOB.getDay() + "/" + Main.p[Main.index].a.DOB.getMonth() + "/" + Main.p[Main.index].a.DOB.getYear()));
        display.add(DOB_t);

        balance_t.setBounds(120, 300, 330, 30);
        balance_t.setEditable(false);
        balance_t.setBorder(null);
        balance_t.setBackground(Color.LIGHT_GRAY);
        balance_t.setText(String.valueOf(Main.p[Main.index].getBalance()));
        display.add(balance_t);

        address_t.setBounds(120, 350, 330, 30);
        address_t.setEditable(false);
        address_t.setBorder(null);
        address_t.setBackground(Color.lightGray);
        address_t.setText(Main.p[Main.index].getAddress());
        display.add(address_t);

    }

    private void back_button() {
        ImageIcon back = new ImageIcon("back.png");
        Image b = back.getImage();
        Image b1 = b.getScaledInstance(20, 20, 10);
        back.setImage(b1);

        back_b = new JButton(back);
        back_b.setBounds(10, 10, 30, 30);
        back_b.setBackground(Color.lightGray);
        back_b.setBorderPainted(false);
        back_b.addActionListener(this);
        display.add(back_b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(back_b)) {
            display.dispose();
            Profile.profile_frame.setVisible(true);
        }
    }
}