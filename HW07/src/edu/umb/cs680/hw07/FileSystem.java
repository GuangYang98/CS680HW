package edu.umb.cs680.hw07;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDir = new LinkedList<Directory>();
    LocalDateTime rootTime = LocalDateTime.now();
    Directory root;
    private FileSystem(){};

    public static FileSystem getFileSystem(){
        if(instance == null){
            instance = new FileSystem();
        }
        return instance;
    }

    public LinkedList<Directory> getRootDirs(){
        return rootDir;
    }

    public void addRootDir(Directory rootDir){
        this.rootDir.add(rootDir);
    }
}
