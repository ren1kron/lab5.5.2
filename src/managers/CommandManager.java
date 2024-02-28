package managers;

import commandRealization.Command;
import commandRealization.commands.InsertCommand;
import commandRealization.commands.ClearCommand;
import commandRealization.commands.HelpCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandManager {
    private Map<String, Command> commands = new HashMap<>();
    private CollectionManager collectionManager;

//    public void register() {
////        commands.put("help", new HelpCommand());
//        commands.put("add", new InsertCommand(collectionManager));
//        commands.put("clear", new ClearCommand(collectionManager));
//    }

//    public Map<String, Command> getCommands() {
//        return commands;
//    }

//    public void run() {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String line = sc.next();
//            String[] tokens = line.split(" ");
//            Command command = commands.get(tokens[0]);
//            command.execute();
//        }
//    }
}
