import java.util.Comparator;

/**
 * VisitorComparator implements the Comparator interface.
 * As per the rubric, it uses at least two instance variables for comparison.
 * Logic: First sorts by Age (Ascending), if age is equal, sorts by Name (Alphabetical).
 */
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First level comparison: Age
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        
        // If ages are different, return the age comparison result
        if (ageCompare != 0) {
            return ageCompare;
        }
        
        // Second level comparison: Name (if ages are the same)
        return v1.getName().compareTo(v2.getName());
    }
}