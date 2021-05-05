package GameState;

import java.awt.Graphics2D;
import java.util.ArrayList ;

// this class manages all the game states(menu,play,gameover)
// it adds and switches between different states
public class StateManager {

    private ArrayList<GameState> gameStates ;
    private int currentState ;
    public static final int MenuState = 0 ;
    public static final int PlayState = 1 ;    // game states
    public static final int GameOverState = 2 ;



    public StateManager()
    {
        gameStates = new ArrayList<GameState>() ; // arraylist of game states
        currentState= MenuState ;

        gameStates.add(new MenuState(this)) ; //add menu state
        gameStates.add(new PlayState(this)) ; // add play state
        gameStates.add(new GameOverState(this)) ; // add gameover state

    }

    public void setCurrentState(int state)
    {
        currentState = state ;
    }


    public void update()
    {
        gameStates.get(currentState).update() ;
    }
    public void render(Graphics2D g)
    {
        gameStates.get(currentState).render(g) ;
    }
    public void keyPressed(int e)
    {
        gameStates.get(currentState).keyPressed(e) ;
    }
    public void keyReleased(int e)
    {
        gameStates.get(currentState).keyReleased(e) ;
    }

}
