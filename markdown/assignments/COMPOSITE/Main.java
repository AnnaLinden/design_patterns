public class Main {
    public static void main(String[] args) {
        Department sales = new Department("Sales");
        Department it = new Department("IT");

        Employee john = new Employee("John", 40000);
        Employee jane = new Employee("Jane", 45000);
        Employee mike = new Employee("Mike", 50000);

        sales.add(john);
        sales.add(jane);
        it.add(mike);

        Department company = new Department("Company");
        company.add(sales);
        company.add(it);

        System.out.println("Total Salary: " + company.getTotalSalary());
        System.out.println(company.printXML());
    }
}