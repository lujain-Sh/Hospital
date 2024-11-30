

public class ExternalTreatment extends Treatment{
    //composition
    private int numOfClinic;
    private Doctor treatingDoctor;

    public int getNumOfClinic() {
        return numOfClinic;
    }


    public ExternalTreatment(int numOfTreatment, int day, int month, int year, double cost, int numOfClinic, Doctor treatingDoctor) {
        super(numOfTreatment, day,month,year, cost);
        this.numOfClinic = numOfClinic;
        this.treatingDoctor = treatingDoctor;
    }

    @Override
    public String toString() {
        return "ExternalTreatment{" +
                "numOfClinic=" + numOfClinic +
                ", treatingDoctor=" + treatingDoctor +
                ", date=" + date +
                ", cost=" + cost +
                '}'+"\n";
    }

    public static ExternalTreatment addExTreatment(){
        System.out.print("enter date of treatment: day");
        int day = scan.nextInt();
        System.out.print("month:");
        int month = scan.nextInt();
        System.out.print("year:");
        int year = scan.nextInt();
        System.out.println("enter the cost of this treatment:");
        double cost = scan.nextDouble();
        System.out.println("choose number of clinic to be treated in:0-emergency,1-internal clinic,2-eyeclinic ,3-digestion clinic ");
        int numOfClinic= scan.nextInt();
        Doctor TreatingDoctor =Doctor.ChooseDoctor(1,numOfClinic);
        if(TreatingDoctor==null) { System.out.println("add doctor: ");Doctor.AllDoctors.add(TreatingDoctor=Doctor.AddcDoctor()); }
        if(TreatingDoctor instanceof ContractorDoctor) ((ContractorDoctor) TreatingDoctor).setPay(((ContractorDoctor) TreatingDoctor).getPay()+0.5*cost);
        ExternalTreatment exTreatment = new ExternalTreatment(++ExternalTreatment.numOfTreatment,day,month,year,cost,numOfClinic,TreatingDoctor);
        return exTreatment;
    }

}
