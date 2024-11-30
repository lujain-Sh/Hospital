import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Doctor {
    static List<Doctor> DeletedDoctors = new ArrayList<>();
    static List<Doctor> AllDoctors = new ArrayList<>();
    protected int number;
    protected String name;
    protected String address;
    protected Date1 birth;
    protected Date1 Start;
    protected Date1 END_DELETED;
    static Scanner scan=new Scanner(System.in);

    public Doctor(int number, String name, String address,Date1 birth,Date1 start ) {
        this.number = number;
        this.name = name;
        this.address = address;
        this.birth=birth;
       this.Start=start;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                '}'+"\n";
    }
    public String printName(){
        return " name='" + name +"" +
                "\n";
    }

    public void setEND_DELETED(int day,int month,int year) {
       END_DELETED =new Date1(day, month, year);
    }
    public static Doctor AddDoctor() {

        System.out.println("CHOOSE: 1-Basic doctor 2-Training doctor 3-Contractor doctor");
        int x = scan.nextInt();
        System.out.println("enter number of the doctor:");
        int number = scan.nextInt();
        scan.nextLine();
        System.out.println("enter name of the doctor:");
        String name = scan.nextLine();
        System.out.println("enter the address of the doctor:");
        String address = scan.nextLine();
        System.out.print("enter birth date: day:");
        int day = scan.nextInt();
        System.out.print("month:");
        int month = scan.nextInt();
        System.out.print("year:");
        int year = scan.nextInt();
        System.out.println();
        Date1 birth= new Date1(day,month,year);

        while (true) {
            switch (x) {
                case 1: {
                    System.out.print("enter date of start working:day: ");
                    int day1 = scan.nextInt();
                    System.out.print("month:");
                    int month1 = scan.nextInt();
                    System.out.print("year:");
                    int year1 = scan.nextInt();
                    Date1 start= new Date1(day1,month1,year1);
                    System.out.println();
                    System.out.println("enter number of section: 0- emergency, 1-eyeSection, 2-chestSection ,3-GeneralSurgeries ");
                    int numOfSection = scan.nextInt();
                    System.out.println("enter salary: ");
                    double salary = scan.nextInt();
                    Doctor doctor = new BasicDoctor(number, name, address,birth, numOfSection, salary, start);
                    return doctor;
                }
                case 2: {
                    System.out.println("enter date of startTraining: day:");
                    int day1 = scan.nextInt();
                    System.out.print(" month: ");
                    int month1 = scan.nextInt();
                    System.out.print(" year: ");
                    int year1 = scan.nextInt();
                    Date1 start= new Date1(day1,month1,year1);
                    System.out.print("enter date of endTraining: day:");
                    int day2 = scan.nextInt();
                    System.out.print(" month: ");
                    int month2 = scan.nextInt();
                    System.out.print(" year: ");
                    int year2 = scan.nextInt();
                    Date1 end= new Date1(day2,month2,year2);
                    int duration = year2 - year1;

                    if (duration > 2) {
                        System.out.println("this is a basic doctor enter 1");
                        x = scan.nextInt();
                        break;
                    } else {
                        System.out.println("Enter the basic salary ");
                        int bsalary = scan.nextInt();
                        Doctor doctor = new TrainingDoctor(number, name, address,birth,start,end, bsalary);
                        return doctor;
                    }
                }
                case 3: {
                    System.out.print("enter date of contract: day:");
                    int day1 = scan.nextInt();
                    System.out.print(" month: ");
                    int month1 = scan.nextInt();
                    System.out.print(" year: ");
                    int year1 = scan.nextInt();
                    Date1 startcont= new Date1(day1,month1,year1);
                    Doctor doctor = new ContractorDoctor(number, name, address,birth,startcont);
                    return doctor;
                }
                default:
                    System.out.println("choose 1 or 2 or 3");

            }

        }
    }
    public static Doctor AddcDoctor()
    {
        System.out.println("enter number of the doctor:");
        int number = scan.nextInt();
        scan.nextLine();
        System.out.println("enter name of the doctor:");
        String name = scan.nextLine();
        System.out.println("enter the address of the doctor:");
        String address = scan.nextLine();
        System.out.print("enter birth date: day:");
        int day = scan.nextInt();
        System.out.print("month:");
        int month = scan.nextInt();
        System.out.print("year:");
        int year = scan.nextInt();
        System.out.println();
        Date1 birth= new Date1(day,month,year);
        System.out.print("enter date of contract: day:");
        int day1 = scan.nextInt();
        System.out.print(" month: ");
        int month1 = scan.nextInt();
        System.out.print(" year: ");
        int year1 = scan.nextInt();
        Date1 startcont= new Date1(day1,month1,year1);
        Doctor doctor = new ContractorDoctor(number, name, address,birth,startcont);
        return doctor;
    }
    public static Doctor ChooseDoctor( int z, int EXclinic) {
        int i = 0;
        System.out.println("choose number of the doctor :");
        if(Doctor.AllDoctors.size()==0){System.out.println("we don't have doctors yet"); return null;}
        if (z == 0) {
            for (Doctor d : AllDoctors)
                System.out.print(" " + ++i + "_ " + d.printName());

            int x = scan.nextInt();
            i = 0;
            for (Doctor d : AllDoctors) {
                i++;
                if (i == x) return d;
            }
            return null;
        } else {
            for (Doctor d : AllDoctors)
                if ((!(d instanceof BasicDoctor)) || (d instanceof BasicDoctor && ((BasicDoctor) d).getNumOfSection() == 0 && EXclinic == 0))
                    System.out.print(" " + ++i + "_ " + d.printName());
            if(i==0) {System.out.println("we don't have doctors here yet"); return null;}
            int x = scan.nextInt();
            i = 0;
            for (Doctor d : AllDoctors) {
                if ((!(d instanceof BasicDoctor)) || (d instanceof BasicDoctor && ((BasicDoctor) d).getNumOfSection() == 0 && EXclinic == 0))
                    i++;
                if (i == x) return d;
            }
            return null;
        }
    }

    public static void PrintDoctors() {
        System.out.println("enter the year to find all doctors working during it:");
        int yearr = scan.nextInt();
        int x=0;
        for (Doctor D : AllDoctors) {
            if (D.Start.year <= yearr) {
                if (D instanceof TrainingDoctor && ((TrainingDoctor) D).getEndTraining().year >= yearr)
                {System.out.println(D); x++;}
                else if (!(D instanceof TrainingDoctor)) {System.out.println(D); x++;}
            }
        }

        for (Doctor D : DeletedDoctors) {
            if (D.Start.year <= yearr && D.END_DELETED.year >= yearr) {
                if (D instanceof TrainingDoctor && ((TrainingDoctor) D).getEndTraining().year >= yearr)
                {System.out.println(D); x++;}
                else if (!(D instanceof TrainingDoctor)){ System.out.println(D); x++;}
            }
        } if(x==0) {System.out.println("we don't have doctors in this year"); return ;}
    }


}
