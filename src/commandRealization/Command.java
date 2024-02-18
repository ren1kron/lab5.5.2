package commandRealization;

import java.util.Objects;

public abstract class Command {
    public abstract void execute();
    private final String name;
    private final String description;
    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String toString() {
//        return "Name of Command: " + name + "; Description of Command:" + description;
        return name + ";" + description;
    }
    public int hashCode() {
        return Objects.hash(name, description);
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null || getClass()!=o.getClass()) return false;
        Command command = (Command) o;
        return name.equals(command.getName()) && description.equals(command.getDescription());
    }
}
