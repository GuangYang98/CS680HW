package edu.umb.cs680.hw01;

public class Calculator{
    static int a = 1;
    public float multiply(float x, float y){
        return x * y;
    }
    public float divide(float x, float y) {
        if (y == 0) {
            throw new IllegalArgumentException("division by zero");
        }
        return x / y;
    }
}




