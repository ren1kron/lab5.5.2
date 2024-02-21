package managers;


import java.io.StringWriter;

import com.opencsv.*;
import utility.console.Console;



/**
 * Convert collection to CSV and CSV to collection
 * @author ren1kron
 */
public class DumpManager {
    private final String fileName;
    private final Console console;

    public DumpManager(String fileName, Console console) {
        this.fileName = fileName;
        this.console = console;
    }

//    private String collectionToCSV(Collection<Dragon> collection) {
//        try {
//            StringWriter sw = new StringWriter();
//            CSVWriter csvWriter = new CSVWriter(sw, ';');
//            for (var e : collection) {
//                csvWriter.writeNext(Dragon.toArray(e));
//            }
//            String csv = sw.toString();
//            return csv;
//        } catch (Exception e) {
//            console.printError("Ошибка сериализации");
//            return null;
//        }
//    }
}

