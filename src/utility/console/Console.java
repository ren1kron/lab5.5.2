package utility.console;


import java.util.Scanner;

/**
 * Interface of Console for entering command and displaying the result
 * //
 * Консоль для ввода команд и вывода результата
 * @author maxbarsukov
 */
public interface Console {
    void print(Object obj);
    void println(Object obj);
    void printError(Object obj);
    String readln();
    boolean isCanReadln();
    void prompt();
    String getPrompt();
    void selectFileScanner(Scanner obj);
    void selectConsoleScanner();
}