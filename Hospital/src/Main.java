import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        //0 for emergency ,1 for eyeSection, 2 chestSection , 3 for GeneralSurgeries
        //1 for internal clinic, 2 eyeclinic ,3 digestion clinic
        while (true) {
            System.out.println("enter 1 for printing all doctors in order");
            System.out.println("enter 2 for printing all patients in order");
            System.out.println("enter 3 to add a doctor");
            System.out.println("enter 4 to remove a doctor");
            System.out.println("enter 5 to make a training doctor basic:");
            System.out.println("enter 6 to print number of contractor doctors: ");
            System.out.println("enter 7 to print all doctors working in a specific duration: ");
            System.out.println("enter 8 to add a new patient");
            System.out.println("enter 9 to quit a patient ");
            System.out.println("enter 10 to add treatment to a patient ");
            System.out.println("enter 11 to print all patients in hospital during a specific time");
            System.out.println("enter 12 to print the treatments of a patient");
            System.out.println("enter 13 to count number of patients in a section in a duration");
            System.out.println("enter 14 to exit ");

            int x = scan.nextInt();
            switch (x) {
                case 1: {
                    if(Doctor.AllDoctors.isEmpty()) System.out.println("we still don't have doctors");
                    else {Collections.sort(Doctor.AllDoctors, new Comparator<Doctor>() {
                        @Override
                        public int compare(Doctor o1, Doctor o2) {
                            return Integer.compare(o1.number, o2.number);
                        }
                    });
                    System.out.println(Doctor.AllDoctors);}

                    break;
                }
                case 2: {
                    if(Patient.AllPatients.isEmpty()) System.out.println("we don't have patients");
                    else{ Collections.sort(Patient.AllPatients, new Comparator<Patient>() {

                        @Override
                        public int compare(Patient o1, Patient o2) {
                            return Integer.compare(o1.number, o2.number);
                        }
                    });
                    System.out.println(Patient.AllPatients);}

                    break;
                }
                case 3: {

                    Doctor.AllDoctors.add(Doctor.AddDoctor());


                    break;
                }
                case 4: {
                    Doctor d = Doctor.ChooseDoctor(0, 100);
                    if(d==null){break;}
                    if (d instanceof ContractorDoctor) ContractorDoctor.setCount(ContractorDoctor.getCount()-1);
                    Doctor.AllDoctors.remove(d);
                    System.out.println("Enter date of removing:day");
                    int day1 = scan.nextInt();
                    System.out.print(" month: ");
                    int month1 = scan.nextInt();
                    System.out.print(" year: ");
                    int year1 = scan.nextInt();
                    d.setEND_DELETED(day1, month1, year1);
                    Doctor.DeletedDoctors.add(d);
                    break;
                }
                case 5: {
                    TrainingDoctor D = TrainingDoctor.FindTdoctor();
                    if(D==null) break;
                    System.out.println("Choose the section the doctor will be in: ");
                    System.out.println("0 for emergency ,1 for eyeSection, 2 chestSection , 3 for GeneralSurgeries");
                    int y = scan.nextInt();
                    Doctor OBJ = new BasicDoctor(D.number, D.name, D.address, D.birth, y, D.getBsalary(), D.getStartTraining());

                        Doctor.AllDoctors.remove(D);
                        Doctor.AllDoctors.add(OBJ);


                    break;
                }
                case 6: {
                    System.out.println("num is "+ContractorDoctor.getCount());
                    break;
                }
                case 7: {
                    Doctor.PrintDoctors();
                    break;
                }
                case 8: {
                    Patient.AllPatients.add(Patient.addPatient());
                    break;
                }
                case 9: {
                    Patient.ChoosePatient( 1,11);
                    break;
                }
                case 10: {
                    if(Patient.AllPatients.size() == 0){System.out.println("we don't have patients yet"); break;}
                   while (true){
                    System.out.println("press 0 to add external treatment /1 internal treatment");
                    int c = scan.nextInt();
                    if (c==0) {
                        ExternalPatient EX = (ExternalPatient) Patient.ChoosePatient( 0,0);
                        EX.externalTreatment.add(ExternalTreatment.addExTreatment()); break;
                    } else if(c==1){
                        InternalPatient IN = (InternalPatient) Patient.ChoosePatient( 0,1);
                        IN.internalTreatment.add(InternalTreatment.addInTreatment()); break;
                    }
                   }

                    break;
                }
                case 11: {
                    Patient.print_AllPatients_inDuration();
                    break;
                }
                case 12: {
                    Patient.printTreatments();
                    break;
                }
                case 13: {
                    Patient.countP_inSection();
                    break;
                }
                case 14: {
                    return;
                }
                default: {
                    System.out.println("CHOOSE NUMBER FROM 1-14");
                    break;
                }
            }

        }

    }

}