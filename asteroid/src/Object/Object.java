package Object;

import GameMap.Game_Map;
import GameMap.Tile;

import java.awt.*;

// the super abstract class for all objects in the game ; player, key, axe etc..
public abstract class Object {

    // game map
    protected Game_Map map ;
    protected int tile_size ;
    // map position
    protected int x_map ;
    protected int y_map ;
    // tile position
    protected int x ;
    protected int y ;
    protected int x_des ; // destination in direction x
    protected int y_des ; // destination in direction y
    protected int curr_row  ;
    protected int curr_col ;
    //movement for tile ( basically for the player )
    protected boolean r ; //right
    protected boolean l ; //left
    protected boolean u ; //up
    protected boolean d ; //down
    protected boolean is_moving ;
    // dimensions
    protected int width ;
    protected int height ;
    protected int col_width ; // width and
    protected int col_height ;//height for detecting collision when collecting item or asteroid
    //aniamtion
    protected animation anim ;
    protected int curr_anim ;
    protected int speed ;


    // constructor
    public Object(Game_Map map)
    {
        this.map= map ;
        tile_size= map.getTile_size() ;
        anim = new animation() ;
    }

    // getters and setters
    public int getX() {return x ;}
    public int getY() {return y ; }

    public int getXmap(){return x_map;}
    public int getYmap(){return y_map;}

    public void set_position(int a,int b)
    {
        y = a * tile_size + tile_size / 2;
        x = b * tile_size + tile_size / 2;
        x_des = x;
        y_des = y;
    }

    public void set_map_position()
    {
        x_map = map.getX();
        y_map = map.getY();
    }

    public void set_right(boolean b)
    {
        if(is_moving) return ;
        r= b ;
        is_moving = can_move_next_position() ;
    }
    public void set_left(boolean b)
    {
        if(is_moving) return ;
        l= b;
        is_moving = can_move_next_position() ;
    }
    public void set_up(boolean b)
    {
        if(is_moving) return ;
        u= b ;
        is_moving = can_move_next_position() ;
    }
    public void set_down(boolean b)
    {
        if(is_moving) return ;
        d= b ;
        is_moving = can_move_next_position() ;
    }


    public boolean can_move_next_position() // check if the object can move to the next position
    {
         if(is_moving) return true ;

         curr_col = x/tile_size ;
         curr_row = y/ tile_size ;

         if(l) //if moving to left
         {
             if(map.getType(curr_row,curr_col-1)== Tile.blocked||curr_col==0) return false ;
             else  x_des=x-tile_size ;
         }
        if(r) //if moving to right
        {
            if(map.getType(curr_row,curr_col+1)== Tile.blocked||curr_col==map.getNum_columns()) return false ;
            else  x_des=x+tile_size ;
        }
        if(u) //if moving up
        {
            if(map.getType(curr_row-1,curr_col)== Tile.blocked|| curr_row==0) return false ;
            else  y_des=y-tile_size ;
        }
        if(d)  // if moving down
        {
            if(map.getType(curr_row+1,curr_col)== Tile.blocked||curr_row==map.getNum_rows()-1) return false ;
            else  y_des=y+tile_size ;
        }
    return true ;
    }

    public boolean collide_with(Object o)
    {
        Rectangle r1 = new Rectangle(x,y,col_width,col_height) ;
        Rectangle r2 = new Rectangle(o.x,o.y,o.col_width,o.col_height) ;

        return r1.intersects(r2) ;
    }
    public void update()
    {
        if (is_moving) next_Position() ;
        stop_moving();

        //animation update
        anim.update();
    }

    public void next_Position()
    {
        if(r && x<x_des) x += speed ; // if move right and current position is less than the next position  we move to the next position with a certain speed
        else r= false ;
        if(r && x> x_des) x = x_des ;
        if(l && x>x_des) x -= speed ;
        else l = false ;
        if(l && x<x_des) x=x_des ;
        if(u && y>y_des) y -= speed ;
        else u = false ;
        if(u && y<y_des) y= y_des ;
        if(d && y<y_des) y += speed ;
        else d = false ;
        if(d && y>y_des) y=y_des ;

    }
    public void stop_moving()
    {
        if(x==x_des && y==y_des)
        {
            r=l=u=d=is_moving = false ;
            curr_row = y / tile_size ;
            curr_col = x/ tile_size ;
        }
    }

    public void render(Graphics2D g)
    {

        g.drawImage(anim.get_tile(), x+x_map-width/2 , y+ y_map-height/2, null) ;
        System.out.println(x + "  " + x_map + "   " + y + "   " + y_map ) ;
    }
}



















