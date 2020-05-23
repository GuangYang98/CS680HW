package edu.umb.cs680.hw10;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ApfsCountingVisitorTest {

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

    private static ApfsLink x = new ApfsLink(home, "x", 10, date, date, app);
    private static ApfsLink y = new ApfsLink(code, "y", 10, date, date, b);

    @BeforeAll
    public static void initalization(){
        root.appendChild(home);
        root.appendChild(app);

        app.appendChild(a);
        app.appendChild(b);

        home.appendChild(code);
        home.appendChild(c);
        home.appendChild(d);
        home.appendChild(x);

        code.appendChild(e);
        code.appendChild(f);
        code.appendChild(y);
    }

    @Test
    public void visitorCountFile() {
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        root.accept(visitor);
        int actual = visitor.getFileNum();
        //a, b, c, d, e, f
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void visitorCountLink() {
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        root.accept(visitor);
        int actual = visitor.getLinkNum();
        //x, y
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void visitorCountDirectory() {
        ApfsCountingVisitor visitor = new ApfsCountingVisitor();
        root.accept(visitor);
        int actual = visitor.getDirNum();
        //root, application, home, code
        int expected = 4;
        assertEquals(expected, actual);
    }
}