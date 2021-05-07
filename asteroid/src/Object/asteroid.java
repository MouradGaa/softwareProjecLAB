package Object;

import GameMap.Game_Map;
import GameState.content;
import classes.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;

//asteroid object
public class asteroid extends Object {
private MaterialBase resource;
private int depth;
    private   int PERIHELION  ;
    private   int APHELION ;
    private boolean isRadioactive ;
    private boolean isHollow;
    public String getResourceNames()
    {	Uranium n= new Uranium();
        Carbon c = new Carbon();
        Iron i =new Iron();
        empty e =new empty();
        WaterIce w =new WaterIce();
        if(resource.getClass().equals(c.getClass()) )return "Carbon";
        if(resource.getClass().equals(i.getClass()) )return "Iron";
        if(resource.getClass().equals(w.getClass()) )return "WaterIce";
        if(resource.getClass().equals(n.getClass()) )return "Uranium";
        return "";
    }
    private BufferedImage image ;
    public asteroid(Game_Map map) {
        super(map);
        width= 96 ;
        height = 96 ;
        col_height = 24 ;
        col_width = 24;
        image = content.asteroid[0][0] ;
    }

    public void setRadioactive(boolean radioactive) {
        isRadioactive = radioactive;
    }

    public boolean isRadioactive() {
        return isRadioactive;
    }
//getters and setters
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
    public void removeResource(){this.resource = new empty();}
    public void render(Graphics2D g)
    {
        set_map_position();
        g.drawImage(image, x+x_map-width/2 , y+ y_map -height/2, null) ;
    }
}
