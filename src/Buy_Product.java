import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buy_Product implements ActionListener {
    public static JFrame buy_frame = new JFrame("Buy Product");
    JLabel buy_label = new JLabel("BUY PRODUCT");

    JButton buy = new JButton("Buy Product");
    JButton chat_to_seller = new JButton("Chat to Seller");
    JButton goto_menu = new JButton("Go to Menu");

    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);
    GUI temp;

    static String Product_ID;

    static int seller_index = -1, Product_index, Seller_Product_index;

    static int main_buyer_index, main_seller_index;

    static String number_of_days;

    static String s;

    Buy_Product(GUI temp, String id, String nod, String s) {
        this.temp = temp;
        Product_ID = id;
        Buy_Product.s = s;
        number_of_days = nod;

        setProduct_index();
        frame_setting();
        text();
        Product_Button();
        Chat_Button();
        Menu_Button();
    }

    void frame_setting() {
        buy_frame.setVisible(true);
        buy_frame.setResizable(false);
        buy_frame.setLayout(null);
        buy_frame.setBounds(500, 50, 500, 500);
        buy_frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        buy_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void text() {
        buy_label.setBounds(170, 0, 500, 50);
        buy_label.setFont(f1);
        buy_frame.add(buy_label);
    }

    void Product_Button() {
        buy.setBounds(145, 110, 200, 50);
        buy_frame.add(buy);
        buy.addActionListener(this);
    }

    void Chat_Button() {
        chat_to_seller.setBounds(145, 170, 200, 50);
        buy_frame.add(chat_to_seller);
        chat_to_seller.addActionListener(this);
    }

    void Menu_Button() {
        goto_menu.setBounds(145, 230, 200, 50);
        buy_frame.add(goto_menu);
        goto_menu.addActionListener(this);
    }

    void setProduct_index() {

        int i, j;

        String seller_product_id;

        if (s.equals("sell")) {
            //for main product index
            for (i = 0; i <= Main.active_product_index; i++) {
                if (Main.all_products_sell[i].product_ID.equals(Product_ID)) {
                    Product_index = i;
                    break;
                }
            }

            //for seller product index and seller index
            boolean flag = false;
            for (i = 0; i < Main.sell_count; i++) {
                for (j = 0; j < Main.s[i].active_product_count; j++) {
                    if (Main.s[i].active_product[j].product_ID.equals(Main.all_products_sell[Product_index].product_ID)) {
                        Seller_Product_index = j;
                        seller_index = i;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }


        } else if (s.equals("rent")) {
            for (i = 0; i <= Main.active_rent_index; i++) {
                if (Main.all_products_rent[i].product_ID.equals(Product_ID)) {
                    Main.all_products_rent[i].rent.setNo_of_days(number_of_days);
                    Main.all_products_rent[i].setPrice(Integer.parseInt(number_of_days) * Main.all_products_rent[i].rent.price_per_day);
                    Product_index = i;
                    break;
                }
            }

            boolean flag = false;
            for (i = 0; i < Main.rent_count; i++) {
                for (j = 0; j < Main.r[i].active_Product_List_count; j++) {
                    if (Main.r[i].active_product_List[j].product_ID.equals(Main.all_products_rent[Product_index].product_ID)) {
                        Main.r[i].active_product_List[j].rent.setNo_of_days(number_of_days);
                        Main.r[i].active_product_List[j].setPrice(Integer.parseInt(number_of_days) * Main.all_products_rent[i].rent.price_per_day);
                        Seller_Product_index = j;
                        seller_index = i;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(buy)) {
            if (s.equals("sell")) {
                boolean flag=false;
                if (Main.s[Main.sell_index] != null) {
                    if (Main.s[seller_index].ID == Main.s[Main.sell_index].ID) {
                        JOptionPane.showMessageDialog(null, "You cannot Buy your Product");
                    } else {
                        flag = true;
                    }
                } else {
                    flag = true;
                }

                if (flag) {
                    if (Main.b[Main.buy_index].balance < Main.all_products_sell[Product_index].price) {
                        JOptionPane.showMessageDialog(null, "Not Enough money");
                    } else {
                        Main.p[Main.index].setBalance(Main.p[Main.index].balance - Main.all_products_sell[Product_index].price);
                        Main.b[Main.buy_index].setBalance(Main.b[Main.buy_index].balance - Main.all_products_sell[Product_index].price);
                        Main.b[Main.buy_index].set_buy_products(Main.all_products_sell[Product_index]);

                        Main.p[Main.s[seller_index].ID].setBalance(Main.p[Main.s[seller_index].ID].balance + Main.all_products_sell[Product_index].price);
                        Main.s[seller_index].set_sold_products(Main.all_products_sell[Product_index]);
                        Main.s[seller_index].setBalance(Main.s[seller_index].balance + Main.all_products_sell[Product_index].price);

                        Product[] remove = new Product[Main.s[seller_index].active_product_count - 1];
                        for (int i = 0, k = 0; i < Main.s[seller_index].active_product_count; i++) {
                            if (i != Seller_Product_index) {
                                remove[k] = Main.s[seller_index].active_product[i];
                                k++;
                            }
                        }

                        Main.s[seller_index].active_product_count -= 1;

                        if (Main.s[seller_index].active_product_count == 0) {
                            Main.s[seller_index].active_product[Main.s[seller_index].active_product_count] = null;
                        } else {
                            for (int i = 0; i < Main.s[seller_index].active_product_count; i++) {
                                Main.s[seller_index].active_product[i] = remove[i];
                            }
                        }

                        Product[] temp_remove = new Product[Main.active_product_index - 1];

                        for (int i = 0, j = 0; i < Main.active_product_index; i++) {
                            if (i != Product_index) {
                                temp_remove[j] = Main.all_products_sell[i];
                                j++;
                            }
                        }
                        Main.active_product_index -= 1;

                        if (Main.active_product_index == 0) {
                            Main.all_products_sell[Main.active_product_index] = null;
                        } else {
                            for (int i = 0; i < Main.active_product_index; i++) {
                                Main.all_products_sell[i] = temp_remove[i];
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Product Bought Successfully");
                        buy_frame.dispose();
                        Buy_product_panel.buy_frame.setVisible(true);
                    }

                }
            }else if (s.equals("rent")) {
                boolean flag=false;
                if(Main.r[Main.rent_index]!=null)
                {
                    if(Main.r[Main.rent_index].ID==Main.r[seller_index].ID)
                    {
                        JOptionPane.showMessageDialog(null, "You cannot Rent your Product");
                    }
                    else
                    {
                        flag=true;
                    }
                }
                else
                {
                    flag=true;
                }

                if(flag)
                {
                    if (Main.b[Main.buy_index].balance < Main.all_products_rent[Product_index].price) {
                        JOptionPane.showMessageDialog(null, "Not Enough money");
                    } else {
                        Main.p[Main.b[Main.buy_index].ID].setBalance(Main.p[Main.b[Main.buy_index].ID].balance - Main.all_products_rent[Product_index].price);
                        Main.b[Main.buy_index].setBalance(Main.b[Main.buy_index].balance - Main.all_products_rent[Product_index].price);
                        Main.b[Main.buy_index].set_buy_products(Main.all_products_rent[Product_index]);


                        Main.p[Main.r[seller_index].ID].setBalance(Main.p[Main.r[seller_index].ID].balance + Main.all_products_rent[Product_index].price);
                        Main.r[seller_index].add_Sold_Product(Main.all_products_rent[Product_index]);
                        Main.r[seller_index].setBalance(Main.r[seller_index].balance + Main.all_products_rent[Product_index].price);

                        Product[] remove = new Product[Main.r[seller_index].active_Product_List_count - 1];
                        for (int i = 0, k = 0; i < Main.r[seller_index].active_Product_List_count; i++) {
                            if (i != Seller_Product_index) {
                                remove[k] = Main.r[seller_index].active_product_List[i];
                                k++;
                            }
                        }

                        Main.r[seller_index].active_Product_List_count -= 1;

                        if (Main.r[seller_index].active_Product_List_count == 0) {
                            Main.r[seller_index].active_product_List[Main.r[seller_index].active_Product_List_count] = null;
                        } else {
                            for (int i = 0; i < Main.r[seller_index].active_Product_List_count; i++) {
                                Main.r[seller_index].active_product_List[i] = remove[i];
                            }
                        }

                        Product[] temp_remove = new Product[Main.active_rent_index - 1];

                        for (int i = 0, j = 0; i < Main.active_rent_index; i++) {
                            if (i != Product_index) {
                                temp_remove[j] = Main.all_products_rent[i];
                                j++;
                            }
                        }
                        Main.active_rent_index -= 1;

                        if (Main.active_rent_index == 0) {
                            Main.all_products_rent[Main.active_rent_index] = null;
                        } else {
                            for (int i = 0; i < Main.active_rent_index; i++) {
                                Main.all_products_rent[i] = temp_remove[i];
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Product Bought Successfully");
                        buy_frame.dispose();
                        Buy_product_panel.buy_frame.setVisible(true);
                    }
                }
            }
        } else if (e.getSource().equals(chat_to_seller)) {
            if (Main.s[seller_index] == Main.s[Main.sell_index]) {
                JOptionPane.showMessageDialog(null, "You cannot send message to yourself");
            } else {
                new Chat_To_Seller(temp, Product_index, s);
                buy_frame.dispose();
            }
        } else if (e.getSource().equals(goto_menu)) {
            Buy_product_panel.buy_frame.setVisible(true);
            buy_frame.dispose();
        }
    }
}