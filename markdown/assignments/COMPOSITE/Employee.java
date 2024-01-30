public class Employee implements OrganizationComponent {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void add(OrganizationComponent component) {
        // Not applicable for Employee
    }

    @Override
    public void remove(OrganizationComponent component) {
        // Not applicable for Employee
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public String printXML() {
        return "<employee name=\"" + name + "\" salary=\"" + salary + "\"/>";
    }
}
