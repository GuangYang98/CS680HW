package edu.umb.cs680.hw14;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Test;

public class CarTest{
    @Test
    public void mileComparatorTest(){
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("audi", "a3", 30000, 2015, 20000));
        cars.add(new Car("audi", "q3", 50000, 2015, 20000));
        cars.add(new Car("audi", "s3", 10000, 2019, 20000));

        int[] expeted = {10000,30000, 50000};
        int[] actual = new int[cars.size()];
        int i = 0;
        Collections.sort(cars, (Car c1, Car c2) -> {return c1.getMileage()- c2.getMileage();});

        for (Car c:cars){
            actual[i++] = c.getMileage();
        }
        assertArrayEquals(expeted, actual);
    }

    @Test
    public void yearComparatorTest(){
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("audi", "a3", 30000, 2015, 20000));
        cars.add(new Car("audi", "q3", 50000, 2010, 20000));
        cars.add(new Car("audi", "s3", 10000, 2019, 20000));

        int[] expeted = {2010,2015, 2019};
        int[] actual = new int[cars.size()];
        int i = 0;
        Collections.sort(cars, (Car c1, Car c2) -> {return c1.getYear()- c2.getYear();});

        for (Car c:cars){
            actual[i++] = c.getYear();
        }
        assertArrayEquals(expeted, actual);
    }

    @Test
    public void priceComparatorTest(){
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("audi", "a3", 30000, 2015, 30000f));
        cars.add(new Car("audi", "q3", 50000, 2015, 20000f));
        cars.add(new Car("audi", "s3", 10000, 2019, 10000f));

        float[] expeted = {10000,20000, 30000};
        float[] actual = new float[cars.size()];
        int i = 0;
        Collections.sort(cars, (Car c1, Car c2) -> {return (int)(c1.getPrice()- c2.getPrice());});

        for (Car c:cars){
            actual[i++] = c.getPrice();
        }
        assertArrayEquals(expeted, actual);
    }

    @Test
    public void paretoComparatorTest(){
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("audi", "a3", 30000, 2015, 20000));
        cars.add(new Car("audi", "q3", 50000, 2010, 20000));
        cars.add(new Car("audi", "s3", 10000, 2019, 20000));

        int[] expeted = {0, 1, 2};
        int[] actual = new int[cars.size()];
        int i = 0;

        for (Car car:cars){
            car.setDominationCount(cars);
        }

        Collections.sort(cars, (Car c1, Car c2) -> {return c1.getDomanationCount()- c2.getDomanationCount();});
        for (Car c: cars){
            actual[i++] = c.getDomanationCount();
        }
        assertArrayEquals(expeted, actual);
    }
}