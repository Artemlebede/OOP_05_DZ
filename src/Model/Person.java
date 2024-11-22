package Model;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int birthYear;

    public Person(String name, int birthYear) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        if (birthYear <= 0) throw new IllegalArgumentException("Invalid birth year");
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return name + ", born in " + birthYear;
    }
}