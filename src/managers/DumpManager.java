package managers;



import java.io.*;
import java.nio.Buffer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


import com.opencsv.*;
import com.opencsv.exceptions.CsvValidationException;
import models.Organization;
import models.Worker;
import utility.ParserCSV;
import utility.console.Console;



/**
 * Convert collection to CSV and CSV to collection
 * @author ren1kron
 */
public class DumpManager {

//    Чтение данных из файла необходимо реализовать с помощью класса java.io.FileReader
//    Запись данных в файл необходимо реализовать с помощью класса java.io.OutputStreamWriter
    private final String fileName;
    private final Console console;

    // console.printError("The entered file could not be found");

    CSVParser parser = new CSVParserBuilder()
            .withSeparator(';')
            .build();

    public DumpManager(String fileName, Console console) {
        this.fileName = fileName;
        this.console = console;
    }

    /**
     * Gets the collection from CSV
     * @param map gotten collection(map)
     */
    // java.io.FileReader should be used here
    public void readCsv(Map<Integer, Worker> map) {
        try {
            CSVReader csvReader = new CSVReaderBuilder(new FileReader(fileName))
    //                    .withSkipLines(1)
                    .withCSVParser(parser)
                    .build();
            String[] data = csvReader.readNext();
            Worker worker = Worker.fromArray(data);
            map.put(worker.getKey(), worker);
//            for (var line : data) {
//                System.out.println(line);
////                Worker worker = Worker.fromArray(line.split(";"));
////                assert worker != null;
////                map.put(worker.getKey(), worker);
//            }
            if (map != null) console.println("Collection was successfully downloaded!");
        } catch (IOException e) {
            console.printError("The entered file could not be found");
        } catch (CsvValidationException e) {
            console.printError("The entered csv-file is not valid");
        }
    }

    /**
     * Saves the collection to CSV
     * @param map saved collection(map)
     */
    // java.io.OutputStreamWriter should be used here
    public void writeCsv(Map<Integer, Worker> map) {
        String[] strings = {"key", "id", "name", "organization", "coordinates", "date of appointment", "salary", "birthday", "position", "status"};
        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName));
            ICSVWriter csvWriter = new CSVWriterBuilder(writer)
                    .withParser(parser)
                    .build();
            for (var worker: map.values()) {
//                var worker = map.get(key);
                csvWriter.writeNext(Worker.toArray(worker));
            }
            try {
                csvWriter.flush();
                csvWriter.close();
                console.print("Collection successfully saved in file!");
            } catch (IOException e) {
                console.printError("Unexpected error while saving file");
            }
        } catch (FileNotFoundException e) {
            console.printError("File with inserted name was never founded");
        }
    }

//    public void readMap(Map<Integer, Worker> workerMap) {
//        if (fileName != null && !fileName.isEmpty()) {
//            try (var fileReader = new BufferedReader(new FileReader(fileName)) {
//                var stringBuffer = new StringBuffer();
//                while(fileReader.hasNextLine()) {
//                    stringBuffer.append(fileReader.nextLine()).append("\n");
//                }
//                workerMap.clear();
////                for(var e:)
//            }
//            catch (FileNotFoundException nfe) {
//                console.printError("Download file was never founded");
//            } catch (IOException ioe) {
//                console.printError("Unexpected error");
//            } ;
//        }
//    }

    //initiating the CSV reader class
//    public String[] csvToStrings() throws FileNotFoundException {
//        try {
//            CSVReader reader = new CSVReader(new FileReader(fileName));
//            StringBuffer stringBuffer = new StringBuffer();
//            String[] data;
//            while
//
//
//        } catch(FileNotFoundException e) {
//            console.printError("File has never been found");
//
//        }
//    }
//    /**
//     * Parses Map to CSV-string
//     * @param Map collection
//     * @return CSV-string
//     */
//    private String collectionToCSV(Map<Integer, Worker> Map) {
//        try {
//            StringWriter sw = new StringWriter();
//            CSVWriter csvWriter = new CSVWriter(sw);
//            for (var e: Map.entrySet()) {
////                Worker worker = e.getValue();
////                String[] values = Worker.toArray(worker);
//                csvWriter.writeNext(Worker.toArray((Worker) e));
//            }
//            return sw.toString();
//        } catch (Exception e) {
//            console.printError("Serialization error");
//            return null;
//        }
//    }
//    /**
//     * Writes collection to file.
//     * @param Map collection
//     */
//    public void writeCollection(Map<Integer, Worker> Map) {
//        OutputStreamWriter writer = null;
//        try {
//            var csv = collectionToCSV(Map);
//            if (csv == null) return;
//            writer = new OutputStreamWriter(new FileOutputStream(fileName));
//            try {
//                writer.write(csv);
//                writer.flush();
//                console.println("Collection was saved in file!");
//            } catch (IOException e) {
//                console.printError("Unexpected error while saving");
//            }
//        } catch (FileNotFoundException | NullPointerException e) {
//            console.printError("File was not found");
//        } finally {
//            try {
//                assert writer != null;
//                writer.close();
//            } catch(IOException e) {
//                console.printError("Error while closing the file");
//            }
//        }
//    }
//
//    /**
//     * Parses CSV-string to collection
//     * @param string CSV-string
//     * @return collection
//     */
//    private LinkedHashMap<Integer, Worker> CSVToCollection(String string) {
//        try {
//
//        }
//    }
}

