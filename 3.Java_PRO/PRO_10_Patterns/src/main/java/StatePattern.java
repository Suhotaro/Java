import java.awt.image.SampleModel;

public class StatePattern {

    public void run ()
    {
        PlayerContext context = new PlayerContext(new PausedState("paused"));

        context.pressButton();
        System.out.println(context.getState());

        context.pressButton();
        System.out.println(context.getState());
    }
}

class PlayerContext {
    private State state;

    public PlayerContext (State state) {
        this.state = state;
    }

    public void setState (State state) {
        this.state = state;
    }

    public State getState () {
        return state;
    }

    public void pressButton () {
        state.pressButton(this);
    }
}

abstract class State {
    protected String stateDes;

    public State (String stateDesc) {
        this.stateDes = stateDesc;
    }

    public abstract void pressButton(PlayerContext context);

    @Override
    public String toString() {return stateDes;}
};

class PausedState extends State {
    public PausedState (String stateDes) {
        super(stateDes);
    }

    @Override
    public void pressButton(PlayerContext context) {
        context.setState(new PlayingState("playing"));
    }
}

class PlayingState extends State {
    public PlayingState (String stateDes) {
        super(stateDes);
    }

    @Override
    public void pressButton(PlayerContext context) {
        context.setState(new PlayingState("paused"));
    }
}