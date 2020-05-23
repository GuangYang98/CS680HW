package edu.umb.cs680.hw09;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsFileTest {

    private String[] fileToStringArray(ApfsFile e) {

        String [] fileInfo = {
                String.valueOf(e.isFile()), e.getName(), String.valueOf(e.getSize()),String.valueOf(e.getCreationTime()),e.getParent().getName(),
                String.valueOf(e.getLastModified())
        };

        return fileInfo;
    }

    private static LocalDateTime date = LocalDateTime.now();
    private static ApfsDirectory root = new ApfsDirectory(null, "root", 0, date, date);
    private static ApfsDirectory home = new ApfsDirectory(root, "home", 0, date, date);
    private static ApfsDirectory app = new ApfsDirectory(root, "app", 0, date, date);
    private static ApfsDirectory code = new ApfsDirectory(home, "code", 0, date, date);

    private static ApfsFile a = new ApfsFile(app, "a", 10, date, date);
    private static ApfsFile b = new ApfsFile(app, "b", 10, date, date);

    private static ApfsFile c = new ApfsFile(home, "c", 10, date, date);
    private static ApfsFile d = new ApfsFile(home, "d", 10, date, date);
    private static ApfsFile e = new ApfsFile(code, "e", 10, date, date);
    private static ApfsFile f = new ApfsFile(code, "f", 10, date, date);

    private static ApfsLink x = new ApfsLink(home, "x", 10, date, date, null);
    private static ApfsLink y = new ApfsLink(code, "y", 10, date, date, null);

    @BeforeAll
    public static void initalization(){
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
        String[] expected = {"true", "a", "10", String.valueOf(date), "app", String.valueOf(date)};
        assertArrayEquals(expected, fileToStringArray(a));
    }

    @Test
    public void FileBTest(){
        String[] expected = {"true", "b", "10", String.valueOf(date), "app", String.valueOf(date)};
        assertArrayEquals(expected, fileToStringArray(b));
    }

    @Test
    public void FileCTest(){
        String[] expected = {"true", "c", "10", String.valueOf(date), "home", String.valueOf(date)};
        assertArrayEquals(expected, fileToStringArray(c));
    }

    @Test
    public void FileDTest(){
        String[] expected = {"true", "d", "10", String.valueOf(date), "home", String.valueOf(date)};
        assertArrayEquals(expected, fileToStringArray(d));
    }

    @Test
    public void FileETest(){
        String[] expected = {"true", "e", "10", String.valueOf(date), "code", String.valueOf(date)};
        assertArrayEquals(expected, fileToStringArray(e));
    }

    @Test
    public void FileFTest(){
        String[] expected = {"true", "f", "10", String.valueOf(date), "code", String.valueOf(date)};
        assertArrayEquals(expected, fileToStringArray(f));
    }
}