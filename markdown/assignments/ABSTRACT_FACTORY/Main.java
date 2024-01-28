public class Main {
    public static void main(String[] args) {
        // UIFactory factory = new AFactory();
        UIFactory factory = new BFactory();
        TextField textField = factory.createTextField("Hello");
        Checkbox checkbox = factory.createCheckbox("Check me");
        Button button = factory.createButton("Click me");

        textField.display();
        checkbox.display();
        button.display();
    }
}
