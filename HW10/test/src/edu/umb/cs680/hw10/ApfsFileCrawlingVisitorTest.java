package edu.umb.cs680.hw10;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ApfsFileCrawlingVisitorTest {

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
    public static void initalization() {
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
    public void rootCrawling() {
        ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
        root.accept(visitor);
        LinkedList<ApfsFile> files =  visitor.getFiles();
        ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
        ApfsFile[] expected = {e, f, c, d, a, b};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void homeCrawling() {
        ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
        home.accept(visitor);
        LinkedList<ApfsFile> files =  visitor.getFiles();
        ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
        ApfsFile[] expected = {e, f, c, d};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void applicationCrawling() {
        ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
        app.accept(visitor);
        LinkedList<ApfsFile> files =  visitor.getFiles();
        ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
        ApfsFile[] expected = {a, b};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void codeCrawling() {
        ApfsFileCrawlingVisitor visitor = new ApfsFileCrawlingVisitor();
        code.accept(visitor);
        LinkedList<ApfsFile> files =  visitor.getFiles();
        ApfsFile[] actual = files.toArray(new ApfsFile[files.size()]);
        ApfsFile[] expected = {e, f};
        assertArrayEquals(expected, actual);
    }



}