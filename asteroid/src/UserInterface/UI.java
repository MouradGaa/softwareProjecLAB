package UserInterface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


import GameState.StateManager;
import GameState.content;
import Main.gamePanel;
import Object.Player ;
import Object.asteroid;

public class UI {

    private BufferedImage asteroid;
    private BufferedImage ui ;
    private Player player ;
    private String time ;
    private String depth   ;
    private String state1;
    private String state2;
    private String radioactive;


    private StateManager sm ;

    private Font font ;
    private Color color ;

    public UI(Player p, ArrayList<asteroid> b)
    {
        player = p ;
        asteroid = content.asteroid[0][0] ;
        ui =content.ui[0][0] ;
        font = new Font("Century Gothic",Font.BOLD,20) ;
        color = new Color(0xFC420005, true) ;
    //depth = asteroid.g
    }

    public void render(Graphics2D g)
    {
        // draw ui box
        g.drawImage(ui, gamePanel.width-200,gamePanel.height-50,null);
        g.setColor(color);
        g.setFont(font);
       // g.drawString("depth : " + depth);
       // g.drawImage(asteroid,0,gamePanel.height-8,null);
        if(player.isCollided()) {
            asteroid a = player.getAsteroid();
            depth = String.valueOf(a.getDepth());
            state1 = "Perehilion";
            state2 = "Aphelion";
            radioactive = "radioactive";
            // draw the statistics of the asteroid on the screen
            if ( a.getPERIHELION() == 1)
                g.drawString("state : " + state1,gamePanel.width-190,gamePanel.height-6);
            else g.drawString("state : " + state2,gamePanel.width-190,gamePanel.height-6);
            g.drawString("depth : " + depth,gamePanel.width-190,gamePanel.height-25);
            if (a.isRadioactive())
                g.drawString("state : " + radioactive,gamePanel.width-190,gamePanel.height+10);

        }
        // draw timer
        int min = (int) (player.get_time()/1800) ; // 30 frames per second so in 1 min the timer increments 1800 times
        int sec = (int) ((player.get_time()/30)%60) ;
        if (min <10)
        { // timer position on the map
            if(sec<10)
            {
                time = "0" + min + ":0" + sec ;
                g.drawString(time,210,22);
            }
            else
            {
                time = "0" + min + ":" + sec ;
                g.drawString(time,210,22);
            }
        }
        else
        {
            if(sec<10)
            {
                time = min + ":0" + sec ;
                g.drawString(time,210,22);
            }
            else
            {
                time = min + ":" + sec ;
                g.drawString(time,210,22);
            }
        }

        }
        public String get_time()
        {
            return time ;
        }

}
