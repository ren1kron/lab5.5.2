package models;

import utility.Element;
import utility.Validatable;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Worker extends Element implements Validatable {
//    public Worker(String name, Coordinates coordinates, java.util.Date creationDate, float salary,
//                  java.time.LocalDate startDate, Position position, Status status, Organization organization) {
public Worker(String name, Coordinates coordinates, float salary,
              java.time.LocalDate startDate, Position position, Status status, Organization organization) {
    this.id = ++nextId; // как будто можно просто добавлять значение здесь каждый раз и всё будет ок. Но посмотрим,
        // может, нужно будет убрать "++"
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.salary = salary;
        this.startDate = startDate;
        this.position = position;
        this.status = status;
        this.organization = organization;
    }

    private static int nextId = 0;
    private final int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение
    // этого поля должно генерироваться автоматически
    private String name; //Поле НЕ может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле НЕ может быть null
    private java.util.Date creationDate; //Поле НЕ может быть null, Значение этого поля должно генерироваться автоматически
    private float salary; //Значение поля должно быть больше 0
    private java.time.LocalDate startDate; //Поле НЕ может быть null
    private Position position; //Поле НЕ может быть null
    private Status status; //Поле МОЖЕТ быть null
    private Organization organization; //Поле МОЖЕТ быть null


    public void touchNextId() {
        nextId++;
    }
    @Override
    public int compareTo(Element element) {
        return (int)(this.id - element.getId());
    }
    @Override
    public boolean validate() {
        if (id <= 0) return false;
        if (name==null || name.isEmpty()) return false;
        if (coordinates == null) return false;
        if (creationDate == null) return false;
        if (salary <= 0) return false;
        if (startDate == null) return false;
//        if (organization == null) return false;
//        if (status == null) return false;
        return (position != null);
    }

    @Override
    public int getId() {
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker that = (Worker) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, salary, startDate, position, status, organization);
    }
    @Override
    public String toString() {
        return "id: "+ id +"; name: "+ name +"; coordinates: " + coordinates + "; Date of appointment: "+ creationDate +
                "; salary: " + salary + "; Birthday: " + startDate + "; position: " + position + "; status: " + status
                + "; organization: " + organization;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
