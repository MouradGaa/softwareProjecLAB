package GameState;

import GameMap.Game_Map;
import Main.gamePanel;
import Object.Player ;
import Object.book ;
import Object.item ;
import UserInterface.UI;
import audio.Audio_player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;


public class PlayState extends GameState{
    // map
    private Game_Map map ;
    //player
    private Player player ;
    // books
    private ArrayList<book> books ;
    // items(axe,key)
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
        //books
        books = new ArrayList<book>() ;
        add_books();
        // player
        player = new Player(map) ;
        player.set_position(2,3);
        player.set_total_num_books(books.size());
        //items
        items = new ArrayList<item>() ;
        add_items();
        // user interface
        ui = new UI(player,books) ;
        //score
        score = new Score() ;
        load_score();
        // audio
        sfx = new Audio_player() ;

    }


    private void add_books()
    {
        book b ;

        b = new book(map) ;
        b.set_position(4,7);
        books.add(b) ;

        b = new book(map) ;
        b.set_position(2,16);
        books.add(b) ;

        b = new book(map) ;
        b.set_position(5,30);
        books.add(b) ;

        b = new book(map) ;
        b.set_position(8,22);
        books.add(b) ;

        b = new book(map) ;
        b.set_position(12,7);
        books.add(b) ;

        b = new book(map) ;
        b.set_position(13,38);
        books.add(b) ;

        b = new book(map) ;
        b.set_position(18,31);
        books.add(b) ;

        b = new book(map) ;
        b.set_position(22,29);
        books.add(b) ;

        b = new book(map) ;
        b.set_position(30,7);
        books.add(b) ;

        b = new book(map) ;
        b.set_position(38,1);
        books.add(b) ;

        b = new book(map) ;
        b.set_position(34,21);
        books.add(b) ;

        b = new book(map) ;
        b.set_position(37,36);
        books.add(b) ;

    }
    private void add_items()
    {
        item it ;
        //add key
        it = new item(map) ;
        it.set_item_type(item.key);
        it.set_position(0,0);
        items.add(it) ;
        //add axe
        it = new item(map) ;
        it.set_item_type(item.axe);
        it.set_position(11,16);
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
        // draw books
        for (book b : books)
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

        if(player.get_num_books()== player.get_total_num_books()  )
        {
            score.add_score(ui.get_time());
            if(score.get_scores().size()>5)
            {
                score.get_scores().remove(0) ;
            }
            save_score();
            init();
            MenuState.sfx1.stopMusic();
            MenuState.sfx1.playMusic(content.bgMenu_sound,true);
            sm.setCurrentState(StateManager.GameOverState);
        }

        //update player
        player.update() ;
        //update map
        map.setPosition(gamePanel.width/2- player.getX(), gamePanel.height/2- player.getY());
        //update books and player collect
        for(int i= 0 ; i<books.size(); i++)
        {
            book b = books.get(i) ;
            if(player.collide_with(b))
            {
                sfx.playMusic(content.book_sound,false);
                books.remove(i) ;
                player.collected_book();
            }

        }
        // update items and player collect
        for(int i=0 ; i<items.size();i++)
        {
            item it = items.get(i) ;
            if(player.collide_with(it))
            {
                sfx.playMusic(content.key_sound,false);
                items.remove(i) ;
                it.collected_by_player(player);

            }
        }

    }

    @Override
    public void keyPressed(int e)
    {
        if(e== KeyEvent.VK_LEFT) player.set_left(true);
        if(e== KeyEvent.VK_RIGHT) player.set_right(true);
        if(e== KeyEvent.VK_DOWN) player.set_down(true);
        if(e== KeyEvent.VK_UP) player.set_up(true);
        if(e== KeyEvent.VK_A) player.open_door();
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
