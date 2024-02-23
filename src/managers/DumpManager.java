package managers;



import java.io.*;
import java.util.Map;


import com.opencsv.*;
import models.Worker;
import utility.ParserCSV;
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

    /**
     * Parses Map to CSV-string
     * @param Map collection
     * @return CSV-string
     */
    private String collectionToCSV(Map<Integer, Worker> Map) {
        try {
            StringWriter sw = new StringWriter();
            CSVWriter csvWriter = new CSVWriter(sw);
            for (var e: Map.entrySet()) {
//                Worker worker = e.getValue();
//                String[] values = Worker.toArray(worker);
                csvWriter.writeNext(Worker.toArray((Worker) e));
            }
            return sw.toString();
        } catch (Exception e) {
            console.printError("Serialization error");
            return null;
        }
    }
    /**
     * Writes collection to file.
     * @param Map collection
     */
    public void writeCollection(Map<Integer, Worker> Map) {
        OutputStreamWriter writer = null;
        try {
            var csv = collectionToCSV(Map);
            if (csv == null) return;
            writer = new OutputStreamWriter(new FileOutputStream(fileName));
            try {
                writer.write(csv);
                writer.flush();
                console.println("Collection was saved in file!");
            } catch (IOException e) {
                console.printError("Unexpected error while saving");
            }
        } catch (FileNotFoundException | NullPointerException e) {
            console.printError("File was not found");
        } finally {
            try {
                assert writer != null;
                writer.close();
            } catch(IOException e) {
                console.printError("Error while closing the file");
            }
        }
    }
}

