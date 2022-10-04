public class Date {
    private int day,month,year;
    Date(int day,int month,int year){
        if(day>0){
            this.day=day;
        }
        if(month>0){
            this.month=month;
        }
        if(year>0){
            this.year=year;
        }
        
    }
    public void setDay(int day){
        if(day>0){
            this.day=day;
        }
    }
    public void setMonth(int month){
        if(month>0){
            this.month=month;
        }this.month=month;
    }
    public void setYear(int year){
        if(year>0){
            this.year=year;
        }
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public String toString(){
        return day+"-"+month+"-"+year;
    }
}
