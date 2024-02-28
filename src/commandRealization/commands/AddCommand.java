package commandRealization.commands;

import commandRealization.Command;
import managers.CollectionManager;
import models.Worker;

public class AddCommand extends Command {
    private final CollectionManager collectionManager;
    private Integer key;
    private Worker worker;

    public AddCommand(CollectionManager collectionManager) {
        super("add", "Adds new element in collection");
        this.collectionManager = collectionManager;
    }
    @Override
    public void execute() {
        collectionManager.add(worker);
    }
}
