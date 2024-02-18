import exceptions.AskExitExecption;
import managers.CollectionManager;
import models.*;
import utility.ImportantChecks;
import utility.console.Console;
import utility.console.StandardConsole;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

//import org.apache.commons.lang3.StringUtils

public class Main {
    static List<Worker> collection = new ArrayList<>();
    public static void main(String[] args) throws AskExitExecption {
        var console = new StandardConsole();
        collection.add(Asker.askWorker(console));
        for (var e : collection) System.out.println(e.toString());
    }
}
/**
 * This thing will link Console and Managers
 * @author ren1kron
 */
class Asker {
    public static Worker askWorker(Console console) throws AskExitExecption{
        try {
            String name;
            do {
                console.print("Enter the name of worker: ");
                name = console.readln().trim();
                if (name.equals("exit")) throw new AskExitExecption();
            } while (name.isEmpty());
            String organizationName;
//            do {
//                console.print("Enter the Full name of organization worker is associated with: ");
//                organizationName = console.readln().trim();
//                if (organizationName.equals("exit")) throw new AskExitExecption();
//            } while (organizationName.isEmpty());

            var organization = askOrganization(console);
            var position = askPosition(console);
            var status = askStatus(console);
            var salary = askSalary(console);
            var coordinates = askCoordinates(console);
            var startDate = askStartDate(console);
//            var creationDate = new Date();

            return new Worker(name, coordinates, salary, startDate, position, status, organization);
        }
        catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Illegal parameter");
            return null;
        }
    }
    public static Coordinates askCoordinates(Console console) throws AskExitExecption {
        try {
            float x;
            while (true) {
                console.print("Enter \"x\" coordinates: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskExitExecption();
                if (!line.isEmpty()) {
                    try {
                        x = Float.parseFloat(line); break;
                    } catch (NumberFormatException ignored) { }
                }
            }
            double y;
            while (true) {
                console.print("Enter \"y\" coordinates: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskExitExecption();
                if (!line.isEmpty()) {
                    try {
                        y = Double.parseDouble(line); break;
                    } catch (NumberFormatException ignored) { }
                }
            }
            return new Coordinates(x, y);
        }
        catch (NoSuchElementException | IllegalStateException e) {
            console.printError("The value of Coordinates is illegal");
            return null;
        }
    }
    public static float askSalary(Console console) throws AskExitExecption{
        try {
            while (true) {
                console.print("Enter the worker's salary (in USD): $");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskExitExecption();
                if (!line.isEmpty()) {
                    return Float.parseFloat(line);
                }
            }
        }
        catch (NoSuchElementException | IllegalStateException e) {
            console.printError("The value of Salary is illegal");
            return 0;
        }
    }
    public static Position askPosition(Console console) throws AskExitExecption {
        Position position;
        try {
            while (true) {
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskExitExecption();
                if (!line.isEmpty()) {
                    try {
//                        position = Position.valueOf(line.toUpperCase());
//                        return position;
                        return Position.valueOf(line.toUpperCase());
                    } catch (NullPointerException | IllegalArgumentException ignored) { }
                }
                console.print("Enter the position (" + Position.names().toLowerCase() + ") of Worker: ");
            }
        }
        catch (NoSuchElementException | IllegalStateException e) {
            console.printError("The value of Position is illegal");
            return null;
        }
    }
    public static LocalDate askStartDate(Console console) throws AskExitExecption{
        LocalDate startDate;
        while (true) {
            console.print("Enter Worker's Birthday in the following format: YYYY-MM-DD or " +
                    LocalDate.now().format(DateTimeFormatter.ISO_DATE) + " : ");
            var line = console.readln().trim();
            if (line.equals("exit")) throw new AskExitExecption();
            if (!line.isEmpty()) {
                try {
                    startDate = LocalDate.parse(line, DateTimeFormatter.ISO_DATE);
                    break;
                } catch (DateTimeParseException ignored) { }
            }
//            catch (NoSuchElementException | IllegalStateException e) {}
        }
        return startDate;
    }
    public static Status askStatus(Console console) throws AskExitExecption {

        while (true) {
            var line = console.readln().trim();
            if (line.equals("exit")) throw new AskExitExecption();
            if (line.isEmpty()) return null;
            else {
                try {
                    return Status.valueOf(line.toUpperCase());
                } catch (NullPointerException | IllegalArgumentException ignored) { }
            }
            console.print("Enter the Status of the Worker (" + Status.names().toLowerCase() + "): ");
        }
    }
//    public static Organization askOrganization(Console console, String organizationName) throws AskExitExecption {
//        console.print("Enter the Full name of Organization the Worker is related to: ");
//        var line = console.readln().trim();
//        while (true) {
//            if (line.equals("exit")) throw new AskExitExecption();
//            if (!line.isEmpty()) {
//
//            }
//        }
//    }
    public static Organization askOrganization(Console console) throws AskExitExecption {
        String organizationName;
        console.print("Enter the Full name of Organization worker is associated with (ENTER if " +
                "organization is unknown): ");
        var line = console.readln().trim();
        if (line.equals("exit")) throw new AskExitExecption();
        else if (line.isEmpty()) return null;
        else organizationName = line;
        Integer orgAnnualTurnover;
        while (true) {
            console.print("Enter the Annual Turnover of the Organization worker is associated with in USD (ENTER if " +
                    "annual turnover of organization is unknown): $");
            line = console.readln().trim();
            if (line.equals("exit")) throw new AskExitExecption();
            else if (line.isEmpty()) orgAnnualTurnover = null;
            else {
                try {
                    orgAnnualTurnover = Integer.parseInt(line);
                    break;
                } catch (NumberFormatException ignored) { }
            }
        }
        return new Organization(organizationName, orgAnnualTurnover);
//        else if (organizationName)
    }
}
