package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public abstract class FSElement {
    private String name;
    private int size;
    private LocalDateTime creationTime;
    private Directory parent;

    public FSElement(Directory parent, String name, int size, LocalDateTime creationTime){
        this.parent = parent;
        this.name= name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Directory getParent(){
        return this.parent;
    }

    public int getSize(){
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LocalDateTime getCreationTime(){
        return this.creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

//  Implement by the subclass
    public abstract boolean isDirectory();
    public abstract boolean isFile();
}
