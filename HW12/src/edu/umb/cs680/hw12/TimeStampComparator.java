package edu.umb.cs680.hw12;
import java.util.Comparator;

public class TimeStampComparator implements Comparator<ApfsElement> {
    public int compare(ApfsElement a1, ApfsElement a2) {
        return a1.getCreationTime().compareTo(a2.getCreationTime());
    }

}
