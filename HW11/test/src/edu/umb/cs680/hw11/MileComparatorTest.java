//Car(String make, String model, int mileage, int year, float price)

package edu.umb.cs680.hw11;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MileComparatorTest{

    @Test
    public void MileComparatorTest(){
        ArrayList<Car> cars = new ArrayList<Car>();

        cars.add(new Car("audi", "a3", 30000, 2015, 20000));
        cars.add(new Car("audi", "q3", 50000, 2015, 20000));
        cars.add(new Car("audi", "s3", 10000, 2019, 20000));

        int[] expected = {10000, 30000, 50000};
        int[] actual = new int[cars.size()];
        int i = 0;
        Collections.sort(cars, new MileComparator());
        for (Car c : cars){
            actual[i++] = c.getMileage();
        }
        assertArrayEquals(expected, actual);
    }


}