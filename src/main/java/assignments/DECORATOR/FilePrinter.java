package assignments.DECORATOR;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter extends PrinterDecorator {
    private String fileName = "output.txt";

    public FilePrinter(Printer printer) {

        super(printer);
    }

    @Override
    public void print(String message) {
        // Implement file printing functionality
        try (FileWriter writer = new FileWriter(new File(fileName), true)) {
            writer.write(message);
            writer.flush();
            System.out.println("Message printed to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.print(message);
    }

}
