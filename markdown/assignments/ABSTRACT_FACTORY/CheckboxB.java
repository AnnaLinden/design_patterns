public class CheckboxB extends Checkbox {
    public void display() {
        System.out.println("CheckboxB");
        String checkMark = text.equals("checked") ? "X" : " ";
        System.out.println("( " + checkMark + " ) - " + text);

    }

}
