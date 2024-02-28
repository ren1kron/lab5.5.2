import exceptions.AskExitExecption;
import managers.CollectionManager;
import managers.DumpManager;
import models.*;
import utility.Asker;
import utility.console.StandardConsole;

import java.util.*;

//import org.apache.commons.lang3.StringUtils

public class Main {
    static Map<Integer, Worker> map = new LinkedHashMap<>();
    public static void main(String[] args) throws AskExitExecption {
        var console = new StandardConsole();
        DumpManager dumpManager = new DumpManager("Workers.csv", console);
        CollectionManager collectionManager = new CollectionManager(dumpManager);
        if (!collectionManager.init()) {
            console.printError("Not valid csv-file: some keys and/or IDs was repeated");
            System.exit(1);
        }
//        else console.println("Collection successfully downloaded!");

//        dumpManager.readCsv(map);
//        for (var e : collectionManager.getKeyMap().values()) {
//            System.out.println(e.toString());
//            var org = e.getOrganization();
//            System.out.println(org.getFullName() + "; " + org.getAnnualTurnover() + "; " + org.getEmployeesCount());
//        }
//        Worker worker = Asker.askWorker(console);
//        collectionManager.add(worker);
////        for (var e : map.values()) System.out.println(e.toString());
////        dumpManager.writeCsv(map);
//        collectionManager.saveMap();
    }
}
