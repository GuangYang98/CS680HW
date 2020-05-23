package edu.umb.cs680.hw12;

import java.util.Comparator;

public class ElementKindComparator implements Comparator<ApfsElement> {
    private int rate1, rate2;

    public int compare(ApfsElement a1, ApfsElement a2) {
        if(a1.isDirectory()) rate1 = 10;
        if(a1.isFile()) rate1 = 20;
        if(a1.isLink()) rate1 = 30;

        if(a2.isDirectory()) rate2 = 10;
        if(a2.isFile()) rate2 = 20;
        if(a2.isLink()) rate2 = 30;

        return rate1 - rate2;

    }
}
