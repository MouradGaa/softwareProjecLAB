package GameState;

import java.awt.*;

// super abstract class for games states
public abstract class GameState {

    protected StateManager sm ;

    public GameState(StateManager sm)
    {
        this.sm=sm;
    }

    public abstract void init();

    public abstract void render(Graphics2D g);

    public abstract void update();

    public abstract void keyPressed(int e);

    public abstract void keyReleased(int e);

}
