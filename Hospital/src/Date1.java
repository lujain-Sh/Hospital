import java.util.Scanner;

public class Date1{
    int day;
    int month;
    int year;
static Scanner scan =new Scanner(System.in);



    public Date1(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return   day +
                "/" + month +
                "/" + year ;

    }
public static boolean compare(Date1 d1,Date1 d2)
{
    //d1 pa >>>>>>> d2 start
    if(d1.year<d2.year) return false;
    else if(d1.year> d2.year) return true;
    else {
        if (d1.month < d2.month) return false;
        else if (d1.month > d2.month) return true;
        else {
            if (d1.day < d2.day) return false;
            else if (d1.day >= d2.day) return true;
        }
    }
    return true;
}
public Date1 countDifference(Date1 D1,Date1 D2)
{
    int month,day;
    if(D1.day>= D2.day) day= D1.day- D2.day;
    else {D1.month--; day=D1.day+30- D2.day;}
    if(D1.month>= D2.month) month= D1.month-D2.month;
    else{ D1.year--; month =D1.month+12- D2.month;}
    Date1 d=new Date1(day, month, D1.year- D2.year);
    return d;
}

    }
