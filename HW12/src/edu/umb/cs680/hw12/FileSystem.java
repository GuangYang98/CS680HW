package edu.umb.cs680.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class FileSystem {
    protected String name;
    protected int capacity;
    protected int id;
    protected LinkedList<ApfsDirectory> rootDir = new LinkedList<ApfsDirectory>();

    protected abstract FSElement createDefaultRoot();
    protected void setRoot(FSElement root){
        rootDir.add((ApfsDirectory) root);
    }
    protected int getCapacity(){
        return capacity;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public FSElement initFileSystem(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        FSElement root = createDefaultRoot();
        if (root.isDirectory() && capacity>=root.getSize()){
            setRoot(root);
            this.id = root.hashCode();
            return root;
        }else {
            return null;
        }
    }
}
