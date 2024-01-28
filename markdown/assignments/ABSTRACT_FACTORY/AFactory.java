public class AFactory extends UIFactory {
    public TextField createTextField(String text) {
        TextFieldA textField = new TextFieldA();
        textField.text = text;
        return textField;
    }

    public Checkbox createCheckbox(String text) {
        CheckboxA checkbox = new CheckboxA();
        checkbox.text = text;
        return checkbox;
    }

    public Button createButton(String text) {
        ButtonA button = new ButtonA();
        button.text = text;
        return button;
    }

}
