/**
 * RideInterface defines the core operations that a Ride must implement.
 * Using an interface enforces specific behavioral standards.
 */
public interface RideInterface {
    // Add a visitor to the waiting queue
    void addVisitorToQueue(Visitor visitor);

    // Remove a visitor from the waiting queue
    void removeVisitorFromQueue(Visitor visitor);

    // Print the list of all visitors currently in the queue
    void printQueue();

    // Run one cycle of the ride (process moving visitors from queue to history)
    void runOneCycle();

    // Add a visitor to the ride history
    void addVisitorToHistory(Visitor visitor);

    // Check if a visitor is in the ride history
    boolean checkVisitorFromHistory(Visitor visitor);

    // Return the number of visitors in the ride history
    int numberOfVisitors();

    // Print the ride history (Must use an Iterator)
    void printRideHistory();
}