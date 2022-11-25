public class testing extends Inheritance{
    int test1;
    {
        System.out.println("Non-static of Testing");
    }
    testing(int a){
        super(23);
        System.out.println("Testing Constructor");
        test1=a;
    }
    static{
        System.out.println("static of Testing");
    }
    testing(testing b){
        this(54);
        this.test1=b.test1;
    }
    public boolean equals(Object another){
        testing temp=(testing)another;
        boolean result=false;
        if(temp.test1==this.test1){
            result=true;
        }
        return result;
    }
    public Object clone(){
        Object  temp=new testing(8);
        return temp;
    }


}
