package edu.umb.cs680.hw06;

public class DVDPlayer {
    private static DVDPlayer instance = null;
    private static State state;
    private DVDPlayer(){};

    public static DVDPlayer getInstance(){
        if (instance == null){
            instance = new DVDPlayer();
            state = DrawerClosedNotPlaying.getInstance();
        }
        return instance;
    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState(){
        return this.state;
    }

    public void openCloseButtonPushed(){
        state.openCloseButtonPushed();
    }

    public void playButtonPushed(){
        state.playButtonPushed();
    }

    public void stopButtonPushed(){
        state.stopButtonPushed();
    }

    public void open(){};
    public void close(){};
    public void play(){};
    public void stop(){};
}

