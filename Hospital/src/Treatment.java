
import java.util.Scanner;

 public class Treatment {
    static Scanner scan= new Scanner(System.in);
    protected static int numOfTreatment=0;
    protected Date1 date;
    protected double cost;


    public Treatment(int numOfTreatment, int day1,int month1,int year1, double cost) {
        this.numOfTreatment = numOfTreatment;
        date=new Date1(day1,month1,year1);
        this.cost = cost;
    }


}
