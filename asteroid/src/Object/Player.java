package Object;

import GameMap.Game_Map;
import GameState.PlayState;
import GameState.StateManager;
import GameState.content;
import audio.Audio_player;
import classes.*;

import javax.management.InvalidAttributeValueException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static GameState.PlayState.inventory;

public class Player extends Object{

    //tile frames
    private BufferedImage[] right_tile ;
    private BufferedImage[] left_tile ;
    private BufferedImage[] up_tile ;
    private BufferedImage[] down_tile ;

    // for animating the player tiles
    private final int down = 0 ;
    private final int left = 1 ;
    private final int right = 2 ;
    private final int up = 3 ;

    private long timer ; // game timer
    private boolean hidden ;
    private int lives = 3 ;
    // audio
    private Audio_player sfx ;

    private boolean collided =false;
    private asteroid asteroid;

    //methods

    //constructor
    public Player(Game_Map map)
   {

       super(map) ;
       width = 32 ;
       height = 32 ;
       col_height = 24 ;
       col_width = 24 ;
       speed = 4 ;
       down_tile = content.player[0] ;
       left_tile = content.player[1] ;
       right_tile = content.player[2] ;
       up_tile = content.player[3] ;
       anim.setImages(down_tile);
       anim.set_wait_time(7);
       sfx = new Audio_player() ;
       asteroid = new asteroid(map);
   }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void Mine(ArrayList<asteroid> asteroids, Inventory inventory){
    for(int i = 0; i< asteroids.size() ;i++)
    {
       asteroid a =asteroids.get(i) ;
        if(this.collide_with(a))
        {
            if(a.getDepth()==0){
            sfx.playMusic(content.key_sound,false);
            if ( a.getResource()== null)
                System.out.println("can't");
            else{
            inventory.setResources(a.getResource());
            increment_resource_num(a);
            a.removeResource();
            }

            }

            else{
                System.out.println("can't");
            }
        }
    }

}

    public asteroid getAsteroid() {
        return asteroid;
    }

    public boolean isCollided() {
        return collided;
    }
    public void check(ArrayList<asteroid> asteroids){
        for(int i = 0; i< asteroids.size() ;i++)
        {
            asteroid a =asteroids.get(i) ;
            if(this.collide_with(a))
            {
                asteroid = a;
                collided = true;

            }
        }
    }
    public void Drill(ArrayList<asteroid> asteroids){
        for(int i = 0; i< asteroids.size() ;i++)
        {
            asteroid a =asteroids.get(i) ;
            if(this.collide_with(a)&& a.getDepth()>0)
            {
                sfx.playMusic(content.key_sound,false);
                a.setDepth(a.getDepth()-1);
                asteroid = a;
                collided = true;

            }
        }
    }

    public void Hide(ArrayList<asteroid> asteroids){
        for(int i = 0; i< asteroids.size() ;i++)
        {
            asteroid a =asteroids.get(i) ;
            if(this.collide_with(a))
            {if (a.getDepth() == 0){
                hidden = true;
                sfx.playMusic(content.key_sound,false);}
                else{
                System.out.println("can't ");
            }
            }
        }
    }
    public void build_Gate(ArrayList<asteroid> asteroids,Inventory inventory){
        for(int i = 0; i< asteroids.size() ;i++)
        {
            asteroid a =asteroids.get(i) ;
            if(this.collide_with(a))
            {
                sfx.playMusic(content.key_sound,false);
            }
        }
    }
    public void teleport(ArrayList<asteroid> asteroids, TeleportationGate g){
        for(int i = 0; i< asteroids.size() ;i++)
        {
            asteroid a =asteroids.get(i) ;
            if(this.collide_with(a))
            {
                sfx.playMusic(content.key_sound,false);
            }
        }
    }

    // setter for animation
    private void set_animation(int act, BufferedImage[] images , int wait_t)
    {
        curr_anim = act ;
        anim.setImages(images);
        anim.set_wait_time(wait_t);
    }

    //timer
    public long get_time() { return timer ;}



    public void update()
    {
        timer ++ ;
        if(r)
        {
            if(curr_anim != right) set_animation(right,right_tile,7);
        }
        if(l)
        {
            if(curr_anim != left) set_animation(left,left_tile,7);
        }
        if(u)
        {
            if(curr_anim != up) set_animation(up,up_tile,7);
        }
        if(d)
        {
            if(curr_anim != down) set_animation(down,down_tile,7);
        }
        super.update();
    }
    public void increment_resource_num(asteroid asteroid){
        Uranium n= new Uranium();
        Carbon c = new Carbon();
        Iron i =new Iron();
        WaterIce w =new WaterIce();
try {
    if (asteroid.getResource().getClass().equals(c.getClass())) inventory.setResourceNumber(0);
    if (asteroid.getResource().getClass().equals(i.getClass())) inventory.setResourceNumber(1);
    if (asteroid.getResource().getClass().equals(w.getClass())) inventory.setResourceNumber(2);
    if (asteroid.getResource().getClass().equals(n.getClass())) inventory.setResourceNumber(3);
}
catch (Exception e){
    e.printStackTrace();
}
    }

    public void render(Graphics2D g)
    {
        set_map_position();
        super.render(g);
    }

}
