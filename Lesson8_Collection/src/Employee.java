public class Employee <T, K>{
    private T id;
    private String name;
    private K year;

    public Employee(T id, String name, K year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
