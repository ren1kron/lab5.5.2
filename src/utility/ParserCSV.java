package utility;

import models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

public class ParserCSV {
    public static Worker fromArray(String[] arr) {
        int id;
        String name;
        Organization organization;
        Position position;
        Status status;
        float salary;
        Coordinates coordinates;
        Date creationDate;
        LocalDate startDate;
        try {
            id = Integer.parseInt(arr[0]);
            name = arr[1];
            organization = new Organization(arr[2]);
            position = Position.valueOf(arr[3]);
            status = Status.valueOf(arr[4]);
            salary = Float.parseFloat(arr[5]);
            coordinates = new Coordinates(arr[6]);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            try {
                creationDate = formatter.parse(arr[7]);
            } catch (ParseException e) {
                creationDate = null;
            }
            try {
                startDate = LocalDate.parse(arr[8], DateTimeFormatter.ISO_DATE);
            } catch (DateTimeParseException e) {
                startDate = null;
            }
            return new Worker(id, name, organization, position, status, salary, coordinates, creationDate, startDate);
        } catch (ArrayIndexOutOfBoundsException ignored) { }
        return null;
    }

}
