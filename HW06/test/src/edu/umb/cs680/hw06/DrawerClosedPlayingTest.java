package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DrawerClosedPlayingTest{

    @Test
    public void sameInstanceCheck(){
        DrawerClosedPlaying instance1 = DrawerClosedPlaying.getInstance();
        DrawerClosedPlaying instance2 = DrawerClosedPlaying.getInstance();
        assertSame(instance1,instance2);
    }

    @Test
    public void openCloseButtonPushedTest(){
        DVDPlayer player = DVDPlayer.getInstance();
        DrawerClosedPlaying closePlay = DrawerClosedPlaying.getInstance();
        player.changeState(closePlay);
        closePlay.openCloseButtonPushed();
        State actual = player.getState();
        State expect = DrawerOpen.getInstance();
        assertEquals(actual, expect);
    }

    @Test
    public void playButtonPushedTest(){
        DVDPlayer player = DVDPlayer.getInstance();
    }
}