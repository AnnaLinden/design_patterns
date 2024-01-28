public class BFactory extends UIFactory {
    public TextField createTextField(String text) {
        TextFieldB textField = new TextFieldB();
        textField.text = text;
        return textField;
    }

    public Checkbox createCheckbox(String text) {
        CheckboxB checkbox = new CheckboxB();
        checkbox.text = text;
        return checkbox;
    }

    public Button createButton(String text) {
        ButtonB button = new ButtonB();
        button.text = text;
        return button;
    }

}
