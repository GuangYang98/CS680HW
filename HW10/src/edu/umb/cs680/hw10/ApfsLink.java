package edu.umb.cs680.hw10;
import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement{

    private FSElement target;

    public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, LocalDateTime lastModified, FSElement target){
        super(parent, name, size, creationTime, lastModified);
        this.target = target;
    }

    public void accept(ApfsVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isDirectory(){
        return false;
    }

    public boolean isFile(){
        return false;
    }

    public boolean isLink(){
        return true;
    }

    public FSElement getTarget(){
        return target;
    }

    public void setTarget(FSElement target){
        this.target = target;
    }
}
