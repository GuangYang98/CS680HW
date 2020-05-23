package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State{
    private DrawerClosedPlaying(){};
    private static DrawerClosedPlaying instance = null;
    private DVDPlayer player = DVDPlayer.getInstance();

    public static DrawerClosedPlaying getInstance(){
        if(instance == null){
            instance = new DrawerClosedPlaying();
        }
        return instance;
    }
    @Override
    public void openCloseButtonPushed(){
        player.open();
        player.changeState(DrawerOpen.getInstance());
    }

    @Override
    public void playButtonPushed(){
        player.play();
    }

    @Override
    public void stopButtonPushed(){
        player.stop();
        player.changeState(DrawerClosedNotPlaying.getInstance());
    }
}
