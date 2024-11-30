public class BasicDoctor extends Doctor{
   private int numOfSection;
    private double salary;

    public int getNumOfSection() {
        return numOfSection;
    }

    public double getSalary() {
        return salary;
    }

    public BasicDoctor(int number, String name, String address,Date1 birth, int numOfSection, double salary,Date1 startWorking) {
        super(number, name, address,birth,startWorking);
        this.numOfSection = numOfSection;
        this.salary = salary;

    }

    @Override
    public String toString() {
        return "BasicDoctor{" +

                " number=" + number +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birth= " + birth +
                ", numOfSection=" + numOfSection +
                ", salary=" + salary +
                ", Start working=" + Start +
                '}'+"\n";
    }
}
