package edu.umb.cs680.hw15;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ElementKindComparatorTest {
    private static LocalDateTime date = LocalDateTime.of(2019, 12, 30, 12, 30);
    private static LocalDateTime date1 = LocalDateTime.of(2020, 5, 1, 12, 30);
    private static ApfsDirectory root = new ApfsDirectory(null, "root", 0, date, date1);
    private static ApfsDirectory home = new ApfsDirectory(root, "home", 0, date, date1);
    private static ApfsDirectory app = new ApfsDirectory(root, "app", 0, date, date1);
    private static ApfsDirectory code = new ApfsDirectory(home, "code", 0, date, date1);

    private static ApfsFile a = new ApfsFile(app, "a", 10, date, date1);
    private static ApfsFile b = new ApfsFile(app, "b", 10, date, date1);

    private static ApfsFile c = new ApfsFile(home, "c", 10, date, date1);
    private static ApfsFile d = new ApfsFile(home, "d", 10, date, date1);
    private static ApfsFile e = new ApfsFile(code, "e", 10, date, date1);
    private static ApfsFile f = new ApfsFile(code, "f", 10, date, date1);

    private static ApfsLink x = new ApfsLink(home, "x", 10, date, date1, null);
    private static ApfsLink y = new ApfsLink(code, "y", 10, date, date1, null);

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
    public void ElementKindChildren() {
        int i = 0;
        String[] expected = {"code","c","d"};
        LinkedList<ApfsElement> list = home.getChildren((ApfsElement a1, ApfsElement a2)-> { int rate1 =0; int rate2 = 0;
            if(a1.isDirectory()) rate1 = 10;
            if(a1.isFile()) rate1 = 20;
            if(a1.isLink()) rate1 = 30;

            if(a2.isDirectory()) rate2 = 10;
            if(a2.isFile()) rate2 = 20;
            if(a2.isLink()) rate2 = 30;
            return rate1 - rate2;});

        String[] actual = new String[list.size()];
        for(ApfsElement f : list) {
            actual[i++] = f.getName();
        }
        assertArrayEquals(expected,actual);
    }

    @Test
    public void ElementKindCodeCheck() {
        int i = 0;
        String[] expected = {"e","f"};
        LinkedList<ApfsElement> list = code.getChildren((ApfsElement a1, ApfsElement a2)-> { int rate1 =0; int rate2 = 0;
        if(a1.isDirectory()) rate1 = 10;
        if(a1.isFile()) rate1 = 15;
        if(a1.isLink()) rate1 = 20;

        if(a2.isDirectory()) rate2 = 10;
        if(a2.isFile()) rate2 = 15;
        if(a2.isLink()) rate2 = 20;
        return rate1 - rate2;});

        String[] actual = new String[list.size()];
        for(ApfsElement f : list) {
            actual[i++] = f.getName();
        }
        assertArrayEquals(expected,actual);
    }

}