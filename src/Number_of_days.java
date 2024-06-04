import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Number_of_days implements ActionListener {

    JFrame id_frame=new JFrame();
    JLabel enter_days=new JLabel("NUMBER OF DAYS");
    JLabel days=new JLabel("Number of days : ");
    JTextField tf_days=new JTextField(20);

    JButton buy=new JButton("RENT");

    JButton back_b;

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);
    Font f2=new Font(Font.SANS_SERIF,Font.ITALIC,10);



    GUI temp;

    String temp_id;

    static String s;
    Number_of_days(GUI temp,String id,String s)
    {
        this.temp=temp;
        temp_id=id;
        this.s=s;

        Frame_setting();
        id_Label();
        id_Field();
        Add_Button();
        back_button();
        id_text();
    }

    public void Frame_setting()
    {
        id_frame.setBounds(500,50,400,300);
        id_frame.setLayout(null);
        id_frame.setVisible(true);
        id_frame.setResizable(false);
        id_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        id_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void id_text()
    {
        enter_days.setBounds(140, 0, 500, 50);
        enter_days.setFont(f1);
        id_frame.add(enter_days);
    }

    public void id_Label()
    {
        days.setBounds(20,80,200,30);
        id_frame.add(days);
    }

    public void id_Field()
    {
        tf_days.setBounds(140,80,230,30);
        id_frame.add(tf_days);
    }

    public void Add_Button()
    {
        buy.setBounds(150,170,100,40);
        id_frame.add(buy);
        buy.addActionListener(this);
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
        id_frame.add(back_b);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buy)
        {
            if(tf_days.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter number of days");
            }
            else
            {
                //Product_Filter.Product_index=i;
                new Buy_Product(temp,temp_id,tf_days.getText(),s);
                id_frame.dispose();
            }
        }

    }
}
