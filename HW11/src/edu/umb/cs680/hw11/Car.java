package edu.umb.cs680.hw11;

import java.util.ArrayList;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;
    private int domainationCount = 0;

    public Car(String make, String model, int year){
        this.make=make;
        this.model=model;
        this.mileage=0;
        this.year=year;
        this.price=0;
    }

    public Car(String make, String model, int mileage, int year, float price){
        this.make=make;
        this.model=model;
        this.mileage=mileage;
        this.year=year;
        this.price=price;
    }

    public void setDominationCount(ArrayList<Car> car){
        for (Car c :car){
            if(this.mileage >= c.mileage && this.price >= c.price && this.year <=c.year){
                if(this.mileage> c.mileage || this.price >c.price || this.year<c.year){
                    this.domainationCount++;
                }
            }
        }
    }

    public int getDomainationCount(){
        return this.domainationCount;
    }

    public int getMileage() {
        return mileage;
    }

    public float getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

}
