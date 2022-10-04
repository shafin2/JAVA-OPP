public class Lab {
    
    static private PC computers[]=new PC[40];
    private String labName;
    private Employee labAttendant;
    public Lab(String labName, Employee labAttendant) {
        this.labName = labName;
        this.labAttendant = labAttendant;
        for(int i=0;i<computers.length;i++){
            computers[i]=new PC("1", "Hp", "64t7", 8000, 512, true);
        }
    }
    public String getLabName() {
        return labName;
    }
    public void setLabName(String labName) {
        this.labName = labName;
    }
    public Employee getLabAttendant() {
        return labAttendant;
    }
    public void setLabAttendant(Employee labAttendant) {
        this.labAttendant = labAttendant;
    }
    public void showPcs(){
        for(int i =0 ;i<computers.length;i++){
            System.out.println(computers[i].toString());
        }
    }
    @Override
    public String toString() {
        return "Lab [labAttendant=" + labAttendant + ", labName=" + labName + "]";
    }
    public boolean equals(Object obj) {
        Lab p1=(Lab)obj;
        boolean equal=false;
        if(this.labName==p1.labName){
            equal=true;
        }
        return equal;
    }
    public Object clone(){
        Object temp=new Lab(this.labName,this.labAttendant);
        return temp;
    }
}
