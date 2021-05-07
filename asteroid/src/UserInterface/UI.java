package UserInterface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


import GameState.PlayState;
import GameState.StateManager;
import GameState.content;
import Main.gamePanel;
import Object.Player ;
import Object.asteroid;
import classes.Inventory;

public class UI {

    private BufferedImage asteroid;
    private BufferedImage ui ;
    private BufferedImage ui2 ;
    private Player player ;
    private Inventory inventory ;
    private String time ;
    private String depth   ;
    private String state1;
    private String state2;
    private String radioactive;
    private String resource;
    private String lives;
    private String sinventory;

    private String[] terma = {"Carbon:","Iron:", "WaterIce:","Uranium:"};
    private StateManager sm ;

    private Font font ;
    private Color color ;

    public UI(Player p, ArrayList<asteroid> b)
    {  inventory = PlayState.inventory;


        player = p ;
        asteroid = content.asteroid[0][0] ;
        ui =content.ui[0][0] ;
        ui2 =content.ui2[0][0] ;
        font = new Font("Century Gothic",Font.BOLD,10) ;
        color = new Color(0xFC7A76E8, true) ;
    //depth = asteroid.g
    }

    public void render(Graphics2D g)
    {


        // draw ui box
        g.drawImage(ui, gamePanel.width-200,gamePanel.height-50,null);
        g.drawImage(ui2, gamePanel.width-80,gamePanel.height-300,null);
        g.setColor(color);
        g.setFont(font);
        lives = String.valueOf(player.getLives());
        g.drawString("Lives : " + lives,gamePanel.width-65,gamePanel.height-280);
        g.drawString("resources : " ,gamePanel.width-65,gamePanel.height-260);

        for ( int i=0 ; i< 4 ; i++){
            g.drawString( terma[i],gamePanel.width-65,gamePanel.height-240+10*i);
        }
        try {
            for ( int i=0 ; i< 4 ; i++){
               sinventory = String.valueOf(inventory.getResourceNumber(i));
                g.drawString(sinventory ,gamePanel.width-15,gamePanel.height-240+10*i);

            }} catch (Exception e) {
        }

        if(player.isCollided()) {
            asteroid a = player.getAsteroid();
            depth = String.valueOf(a.getDepth());
            state1 = "Perehilion";
            state2 = "Aphelion";
            radioactive = "radioactive";
            resource = a.getResourceNames();
            // draw the statistics of the asteroid on the screen
            if ( a.getPERIHELION() == 1)
                g.drawString("state : " + state1,gamePanel.width-190,gamePanel.height-6);
            else g.drawString("state : " + state2,gamePanel.width-190,gamePanel.height-6);
            g.drawString("depth : " + depth + "| ",gamePanel.width-190,gamePanel.height-25);
            if (a.isRadioactive())
                g.drawString("state : " + radioactive,gamePanel.width-140,gamePanel.height-25);
            g.drawString("resource : " + resource,gamePanel.width-190,gamePanel.height+10);
        }
        // draw timer
        int min = (int) (player.get_time()/1800) ; // 30 frames per second so in 1 min the timer increments 1800 times
        int sec = (int) ((player.get_time()/30)%60) ;
        if (min <10)
        { // timer position on the map
            if(sec<10)
            {
                time = "0" + min + ":0" + sec ;
                g.drawString(time,250,22);
            }
            else
            {
                time = "0" + min + ":" + sec ;
                g.drawString(time,250,22);
            }
        }
        else
        {
            if(sec<10)
            {
                time = min + ":0" + sec ;
                g.drawString(time,250,22);
            }
            else
            {
                time = min + ":" + sec ;
                g.drawString(time,250,22);
            }
        }

        }
        public String get_time()
        {
            return time ;
        }

}
