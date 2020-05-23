package edu.umb.cs680.hw11;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ParetoComparatorTest{

    @Test
    public void DominationComparatorTest(){
        ArrayList<Car> cars = new ArrayList<Car>();

        cars.add(new Car("audi", "a3", 30000, 2015, 20000));
        cars.add(new Car("audi", "q3", 50000, 2015, 20000));
        cars.add(new Car("audi", "s3", 10000, 2019, 20000));

        int[] expected = {1, 2, 0};
        int[] actual = new int[cars.size()];
        int i = 0;
        Collections.sort(cars, new ParetoComparator());
        for (Car c : cars){
            c.setDominationCount(cars);
            actual[i++] = c.getDomainationCount();
        }
        assertArrayEquals(expected, actual);
    }


}