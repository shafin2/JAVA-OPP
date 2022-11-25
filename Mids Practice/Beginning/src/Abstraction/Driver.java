package Abstraction;

public  class Driver {
    public static void main(String[] args) {
        // Industry v1=new Bike();
        // v1.noOfWheels();
        // v1.running();
        // v1.name();
        // Vehicle v2=new Vehicle() {
        //     @Override
        //     public void noOfWheels() {
        //         // TODO Auto-generated method stub
                
        //     }
            
        // };
        Industry i=new Industry() {
            
        };
        Vehicle b1=new Bike();
        b1.noOfWheels();
    }
    
}
