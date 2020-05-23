package edu.umb.cs680.hw11;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class YearComparatorTest{

    @Test
    public void YearComparatorTest(){
        Car c1 = new Car("audi", "a3", 30000, 2015, 20000);
        Car c2 = new Car("audi", "q3", 50000, 2016, 20000);
        Car c3 = new Car("audi", "s3", 10000, 2019, 20000);
        ArrayList<Car> cars = new ArrayList<Car>();

        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        int[] expected = {2015, 2016, 2019};
        int[] actual = new int[cars.size()];
        int i = 0;
        Collections.sort(cars, new YearComparator());
        for (Car c : cars){
            actual[i++] = c.getYear();
        }
        assertArrayEquals(expected, actual);
    }


}