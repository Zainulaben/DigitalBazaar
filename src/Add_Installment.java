import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Installment implements ActionListener {
    public JFrame installment_frame=new JFrame("Installment");
    JLabel installment_l = new JLabel("ADD INSTALLMENT  ");

    JPanel labels=new JPanel();
    JPanel text_fields=new JPanel();



    JLabel id=new JLabel("Product ID : ");
    JLabel price=new JLabel("Price : ");
    JLabel advance=new JLabel("Advance : ");
    JLabel interest =new JLabel("Interest : ");
    JLabel month_price=new JLabel("Monthly_price : ");


    JButton submit = new JButton("Submit");
    JButton clear = new JButton("Clear");

    JTextField tf_id=new JTextField(0);
    JTextField tf_price=new JTextField(0);
    JTextField tf_advance=new JTextField(20);
    JTextField tf_interest=new JTextField(20);
    JTextField tf_month_price=new JTextField(20);
    JTextField greater_advance=new JTextField(20);
    JTextField monthly_price=new JTextField(20);


    Font f1 = new Font(Font.SERIF, Font.BOLD, 20);
    Font f2=new Font(Font.SANS_SERIF,Font.ITALIC,10);


    JButton back_b;

    GUI temp;

    Add_Installment(GUI temp)
    {
        this.temp=temp;

        frame_setting();
        inst_text();
        labels();
        set_panels();
        text_fields();
        Submit_Button();
        Clear_Button();
        back_button();

    }

    private void set_panels()
    {
        labels.setBounds(20,60,90,270);
        labels.setLayout(new GridLayout(5,1,1,1));
        labels.setBackground(Color.lightGray);
        installment_frame.add(labels);

        text_fields.setBounds(120,73,330,243);
        text_fields.setLayout(new GridLayout(5,1,1,25));
        text_fields.setBackground(null);
        installment_frame.add(text_fields);
    }

    private void inst_text()
    {
        installment_l.setBounds(160, 0, 500, 50);
        installment_l.setFont(f1);
        installment_frame.add(installment_l);
    }
    private void frame_setting()
    {
        installment_frame.setBounds(500, 50, 500, 500);
        installment_frame.setLayout(null);
        installment_frame.getContentPane().setBackground(Color.lightGray);
        installment_frame.setVisible(true);
        installment_frame.setResizable(false);
        installment_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void labels()
    {
        labels.add(id);
        labels.add(price);
        labels.add(advance);
        labels.add(interest);
        labels.add(month_price);

        greater_advance.setBounds(120, 167, 330, 12);
        greater_advance.setEditable(false);
        greater_advance.setBackground(null);
        greater_advance.setBorder(null);
        greater_advance.setText("Advance cannot be greater than product price");
        greater_advance.setFont(f2);
        greater_advance.setForeground(Color.red);
        greater_advance.setVisible(false);
        installment_frame.add(greater_advance);

        monthly_price.setBounds(120, 273, 330, 12);
        monthly_price.setEditable(false);
        monthly_price.setBackground(null);
        monthly_price.setBorder(null);
        monthly_price.setText("Enough monthly price");
        monthly_price.setFont(f2);
        monthly_price.setForeground(Color.red);
        monthly_price.setVisible(false);
        installment_frame.add(monthly_price);
    }


    private void text_fields()
    {

        tf_id.setEditable(false);
        tf_id.setBackground(Color.lightGray);
        tf_id.setBorder(null);
        if(Main.s[Main.sell_index].active_product_count!=0) {
            tf_id.setText(Main.s[Main.sell_index].active_product[Search_ID.Product_index].product_ID);
        }
        //tf_id.setText("P0");
        text_fields.add(tf_id);


        tf_price.setEditable(false);
        tf_price.setBackground(Color.lightGray);
        tf_price.setBorder(null);
        if(Main.s[Main.sell_index].active_product_count!=0) {
            tf_price.setText(Float.toString(Main.s[Main.sell_index].active_product[Search_ID.Product_index].price));
        }

        //tf_price.setText("10");
        text_fields.add(tf_price);

        text_fields.add(tf_advance);
        text_fields.add(tf_interest);
        text_fields.add(tf_month_price);


    }


    private void Submit_Button()
    {
        submit.setBounds(130, 370, 100, 40);
        // submit.setBackground(Color.gray);
        installment_frame.add(submit);
        submit.addActionListener(this);
    }

    private void Clear_Button()
    {
        clear.setBounds(270, 370, 100, 40);
        //clear.setBackground(Color.gray);
        installment_frame.add(clear);
        clear.addActionListener(this);
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
        installment_frame.add(back_b);
    }

    private void Clear ()
    {
        tf_advance.setText("");
        tf_interest.setText("");
        tf_month_price.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(back_b)){
            Category.category_frame.setVisible(true);
            installment_frame.dispose();
        }

        if(e.getSource().equals(clear))
        {
            Clear();
        }

        if(e.getSource().equals(submit)){
            if(tf_price.getText().equals("") || tf_advance.getText().equals("") || tf_interest.getText().equals("")||  tf_month_price.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill All Data");
            }
            else
            {
                float ad=Float.parseFloat(tf_advance.getText());
                float price=Main.s[Main.sell_index].active_product[Search_ID.Product_index].price;
                if(ad>price)
                {
                    greater_advance.setVisible(true);
                    monthly_price.setVisible(false);
                }
                else if(Float.parseFloat(tf_month_price.getText())>((Main.s[Main.sell_index].active_product[Search_ID.Product_index].price)-Float.parseFloat(tf_advance.getText())))
                {
                    greater_advance.setVisible(false);
                    monthly_price.setVisible(true);
                }
                else
                {
                    Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment=new Installment();
                    Main.s[Main.sell_index].active_product[Search_ID.Product_index].installment.set_inst_data(Float.parseFloat(tf_advance.getText()),Float.parseFloat(tf_interest.getText()),Float.parseFloat(tf_month_price.getText()));

                    JOptionPane.showMessageDialog(null,"Successfully Added");
                    Main.s[Main.sell_index].active_product[Search_ID.Product_index].display_product();

                    installment_frame.dispose();
                    Product_info.prod_frame.setVisible(true);
                }

            }

        }
        else if(e.getSource().equals(back_b))
        {
            installment_frame.dispose();
            Product_info.prod_frame.setVisible(true);
        }
    }

}
