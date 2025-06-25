//create a class for Full Time Employees by extending the class AbstractEmployee
public class FullTimeEmployee extends AbstractEmployee {

    //an instance variable that holds Annual Salary
    double annualSalary;

    //parameterized constructor of the class
    FullTimeEmployee(String name, String id, String department, double bSalary, double annualSalary) {

        //calling superclass constructor by passing values
        super(name, id, department, bSalary);

        //assign values for instance variable
        this.annualSalary = annualSalary;


    }

    //override the method called calculateSalary() which essential to override as it get inherited from the parent class since it was Abstract
    @Override
    public double calculateSalary() {

        //return the salary by adding
        return bSalary + annualSalary;
    }

    //override the method called getDetails() which essential to override as it get inherited from the parent class since it was Abstract
    @Override
    public String getDetails() {

        //return details
        return super.getDetails() + "Initial salary : " + bSalary + "\nAnnual salary  : " + annualSalary + "\nTotal Salary   : " + calculateSalary();
    }
}
