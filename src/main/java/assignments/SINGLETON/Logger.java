package assignments.SINGLETON;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private PrintWriter writer;

    private Logger(String fileName) {
        try {
            writer = new PrintWriter(new FileWriter(fileName, true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger("default_log.txt");
        }
        return instance;
    }

    public void setFileName(String fileName) {
        if (writer != null) {
            writer.close();
        }
        try {
            writer = new PrintWriter(new FileWriter(fileName, true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String message) {
        writer.println(message);
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}