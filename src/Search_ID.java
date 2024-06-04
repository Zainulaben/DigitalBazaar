import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Search_ID implements ActionListener {

    JFrame id_frame=new JFrame();
    JLabel search_id=new JLabel("SEARCH ID");
    JLabel id=new JLabel("Enter Product ID : ");
    JTextField tf_id=new JTextField(20);
    JLabel id_not_found=new JLabel("ID not found");

    JButton Add=new JButton("OK");

    JButton back_b;

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);
    Font f2=new Font(Font.SANS_SERIF,Font.ITALIC,10);

    public static int Product_index;

    GUI temp;
    String temp_s;
    String s;

    Search_ID(GUI temp,String a,String s)
    {
        this.temp=temp;
        temp_s=a;
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
        Add.setBounds(150,170,100,40);
        id_frame.add(Add);
        Add.addActionListener(this);
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
        if(e.getSource().equals(Add))
        {
            boolean flag=false;
            if(s.equals("Seller")) {
                for (int i = 0; i < Main.s[Main.sell_index].active_product_count; i++) {
                    if (tf_id.getText().equals(Main.s[Main.sell_index].active_product[i].product_ID)) {
                        Product_index = i;
                        flag = true;
                        break;
                    }
                }
            }
            else if(s.equals("Renter")) {
                for (int i = 0; i < Main.r[Main.rent_index].active_Product_List_count; i++) {
                    if (tf_id.getText().equals(Main.r[Main.rent_index].active_product_List[i].product_ID)) {
                        Product_index = i;
                        flag = true;
                        break;
                    }
                }
            }

            if(flag) {
                id_frame.dispose();
                if (Objects.equals(temp_s, "installment")) {
                    id_frame.dispose();
                    new Add_Installment(temp);
                } else if (Objects.equals(temp_s, "edit")) {
                    id_frame.dispose();
                    new Edit_Product(temp, s);
                } else if (Objects.equals(temp_s, "remove")) {
                    id_frame.dispose();
                    new Remove_product(temp, s);
                }
            }
            else if(!flag) {
                id_not_found.setVisible(true);
            }
        }
        else if(e.getSource().equals(back_b))
        {
            id_frame.dispose();
            if(s.equals("Seller")) {
                Product_info.prod_frame.setVisible(true);
            }
            else if(s.equals("Renter"))
            {
                Rent_Product_Info.r_prod_frame.setVisible(true);
            }
        }


    }
}
