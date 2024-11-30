
import java.util.ArrayList;
import java.util.List;

public class ExternalPatient extends Patient{
    //aggregation
    protected List<ExternalTreatment> externalTreatment= new ArrayList<>();
    private int accepted;


    public int getAccepted() {
        return accepted;
    }

    public ExternalPatient(int number, String name, String address, int day, int month, int year, int day1, int month1, int year1, List<ExternalTreatment> externalTreatment, int accepted) {
        super(number, name, address, day, month,year,day1, month1,year1);
        this.externalTreatment = externalTreatment;
        this.accepted = accepted;
    }

    public ExternalPatient(int number, String name, String address, int day, int month, int year, int day1, int month1, int year1, List<ExternalTreatment> externalTreatment) {
        super(number, name, address, day, month, year, day1, month1, year1);
        this.externalTreatment = externalTreatment;
    }

    public void printExTreatment()
    {
        System.out.println("the external treatments: "+externalTreatment);
    }

    @Override
    public String toString() {
        return "ExternalPatient{" +
                "externalTreatment=" + externalTreatment +
                ", accepted=" + accepted +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                ", dateOfEnterance=" + dateOfEnterance +
                '}'+"\n";
    }
}
