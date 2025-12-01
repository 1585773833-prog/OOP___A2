/**
 * Employee class extends Person, representing staff working at the theme park.
 * Adds specific attributes for job title and salary.
 */
public class Employee extends Person {
    private String jobTitle;
    private double salary;

    // Default constructor
    public Employee() {
        super();
        this.jobTitle = "General Staff";
        this.salary = 0.0;
    }

    // Constructor with parameters
    public Employee(String id, String name, int age, String mobileNumber, String jobTitle, double salary) {
        super(id, name, age, mobileNumber);
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    // Getters and Setters
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "[Employee] " + super.toString() + " | Title: " + jobTitle + " | Salary: $" + salary;
    }
}