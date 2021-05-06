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
    }

    public void render(Graphics2D g)
    {
        // draw ui box
        g.drawImage(ui,0,gamePanel.height-14,null);
        g.setColor(color);
        g.setFont(font);
        g.drawImage(asteroid,0,gamePanel.height-8,null);
        // draw timer
        int min = (int) (player.get_time()/1800) ; // 30 frames per second so in 1 min the timer increments 1800 times
        int sec = (int) ((player.get_time()/30)%60) ;
        if (min <10)
        {
            if(sec<10)
            {
                time = "0" + min + ":0" + sec ;
                g.drawString(time,160,22);
            }
            else
            {
                time = "0" + min + ":" + sec ;
                g.drawString(time,160,22);
            }
        }
        else
        {
            if(sec<10)
            {
                time = min + ":0" + sec ;
                g.drawString(time,160,22);
            }
            else
            {
                time = min + ":" + sec ;
                g.drawString(time,160,22);
            }
        }

        }
        public String get_time()
        {
            return time ;
        }

}
