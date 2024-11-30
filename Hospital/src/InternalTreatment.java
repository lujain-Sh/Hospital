import java.util.ArrayList;
import java.util.List;

public class InternalTreatment extends Treatment{
  private int numOfSection;
   List<Doctor> doctors ;

  public int getNumOfSection() {
    return numOfSection;
  }

  public InternalTreatment(int numOfTreatment, int day, int month, int year, double cost, int numOfSection, List<Doctor> doctors) {
    super(numOfTreatment,day,month,year, cost);
    this.numOfSection = numOfSection;
    this.doctors = doctors;
  }

  @Override
  public String toString() {
    return "InternalTreatment{" +
            "numOfSection=" + numOfSection +
            ", doctors=" + doctors +
            ", date=" + date +
            ", cost=" + cost +
            '}'+"\n ";
  }
  public static InternalTreatment addInTreatment() {
    System.out.print("enter date of treatment: day");
    int day = scan.nextInt();
    System.out.print("month:");
    int month = scan.nextInt();
    System.out.print("year:");
    int year = scan.nextInt();

    System.out.println("enter the cost of this treatment:");
    double cost = scan.nextDouble();
    System.out.println("choose number of section to be treated in:0-emergency ,1-eyeSection, 2-chestSection ,3-GeneralSurgeries ");
    int numOfSection = scan.nextInt();
    List<Doctor> doctors = new ArrayList<>();
    System.out.println("enter number of doctors working for this treatment:");
    int n = scan.nextInt();
    for (int i = 0; i < n  ; i++) {
      Doctor d=Doctor.ChooseDoctor( 0, 100);
      if(d==null) return null;
      if(d instanceof ContractorDoctor) ((ContractorDoctor) d).setPay( ((ContractorDoctor) d).getPay()+0.5*cost);
      doctors.add(d);
    }
    InternalTreatment inTreatment = new InternalTreatment(++InternalTreatment.numOfTreatment, day, month, year, cost, numOfSection, doctors);
    return inTreatment;
  }

}
