package commandRealization.commands;

import commandRealization.Command;
import managers.CollectionManager;
import utility.ExecutionResponse;

public class RemoveKeyCommand extends Command {
    private final CollectionManager collectionManager;
    public RemoveKeyCommand(CollectionManager collectionManager) {
        super("remove_key key", "Removes element from collection by key");
        this.collectionManager = collectionManager;
    }

    @Override
    public ExecutionResponse apply(String[] arguments) {
        if (arguments[1].isEmpty()) return new ExecutionResponse(false, "Wrong amount of arguments!\nYou suppose to write: '" + getName() + "'");
        int key;
        try {
            key = Integer.parseInt(arguments[1].trim());
        } catch (NumberFormatException e) {
            return new ExecutionResponse(false, "Invalid key value!");
        }
        if (!collectionManager.getKeyMap().containsKey(key))
            return new ExecutionResponse(false, "Worker with this key already doesn't exist!");
        collectionManager.removeByKey(key);
        return new ExecutionResponse("Worker successfully removed");
    }
}
