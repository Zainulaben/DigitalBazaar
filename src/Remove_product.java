import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Remove_product implements ActionListener {

    public JFrame remove_frame=new JFrame();
    JLabel remove_prod=new JLabel("Remove product");
    JLabel remove=new JLabel("Do you want to remove product? ");

    JButton Yes=new JButton("YES");

    JButton No = new JButton("NO");

    JButton back_b;

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);

    GUI temp;
    String s;


    Remove_product(GUI temp,String s)
    {
        this.temp=temp;
        this.s=s;

        Frame_setting();
        id_Label();
        Button();
        back_button();
        id_text();
    }

    public void Frame_setting()
    {
        remove_frame.setBounds(500,50,400,300);
        remove_frame.setLayout(null);
        remove_frame.setVisible(true);
        remove_frame.setResizable(false);
        remove_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        remove_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private void id_text()
    {
        remove_prod.setBounds(130, 0, 500, 50);
        remove_prod.setFont(f1);
        remove_frame.add(remove_prod);
    }

    public void id_Label()
    {
        remove.setBounds(20,80,200,30);
        remove_frame.add(remove);
    }

    public void Button()
    {
        Yes.setBounds(110,170,80,40);
        remove_frame.add(Yes);
        Yes.addActionListener(this);

        No.setBounds(200,170,80,40);
        remove_frame.add(No);
        No.addActionListener(this);
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
        remove_frame.add(back_b);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(Yes))
        {
            if(s.equals("Seller")) {

                Product []temp=new Product[Main.active_product_index-1];
                for(int i=0,k=0;i<Main.active_product_index;i++)
                {
                    if(!Main.all_products_sell[i].product_ID.equals(Main.s[Main.sell_index].active_product[Search_ID.Product_index].product_ID))
                    {
                        temp[k]=Main.all_products_sell[i];
                        k++;
                    }
                }
                Main.active_product_index-=1;
                if(Main.active_product_index==0)
                {
                    Main.all_products_sell[Main.active_product_index]=null;
                }
                else {
                    for (int i = 0; i < Main.active_product_index; i++) {
                        Main.all_products_sell[i] = temp[i];
                    }
                }


                Product[] remove = new Product[Main.s[Main.sell_index].active_product_count-1];
                for (int i = 0, k = 0; i < Main.s[Main.sell_index].active_product_count; i++) {
                    if (i != Search_ID.Product_index) {
                        remove[k] = Main.s[Main.sell_index].active_product[i];
                        k++;
                    }
                }

                Main.s[Main.sell_index].active_product_count -= 1;

                if(Main.s[Main.sell_index].active_product_count==0)
                {
                    Main.s[Main.sell_index].active_product[Main.s[Main.sell_index].active_product_count]=null;
                }
                else {
                    for (int i = 0; i < Main.s[Main.sell_index].active_product_count; i++) {
                        Main.s[Main.sell_index].active_product[i] = remove[i];
                    }
                }

                Product_info.prod_frame.setVisible(true);
            }
            else if(s.equals("Renter"))
            {

                Product []temp=new Product[Main.active_rent_index-1];
                for(int i=0,k=0;i<Main.active_rent_index;i++)
                {
                    if(!Main.all_products_rent[i].product_ID.equals(Main.r[Main.rent_index].active_product_List[Search_ID.Product_index].product_ID))
                    {
                        temp[k]=Main.all_products_rent[i];
                        k++;
                    }
                }
                Main.active_rent_index-=1;
                if(Main.active_rent_index==0)
                {
                    Main.all_products_rent[Main.active_rent_index]=null;
                }
                else
                {
                    for(int i=0;i<Main.active_rent_index;i++)
                    {
                        Main.all_products_rent[i]=temp[i];
                    }
                }



                Product []remove=new Product[Main.r[Main.rent_index].active_Product_List_count-1];
                for(int i=0,k=0;i<Main.r[Main.rent_index].active_Product_List_count;i++)
                {
                    if(i!=Search_ID.Product_index)
                    {
                        remove[k]=Main.r[Main.rent_index].active_product_List[i];
                        k++;
                    }
                }

                Main.r[Main.rent_index].active_Product_List_count-=1;

                if(Main.r[Main.rent_index].active_Product_List_count==0)
                {
                    Main.r[Main.rent_index].active_product_List[Main.r[Main.rent_index].active_Product_List_count]=null;
                }
                else {
                    for (int i = 0; i < Main.r[Main.rent_index].active_Product_List_count; i++) {
                        Main.r[Main.rent_index].active_product_List[i] = remove[i];
                    }
                }


                Rent_Product_Info.r_prod_frame.setVisible(true);
            }
            remove_frame.dispose();
        }
        else if(e.getSource().equals(back_b))
        {
            remove_frame.dispose();
            if(s.equals("Seller")) {
                Product_info.prod_frame.setVisible(true);
            }
            else if(s.equals("Renter"))
            {
                Rent_Product_Info.r_prod_frame.setVisible(true);
            }
        }
        else if(e.getSource().equals(No))
        {
            remove_frame.dispose();
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
