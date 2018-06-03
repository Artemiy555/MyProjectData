package spring.lesson15.part2.entity;

public class Car {
    private String model;
    private Integer year;

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public Car(String model, Integer year) {
        this.model = model;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
