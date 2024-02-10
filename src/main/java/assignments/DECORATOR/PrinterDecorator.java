package assignments.DECORATOR;

public class PrinterDecorator implements Printer {
    private Printer printer;

    public PrinterDecorator(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String message) {
        printer.print(message);
    }

}
