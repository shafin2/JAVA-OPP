public class Department {
    
    static private Lab labs[]=new Lab[20];
    private String name;
    private Employee labsIncharge;
    public Department(String name, Employee labsIncharge) {
        this.name = name;
        this.labsIncharge = labsIncharge;
        for(int i=0;i<labs.length;i++){
            labs[i]=new Lab("ICt lab", new Employee("4", "shafin", "attendant"));
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Employee getLabsIncharge() {
        return labsIncharge;
    }
    public void setLabsIncharge(Employee labsIncharge) {
        this.labsIncharge = labsIncharge;
    }
    public void showLabs(){
        for(int i=0;i<labs.length;i++){
            System.out.println(labs[i].toString());
        }
    }
    @Override
    public String toString() {
        return "Department [labsIncharge=" + labsIncharge + ", name=" + name + "]";
    }
    public boolean equals(Object obj) {
        Department p1=(Department)obj;
        boolean equal=false;
        if(this.name==p1.name){
            equal=true;
        }
        return equal;
    }
    public Object clone(){
        Object temp=new Department(this.name,this.labsIncharge);
        return temp;
    }
}