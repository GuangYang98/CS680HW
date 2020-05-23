package edu.umb.cs680.hw09;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ApfsDirectoryTest {
    private String[] dirToStringArray(ApfsDirectory d){
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
    public void verifyDirectoryEqualityRoot(){
        String[] expected = {"false", "root", "0", date.toString(), null, "60", "2"};
        ApfsDirectory dir = root;
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityHome(){
        String[] expected = {"false", "home", "0", date.toString(), "root", "40", "3"};
        ApfsDirectory dir = home;
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void verifyDirectoryEqualityCode(){
        String[] expected = {"false", "code", "0", date.toString(), "home", "20", "2"};
        ApfsDirectory dir = code;
        String[] actual = dirToStringArray(dir);
        assertArrayEquals(expected, actual);
    }
}