import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat_To_Seller implements ActionListener {

    JFrame chat_frame=new JFrame("Chat to seller");
    JLabel chat=new JLabel("CHAT");
    JLabel message=new JLabel("Enter message : ");
    JTextField tf_msg=new JTextField(20);

    JButton submit=new JButton("SUBMIT");

    JButton back_b;

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);



    GUI temp;

    static int Product_index;

    static String s;

    Chat_To_Seller(GUI temp,int i,String s)
    {
        this.temp=temp;
        Product_index=i;
        this.s=s;

        Frame_setting();
        msg_Label();
        msg_Field();
        Add_Button();
        back_button();
        id_text();
    }

    public void Frame_setting()
    {
        chat_frame.setBounds(500,50,400,300);
        chat_frame.setLayout(null);
        chat_frame.setVisible(true);
        chat_frame.setResizable(false);
        chat_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        chat_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void id_text()
    {
        chat.setBounds(140, 0, 500, 50);
        chat.setFont(f1);
        chat_frame.add(chat);
    }

    public void msg_Label()
    {
        message.setBounds(20,80,200,30);
        chat_frame.add(message);

    }

    public void msg_Field()
    {
        tf_msg.setBounds(140,80,230,30);
        chat_frame.add(tf_msg);
    }

    public void Add_Button()
    {
        submit.setBounds(150,170,100,40);
        chat_frame.add(submit);
        submit.addActionListener(this);
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
        chat_frame.add(back_b);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(submit))
        {
            boolean flag=false;
            if(s.equals("sell")) {
                for (int i = 0; i < Main.sell_count; i++) {
                    for (int j = 0; j < Main.s[i].active_product_count; j++) {
                        if (Main.all_products_sell[Product_index] == Main.s[i].active_product[j]) {
                            Main.s[i].active_product[j].setMessages_list(tf_msg.getText());
                            Main.all_products_sell[Product_index] = Main.s[i].active_product[j];
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
            }
            if(s.equals("rent")) {
                for (int i = 0; i < Main.rent_count; i++) {
                    for (int j = 0; j < Main.r[i].active_Product_List_count; j++) {
                        if (Main.all_products_rent[Product_index].product_ID.equals(Main.r[i].active_product_List[j].product_ID)) {
                            Main.r[i].active_product_List[j].setMessages_list(tf_msg.getText());
                            Main.all_products_rent[Product_index] = Main.r[i].active_product_List[j];
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
            }
            new Buy_product_panel(temp);
            chat_frame.dispose();
        }

        if(e.getSource().equals(back_b))
        {
            Buy_Product.buy_frame.setVisible(true);
            chat_frame.dispose();
        }
    }
}
