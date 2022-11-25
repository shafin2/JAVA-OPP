import java.util.Comparator;

public class House implements Comparable<House>,Comparator<House>{

    int rent;
    String location;
    Double area;
    int noOfRooms;

    @Override
    public String toString() {
        return "House{" +
                "rent=" + rent +
                ", location='" + location + '\'' +
                ", area=" + area +
                ", noOfRooms=" + noOfRooms +
                '}';
    }



    public House(int rent, String location, Double area, int noOfRooms) {
        this.rent = rent;
        this.location = location;
        this.area = area;
        this.noOfRooms = noOfRooms;
    }



    @Override
    public int compareTo(House o) {
        int flag=-1;
            if(this.rent>o.rent){
                flag=1;
            }
            if(this.rent<o.rent){
                flag=-1;
            }
            if(this.rent==o.rent){
                flag=0;
            }
            return flag;
    }



    @Override
    public int compare(House o1, House o2) {
        int flag=-1;
            if(o1.area>o2.area){
                flag=1;
            }
            if(o1.area<o2.area){
                flag=-1;
            }
            if(o1.area==o2.area){
                flag=0;
            }
            return flag;
    }

    // @Override
    // public int compareTo(House o) {
    //     int flag=-1;
    //     if(this.rent>o.rent){
    //         flag=1;
    //     }
    //     if(this.rent<o.rent){
    //         flag=-1;
    //     }
    //     if(this.rent==o.rent){
    //         flag=0;
    //     }
    //     return flag;
    // }

    // @Override
    // public int compare(House o1, House o2) {
    //     int flag=-1;
    //     if(o1.area>o2.area){
    //         flag=1;
    //     }
    //     if(o1.area<o2.area){
    //         flag=-1;
    //     }
    //     if(o1.area==o2.area){
    //         flag=0;
    //     }

    //     return flag;
    // }


}