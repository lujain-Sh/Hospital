import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Patient {
    static List<Patient> AllPatients = new ArrayList<>();
    static Scanner scan= new Scanner(System.in);

    protected int number;
    protected String name;
    protected String address;
    protected Date1 birth;
    protected Date1 dateOfEnterance;

    public Patient(int number, String name, String address,int day,int month,int year,int day1,int month1,int year1) {
        this.number = number;
        this.name = name;
        this.address = address;
        birth = new Date1(day,month,year);
        dateOfEnterance =new Date1(day1,month1,year1);
    }
    public String printName(){
        return " name='" + name +"" +
                "\n";
    }

    @Override
    public String toString() {
        return "Patient{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                ", dateOfEnterance=" + dateOfEnterance +
                '}'+"\n";
    }
    public static void countP_inSection() {
        System.out.println("Enter number of section : 0- emergency ,1- eyeSection, 2- chestSection , 3- GeneralSurgeries");
        int num = scan.nextInt();
        System.out.println("ENTER DURATION: first date: day ");
        int day1 = scan.nextInt();
        System.out.print("month:");
        int month1 = scan.nextInt();
        System.out.print("year:");
        int year1 = scan.nextInt();
        System.out.println("Final date: day ");
        int day2 = scan.nextInt();
        System.out.print("month:");
        int month2 = scan.nextInt();
        System.out.print("year:");
        int year2 = scan.nextInt();
        Date1 d1 = new Date1(day1, month1, year1);
        Date1 d2 = new Date1(day2, month2, year2);
        int count = 0;
        for (Patient p : AllPatients)
            if (p instanceof InternalPatient)
                for (InternalTreatment T : ((InternalPatient) p).internalTreatment)
                    if (T.getNumOfSection() == num && Date1.compare(((InternalPatient) p).getDateOfAccepting(), d1) && Date1.compare(d2, ((InternalPatient) p).getDateOfAccepting()))
                        count++;
        if (num == 0) {
            for (Patient p : AllPatients)
                if (p instanceof ExternalPatient &&  Date1.compare(p.dateOfEnterance,d1) && Date1.compare(d2,p.dateOfEnterance) )
                    for (ExternalTreatment T : ((ExternalPatient) p).externalTreatment)
                        if (T.getNumOfClinic() == 0 ) count++;

        }
        System.out.println("The number of patients in this section: " + count );
    }
    public static void printTreatments() {
        Patient P = ChoosePatient( 0,0);
        if(P==null) return;
        if (P instanceof ExternalPatient) ((ExternalPatient) P).printExTreatment();
        else if (P instanceof InternalPatient) ((InternalPatient) P).printInTreatment();
    }

    public static void print_AllPatients_inDuration() {
        System.out.println("ENTER DURATION: first date: day ");
        int day1 = scan.nextInt();
        System.out.print("month:");
        int month1 = scan.nextInt();
        System.out.print("year:");
        int year1 = scan.nextInt();
        System.out.println("Final date: day ");
        int day2 = scan.nextInt();
        System.out.print("month:");
        int month2 = scan.nextInt();
        System.out.print("year:");
        int year2 = scan.nextInt();
        Date1 d1 = new Date1(day1, month1, year1);
        Date1 d2 = new Date1(day2, month2, year2);
        for (Patient p : Patient.AllPatients) {
            if (Date1.compare(p.dateOfEnterance, d1) && (Date1.compare(d2, p.dateOfEnterance)))
                System.out.println(p);
        }
    }
    public static Patient ChoosePatient( int z , int y) {
        int i = 0;
        if(Patient.AllPatients.size() == 0){System.out.println("we don't have patients yet"); return null;}
        if (z == 0) {
            if(y==0) {
                System.out.println("choose number of the patient :");
                for (Patient d : AllPatients)
                    System.out.print(" " + ++i + "_ " + d.printName());

                int x = scan.nextInt();
                i = 0;
                for (Patient d : AllPatients) {
                    i++;
                    if (i == x) return d;
                }
                return null;
            }
            else {
                System.out.println("choose number of the patient :");
                for (Patient d : AllPatients)
                    if(d instanceof InternalPatient) System.out.print(" " + ++i + "_ " + d.printName());
                if(i==0) {System.out.println("we don't have internal patients yet"); return null;}

                int x = scan.nextInt();
                i = 0;
                for (Patient d : AllPatients) {
                    if(d instanceof InternalPatient) i++;
                    if (i == x) return d;
                }
                return null;
            }
            }
         else {
            for (Patient d : AllPatients)
                if (d instanceof InternalPatient && ((InternalPatient) d).getLeave() == 0)
                    System.out.print(" " + ++i + "_ " + d.printName());

            int x = scan.nextInt();
            i = 0;
            for (Patient d : AllPatients) {
                if (d instanceof InternalPatient && ((InternalPatient) d).getLeave() == 0) i++;
                if (i == x) {
                    ((InternalPatient) d).setLeave(1);
                    System.out.println("enter date of leaving: day: ");
                    int day = scan.nextInt();
                    System.out.print("month:");
                    int month = scan.nextInt();
                    System.out.print("year:");
                    int year = scan.nextInt();
                    Date1 date1 = new Date1(day, month, year);
                    ((InternalPatient) d).setDateOfLeaving(date1);
                    return d;
                }
            }
            return null;
        }
    }
    public static Patient addPatient() {
        System.out.println("enter number of patient:");
        int number = scan.nextInt();
        scan.nextLine();
        System.out.println("enter name:");
        String name = scan.nextLine();
        System.out.println("enter address:");
        String address = scan.nextLine();
        System.out.print("enter date of birth: day:");
        int day1 = scan.nextInt();
        System.out.print(" month: ");
        int month1 = scan.nextInt();
        System.out.print(" year: ");
        int year1 = scan.nextInt();
        System.out.print("enter date of entrance: day:");
        int day2 = scan.nextInt();
        System.out.print(" month: ");
        int month2 = scan.nextInt();
        System.out.print(" year: ");
        int year2 = scan.nextInt();
        System.out.println("enter number of external treatments to add:");
        int n = scan.nextInt();
        List<ExternalTreatment> exTreatments = new ArrayList<>();
        for (int i = 0; i < n; i++){
            exTreatments.add(ExternalTreatment.addExTreatment());
          if(ExternalTreatment.numOfTreatment==0) return null;
           }
        ExternalTreatment.numOfTreatment = 0;//?
        while(true){
        System.out.println("Do you want to accept the patient?...press 1 to accept/ 0 to reject");
        int c = scan.nextInt();
        if (c == 1) {
            System.out.print("enter date of acceptance:day:");
            int day3 = scan.nextInt();
            System.out.print(" month: ");
            int month3 = scan.nextInt();
            System.out.print(" year: ");
            int year3 = scan.nextInt();
            System.out.println("enter number of internal treatments to add:");
            int r = scan.nextInt();
            List<InternalTreatment> inTreatments = new ArrayList<>();
            for (int i = 0; i < r; i++){
                inTreatments.add(InternalTreatment.addInTreatment());
                if( InternalTreatment.numOfTreatment == 0) {System.out.println("the patient will still be external// no doctors working here.."); return null;}}
            InternalTreatment.numOfTreatment = 0;
            while (true) {
                System.out.println("will the patient leave?...press 1 to leave/ 0 to stay");
                int w = scan.nextInt();
                if (w == 1) {
                    System.out.print("enter date of leaving: day");
                    int day4 = scan.nextInt();
                    System.out.print("month:");
                    int month4 = scan.nextInt();
                    System.out.print("year:");
                    int year4 = scan.nextInt();
                    Patient internalPatient = new InternalPatient(number, name, address, day1, month1, year1, day2, month2, year2, exTreatments, day3, month3, year3, inTreatments, w, day4, month4, year4);
                    return internalPatient;
                } else if (w == 0) {
                    Patient internalPatient = new InternalPatient(number, name, address, day1, month1, year1, day2, month2, year2, exTreatments, day3, month3, year3, inTreatments, w);
                    return internalPatient;
                } else System.out.println("0 or 1");
            }
        }
        else if(c==0) {
            Patient externalPatient = new ExternalPatient(number, name, address, day1, month1, year1, day2, month2, year2, exTreatments, c);
            return externalPatient;
        }
        else System.out.println("0 or 1");
        }
    }


}
