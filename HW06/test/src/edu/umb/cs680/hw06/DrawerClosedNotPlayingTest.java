package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DrawerClosedNotPlayingTest {
    @Test
    public void sameInstanceCheck() {
        DrawerClosedNotPlaying instance1 = DrawerClosedNotPlaying.getInstance();
        DrawerClosedNotPlaying instance2 = DrawerClosedNotPlaying.getInstance();
        assertSame(instance1,instance2);
    }

    @Test
    public void openCloseButtonPushedTest() {
        DVDPlayer player = DVDPlayer.getInstance();
        DrawerClosedNotPlaying closeNotPlay =  DrawerClosedNotPlaying.getInstance();
        player.changeState(closeNotPlay);
        closeNotPlay.openCloseButtonPushed();
        State actual = player.getState();
        State expect = DrawerOpen.getInstance();
        assertEquals(actual,expect);
    }

    @Test
    public void playButtonPushedTest() {
        DVDPlayer player = DVDPlayer.getInstance();
        DrawerClosedNotPlaying closeNotPlay =  DrawerClosedNotPlaying.getInstance();
        player.changeState(closeNotPlay);
        closeNotPlay.playButtonPushed();
        State actual = player.getState();
        State expect = DrawerClosedPlaying.getInstance();
        assertEquals(actual,expect);
    }


    @Test
    public void stopButtonPushedTest() {
        DVDPlayer player = DVDPlayer.getInstance();
        DrawerClosedNotPlaying closeNotPlay =  DrawerClosedNotPlaying.getInstance();
        player.changeState(closeNotPlay);
        closeNotPlay.stopButtonPushed();
        State actual = player.getState();
        State expect = DrawerClosedNotPlaying.getInstance();
        assertEquals(actual,expect);
    }

}
