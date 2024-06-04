import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Other_info implements ActionListener {
    JFrame Other_info_frame=new JFrame("Other Information");
    JLabel Other_info_l = new JLabel("OTHER INFORMATION");
    JLabel balance=new JLabel("Balance : ");
    JLabel address=new JLabel("Address : ");
    JButton add = new JButton("Add");
    JButton clear = new JButton("Clear");


    JTextField tf_balance=new JTextField(20);
    JTextField tf_address=new JTextField(20);

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

    JButton back_b;

    GUI temp;

    Other_info(GUI temp)
    {
        this.temp=temp;

        frame_setting();
        other_text();
        labels();
        text_fields();
        add_Button();
        Clear_Button();
        back_button();
    }


    private void other_text()
    {
        Other_info_l.setBounds(150, 0, 500, 50);
        Other_info_l.setFont(f1);
        Other_info_frame.add(Other_info_l);
    }
    private void frame_setting()
    {
        Other_info_frame.setBounds(500, 50, 500, 500);
        Other_info_frame.setLayout(null);
        Other_info_frame.getContentPane().setBackground(Color.lightGray);
        Other_info_frame.setVisible(true);
        Other_info_frame.setResizable(false);
        Other_info_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void labels()
    {

        balance.setBounds(20, 60, 500, 50);
        Other_info_frame.add(balance);

        address.setBounds(20, 120, 500, 50);
        Other_info_frame.add(address);


    }


    private void text_fields()
    {

        tf_balance.setBounds(120, 70, 330, 30);
        Other_info_frame.add(tf_balance);

        tf_balance.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                tf_balance.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
            }
        });

        tf_balance.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                tf_balance.setEditable(true);
            }
        });

        tf_address.setBounds(120, 130, 330, 30);
        Other_info_frame.add(tf_address);

    }


    private void add_Button()
    {
        add.setBounds(130, 350, 100, 40);
        Other_info_frame.add(add);
        add.addActionListener(this);
    }

    private void Clear_Button()
    {
        clear.setBounds(270, 350, 100, 40);
        Other_info_frame.add(clear);
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
        Other_info_frame.add(back_b);
    }

    private void Clear ()
    {

        tf_balance.setText("");
        tf_address.setText("");

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(add)) {
            if (tf_balance.getText().equals("") || tf_address.getText().equals("")|| !tf_balance.isEditable()) {
                JOptionPane.showMessageDialog(null, "Fill All Data");
            } else {


                Main.p[Main.count].setBalance(Float.parseFloat(tf_balance.getText()));
                Main.p[Main.count].setAddress(tf_address.getText());
                Main.p[Main.count].display();
                Main.count++;
                Clear();
                Other_info_frame.dispose();
                new Profile(temp);
            }
        }
        else if(e.getSource().equals(clear))
        {
            Clear();
        }


        if(e.getSource().equals(back_b)){
            new Signup(temp);
            Other_info_frame.dispose();
        }

    }
}
