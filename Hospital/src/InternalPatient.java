import java.util.ArrayList;
import java.util.List;

public class InternalPatient extends ExternalPatient{
    private Date1 dateOfAccepting;
    protected List <InternalTreatment> internalTreatment=new ArrayList<>();
    private int leave;
    private Date1 dateOfLeaving;

    public Date1 getDateOfAccepting() {
        return dateOfAccepting;
    }

    public void setDateOfLeaving(Date1 dateOfLeaving) {
        this.dateOfLeaving = dateOfLeaving;
    }

    public void setLeave(int leave) {
        this.leave = leave;
    }


    public int getLeave() {
        return leave;
    }


    public InternalPatient(int number, String name, String address, int day, int month, int year, int day1, int month1, int year1,
                           List<ExternalTreatment> externalTreatment, int day3, int month3, int year3, List<InternalTreatment> internalTreatment,
                           int leave, int day4, int month4, int year4 ) {
        super(number, name, address, day, month,year,day1,month1,year1, externalTreatment);
        this.internalTreatment = internalTreatment;
        this.leave = leave;
        this.dateOfAccepting=new Date1(day3, month3,year3);
        this.dateOfLeaving = new Date1(day4, month4,year4);

    }
    public InternalPatient(int number, String name, String address,int day,int month,int year,int day1,int month1,int year1,
                           List<ExternalTreatment> externalTreatment,int day3,int month3,int year3,  List<InternalTreatment> internalTreatment,
                           int leave) {
        super(number, name, address, day, month,year,day1,month1,year1, externalTreatment);
        this.internalTreatment = internalTreatment;
        this.leave = leave;
        this.dateOfAccepting=new Date1(day3, month3,year3);

    }
public void printInTreatment()
{
    printExTreatment();
    System.out.println( "the internal treatment : "+ internalTreatment);
}

    @Override
    public String toString() {
        return "InternalPatient{" +
                "dateOfAccepting=" + dateOfAccepting +
                ", internalTreatment=" + internalTreatment +
                ", leave=" + leave +
                ", dateOfLeaving=" + dateOfLeaving +
                ", externalTreatment=" + externalTreatment +
                ", accepted=" + getAccepted() +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                ", dateOfEnterance=" + dateOfEnterance +
                '}'+"\n";
    }
}
