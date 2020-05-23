package edu.umb.cs680.hw10;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class APFSTest {

    private String[] apfsElementToArray(ApfsElement e) {
        String[] eInfo = {e.getName(),
                Integer.toString(e.getSize())};
        return eInfo;
    }

    @Test
    public void sameAPFSTest() {
        APFS apfs1 = APFS.getInstance();
        APFS apfs2 = APFS.getInstance();
        assertSame(apfs1, apfs2);
    }

    @Test
    public void createDefaultRootTest() {
        APFS apfs1 = APFS.getInstance();
        String[] actual = this.apfsElementToArray(apfs1.createDefaultRoot());
        String[] expected = {"root", "0"};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void getRootDirTest() {
        APFS apfs1 = APFS.getInstance();
        apfs1.initFileSystem("root", 100);
        ApfsDirectory root = apfs1.getRootDir();
        String[] actual = this.apfsElementToArray(root);
        String[] expected = {"root", "0"};
        assertArrayEquals(actual, expected);
    }
}