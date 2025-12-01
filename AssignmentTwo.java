/**
 * AssignmentTwo class contains the main method and demonstration logic for each part of the assignment.
 */
public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        
        System.out.println("---------------------------------------");
        assignment.partThree();
        System.out.println("---------------------------------------");
        assignment.partFourA();
        System.out.println("---------------------------------------");
        assignment.partFourB();
        System.out.println("---------------------------------------");
        assignment.partFive();
        System.out.println("---------------------------------------");
        assignment.partSix();
        System.out.println("---------------------------------------");
        assignment.partSeven();
        System.out.println("---------------------------------------");
    }

    public void partThree() {
        System.out.println(">>> Part 3: Demonstration of Waiting Queue (Queue)");
        
        Ride rollerCoaster = new Ride();
        rollerCoaster.setRideName("Speedy Coaster");

        // Create Visitors
        Visitor v1 = new Visitor("V001", "Jack", 25, "123456789", "Unlimited", true);
        Visitor v2 = new Visitor("V002", "Sharon", 30, "987654321", "Unlimited", false);
        Visitor v3 = new Visitor("V003", "Benny", 18, "112233445", "Standard", false);
        Visitor v4 = new Visitor("V004", "Leo", 22, "556677889", "Unlimited", true);
        Visitor v5 = new Visitor("V005", "Nehemia", 28, "667788990", "Standard", false);

        // Add to Queue
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // Remove a visitor
        rollerCoaster.removeVisitorFromQueue(v3); // Remove Benny

        // Print Queue
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        System.out.println(">>> Part 4A: Demonstration of Ride History (LinkedList)");
        
        Ride waterRide = new Ride();
        waterRide.setRideName("Splash Mountain");

        Visitor v1 = new Visitor("V010", "Alice", 20, "111", "Unlimited", true);
        Visitor v2 = new Visitor("V011", "Bob", 22, "222", "Unlimited", false);
        Visitor v3 = new Visitor("V012", "Charlie", 25, "333", "Standard", false);
        Visitor v4 = new Visitor("V013", "David", 19, "444", "Unlimited", true);
        Visitor v5 = new Visitor("V014", "Eve", 21, "555", "Standard", false);

        // Add to History
        waterRide.addVisitorToHistory(v1);
        waterRide.addVisitorToHistory(v2);
        waterRide.addVisitorToHistory(v3);
        waterRide.addVisitorToHistory(v4);
        waterRide.addVisitorToHistory(v5);

        // Check Visitors
        waterRide.checkVisitorFromHistory(v3); // Should return Yes (true)
        Visitor unknown = new Visitor("V999", "Unknown", 0, "0", "None", false);
        waterRide.checkVisitorFromHistory(unknown); // Should return No (false)

        // Print Count
        System.out.println("Total visitors in history: " + waterRide.numberOfVisitors());

        // Print All
        waterRide.printRideHistory();
    }

    public void partFourB() {
        System.out.println(">>> Part 4B: Demonstration of Sorting");
        
        Ride ride = new Ride();
        // Add random data
        ride.addVisitorToHistory(new Visitor("V1", "Zack", 30, "000", "Std", false));
        ride.addVisitorToHistory(new Visitor("V2", "Adam", 30, "111", "Std", false)); // Same age, Name first
        ride.addVisitorToHistory(new Visitor("V3", "Ben", 15, "222", "Std", false));  // Youngest
        ride.addVisitorToHistory(new Visitor("V4", "Chris", 40, "333", "Std", false)); // Oldest
        ride.addVisitorToHistory(new Visitor("V5", "Zack", 20, "444", "Std", false)); // Same Name, Younger

        System.out.println("--- Before Sorting ---");
        ride.printRideHistory();

        ride.sortRideHistory();

        System.out.println("--- After Sorting ---");
        ride.printRideHistory();
    }

    public void partFive() {
        System.out.println(">>> Part 5: Demonstration of Running a Cycle");
        
        Employee operator = new Employee("E01", "John Operator", 40, "555-1234", "Ride Operator", 50000);
        Ride ferrisWheel = new Ride("Ferris Wheel", "Family", operator, 3); // maxRider = 3

        // Add 10 visitors to the Queue
        for (int i = 1; i <= 10; i++) {
            ferrisWheel.addVisitorToQueue(new Visitor("V"+i, "Visitor"+i, 20+i, "000"+i, "Unlimited", false));
        }

        ferrisWheel.printQueue();

        // Run one cycle (should process the first 3 visitors)
        ferrisWheel.runOneCycle();

        System.out.println("--- After Running One Cycle ---");
        ferrisWheel.printQueue(); // Should have 7 left
        ferrisWheel.printRideHistory(); // Should have 3 processed
    }

    public void partSix() {
        System.out.println(">>> Part 6: Exporting Data to File");
        
        Ride ride = new Ride();
        ride.addVisitorToHistory(new Visitor("V100", "ExportData", 50, "999", "VIP", true));
        ride.addVisitorToHistory(new Visitor("V101", "SaveMe", 22, "888", "STD", false));
        ride.addVisitorToHistory(new Visitor("V102", "FileTest", 33, "777", "STD", false));
        ride.addVisitorToHistory(new Visitor("V103", "JavaIO", 44, "666", "VIP", true));
        ride.addVisitorToHistory(new Visitor("V104", "Success", 18, "555", "STD", false));

        ride.exportRideHistory("ride_history.csv");
    }

    public void partSeven() {
        System.out.println(">>> Part 7: Importing Data from File");
        
        Ride ride = new Ride();
        System.out.println("History count before import: " + ride.numberOfVisitors());

        // Import the file created in Part 6
        ride.importRideHistory("ride_history.csv");

        System.out.println("History count after import: " + ride.numberOfVisitors());
        ride.printRideHistory();
    }
}