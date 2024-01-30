public interface OrganizationComponent {
    void add(OrganizationComponent component);
    void remove(OrganizationComponent component);
    double getTotalSalary();
    String printXML();
}
