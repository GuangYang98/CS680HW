package edu.umb.cs680.hw10;

public interface ApfsVisitor {
    public void visit(ApfsLink link);
    public void visit(ApfsDirectory directory);
    public void visit(ApfsFile file);
}
