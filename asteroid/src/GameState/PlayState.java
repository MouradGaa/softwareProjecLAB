package GameState;

import GameMap.Game_Map;
import Main.gamePanel;
import Object.Player ;
import Object.asteroid;
import Object.item ;
import UserInterface.UI;
import audio.Audio_player;
import classes.Carbon;
import classes.Inventory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;


public class PlayState extends GameState{
    // map
    private Game_Map map ;
    //player
    private Player player ;
    // asteroids
    private ArrayList<asteroid> asteroids;
    private Inventory inventory = new Inventory();
    private ArrayList<item> items ;
    // user interface
    private UI ui ;
    // score
    public static Score score ;
    // audio
    Audio_player sfx ;

    public PlayState(StateManager sm)
    {
        super(sm);
        init();
    }


    @Override
    public void init()
    {
        // load the map
        map = new Game_Map(32) ;
        map.load_tiles("/zebi.png");
        map.load_map("/zebi.txt");
        map.setPosition(0,0);
        map.set_smooth(0.1);
        //asteroids
        asteroids = new ArrayList<asteroid>() ;
        add_asteroids();
        // player
        player = new Player(map) ;
        player.set_position(2,3);
        //items
        items = new ArrayList<item>() ;
        add_items();
        // user interface
        ui = new UI(player, asteroids) ;
        //score
        score = new Score() ;
        load_score();
        // audio
        sfx = new Audio_player() ;

    }


    private void add_asteroids()
    {
        asteroid g ;

        g = new asteroid(map) ;
        g.set_position(4,7);
        g.setResource(new Carbon());
        g.setDepth(5);
        g.setPERIHELION(1);
        asteroids.add(g) ;

        g = new asteroid(map) ;
        g.set_position(2,16);
        asteroids.add(g) ;

        g = new asteroid(map) ;
        g.set_position(5,30);
        asteroids.add(g) ;

        g = new asteroid(map) ;
        g.set_position(8,22);
        asteroids.add(g) ;

        g = new asteroid(map) ;
        g.set_position(12,7);
        asteroids.add(g) ;

        g = new asteroid(map) ;
        g.set_position(13,38);
        asteroids.add(g) ;

        g = new asteroid(map) ;
        g.set_position(18,31);
        asteroids.add(g) ;

        g = new asteroid(map) ;
        g.set_position(22,29);
        asteroids.add(g) ;

        g = new asteroid(map) ;
        g.set_position(30,7);
        asteroids.add(g) ;

        g = new asteroid(map) ;
        g.set_position(38,1);
        asteroids.add(g) ;

        g = new asteroid(map) ;
        g.set_position(34,21);
        asteroids.add(g) ;

        g = new asteroid(map) ;
        g.set_position(37,36);
        asteroids.add(g) ;

    }
    private void add_items()
    {
        item it ;
        //add key
        it = new item(map) ;
        it.set_item_type(item.key);
        it.set_position(0,0);
        items.add(it) ;


    }
    // save and load score in file
    public void save_score()
    {
        try {
            FileOutputStream fileOut = new FileOutputStream("score.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(score);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public void load_score()
    {
        try {
            FileInputStream fileIn = new FileInputStream("score.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            score = (Score) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException f) {
            System.out.println("Score class not found");
            f.printStackTrace();
            return;
        }
    }

    @Override
    public void render(Graphics2D g)
    {
        // draw map
        map.render(g) ;

        // draw items
        for (item t : items)
        {
            t.render(g);
        }
        // draw asteroids
        for (asteroid b : asteroids)
        {
            b.render(g);
        }
        // draw player
        player.render(g);
        //draw UI
        ui.render(g);

    }

    @Override
    public void update()
    {
        for(int i= 0 ; i<asteroids.size(); i++)
        {
            asteroid a = asteroids.get(i) ;
            if (a.getDepth() == 0 && a.getPERIHELION() == 1)
            { asteroids.remove(i);
                if(player.collide_with(a))
                {
                    sfx.playMusic(content.key_sound,false);
                    if ( player.getLives() != 0){
                    player.set_position(2,3);
                    player.setLives(player.getLives()-1);}
                    else {
                        init();
                        MenuState.sfx1.stopMusic();
                        MenuState.sfx1.playMusic(content.bgMenu_sound,true);
                        sm.setCurrentState(StateManager.GameOverState);
                }
                }}

        }
        //update player
        player.update() ;
        //update map
        map.setPosition(gamePanel.width/2- player.getX(), gamePanel.height/2- player.getY());




    }

    @Override
    public void keyPressed(int e)
    {
        if(e== KeyEvent.VK_LEFT) player.set_left(true);
        if(e== KeyEvent.VK_RIGHT) player.set_right(true);
        if(e== KeyEvent.VK_DOWN) player.set_down(true);
        if(e== KeyEvent.VK_M) player.Mine(asteroids,inventory);
        if(e== KeyEvent.VK_L) player.Drill(asteroids);
        if(e== KeyEvent.VK_UP) player.set_up(true);
        if(e== KeyEvent.VK_ESCAPE) sm.setCurrentState(StateManager.MenuState);

    }

    @Override
    public void keyReleased(int e) {
        if(e== KeyEvent.VK_LEFT) player.set_left(false);
        if(e== KeyEvent.VK_RIGHT) player.set_right(false);
        if(e== KeyEvent.VK_DOWN) player.set_down(false);
        if(e== KeyEvent.VK_UP) player.set_up(false);

    }
}
