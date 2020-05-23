package edu.umb.cs680.hw10;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsElement extends FSElement{

    private LocalDateTime lastModified;
    private LinkedList<ApfsElement> ApfsChildren = new LinkedList<ApfsElement>();

    public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, LocalDateTime lastModified){
        super(parent, name, size, creationTime);
        this.lastModified = lastModified;
    }

    public void accept(ApfsVisitor visitor) {

    }

    public int getSize() { return this.size; }

    public LocalDateTime getLastModified(){
        return lastModified;
    }

    public void setLastModified(){
        this.lastModified = lastModified;
    }

    public LinkedList<ApfsElement> getChildren(){
        return this.ApfsChildren;
    }

    public void appendChild(FSElement child){
        this.ApfsChildren.add((ApfsElement) child);
    }

    public boolean isDirectory(){
        return false;
    }

    public boolean isFile(){
        return false;
    }

    public boolean isLink(){
        return false;
    }
}
