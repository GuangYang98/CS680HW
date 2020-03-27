package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void multiply3by4(){
        Calculator cut = new Calculator();
        float actual = cut.multiply(3,4);
        float expected = 12;
        assertEquals(expected, actual);
    }
    @Test
    public void multiply3_4028235E38by0_5(){
        Calculator cut = new Calculator();
        float actual = cut.multiply(3.4028235E38f,0.5f);
        float expected = 1.7014117E38f;
        assertEquals(expected, actual);
    }
    @Test
    public void multiply5_3by4_0(){
        Calculator cut = new Calculator();
        float actual = cut.multiply(5.3f,4.0f);
        float expected = 21.2f;
        assertEquals(expected, actual);
    }
    @Test
    public void multiply3byMinus1(){
        Calculator cut = new Calculator();
        float actual = cut.multiply(3,-1);
        float expected = -3;
        assertEquals(expected, actual);
    }
    @Test
    public void multiply3_0by0_0(){
        Calculator cut = new Calculator();
        float actual = cut.multiply(3.0f,0.0f);
        float expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void divide3by2(){
        Calculator cut = new Calculator();
        float actual = cut.divide(3,2);
        float expected = 1.5f;
        assertEquals(expected, actual);
    }
    @Test
    public void divide55byMinus5(){
        Calculator cut = new Calculator();
        float actual = cut.divide(55,-5);
        float expected = -11;
        assertEquals(expected, actual);
    }
    @Test
    public void divide55byMinus7(){
        Calculator cut = new Calculator();
        float actual = cut.divide(55,-7);
        float expected = -7.857143f;
        assertEquals(expected, actual);
    }
    @Test
    public void divide1_0by1(){
        Calculator cut = new Calculator();
        float actual = cut.divide(1.0f,1);
        float expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    public void divide5by3(){
        Calculator cut = new Calculator();
        float actual = cut.divide(5,3);
        float expected = 1.6666666f;
        assertEquals(expected, actual);
    }
    @Test
    public void divide5by0ExceptionWord(){
        Calculator cut = new Calculator();
        try {
            cut.divide(5,0);
            fail("ExceptionWord wrong");
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            assertEquals("division by zero", ex.getMessage() );
        }
    }
    @Test
    public void divide5by0Throw(){
        Calculator cut = new Calculator();
        assertThrows(IllegalArgumentException.class, ()->cut.divide(5,0) );
    }
}
