public class ContractorDoctor extends Doctor{

    private static int count = 0;
    private double pay;

    public static void setCount(int count) {
        ContractorDoctor.count = count;
    }

    public static int getCount() {
        return count;
    }

    public void setPay(double pay) {

        this.pay = pay;
    }

    public double getPay() {
        return pay;
    }

    public ContractorDoctor(int number, String name, String address, Date1 birth, Date1 start ) {
        super(number, name, address,birth,start);
        count ++;
    }

    @Override
    public String toString() {
        return "ContractorDoctor{" +
                "pay=" + pay +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                ", Start=" + Start +
                '}'+"\n";
    }
}
