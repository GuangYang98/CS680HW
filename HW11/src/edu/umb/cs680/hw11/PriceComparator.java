package edu.umb.cs680.hw11;
import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {
    public int compare(Car c1, Car c2){
        return (int)(c1.getPrice() - c2.getPrice());
    }

}
