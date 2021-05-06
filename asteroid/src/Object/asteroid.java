package Object;

import GameMap.Game_Map;
import GameState.content;
import classes.MaterialBase;
import classes.Settler;
import classes.TeleportationGate;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;

//asteroid object
public class asteroid extends Object {
private MaterialBase resource;
private int depth;
    private   int PERIHELION  ;
    private   int APHELION ;
    private boolean isRadioactive = true;
    private boolean isHollow;

    private BufferedImage image ;
    public asteroid(Game_Map map) {
        super(map);
        width= 96 ;
        height = 96 ;
        col_height = 24 ;
        col_width = 24;
        image = content.asteroid[0][0] ;
    }

    public void setAPHELION(int APHELION) {
        this.APHELION = APHELION;
    }

    public int getAPHELION() {
        return APHELION;
    }

    public void setPERIHELION(int PERIHELION) {
        this.PERIHELION = PERIHELION;
    }

    public int getPERIHELION() {
        return PERIHELION;
    }


    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public MaterialBase getResource() {
        return resource;
    }
    public void setResource(MaterialBase resource){
        this.resource = resource;
    }
    public void render(Graphics2D g)
    {
        set_map_position();
        g.drawImage(image, x+x_map-width/2 , y+ y_map -height/2, null) ;
    }
}
