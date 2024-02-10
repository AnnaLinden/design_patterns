package assignments.DECORATOR;

public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String encryptedMassage = new StringBuilder(message).reverse().toString();
        super.print(encryptedMassage);
        System.out.println("Message Encrypted");
    }

}
