
// this class represents 2 types of tile : blocked or normal

package GameMap;

import java.awt.image.BufferedImage;

public class Tile {

     private BufferedImage tile ;
     private int type ;
     // types
     public static final int normal = 0 ;
     public static final int blocked = 1 ;
     // constructor
     public Tile(BufferedImage tile , int type )
     {
         this.tile = tile ;
         this.type = type ;
     }
     // getters
    public BufferedImage getTile() { return tile ;}
    public int getType() {return type ; }

}
