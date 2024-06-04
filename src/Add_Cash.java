import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class Add_Cash implements ActionListener {

    JFrame add_cash_frame=new JFrame("Add balance");
    JLabel add_cash=new JLabel("ADD CASH");
    JLabel Balance=new JLabel("Enter Amount : ");
    JTextField Balance_text_field=new JTextField(20);

    JButton Add=new JButton("ADD");

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

    JButton back_b;

    GUI temp;

    Add_Cash(GUI temp)
    {
        this.temp=temp;

        Frame_setting();
        cash_text();
        Balance_Label();
        Balance_Field();
        Add_Button();
        back_button();

    }

    public void Frame_setting()
    {
        add_cash_frame.setBounds(500,50,400,300);
        add_cash_frame.setLayout(null);
        add_cash_frame.setVisible(true);
        add_cash_frame.setResizable(false);
        add_cash_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        add_cash_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void cash_text()
    {
        add_cash.setBounds(140, 0, 500, 50);
        add_cash.setFont(f1);
        add_cash_frame.add(add_cash);
    }

    public void Balance_Label()
    {
        Balance.setBounds(20,70,100,30);
        add_cash_frame.add(Balance);
    }

    public void Balance_Field()
    {
        Balance_text_field.setBounds(130,70,230,30);
        add_cash_frame.add(Balance_text_field);

        Balance_text_field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Balance_text_field.setEditable((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == 8 || e.getKeyChar() == '.');
            }
        });

        Balance_text_field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Balance_text_field.setEditable(true);
            }
        });
    }

    public void Add_Button()
    {
        Add.setBounds(160,180,80,40);
        add_cash_frame.add(Add);
        Add.addActionListener(this);
    }

    private void back_button(){
        ImageIcon back=new ImageIcon("back.png");
        Image b=back.getImage();
        Image b1=b.getScaledInstance(20,20,10);
        back.setImage(b1);

        back_b=new JButton(back);
        back_b.setBounds(10,10,30,30);
        back_b.setBackground(Color.lightGray);
        back_b.setBorderPainted(false);
        back_b.addActionListener(this);
        add_cash_frame.add(back_b);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(Add))
        {
            if(!Objects.equals(Balance_text_field.getText(), "")) {
                Main.p[Main.index].setBalance(Float.parseFloat(Balance_text_field.getText())+Main.p[Main.index].getBalance());
                add_cash_frame.dispose();
                new Profile(temp);
            }
        }
        else if(e.getSource().equals(back_b))
        {
            add_cash_frame.dispose();
            Profile.profile_frame.setVisible(true);
        }


    }
}
