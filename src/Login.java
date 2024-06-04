import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {

    public static JFrame login_frame = new JFrame("Login");
    JLabel login_l = new JLabel("LOGIN");
    JLabel login_user_name = new JLabel("Username : ");
    JLabel login_password = new JLabel("Password : ");
    JTextField login_f_name = new JTextField(20);
    JPasswordField login_pass_word=new JPasswordField(20);
    JCheckBox login_show_password=new JCheckBox("Show Password");

    JButton login_clear= new JButton("CLEAR");
    JButton loginB= new JButton("LOGIN");

    JButton login_back_b;


    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);


    JLabel incorrect_u_name=new JLabel("Incorrect UserName");
    JLabel incorrect_password=new JLabel("Incorrect Password");

    Font f2=new Font(Font.SANS_SERIF,Font.ITALIC,10);
    GUI temp;

    Login(GUI temp) {

        this.temp = temp;


        login_Frame_setting();
        login_text();
        login_labels();
        login_text_fields();
        login_checkboxes();
        Login_Button();
        login_Clear_Button();
        login_back_button();
    }

    private void login_Frame_setting()
    {
        login_frame.setBounds(500, 50, 500, 500);
        login_frame.setLayout(null);
        login_frame.getContentPane().setBackground(Color.lightGray);
        login_frame.setVisible(true);
        login_frame.setResizable(false);
        login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void login_text()
    {
        login_l.setBounds(200, 0, 500, 50);
        login_l.setFont(f1);
        login_frame.add(login_l);
    }


    public void login_labels()
    {
        login_user_name.setBounds(20,100,500,50);
        login_frame.add(login_user_name);

        login_password.setBounds(20,200,500,50);
        login_frame.add(login_password);

        incorrect_u_name.setBounds(120, 85, 330, 30);
        incorrect_u_name.setFont(f2);
        incorrect_u_name.setForeground(Color.red);
        incorrect_u_name.setVisible(false);
        login_frame.add(incorrect_u_name);

        incorrect_password.setBounds(120, 185, 330, 30);
        incorrect_password.setFont(f2);
        incorrect_password.setForeground(Color.red);
        incorrect_password.setVisible(false);
        login_frame.add(incorrect_password);
    }


    private void login_text_fields()
    {
        login_f_name.setBounds(120, 110, 330, 30);
        login_frame.add(login_f_name);

        login_pass_word.setBounds(120, 210, 330, 30);
        login_frame.add(login_pass_word);
        login_pass_word.setEchoChar('*');
    }



    private void login_checkboxes()
    {
        login_show_password.setBounds(120, 250, 330, 30);
        login_show_password.setBackground(Color.lightGray);
        login_frame.add(login_show_password);
        login_show_password.addActionListener(this);
    }



    private void Login_Button()
    {
        loginB.setBounds(150,350,80,30);
        loginB.addActionListener(this);
        login_frame.add(loginB);
    }

    private void login_Clear_Button()
    {
        login_clear.setBounds(250,350,80,30);
        login_clear.addActionListener(this);
        login_frame.add(login_clear);

    }


    private void clear_login(){
        login_f_name.setText("");
        login_pass_word.setText("");
        login_show_password.setSelected(false);
        if(!login_show_password.isSelected()){
            login_pass_word.setEchoChar('*');
        }
    }


    private void login_back_button(){
        ImageIcon back=new ImageIcon("E:\\back.jpeg");
        Image b=back.getImage();
        Image b1=b.getScaledInstance(20,20,10);
        back.setImage(b1);

        login_back_b=new JButton(back);
        login_back_b.setBounds(10,10,30,30);
        login_back_b.setBackground(Color.lightGray);
        login_back_b.setBorderPainted(false);
        login_back_b.addActionListener(this);
        login_frame.add(login_back_b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(login_show_password.isSelected()){
            login_pass_word.setEchoChar((char)0);
        }
        if(!login_show_password.isSelected()){
            login_pass_word.setEchoChar('*');
        }

        if (e.getSource().equals(loginB))
        {
            boolean check_u=false;
            boolean check_p=false;
            String user_name;
            String pass;
            for(int i=0 ; i< Main.count ; i++)
            {
                user_name= Main.p[i].a.getU_name();
                if(login_f_name.getText().equals(user_name))
                {
                    check_u=true;
                }

                pass=Main.p[i].a.getPassword();

                if(String.valueOf(login_pass_word.getPassword()).equals(pass))
                {
                    check_p=true;
                }

                if(check_u && check_p)
                {
                    Main.index=i;
                    break;
                }
            }
            if(check_u && check_p)
            {
                incorrect_u_name.setVisible(false);
                incorrect_password.setVisible(false);

                boolean check_sell_id=false;
                boolean check_buy_id=false;
                boolean check_rent_id=false;

                for(int i=0;i<Main.sell_count;i++)
                {
                    if(Main.s[i].ID==Main.p[Main.index].ID)
                    {
                        Main.sell_index=i;
                        check_sell_id=true;
                        break;
                    }
                }

                for(int i=0;i<Main.buy_count;i++)
                {
                    if(Main.b[i].ID==Main.p[Main.index].ID)
                    {
                        Main.buy_index=i;
                        check_buy_id=true;
                        break;
                    }
                }

                for(int i=0;i<Main.rent_count;i++)
                {
                    if(Main.r[i].ID==Main.p[Main.index].ID)
                    {
                        Main.rent_index=i;
                        check_rent_id=true;
                        break;
                    }
                }
                if(!check_rent_id)
                {
                    Main.rent_index=Main.rent_count;
                }

                if(!check_sell_id)
                {
                    Main.sell_index=Main.sell_count;
                }

                if(!check_buy_id)
                {
                    Main.buy_index=Main.buy_count;
                }

                login_frame.dispose();
                new Profile(temp);

            }
            if(!check_u)
            {
                incorrect_u_name.setVisible(true);
                login_f_name.setText("");
            }
            if(!check_p)
            {
                incorrect_password.setVisible(true);
                login_pass_word.setText("");
            }
        }
        else if(e.getSource().equals(login_clear))
        {
            clear_login();
        }

        if(e.getSource().equals(login_back_b)){
            new GUI();
            login_frame.dispose();
        }


    }



}