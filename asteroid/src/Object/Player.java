package Object;

import GameMap.Game_Map;
import GameState.StateManager;
import GameState.content;
import audio.Audio_player;

import java.awt.*;
import java.awt.image.BufferedImage;

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

    private boolean has_key ;
    private boolean has_axe ;

    // books collected
    private int num_books ;
    private int total_num_books ;
    // audio
    private Audio_player sfx ;

    private StateManager sm ;

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
       num_books = 0 ;
       sfx = new Audio_player() ;
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

    // player collected key or axe
    public void player_has_key()
    {
        has_key = true ;
    }
    public void player_has_axe()
    {
        has_axe = true ;
    }
    public boolean key_is_collected() {return has_key ;}
    public boolean axe_is_collected() {return has_axe ;}

    //open door function
    public void open_door()
    {
        if(has_key)
        {
            if(curr_anim==down && (map.getmap_index(curr_row+1,curr_col)==16 || map.getmap_index(curr_row+1,curr_col)==17))
            {
                if(map.getmap_index(curr_row+1,curr_col)==16)
                {
                    map.set_tile(curr_row+1,curr_col,30);
                    map.set_tile(curr_row+2,curr_col,30);
                    map.set_tile(curr_row+1,curr_col+1,30);
                    map.set_tile(curr_row+2,curr_col+1,30);
                }
                if(map.getmap_index(curr_row+1,curr_col)==17)
                {
                    map.set_tile(curr_row+1,curr_col,30);
                    map.set_tile(curr_row+2,curr_col,30);
                    map.set_tile(curr_row+1,curr_col-1,30);
                    map.set_tile(curr_row+2,curr_col-1,30);
                }
               sfx.playMusic(content.door_sound,false);
            }
            if(curr_anim==up && map.getmap_index(curr_row-1,curr_col)==18)
            {
                if(map.getmap_index(curr_row-1,curr_col)==18 && (map.getmap_index(curr_row-1,curr_col-1) != 18 ))
                {
                    map.set_tile(curr_row-1,curr_col,30);
                    map.set_tile(curr_row-2,curr_col,30);
                    map.set_tile(curr_row-1,curr_col+1,30);
                    map.set_tile(curr_row-2,curr_col+1,30);
                }
                if(map.getmap_index(curr_row-1,curr_col)==18 && (map.getmap_index(curr_row-1,curr_col-1) == 18))
                {
                    map.set_tile(curr_row-1,curr_col,30);
                    map.set_tile(curr_row-2,curr_col,30);
                    map.set_tile(curr_row-1,curr_col-1,30);
                    map.set_tile(curr_row-2,curr_col-1,30);
                }
                sfx.playMusic(content.door_sound,false);
            }
        }
        if(has_axe)
        {
            if(curr_anim==down && (map.getmap_index(curr_row+1,curr_col)==19 || map.getmap_index(curr_row+1,curr_col)==20))
            {
                if(map.getmap_index(curr_row+1,curr_col)==19)
                {
                    map.set_tile(curr_row+1,curr_col,30);
                    map.set_tile(curr_row+2,curr_col,30);
                    map.set_tile(curr_row+1,curr_col+1,30);
                    map.set_tile(curr_row+2,curr_col+1,30);
                }
                if(map.getmap_index(curr_row+1,curr_col)==20)
                {
                    map.set_tile(curr_row+1,curr_col,30);
                    map.set_tile(curr_row+2,curr_col,30);
                    map.set_tile(curr_row+1,curr_col-1,30);
                    map.set_tile(curr_row+2,curr_col-1,30);
                }
                sfx.playMusic(content.door_sound,false);
            }
            if(curr_anim==up && (map.getmap_index(curr_row-1,curr_col)==21|| map.getmap_index(curr_row-1,curr_col)==22))
            {
                if(map.getmap_index(curr_row-1,curr_col)==21)
                {
                    map.set_tile(curr_row-1,curr_col,30);
                    map.set_tile(curr_row-2,curr_col,30);
                    map.set_tile(curr_row-1,curr_col+1,30);
                    map.set_tile(curr_row-2,curr_col+1,30);
                }
                if(map.getmap_index(curr_row-1,curr_col)==22)
                {
                    map.set_tile(curr_row-1,curr_col,30);
                    map.set_tile(curr_row-2,curr_col,30);
                    map.set_tile(curr_row-1,curr_col-1,30);
                    map.set_tile(curr_row-2,curr_col-1,30);
                }
                sfx.playMusic(content.door_sound,false);
            }
        }
    }

    //player collected a book
    public void collected_book() {num_books ++ ;}
    public int get_num_books() {return num_books ;}
    public void set_total_num_books(int n)
    {
        total_num_books = n ;
    }
    public int get_total_num_books()
    {
        return total_num_books ;
    }

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

    public void render(Graphics2D g)
    {
        set_map_position();
        super.render(g);
    }

}
