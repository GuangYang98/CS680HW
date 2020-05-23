package edu.umb.cs680.hw10;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {

    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, LocalDateTime lastModified){
        super(parent, name, size, creationTime, lastModified);
    }

    public void accept(ApfsVisitor visitor) {
        visitor.visit(this);
    }

    public String getName(){
        return name;
    }

    public LocalDateTime getCreationTime(){
        return creationTime;
    }

    public boolean isDirectory(){
        return false;
    }

    public boolean isFile(){
        return true;
    }

    public boolean isLink(){
        return false;
    }
}
