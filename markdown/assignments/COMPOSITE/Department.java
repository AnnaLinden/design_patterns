import java.util.ArrayList;
import java.util.List;

public class Department implements OrganizationComponent {
    private String name;
    private List<OrganizationComponent> components = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    @Override
    public void add(OrganizationComponent component) {
        components.add(component);
    }

    @Override
    public void remove(OrganizationComponent component) {
        components.remove(component);
    }

    @Override
    public double getTotalSalary() {
        double total = 0;
        for (OrganizationComponent component : components) {
            total += component.getTotalSalary();
        }
        return total;
    }

    @Override
    public String printXML() {
        StringBuilder builder = new StringBuilder();
        builder.append("<department name=\"").append(name).append("\">\n");
        for (OrganizationComponent component : components) {
            builder.append(component.printXML()).append("\n");
        }
        builder.append("</department>");
        return builder.toString();
    }
}
