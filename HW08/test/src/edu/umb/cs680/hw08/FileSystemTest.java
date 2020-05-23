package edu.umb.cs680.hw08;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

public class FileSystemTest {
    private Directory[] LinkedListToArray(LinkedList<Directory> rootList) {
        Directory[] roots = new Directory[rootList.size()];
        int i = 0;
        for (Directory root: rootList) {
            roots[i] = root;
            i++;
        }
        return roots;
    }

    @Test
    public void SameInstance() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2);
    }

    @Test
    public void RootTest() {
        LocalDateTime date = LocalDateTime.now();;
        Directory root = new Directory(null, "root", 0, date);
        FileSystem fs = FileSystem.getFileSystem();
        fs.addRootDir(root);
        Directory[] actual = LinkedListToArray(fs.getRootDirs());
        Directory[] expected = {root};
        assertArrayEquals(expected, actual);

    }
}