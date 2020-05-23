package edu.umb.cs680.hw11;
import java.util.ArrayList;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PriceComparatorTest{
    @Test
    public void PriceComparatorTestInInteger(){
        ArrayList<Car> cars = new ArrayList<Car>();

        cars.add(new Car("audi", "a3", 30000, 2015, 30000));
        cars.add(new Car("audi", "q3", 50000, 2017, 50000));
        cars.add(new Car("audi", "s3", 10000, 2019, 90000));

        float[] expected = {30000, 50000, 90000};
        float[] actual = new float[cars.size()];
        int i = 0;
        Collections.sort(cars, new PriceComparator());
        for (Car c : cars){
            actual[i++] = c.getPrice();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void PriceComparatorTestInInFloat(){
        ArrayList<Car> cars = new ArrayList<Car>();

        cars.add(new Car("audi", "a3", 30000, 2015, 34459));
        cars.add(new Car("audi", "q3", 50000, 2017, 34555.8F));
        cars.add(new Car("audi", "s3", 10000, 2019, 90000));

        float[] expected = {34459, 34555.8F, 90000};
        float[] actual = new float[cars.size()];
        int i = 0;
        Collections.sort(cars, new PriceComparator());
        for (Car c : cars){
            actual[i++] = c.getPrice();
        }
        assertArrayEquals(expected, actual);
    }
}