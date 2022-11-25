import java.util.Comparator;

public class CompareByName implements Comparator<House>{
    public int compare(House a,House b){
        return a.location.compareTo(b.location);

    }
}
