/**
 * Person class represents a generic person.
 * This is an abstract class because it should not be instantiated directly.
 * It manages basic personal information.
 */
public abstract class Person {
    // Instance variables
    private String id;
    private String name;
    private int age;
    private String mobileNumber;

    // Default constructor
    public Person() {
        this.id = "Unknown";
        this.name = "Unknown";
        this.age = 0;
        this.mobileNumber = "Unknown";
    }

    // Constructor with parameters
    public Person(String id, String name, int age, String mobileNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobileNumber = mobileNumber;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(String mobileNumber) { this.mobileNumber = mobileNumber; }

    // Override toString method for printing details
    @Override
    public String toString() {
        return String.format("ID: %-5s | Name: %-10s | Age: %-3d | Mobile: %s", id, name, age, mobileNumber);
    }
}