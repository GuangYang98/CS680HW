package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    public void InState_testStatus(){
        Student actual = Student.createInStateStudent("GG","Cambridge");
        StudentStatus expected = StudentStatus.INSTATE;
        assertEquals(expected, actual.getStatus());
    }

    @Test
    public void InState_testName(){
        Student actual = Student.createInStateStudent("GG","Cambridge");
        String expected = "GG";
        assertEquals(expected, actual.getName());
    }

    @Test
    public void OutState_testStatus(){
        Student actual = Student.createOutStateStudent("GG","Cambridge", 234);
        StudentStatus expected = StudentStatus.OUTSTATE;
        assertEquals(expected, actual.getStatus());
    }

    @Test
    public void OutState_testUsAddr(){
        Student actual = Student.createOutStateStudent("GG","Cambridge", 234);
        String expected = "Cambridge";
        assertEquals(expected, actual.getUsAddr());
    }

    @Test
    public void OutState_testYrsInState(){
        Student actual = Student.createOutStateStudent("GG","Cambridge", 234);
        int expected = 234;
        assertEquals(expected, actual.getYrsInState());
    }

    @Test
    public void Intl_testStatus(){
        Student actual = Student.createIntlStudent("GG","Cambridge", 234, "Hubei");
        StudentStatus expected = StudentStatus.INTL;
        assertEquals(expected, actual.getStatus());
    }

    @Test
    public void Intl_testI20num(){
        Student actual = Student.createIntlStudent("GG","Cambridge", 234, "Hubei");
        int expected = 234;
        assertEquals(expected, actual.getI20num());
    }

    @Test
    public void Intl_testForeignAddr(){
        Student actual = Student.createIntlStudent("GG","Cambridge", 234, "Hubei");
        String expected = "Hubei";
        assertEquals(expected, actual.getForeignAddr());
    }
}