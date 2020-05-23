package edu.umb.cs680.hw10;

import java.util.LinkedList;

public class ApfsFileSearchVisitor implements ApfsVisitor {

    private String fileName;
    private LinkedList<ApfsFile> foundFiles = new LinkedList<ApfsFile>();

    public ApfsFileSearchVisitor(String fileName) {
        super();
        this.fileName = fileName;
    }

    public void visit(ApfsLink link) {
        return;
    }

    public void visit(ApfsDirectory directory) {
        return;
    }

    public void visit(ApfsFile file) {
        if (file.getName().equals(fileName)) {
            foundFiles.add(file);
        }
    }

    public LinkedList<ApfsFile> getFoundFiles() {
        return foundFiles;
    }

}
