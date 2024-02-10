package assignments.DECORATOR;

public class Main {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        Printer printer2 = new EncryptedPrinter(new FilePrinter(new BasicPrinter()));
        printer2.print("Hello World!");
    }

}
