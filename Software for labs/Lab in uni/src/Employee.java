public class Employee {
    
    private String employeeID;
    private String employeeName;
    private String employeeDesignation;
    public Employee(String employeeID, String employeeName, String employeeDesignation) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeDesignation = employeeDesignation;
    }
    public String getEmployeeID() {
        return employeeID;
    }
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getEmployeeDesignation() {
        return employeeDesignation;
    }
    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }
    @Override
    public String toString() {
        return "Employee [employeeDesignation=" + employeeDesignation + ", employeeID=" + employeeID + ", employeeName="
                + employeeName + "]";
    }
    public boolean equals(Object obj) {
        Employee p1=(Employee)obj;
        boolean equal=false;
        if(this.employeeID==p1.employeeID){
            equal=true;
        }
        return equal;
    }
    public Object clone(){
        Object temp=new Employee(this.employeeID, this.employeeName, this.employeeDesignation);
        return temp;
    }
}
