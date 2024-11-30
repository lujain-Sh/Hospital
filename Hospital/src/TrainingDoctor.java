public class TrainingDoctor extends Doctor{
    private double bsalary;
    private Date1 startTraining;
    private Date1 endTraining;
    private Date1 duration;
    private double Tsalary;

    public double getBsalary() {
        return bsalary;
    }

    public Date1 getStartTraining() {
        return startTraining;
    }

    public Date1 getEndTraining() {
        return endTraining;
    }


    public TrainingDoctor(int number, String name, String address, Date1 birth, Date1 start, Date1 end, double bsalary) {
        super(number, name, address,birth,start);
        this.bsalary = bsalary;
       startTraining=start;
       endTraining =end;
       this.duration=startTraining.countDifference(endTraining,startTraining);
       this.Tsalary=CalculateTsalary();


    }
public double CalculateTsalary()
{
    if(duration.year==0||(duration.year==1 &&duration.month<=0 &&duration.day<=0 )) Tsalary=0.5*bsalary;
    else if((duration.year>=1 && duration.year<2)||(duration.year==2 && duration.month<=0 &&duration.day<=0) ) Tsalary=0.75*bsalary;
    return Tsalary;
}

    public static TrainingDoctor FindTdoctor() {
        int i = 0;
        System.out.println("choose number of training doctor to make it basic: ");
        for (Doctor s : AllDoctors) {
            if (s instanceof TrainingDoctor) System.out.print(" " + ++i + "_ " + s.printName());}
        if(i==0){System.out.println("Sorry..we don't have training doctors yet"); return null;}
        int x = scan.nextInt();
        i = 0;
        for (Doctor s : AllDoctors) {
            if (s instanceof TrainingDoctor) {
                ++i;
                if (i == x) return (TrainingDoctor) s;
            }

        }
        return null;
    }
    @Override
    public String toString() {
        return "TrainingDoctor{" +

                " number=" + number +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                ", startTraining=" + startTraining +
                ", endTraining=" + endTraining +
                ", duration=" + duration +
                ", Tsalary=" + Tsalary +
                '}'+"\n";
    }
}
