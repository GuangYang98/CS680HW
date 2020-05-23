package edu.umb.cs680.hw11;
import java.util.Comparator;

public class MileComparator implements  Comparator<Car> {

    public int compare(Car c1, Car c2){
        return c1.getMileage() - c2.getMileage();
    }
}
