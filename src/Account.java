class Date
{
    private int day;
    private int month;
    private int year;

    //Constructor
    Date()
    {
        day=0;
        month=0;
        year=0;
    }

    //Setter Function
    public void Set_ALL_Data_of_Date(int d,int m,int y)
    {
        setDay(d);
        setMonth(m);
        setYear(y);
    }
    public void setDay(int d)
    {
        if(d>0&&d<32)
        {
            day=d;
        }
        else
        {
            System.out.println("Invalid Day");
        }
    }
    public void setMonth(int m)
    {
        if(m>0&&m<13)
        {
            month=m;
        }
        else
        {
            System.out.println("Invalid Month");
        }
    }
    public void setYear(int year)
    {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    //Display Function
    public void Display_Date()
    {
        System.out.printf("Day/Month/Year : "+day+"/"+month+"/"+year);
    }

}




public class Account {
    String f_name;
    String l_name;
    String u_name;
    String password;
    public Date DOB;

    Account()
    {
        f_name="NULL";
        l_name="NULL";
        u_name="NULL";
        password="NULL";
        DOB=new Date();
    }

    //Setter Functions
    public void setF_name(String name)
    {
        f_name=name;
    }
    public void setL_name(String name)
    {
        l_name=name;
    }
    public void setU_name(String name)
    {
        u_name=name;
    }
    public void setPassword(String p)
    {
        password=p;
    }
    public void setDOB(int d,int m,int y)
    {
        DOB.Set_ALL_Data_of_Date(d,m,y);
    }


    //Getter Function
    public String getF_name()
    {
        return f_name;
    }
    public String getL_name()
    {
        return l_name;
    }
    public String getU_name()
    {
        return u_name;
    }
    public String getPassword()
    {
        return password;
    }
    public Date getDOB()
    {
        return DOB;
    }



    //Display Function
    public void Display_Account_Data()
    {
        System.out.printf("First Name : "+f_name+"\n");
        System.out.printf("Last Name : "+l_name+"\n");
        System.out.printf("User Name : "+u_name+"\n");
        System.out.printf("Password : "+password+"\n");
        DOB.Display_Date();

    }

}

