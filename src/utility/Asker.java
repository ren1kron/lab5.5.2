package utility;

import exceptions.AskExitExecption;
import models.*;
import utility.console.Console;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.NoSuchElementException;

/**
 * This thing will link Console and Managers
 *
 * @author ren1kron
 */
public class Asker {
    // TODO chk if inserted organization exist
    public static Worker askWorker(Console console, int id) throws AskExitExecption {
        Worker worker;
        while (true) {
            try {
                Integer key = askKey(console);
                String name;
                do {
                    console.print("Enter the name of worker: ");
                    name = console.readln().trim();
                    if (name.equals("exit")) throw new AskExitExecption();
                } while (name.isEmpty());
                //            do {
                //                console.print("Enter the Full name of organization worker is associated with: ");
                //                organizationName = console.readln().trim();
                //                if (organizationName.equals("exit")) throw new AskExitException();
                //            } while (organizationName.isEmpty());

                var organization = askOrganization(console);
                var position = askPosition(console);
                var status = askStatus(console);
                var salary = askSalary(console);
                var coordinates = askCoordinates(console);
                var startDate = askStartDate(console);
                //            var creationDate = new Date();
                //            Integer key, int id, String name, Organization organization, Position position, Status status, float salary,
                //            Coordinates coordinates, Date creationDate, LocalDate startDate
                worker = new Worker(key, name, organization, position, status, salary, coordinates, startDate);
                if (worker.validate()) return worker;
                else console.printError("Inserted worker has invalid values. Try again");
            } catch (NoSuchElementException | IllegalStateException e) {
                console.printError("Illegal parameter");
                return null;
            }
        }
    }

    public static Coordinates askCoordinates(Console console) throws AskExitExecption {
        try {
            float x;
            while (true) {
                console.print("Enter \"x\" coordinates: ");
                var line = console.readln().trim();
                line = line.replace("\\s","");
                if (line.equals("exit")) throw new AskExitExecption();
                if (!line.isEmpty()) {
                    try {
                        x = Float.parseFloat(line);
                        break;
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
            double y;
            while (true) {
                console.print("Enter \"y\" coordinates: ");
                var line = console.readln().trim();
                line = line.replace("\\s","");
                if (line.equals("exit")) throw new AskExitExecption();
                if (!line.isEmpty()) {
                    try {
                        y = Double.parseDouble(line);
                        break;
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
            return new Coordinates(x, y);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("The value of Coordinates is illegal");
            return null;
        }
    }

    public static float askSalary(Console console) throws AskExitExecption {
        try {
            while (true) {
                console.print("Enter the worker's salary (in USD): $");
                var line = console.readln().trim();
                line = line.replace("\\s","");
                if (line.equals("exit")) throw new AskExitExecption();
                if (!line.isEmpty()) {
                    return Float.parseFloat(line);
                }
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("The value of Salary is illegal");
            return 0;
        }
    }

    public static Position askPosition(Console console) throws AskExitExecption {
        try {
            while (true) {
                console.print("Enter the position (" + Position.names().toLowerCase() + ") of Worker: ");

                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskExitExecption();
                if (!line.isEmpty()) {
                    try {
//                        position = Position.valueOf(line.toUpperCase());
//                        return position;
                        return Position.valueOf(line.toUpperCase());
                    } catch (NullPointerException | IllegalArgumentException ignored) {
                    }
                }
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("The value of Position is illegal");
            return null;
        }
    }

    public static LocalDate askStartDate(Console console) throws AskExitExecption {
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
                } catch (DateTimeParseException ignored) {
                }
            }
//            catch (NoSuchElementException | IllegalStateException e) {}
        }
        return startDate;
    }

    public static Status askStatus(Console console) throws AskExitExecption {

        while (true) {
            console.print("Enter the Status of the Worker (" + Status.names().toLowerCase() + "): ");
            var line = console.readln().trim();
            if (line.equals("exit")) throw new AskExitExecption();
            if (line.isEmpty()) return null;
            else {
                try {
                    return Status.valueOf(line.toUpperCase());
                } catch (NullPointerException | IllegalArgumentException ignored) { }
            }
        }
    }

    //    public static Organization askOrganization(Console console, String organizationName) throws AskExitException {
//        console.print("Enter the Full name of Organization the Worker is related to: ");
//        var line = console.readln().trim();
//        while (true) {
//            if (line.equals("exit")) throw new AskExitException();
//            if (!line.isEmpty()) {
//
//            }
//        }
//    }
    public static Organization askOrganization(Console console) throws AskExitExecption {
        String organizationName;
        while (true) {
            console.print("Enter the Full name of Organization worker is associated with (ENTER if " +
                    "organization is unknown): ");
            var line = console.readln().trim();
            if (line.equals("exit")) throw new AskExitExecption();
            else if (line.isEmpty()) return null;
//            else if (workerMap.containsKey(line)) return workerMap.get(line).getOrganization();
            else organizationName = line; break;
        }

        int employeesCount;
        while (true) {
            console.print("Enter the Employees count of the Organization worker associated with: ");
            var line = console.readln().trim();
            line = line.replace("\\s","");
            if (line.equals("exit")) throw new AskExitExecption();
//            else if (line.isEmpty()) return new Organization(organizationName, null);
            if (!line.isEmpty()) {
                try {
                    employeesCount = Integer.parseInt(line);
                    break;
//                    return new Organization(organizationName, orgAnnualTurnover);
                } catch (NumberFormatException ignored) { }
            }
        }

        int orgAnnualTurnover;
        while (true) {
            console.print("Enter the Annual Turnover of the Organization worker is associated with in USD (ENTER if " +
                    "annual turnover of organization is unknown): $");
            var line = console.readln().trim();
            line = line.replace("\\s","");
            if (line.equals("exit")) throw new AskExitExecption();
//            else if (line.isEmpty()) return new Organization(organizationName, null);
            else if (line.isEmpty()) return new Organization(organizationName, null, employeesCount);
            else {
                try {
                    orgAnnualTurnover = Integer.parseInt(line);
                    return new Organization(organizationName, orgAnnualTurnover, employeesCount);
                } catch (NumberFormatException ignored) { }
            }
        }



//        else if (organizationName)
    }
    public static Integer askKey(Console console) throws AskExitExecption{
//        Integer key;
        try {
            while (true) {
                console.print("Enter the Key of Worker (it must be an integer): ");
                var line = console.readln().trim();
                line = line.replace("\\s","");
                if (line.equals("exit")) throw new AskExitExecption();
                if (!line.isEmpty()) {
                    return Integer.parseInt(line);
                }
            }
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("The value of Key is illegal");
            return null;
        }
    }
}
