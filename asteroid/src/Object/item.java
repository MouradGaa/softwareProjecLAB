package Object;

import GameMap.Game_Map;
import GameState.content;

import java.awt.*;
import java.awt.image.BufferedImage;


// items class
public class item extends Object{

    private BufferedImage image ;
    public static final int key = 0 ; // there 2 items key or axe
    public static final int axe = 1 ;
    private int type ; // key or axe

    public item(Game_Map map) {
        super(map);
        width = 32 ;
        height = 32 ;
        col_height = 24 ;
        col_width = 24 ;

    }

    public void set_item_type(int t)
    {
        type = t ;
        if(type==key)
        {
            image = content.key[0][0] ;
        }

    }


    public void render(Graphics2D g)
    {
        set_map_position();
        g.drawImage(image, x+x_map -width/2, y+y_map-height/2, null);
    }
}
