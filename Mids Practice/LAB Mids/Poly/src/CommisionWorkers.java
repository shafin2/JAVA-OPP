public class CommisionWorkers extends Employee{

    public CommisionWorkers(char employeeType, int iD, String name, double work, double pay) {
        super(employeeType, iD, name, work, pay);
    }

    @Override
    public String toString() {
        return "Employee [employeeType=" + employeeType + ", ID=" + ID + ", name=" + name + ", work=" + work + ", pay="
        + pay + "]";
    }

  

    
}
