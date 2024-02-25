import exceptions.AskExitExecption;
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
        dumpManager.readCsv(map);
        for (var e : map.values()) {
            System.out.println(e.toString());
            var org = e.getOrganization();
            System.out.println(org.getFullName() + "; " + org.getAnnualTurnover() + "; " + org.getEmployeesCount());
        }
        Worker worker = Asker.askWorker(console);
        map.put(worker.getKey(), worker);
        for (var e : map.values()) System.out.println(e.toString());
        dumpManager.writeCsv(map);
    }
}
