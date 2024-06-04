import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search_By_ID implements ActionListener {

    JFrame id_frame=new JFrame();
    JLabel search_id=new JLabel("ENTER ID");
    JLabel id=new JLabel("Enter Product ID : ");
    JTextField tf_id=new JTextField(20);
    JLabel id_not_found=new JLabel("Product not found");

    JButton buy=new JButton("BUY");

    JButton back_b;

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);
    Font f2=new Font(Font.SANS_SERIF,Font.ITALIC,10);



    GUI temp;

    static String s;
    Search_By_ID(GUI temp,String s)
    {
        this.temp=temp;
        this.s=s;

        if(s.equals("rent"))
        {
            buy.setText("Rent");
        }

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
        search_id.setBounds(140, 0, 500, 50);
        search_id.setFont(f1);
        id_frame.add(search_id);
    }

    public void id_Label()
    {
        id.setBounds(20,80,200,30);
        id_frame.add(id);

        id_not_found.setBounds(140, 55, 330, 30);
        id_not_found.setFont(f2);
        id_not_found.setForeground(Color.red);
        id_not_found.setVisible(false);
        id_frame.add(id_not_found);
    }

    public void id_Field()
    {
        tf_id.setBounds(140,80,230,30);
        id_frame.add(tf_id);
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
        if(e.getSource().equals(buy))
        {
            boolean flag=false;
            if(s.equals("sell"))
            {
                for (int i = 0; i < Main.active_product_index; i++) {
                    if (tf_id.getText().equals(Main.all_products_sell[i].product_ID)) {
                        Product_Filter.Product_index = i;
                        flag = true;
                        new Buy_Product(temp, tf_id.getText(),"0",s);
                        id_frame.dispose();
                        break;
                    }
                }
            }
            else if(s.equals("rent"))
            {
                for (int i = 0; i < Main.active_rent_index; i++) {
                    if (tf_id.getText().equals(Main.all_products_rent[i].product_ID)) {
                        Product_Filter.Product_index = i;
                        flag = true;
                        new Number_of_days(temp,tf_id.getText(),s);
                        id_frame.dispose();
                        break;
                    }
                }
            }
            if(!flag)
            {
                id_not_found.setVisible(true);
            }
        }
        else if(e.getSource().equals(back_b))
        {
            Product_Filter.f_frame.setVisible(true);
            id_frame.dispose();
        }
    }
}
