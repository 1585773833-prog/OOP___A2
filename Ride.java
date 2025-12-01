import java.io.*;
import java.util.*;

/**
 * Ride class manages the state of a theme park ride, including the waiting queue and history.
 * Implements the RideInterface.
 */
public class Ride implements RideInterface {
    private String rideName;
    private String rideType; // e.g., Rollercoaster, Water Ride
    private Employee operator; // Staff operating the ride
    private int maxRider;      // Max visitors per cycle
    private int numOfCycles;   // Number of times the ride has run

    // Collections
    private Queue<Visitor> waitingQueue; // Waiting Line (Part 3)
    private LinkedList<Visitor> rideHistory; // Ride History (Part 4)

    // Default Constructor
    public Ride() {
        this.rideName = "Unknown Ride";
        this.rideType = "Generic";
        this.operator = null;
        this.maxRider = 1;
        this.numOfCycles = 0;
        this.waitingQueue = new LinkedList<>(); // LinkedList implements Queue interface
        this.rideHistory = new LinkedList<>();
    }

    // Parameterized Constructor
    public Ride(String rideName, String rideType, Employee operator, int maxRider) {
        this.rideName = rideName;
        this.rideType = rideType;
        this.operator = operator;
        this.maxRider = maxRider;
        this.numOfCycles = 0;
        this.waitingQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Getters and Setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    
    public String getRideType() { return rideType; }
    public void setRideType(String rideType) { this.rideType = rideType; }
    
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    
    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }
    
    public int getNumOfCycles() { return numOfCycles; }

    // --- Part 2 & 3: Queue Interface Implementation ---

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingQueue.offer(visitor); // 'offer' is the preferred method for Queues
            System.out.println("Successfully added visitor to the queue: " + visitor.getName());
        } else {
            System.out.println("Error: Visitor object is null. Cannot add to queue.");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (waitingQueue.remove(visitor)) {
            System.out.println("Successfully removed visitor from the queue: " + visitor.getName());
        } else {
            System.out.println("Error: Visitor not found in the queue.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("\n=== Current Waiting Queue (Total: " + waitingQueue.size() + ") ===");
        if (waitingQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            for (Visitor v : waitingQueue) {
                System.out.println(v);
            }
        }
    }

    // --- Part 4A: History Interface Implementation ---

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Successfully added visitor to ride history: " + visitor.getName());
        } else {
            System.out.println("Error: Visitor object is null. Cannot add to history.");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean exists = rideHistory.contains(visitor);
        System.out.println("Check if " + visitor.getName() + " is in history: " + (exists ? "Yes" : "No"));
        return exists;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("\n=== Ride History Record (Total: " + rideHistory.size() + ") ===");
        // Critical: Must use Iterator as per assignment requirements
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    // --- Part 4B: Sorting ---

    public void sortRideHistory() {
        // Sort using the custom VisitorComparator
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history has been sorted by [Age (Ascending) -> Name (A-Z)].");
    }

    // --- Part 5: Run a Cycle ---

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("Error: Cannot run the ride. No operator assigned.");
            return;
        }

        if (waitingQueue.isEmpty()) {
            System.out.println("Error: Cannot run the ride. The waiting queue is empty.");
            return;
        }

        System.out.println("\n--- Running Ride Cycle " + (numOfCycles + 1) + " ---");
        
        int ridersProcessed = 0;
        // Move visitors: Remove from Queue -> Add to History
        // Loop runs while Queue is not empty AND we haven't reached max capacity
        while (!waitingQueue.isEmpty() && ridersProcessed < maxRider) {
            Visitor v = waitingQueue.poll(); // Retrieve and remove head of queue
            addVisitorToHistory(v);
            ridersProcessed++;
        }

        numOfCycles++;
        System.out.println("Cycle finished. Processed " + ridersProcessed + " visitors.");
    }

    // --- Part 6: Export to File ---

    public void exportRideHistory(String filename) {
        // Use try-with-resources to automatically close the writer
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor v : rideHistory) {
                // CSV Format: ID,Name,Age,Mobile,TicketType,IsVip
                String line = String.format("%s,%s,%d,%s,%s,%b",
                        v.getId(), v.getName(), v.getAge(), v.getMobileNumber(),
                        v.getTicketType(), v.isVip());
                writer.write(line);
                writer.newLine(); // New line
            }
            System.out.println("Successfully exported ride history to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error exporting to file: " + e.getMessage());
        }
    }

    // --- Part 7: Import from File ---

    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split CSV line by comma
                String[] data = line.split(",");
                if (data.length == 6) {
                    // Parse data and create new Visitor object
                    String id = data[0];
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String mobile = data[3];
                    String ticket = data[4];
                    boolean isVip = Boolean.parseBoolean(data[5]);

                    Visitor v = new Visitor(id, name, age, mobile, ticket, isVip);
                    addVisitorToHistory(v); // Add to history list
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
            System.out.println("Successfully imported data from file: " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filename);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}