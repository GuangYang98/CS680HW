package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Iterator;

public class Directory extends FSElement{

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime){
        super(parent, name,size, creationTime);
    }

    private LinkedList<FSElement> children = new LinkedList<FSElement>();

    public LinkedList<FSElement> getChildren(){
        return this.children;
    }

    public void appendChild(FSElement child){
        this.children.add(child);
    }

    public int countChildren(){
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirctories(){
        LinkedList<Directory> directoryList = new LinkedList<Directory>();
        for(FSElement child : children){
            if (child.isDirectory()){
                directoryList.add((Directory) child);
            }
        }
        return directoryList;
    }

    public LinkedList<File> getFiles(){
        LinkedList<File> fileList = new LinkedList<File>();
        for (FSElement child : children){
            if (!child.isDirectory()){
                fileList.add((File) child);
            }
        }
        return fileList;
    }

    public int getTotalSize(){
        int totalSize = 0;
        Iterator<FSElement> fs = getChildren().iterator();
        while(fs.hasNext()){
            FSElement f = fs.next();
            if(!f.isDirectory()){
                totalSize += f.getSize();
            }
            else{
                totalSize += ((Directory)f).getTotalSize();
            }
        }
        return totalSize;
    }

    public boolean isDirectory(){
        return true;
    }

    public boolean isFile(){
        return false;
    }
}
