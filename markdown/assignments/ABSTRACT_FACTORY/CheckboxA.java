public class CheckboxA extends Checkbox {
    public void display() {
        System.out.println("CheckboxA: ");
        String checkMark = text.equals("checked") ? "X" : " ";
        System.out.println("[ ] - " + checkMark);
    }
}
