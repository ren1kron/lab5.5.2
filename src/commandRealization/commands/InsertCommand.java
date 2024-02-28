package commandRealization.commands;

import commandRealization.Command;
import exceptions.AskExitExecption;
import managers.CollectionManager;
import models.Worker;
import utility.Asker;
import utility.ExecutionResponse;
import utility.console.Console;

public class InsertCommand extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public InsertCommand(Console console, CollectionManager collectionManager) {
        super("insert null {element}", "Adds new element with specified key in collection");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        try {
            if (!arguments[2].isEmpty()) return new ExecutionResponse(false, "Wrong amount of arguments!\nYou suppose to write: '" + getName() + "'");

            var key = Integer.parseInt(arguments[1]);
            console.println("* Adding new Worker: ...");
            Worker worker = Asker.askWorker(console, key, collectionManager.getFreeId());

            if (worker != null && worker.validate()) {
                collectionManager.add(worker);
                return new ExecutionResponse("Worker was successfully added to collection!");
            } else return new ExecutionResponse(false, "Fields of inserted worker are invalid. Worker wasn't added to collection");
        } catch (AskExitExecption e) {
            return new ExecutionResponse(false, "Отмена...");
        }
    }
}
