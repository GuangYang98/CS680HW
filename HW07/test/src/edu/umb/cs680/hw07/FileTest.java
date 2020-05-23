package edu.umb.cs680.hw07;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileTest{
    private String[] fileToStringArray(File f){
        String[] fileInfor = {
                String.valueOf(f.isFile()),
                f.getName(),
                Integer.toString(f.getSize()),
                f.getCreationTime().toString(),
                f.getParent().getName()
        };
        return fileInfor;
    }

    private static LocalDateTime date = LocalDateTime.now();
    private static Directory root = new Directory(null, "root", 0, date);
    private static Directory home = new Directory(root, "home", 0, date);
    private static Directory app = new Directory(root, "app", 0, date);
    private static Directory code = new Directory(home, "code", 0, date);

    private static File a = new File(app, "a", 10, date);
    private static File b = new File(app, "b", 10, date);

    private static File c = new File(home, "c", 10, date);
    private static File d = new File(home, "d", 10, date);
    private static File e = new File(code, "e", 10, date);
    private static File f = new File(code, "f", 10, date);

    @BeforeAll
    public static void initialization(){
        root.appendChild(home);
        root.appendChild(app);
        app.appendChild(a);
        app.appendChild(b);
        home.appendChild(code);
        home.appendChild(c);
        home.appendChild(d);
        code.appendChild(e);
        code.appendChild(f);
    }

    @Test
    public void FileATest(){
        String[] expected = {"true", "a", "10", String.valueOf(date), "app"};
        assertArrayEquals(expected, fileToStringArray(a));
    }

    @Test
    public void FileBTest(){
        String[] expected = {"true", "b", "10", String.valueOf(date), "app"};
        assertArrayEquals(expected, fileToStringArray(b));
    }

    @Test
    public void FileCTest(){
        String[] expected = {"true", "c", "10", String.valueOf(date), "home"};
        assertArrayEquals(expected, fileToStringArray(c));
    }

    @Test
    public void FileDTest(){
        String[] expected = {"true", "d", "10", String.valueOf(date), "home"};
        assertArrayEquals(expected, fileToStringArray(d));
    }

    @Test
    public void FileETest(){
        String[] expected = {"true", "e", "10", String.valueOf(date), "code"};
        assertArrayEquals(expected, fileToStringArray(e));
    }

    @Test
    public void FileFTest(){
        String[] expected = {"true", "f", "10", String.valueOf(date), "code"};
        assertArrayEquals(expected, fileToStringArray(f));
    }
}
