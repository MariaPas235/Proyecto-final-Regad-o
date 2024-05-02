package github.mariapas235.model.entity;

import java.util.Objects;

public class Garage {
    private int garageNumber;
    private String name;
    private String location;

    public Garage(int garageNumber, String name, String location){
        this.garageNumber = garageNumber;
        this.name = name;
        this.location = location;

    }

    public Garage(){

    }

    public int getGarageNumber() {
        return garageNumber;
    }

    public void setGarageNumber(int garageNumber) {
        this.garageNumber = garageNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.equals(garageNumber, garage.garageNumber);
    }

    public int hashCode() {
        return Objects.hash(garageNumber);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "garageNumber=" + garageNumber +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
