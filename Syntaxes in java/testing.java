public class testing extends Inheritance{
    int test1;
    
    testing(int a){
        test1=a;
    }
    testing(testing b){
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
