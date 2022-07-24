/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author LENOVO
 */
import Java.lang.*;

public class Car implements Comparable<Car> {

    String carID;
    Brand brand;
    String color;
    String frameID;
    String engineID;

    public Car() {
    }

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() {
        return carID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    @Override
    public String toString() {
        return carID + ", " + brand.getBrandId() + ", " + color + ", " + frameID + ", " + engineID;
    }

    public String screenString() {
        return brand + "\n" + carID + ", " + color + ", " + frameID + ", " + engineID;

    }

    @Override
    public int compareTo(Car o) {
        if (this.getBrand().getBrandName().compareTo(o.getBrand().getBrandName()) > 0) {
            return 1;
        } else if (this.getBrand().getBrandName().compareTo(o.getBrand().getBrandName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
