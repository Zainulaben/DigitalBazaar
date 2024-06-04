public class Person {
    public int ID=0;
    public float balance;
    public String address;
    public String message;
    public Account a;

    public Account getA() {
        return a;
    }

    public void setA(Account a) {
        this.a = a;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return ID;
    }

    Person()
    {
        balance=0;
        address="NULL";
        message="NULL";
        a=new Account();
    }

    public void set_Data(String f_name,String l_name,String u_name,String p,int d,int m,int y)
    {
        a.setF_name(f_name);
        a.setL_name(l_name);
        a.setU_name(u_name);
        a.setPassword(p);
        a.setDOB(d,m,y);
    }


    public void setAddress(String address) {
        this.address = address;
    }

    void setBalance(float b)
    {
        balance=b;
    }

    public void display()
    {
        a.Display_Account_Data();
        System.out.printf("\nID : "+ID+"\n");
        System.out.printf("\nBalance : "+balance+"\n");
        System.out.printf("\nAddress : "+address+"\n");
    }

    public float getBalance() {
        return balance;
    }

    public String getAddress() {
        return address;
    }

}
