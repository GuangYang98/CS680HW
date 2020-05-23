package edu.umb.cs680.hw06;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class DVDPlayerTest{

    @Test
    public void SameInstanceTest(){
        DVDPlayer instance1 = DVDPlayer.getInstance();
        DVDPlayer instance2 = DVDPlayer.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void changeStateTest(){
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerClosedPlaying.getInstance());
        State actual = player.getState();
        State expect = DrawerClosedPlaying.getInstance();
        assertEquals(actual, expect);
    }

    @Test
    public void openCloseButtonPushedTest(){
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerOpen.getInstance());
        player.openCloseButtonPushed();
        State actual = player.getState();
        State expect = DrawerClosedNotPlaying.getInstance();
        assertEquals(actual, expect);
    }

    @Test
    public void playButtonPushedTest(){
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerClosedNotPlaying.getInstance());
        player.playButtonPushed();
        State actual = player.getState();
        State expect = DrawerClosedPlaying.getInstance();
        assertEquals(actual, expect);
    }

    @Test
    public void stopButtonPushedTest(){
        DVDPlayer player = DVDPlayer.getInstance();
        player.changeState(DrawerClosedPlaying.getInstance());
        player.stopButtonPushed();
        State actual = player.getState();
        State expect = DrawerClosedNotPlaying.getInstance();
        assertEquals(actual, expect);
    }
}