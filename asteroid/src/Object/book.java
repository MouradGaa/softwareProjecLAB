package Object;

import GameMap.Game_Map;
import GameState.content;

import java.awt.*;
import java.awt.image.BufferedImage;

//book object
public class book extends Object {

    private BufferedImage image ;
    public book(Game_Map map) {
        super(map);
        width= 96 ;
        height = 96 ;
        col_height = 24 ;
        col_width = 24;
        image = content.book[0][0] ;
    }

    public void render(Graphics2D g)
    {
        set_map_position();
        g.drawImage(image, x+x_map-width/2 , y+ y_map -height/2, null) ;
    }
}
