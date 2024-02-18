package commandRealization.commands;

import commandRealization.Command;
import managers.CollectionManager;

public class ClearCommand extends Command {
    private final CollectionManager collectionManager;
    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "Clears the collection");

        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        collectionManager.clearCollection();
    }
}
