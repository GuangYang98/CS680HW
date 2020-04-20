package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

public class PrimeGeneratorTest {
    @Test
    public void from1to10(){
        PrimeGenerator gen = new PrimeGenerator(1,10);
        gen.generatePrimes();
        Long[] expetedPrimes = {2L, 3L, 5L, 7L};
        assertArrayEquals(expetedPrimes, gen.getPrimes().toArray());
    }
    @Test
    public void from2to100(){
        PrimeGenerator gen = new PrimeGenerator(2,100);
        gen.generatePrimes();
        Long[] expetedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L};
        assertArrayEquals(expetedPrimes, gen.getPrimes().toArray());
    }
    @Test
    public void fromMinus10to10(){
        try {
            PrimeGenerator gen = new PrimeGenerator(-10,10);
            gen.generatePrimes();
            fail("ExceptionWord wrong");
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
            assertEquals("Wrong input values: from=-10 to=10", ex.getMessage() );
        }
    }
    @Test
    public void from100to1(){
        assertThrows(RuntimeException.class, ()-> new PrimeGenerator(100,1) );
    }
    @Test
    public void from14to16(){
        PrimeGenerator gen = new PrimeGenerator(14,16);
        gen.generatePrimes();
        LinkedList<Long> empty = new LinkedList<Long>();
        assertEquals(empty, gen.getPrimes());
    }
}
