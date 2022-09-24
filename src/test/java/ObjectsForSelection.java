public class ObjectsForSelection {

    private String name;
    private String position;
    private String office;
    private int age;
    private double salary;

    public ObjectsForSelection(String name, String position, String office, int age, double salary) {
        this.name = name;
        this.position = position;
        this.office = office;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        String employeeInfo;
        employeeInfo = String.format("Name: %-15s Position: %-25s Office: %-10s", name, position,office);
        return employeeInfo;
    }
}
