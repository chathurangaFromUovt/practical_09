//create an abstract class called AbstractEmployee and get implements from the interface created previous called Employee
public abstract class AbstractEmployee implements Employee {

    // declare four instance variables following the type String
    String name, department, id, details;

    // declare an instance variables following the type double
    double bSalary;

    //parameterized constructor of the class by catching passing value when super() method get called
    AbstractEmployee(String name, String id, String department, double bSalary) {

        //initiate values for instance variables using THIS keyword despite the coalition of variables which created under the same names
        this.name = name;
        this.department = department;
        this.id = id;
        this.bSalary = bSalary;
    }

    // override the methods which inherited from Employee interface
    @Override
    public String getDetails() {

        //assign values for the instance variable, and format them so that can return when return is called
        this.details = "Name           : " + name + "\nID             : " + id + "\nDepartment     : " + department + "\n";

        //return formatted values
        return this.details;
    }

 /* No need to initiate because this cals ia an Abstract class, but subclasses must implement all methods of the Interface
    @Override
    public  double calculateSalary(){

        return 0;

    } */

}
