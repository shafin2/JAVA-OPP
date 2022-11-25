public abstract class Employee {
    @Override
    public String toString() {
        return "Employee [employeeType=" + employeeType + ", ID=" + ID + ", name=" + name + ", work=" + work + ", pay="
                + pay + "]";
    }
    public Employee(char employeeType, int iD, String name, double work, double pay) {
        this.employeeType = employeeType;
        ID = iD;
        this.name = name;
        this.work = work;
        this.pay = pay;
    }
    
    public char employeeType;
    public int ID;
    public String name;
    public double work;
    public double pay;

    
    
}
