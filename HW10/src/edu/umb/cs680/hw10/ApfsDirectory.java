package edu.umb.cs680.hw10;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement{

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, LocalDateTime lastModified){
        super(parent, name, size, creationTime, lastModified);
    }

    private LinkedList<ApfsElement> children = new LinkedList<ApfsElement>();

    public LinkedList<ApfsElement> getChildren(){
        return this.children;
    }

    public void appendChild(ApfsElement child){
        this.children.add(child);
    }

    public int countChildren(){
        return this.children.size();
    }

    public LinkedList<ApfsDirectory> getSubDirctories(){
        LinkedList<ApfsDirectory> directoryList = new LinkedList<ApfsDirectory>();
        for(FSElement child : children){
            if (child.isDirectory()){
                directoryList.add((ApfsDirectory) child);
            }
        }
        return directoryList;
    }

    public LinkedList<ApfsFile> getFiles(){
        LinkedList<ApfsFile> fileList = new LinkedList<ApfsFile>();
        for (FSElement child : children){
            if (!child.isDirectory()){
                fileList.add((ApfsFile) child);
            }
        }
        return fileList;
    }

    public int getTotalSize(){
        int totalSize = 0;
        Iterator<ApfsElement> fs = getChildren().iterator();
        while(fs.hasNext()){
            FSElement f = fs.next();
            if(!f.isDirectory()){
                totalSize += f.getSize();
            }
            else{
                totalSize += ((ApfsDirectory)f).getTotalSize();
            }
        }
        return totalSize;
    }

    public void accept(ApfsVisitor visitor) {
        visitor.visit(this);
        for(ApfsElement e: children){
            e.accept(visitor);
        }
    }

    public LocalDateTime getCreationTime(){
        return creationTime;
    }

    public boolean isDirectory(){
        return true;
    }

    public boolean isFile(){
        return false;
    }

    public boolean isLink(){
        return false;
    }
}
