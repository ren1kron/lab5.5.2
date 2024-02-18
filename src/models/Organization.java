package models;

import utility.Validatable;

import java.util.Objects;

public class Organization implements Validatable {
    public Organization(String fullName, Integer annualTurnover) {
        this.fullName = fullName;
        this.annualTurnover = annualTurnover;
    }
    private String fullName; //Поле не может быть null
    private Integer annualTurnover; //Поле МОЖЕТ быть null, Значение поля должно быть больше 0
    private int employeesCount; //Значение поля должно быть больше 0



    @Override
    public boolean validate() {
        if (fullName == null) return false;
        if (annualTurnover <= 0) return false;
        return (employeesCount > 0);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return fullName.equals(that.fullName);
    }
    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

    public String toString() {
        return fullName;
    }
}
