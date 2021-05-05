package GameState;

import java.io.Serializable;
import java.util.ArrayList;

// serializable class, stores array of scores to load it when executing the game
public class Score implements Serializable {

    private ArrayList<String> scores ;

    public Score() {
        scores = new ArrayList<String>() ;
    }

    public void add_score(String s)
    {
        scores.add(s) ;
    }
    public ArrayList<String> get_scores()
    {
        return scores ;
    }
    
}
