public class Employee {

    private String name;
    private String position;
    private String office;


    public Employee(String name, String position, String office) {
        this.name = name;
        this.position = position;
        this.office = office;
    }

    @Override
    public String toString() {
        String employeeInfo;
        employeeInfo = String.format("Name: %-15s Position: %-25s Office: %-10s", name, position,office);
        return employeeInfo;
    }
}
