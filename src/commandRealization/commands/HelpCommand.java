package commandRealization.commands;

import commandRealization.Command;
import managers.CollectionManager;
import managers.CommandManager;

public class HelpCommand extends Command {
//    private final CommandManager commandManager;
    private CommandManager commandManager;
    public HelpCommand(CommandManager commandManager) {
        super("help", "Displays help for existing commands");
        this.commandManager = commandManager;
    }
    @Override
    public void execute() {

    }
}
