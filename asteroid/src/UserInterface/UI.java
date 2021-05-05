package UserInterface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


import GameState.StateManager;
import GameState.content;
import Main.gamePanel;
import Object.Player ;
import Object.book ;

public class UI {

    private BufferedImage book ;
    private BufferedImage key ;
    private BufferedImage axe ;
    private BufferedImage ui ;
    private Player player ;
    private int num_books ;
    private String time ;

    private StateManager sm ;

    private Font font ;
    private Color color ;

    public UI(Player p, ArrayList<book> b)
    {
        player = p ;
        num_books = b.size() ;
        book = content.book[0][0] ;
        key = content.key[0][0] ;
        axe = content.axe[0][0] ;
        ui =content.ui[0][0] ;
        font = new Font("Century Gothic",Font.BOLD,20) ;
        color = new Color(0xFC420005, true) ;
    }

    public void render(Graphics2D g)
    {
        // draw ui box
        g.drawImage(ui,0,gamePanel.height-14,null);
        //draw book image and books counter
        g.setColor(color);
        g.setFont(font);
        String s = player.get_num_books() + "/" + num_books ;
        g.drawString(s,30, gamePanel.height+8);
        g.drawImage(book,0,gamePanel.height-8,null);
        //draw axe and key
        if(player.key_is_collected()) g.drawImage(key,173,gamePanel.height-7,null);
        if(player.axe_is_collected()) g.drawImage(axe,145,gamePanel.height-9,null);
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
