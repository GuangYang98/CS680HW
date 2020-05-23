package edu.umb.cs680.hw15;

import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<ApfsElement> {
    public int compare(ApfsElement a1, ApfsElement a2) {
        return a2.getName().compareTo(a1.getName());
    }
}
