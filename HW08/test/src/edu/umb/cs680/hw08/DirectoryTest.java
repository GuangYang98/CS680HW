package edu.umb.cs680.hw08;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class DirectoryTest {
    private String[] dirToStringArray(Directory d){
        String[] dirInfor = {
                String.valueOf(d.isFile()),
                d.getName(),
                Integer.toString(d.getSize()),
                d.getCreationTime().toString(),
                null,
                Integer.toString(d.getTotalSize()),
                Integer.toString(d.countChildren())
        };
        if (d.getParent() != null)
            dirInfor[4] = d.getParent().getName();

        return dirInfor;
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
    public void verifyDirectoryEqualityRoot(){
        String[] expected = {"false", "root", "0", date.toString(), null, "60", "2"};
        Directory dir = root;
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityHome(){
        String[] expected = {"false", "home", "0", date.toString(), "root", "40", "3"};
        Directory dir = home;
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityCode(){
        String[] expected = {"false", "code", "0", date.toString(), "home", "20", "2"};
        Directory dir = code;
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(expected, actual);
    }
}