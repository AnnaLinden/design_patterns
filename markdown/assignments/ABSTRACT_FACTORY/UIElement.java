public abstract class UIElement {
    protected String text;

    public void setText(String text) {
        this.text = text;
    }

    public abstract void display();
}
