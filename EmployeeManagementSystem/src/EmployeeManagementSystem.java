import java.util.Scanner;

// the main class
public class EmployeeManagementSystem {

    // scanner type variable to store user inputs
    Scanner sn;

    // private Employee interface type variables
    private Employee fullTime;
    private Employee partTime;
    private Employee contractTime;

    //default constructor
    EmployeeManagementSystem() {

        //create a scanner object
        sn = new Scanner(System.in);
    }


    //a method for full time employees
    void fullTimeEmployee() {

        String name, id, department;
        double bSalary, annualSalary;

        System.out.println();
        System.out.print("Enter Name  : ");
        name = sn.nextLine();

        System.out.print("Enter ID : ");
        id = sn.nextLine();

        System.out.print("Enter Department  : ");
        department = sn.nextLine();

        System.out.print("Enter Initial salary  : ");
        bSalary = sn.nextDouble();

        System.out.print("Enter Annual salary  : ");
        annualSalary = sn.nextDouble();


        //try to assign an object for instance variable called fullTime
        try {

            fullTime = new FullTimeEmployee(name, id, department, bSalary, annualSalary);

        } catch (Exception e) {

            System.out.println("Object creation error");
        }

    }

    void partTimeEmployee() {

        String name, id, department;
        double bSalary, hourlyRate, workedHours;

        //ask user to enter inputs
        System.out.println();
        System.out.print("Enter Name  : ");
        name = sn.nextLine();

        System.out.print("Enter ID : ");
        id = sn.nextLine();

        System.out.print("Enter Department  : ");
        department = sn.nextLine();

        System.out.print("Enter Initial salary  : ");
        bSalary = sn.nextDouble();

        System.out.print("Enter Hourly Rate    : ");
        hourlyRate = sn.nextDouble();

        System.out.print("Enter Worked Hours   : ");
        workedHours = sn.nextDouble();

        try {

            partTime = new PartTimeEmployee(name, id, department, bSalary, hourlyRate, workedHours);

        } catch (Exception e) {

            System.out.println("Object creation error");
        }

    }

    void contractTimeEmployee() {

        String name, id, department;
        double bSalary, contractAmount, contractADuration;

        System.out.println();
        System.out.print("Enter Name  : ");
        name = sn.nextLine();

        System.out.print("Enter ID : ");
        id = sn.nextLine();

        System.out.print("Enter Department  : ");
        department = sn.nextLine();

        System.out.print("Enter Initial salary  : ");
        bSalary = sn.nextDouble();

        System.out.print("Enter Contract Amount    : ");
        contractAmount = sn.nextDouble();

        System.out.print("Enter ContractA Duration   : ");
        contractADuration = sn.nextDouble();

        try {

            contractTime = new ContractEmployee(name, id, department, bSalary, contractAmount, contractADuration);

        } catch (Exception e) {

            System.out.println("Object creation error");
        }

    }

    //a method for get details
    void getDetailsF() {

        System.out.println();
        System.out.println(fullTime.getDetails());
    }

    void getDetailsP() {

        System.out.println();
        System.out.println(partTime.getDetails());
    }

    void getDetailsC() {

        System.out.println();
        System.out.println(contractTime.getDetails());

    }


    //the main thread starts
    public static void main(String[] args) {

        //an instance variable to store the type of employees
        int type;

        System.out.println("\n---------------------------\nEmployee Management System\n---------------------------\n");

        //create an object of EmployeeManagementSystem class
        EmployeeManagementSystem run = new EmployeeManagementSystem();
        Scanner sn = new Scanner(System.in);

        System.out.println("1 : for Full-time");
        System.out.println("2 : for Part-time");
        System.out.println("3 : for Contract-time\n");

        System.out.print("Enter your selection : ");
        type = sn.nextInt();

        //creating a thread to handle fullTime employee method
        Thread ft = new Thread(run::fullTimeEmployee);

        //creating a thread to handle getDetails method of fullTime employee
        Thread getDetailsF = new Thread(run::getDetailsF);

        Thread pt = new Thread(run::partTimeEmployee);
        Thread getDetailsP = new Thread(run::getDetailsP);

        Thread ct = new Thread(run::contractTimeEmployee);
        Thread getDetailsC = new Thread(run::getDetailsC);

        if (type == 1) {

            //tread starts
            ft.start();

            //the main thread waits until the previous method gets finished
            try {
                ft.join();
            } catch (InterruptedException e) {
                System.out.println("Runtime error");
            }

        } else if (type == 2) {

            pt.start();

            try {
                pt.join();
            } catch (InterruptedException e) {
                System.out.println("Runtime error");
            }

        } else if (type == 3) {

            ct.start();

            try {
                ct.join();
            } catch (InterruptedException e) {
                System.out.println("Runtime error");
            }
        }


        System.out.println("\n1 : for Full-time");
        System.out.println("2 : for Part-time");
        System.out.println("3 : for Contract-time\n");
        System.out.print("Enter type to see details : ");
        type = sn.nextInt();

        if (type == 1) {

            getDetailsF.start();

            try {
                getDetailsF.join();
            } catch (InterruptedException e) {
                System.out.println("Runtime error");
            }

        } else if (type == 2) {

            getDetailsP.start();

            try {
                getDetailsP.join();
            } catch (InterruptedException e) {
                System.out.println("Runtime error");
            }

        } else if (type == 3) {

            getDetailsC.start();

            try {
                getDetailsC.join();
            } catch (InterruptedException e) {
                System.out.println("Runtime error");
            }
        }


        //close the scanner object to save resources
        run.sn.close();

        //the main thread waits until all other previous methods get finished
        System.out.println("\n---------------------------");

    }
}
