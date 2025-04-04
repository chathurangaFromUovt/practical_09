import java.util.ArrayList;
import java.util.Scanner;

public class HospitalPatientManagementSystem {

    private final Scanner sn;
    private final ArrayList<Person> doctorList;

    HospitalPatientManagementSystem(){

        this.sn = new Scanner(System.in);
        this.doctorList = new ArrayList<>();
    }

    static void dashboard(){

        String info = """
        ===========================================
            Hospital Patient Management System
        ===========================================
       \s
            [1] Add New Doctor
            [2] Add New Patient
            [3] Assign Doctor to Patient
            [4] Show All Patients
            [5] Show All Doctors
            [6] Exit
           \s
        ===========================================
                          Thanks!
        ===========================================
       \s""";

        System.out.println(info);

    }

    void doctor(){

        String id, name, specialization;

        System.out.print("Enter ID : ");
        id = sn.nextLine();

        System.out.print("Enter Name : ");
        name = sn.nextLine();

        System.out.print("Enter Specialization : ");
        specialization = sn.nextLine();

        try{

            Person newDoctor = new Doctor(id, name, specialization);
            doctorList.add(newDoctor);
            System.out.println("Doctor added successfully!\n");

        } catch (Exception e){

            System.out.println("Doctor creation error");
        }
    }

    void showDoctors(){

        for (Person doctor : doctorList){
            System.out.println(doctor.getInfo() + "\n");
        }
    }

    static void system() {

        HospitalPatientManagementSystem system = new HospitalPatientManagementSystem();

        while (true) {
            System.out.print("Enter your key : ");
            String input = system.sn.nextLine();

            switch (input) {
                case "1":
                    system.doctor();
                    break;

                case "5":
                    system.showDoctors();
                    break;

                case "6":
                    System.out.println("Exiting... Thanks!");
                    system.sn.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void main(String[] args) {

        dashboard();
        system();

    }
}