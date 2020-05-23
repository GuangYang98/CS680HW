package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CarTest {
    private String[] carToStringArray(Car c){
        String[] carInfo = {c.getMake(), c.getModel(), Integer.toString(c.getYear()) };
        return carInfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear1() {
        String[] expected = {"Toyota", "RAV4", "2018"};
        Car actual = new Car("Toyota", "RAV4", 2018); //Car instance 1
        assertArrayEquals(expected, carToStringArray(actual) );
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear2() {
        String[] expected = {"Honda", "civic", "2001"};
        Car actual = new Car("Honda", "civic", 2001); //Car instance 2
        assertArrayEquals(expected, carToStringArray(actual) );
    }
}