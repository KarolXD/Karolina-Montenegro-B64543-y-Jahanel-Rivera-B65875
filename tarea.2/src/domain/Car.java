/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.File;

/**
 *
 * @author karol
 */
public class Car {

    public String name;
    public int year;
    public float mileage;
    public boolean american;
    public int series;

    public Car() {
        this.name = " ";
        this.year = 0;
        this.mileage = 0;
        this.american = false;
        this.series = 0;

    }

    public Car(String name, int year, float mileage, boolean american, int series) {
        this.name = name;
        this.year = year;
        this.mileage = mileage;
        this.american = american;
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public boolean getAmerican() {
        return american;
    }

    public void setAmerican(boolean american) {
        this.american = american;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return " Name: " + this.getName() + ", Year: " + this.getYear() + ", Mileage: " + this.getMileage() + ", American: " + this.getAmerican() + ", Series: " + this.getSeries() + "\n";
    }

    public int size() {

        return this.getName().length() * 2 + 4 + 4 + 1 + 4;

    }
}//en class
