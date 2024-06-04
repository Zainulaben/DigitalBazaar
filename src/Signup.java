import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup implements ActionListener {

    public static JFrame signup_frame=new JFrame("Signup");
    JLabel signup_l = new JLabel("SIGNUP");
    JLabel first_name=new JLabel("First name : ");
    JLabel last_name=new JLabel("Last name : ");
    JLabel user_name=new JLabel("User Name : ");
    JLabel password =new JLabel("Password : ");
    JLabel BOD=new JLabel("Date Of Birth : ");
    JLabel day =new JLabel("Day");
    JLabel month=new JLabel("Month");
    JLabel year=new JLabel("Year");
    JButton submit = new JButton("Submit");
    JButton clear = new JButton("Clear");
    JCheckBox show_password=new JCheckBox("Show Password");
    JLabel already_u_name=new JLabel("Username Already Exists");

    JTextField f_name=new JTextField(20);
    JTextField l_name=new JTextField(20);
    JTextField u_name=new JTextField(20);
    JPasswordField passwordField=new JPasswordField(20);

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);
    Font f2=new Font(Font.SANS_SERIF,Font.ITALIC,10);

    String []d=new String[31];
    String[]m=new String[12];
    String[]y=new String[31];

    JComboBox<String> Day = new JComboBox<>();
    JComboBox<String> Month = new JComboBox<>();
    JComboBox<String> Year = new JComboBox<>();


    JButton back_b;

    GUI temp;

    Signup(GUI temp)
    {
        this.temp=temp;

        frame_setting();
        signup_text();
        labels();
        combo_boxes();
        text_fields();
        check_boxes();
        Submit_Button();
        Clear_Button();
        back_button();
    }


    private void signup_text()
    {
        signup_l.setBounds(200, 0, 500, 50);
        signup_l.setFont(f1);
        signup_frame.add(signup_l);
    }
    private void frame_setting()
    {
        signup_frame.setBounds(500, 50, 500, 500);
        signup_frame.setLayout(null);
        signup_frame.getContentPane().setBackground(Color.lightGray);
        signup_frame.setVisible(true);
        signup_frame.setResizable(false);
        signup_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void labels()
    {
        first_name.setBounds(20, 40, 500, 50);
        signup_frame.add(first_name);

        last_name.setBounds(20, 90, 500, 50);
        signup_frame.add(last_name);

        user_name.setBounds(20, 140, 500, 50);
        signup_frame.add(user_name);

        password.setBounds(20, 190, 500, 50);
        signup_frame.add(password);

        BOD.setBounds(20, 290, 500, 50);
        signup_frame.add(BOD);

        day.setBounds(120, 250, 500, 50);
        signup_frame.add(day);

        month.setBounds(170, 250, 500, 50);
        signup_frame.add(month);

        year.setBounds(230, 250, 500, 50);
        signup_frame.add(year);

        already_u_name.setBounds(120, 125, 330, 30);
        already_u_name.setFont(f2);
        already_u_name.setForeground(Color.red);
        already_u_name.setVisible(false);
        signup_frame.add(already_u_name);
    }


    private void combo_boxes()
    {
        date();
        Day=new JComboBox<>(d);
        Month=new JComboBox<>(m);
        Year=new JComboBox<>(y);


        Day.setBounds(120, 300, 40, 30);
        signup_frame.add(Day);

        Month.setBounds(170, 300, 50, 30);
        signup_frame.add(Month);

        Year.setBounds(230, 300, 60, 30);
        signup_frame.add(Year);
    }


    private void text_fields()
    {
        f_name.setBounds(120, 50, 330, 30);
        signup_frame.add(f_name);

        l_name.setBounds(120, 100, 330, 30);
        signup_frame.add(l_name);

        u_name.setBounds(120, 150, 330, 30);
        signup_frame.add(u_name);

        passwordField.setBounds(120, 200, 330, 30);
        signup_frame.add(passwordField);
        passwordField.setEchoChar('*');
    }



    private void check_boxes()
    {
        show_password.setBounds(120, 230, 330, 30);
        show_password.setBackground(Color.lightGray);
        signup_frame.add(show_password);
        show_password.addActionListener(this);
    }



    private void date()
    {
        for(int i=0;i<31;i++)
        {
            d[i]=Integer.toString(i+1);
        }
        for(int i=0;i<12;i++)
        {
            m[i]=Integer.toString(i+1);
        }
        for(int i=0;i<31;i++)
        {
            y[i]=Integer.toString(1992+i);
        }
    }

    private void Submit_Button()
    {
        submit.setBounds(130, 350, 100, 40);
        signup_frame.add(submit);
        submit.addActionListener(this);
    }

    private void Clear_Button()
    {
        clear.setBounds(270, 350, 100, 40);
        signup_frame.add(clear);
        clear.addActionListener(this);
    }


    private void back_button(){
        ImageIcon back=new ImageIcon("E:\\back.jpeg");
        Image b=back.getImage();
        Image b1=b.getScaledInstance(20,20,10);
        back.setImage(b1);

        back_b=new JButton(back);
        back_b.setBounds(10,10,30,30);
        back_b.setBackground(Color.lightGray);
        back_b.setBorderPainted(false);
        back_b.addActionListener(this);
        signup_frame.add(back_b);
    }

    private void Clear ()
    {
        f_name.setText("");
        l_name.setText("");
        u_name.setText("");
        passwordField.setText("");
        Day.setSelectedIndex(0);
        Month.setSelectedIndex(0);
        Year.setSelectedIndex(0);
        show_password.setSelected(false);
        if(!show_password.isSelected()) {
            passwordField.setEchoChar('*');
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(submit))
        {

            if(f_name.getText().equals("") || l_name.getText().equals("") || u_name.getText().equals("")|| String.valueOf(passwordField.getPassword()).equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill All Data");
            }
            else
            {
                passwordField.getPassword();
                boolean flag =true;
                for(int i=0;i<Main.count;i++)
                {
                    if(Main.p[i].a.getU_name().equals(u_name.getText()))
                    {
                        flag=false;
                        already_u_name.setVisible(true);
                    }
                }
                if(flag)
                {
                    Main.index=Main.count;
                    Main.p[Main.count]=new Person();
                    Main.p[Main.count].setID(Main.index);
                    Main.p[Main.count].set_Data(f_name.getText(),l_name.getText(),u_name.getText(), String.valueOf(passwordField.getPassword()),Day.getSelectedIndex()+1,Month.getSelectedIndex()+1,Year.getSelectedIndex()+1992);
                    Main.sell_index=Main.sell_count;
                    Main.buy_index=Main.buy_count;
                    Main.rent_index=Main.rent_count;
                    Clear();
                    signup_frame.dispose();
                    new Other_info(temp);
                }
            }
        }
        else if(e.getSource().equals(clear))
        {
            Clear();
        }


        if(show_password.isSelected()){
            passwordField.setEchoChar((char)0);
        }
        if(!show_password.isSelected()){
            passwordField.setEchoChar('*');
        }


        if(e.getSource().equals(back_b)){
            GUI.menu.setVisible(true);
            signup_frame.dispose();
        }

    }
}
