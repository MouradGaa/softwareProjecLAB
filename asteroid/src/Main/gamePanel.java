package Main;

import GameState.StateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;



public class gamePanel extends JPanel implements Runnable, KeyListener{

    //dimensions
    public static final int width = 500; //214
    public static final int height =320; //288
    public static final int heightPlusBar = height +21 ;  // the height of the window plus the items bar
    public static final int scale = 2; // scale of the window
    //game thread
    private Thread thread ;
    private boolean running ;
    private final int fps = 30 ; // how many frames per second the game is working on
    private final int T_time = 1000/fps ; // the target time for the game loop (in milliseconds)

    // image
    private BufferedImage image ;
    private Graphics2D g ;
    //Game state manager
    private StateManager sm ;


    // constructor

    public gamePanel()
    {
        setPreferredSize(new Dimension(width*scale, heightPlusBar*scale));
        setFocusable(true) ;
        requestFocus();
    }
    @Override
    public void addNotify()
    {
        super.addNotify(); // game panel is downloading
        if(thread == null)
        {
            addKeyListener(this);            // when the game panel is downloading add new
            thread = new Thread(this) ;  // key listener and start new thread
            thread.start() ;
        }
    }

    //initialisation
    public void init() {
        image = new BufferedImage(width,heightPlusBar,BufferedImage.TYPE_INT_ARGB) ;
        running = true ;
        g = (Graphics2D) image.getGraphics() ; // g is like the paint brush for the image
        sm = new StateManager() ;

    }
    @Override
    public void run()
    {
        init() ;
        long StartTime ;
        long ElapsedTime ;
        long waitTime ;

        // GAME LOOP
        while(running)
        {
            StartTime = System.nanoTime() ;
            update() ;
            render() ;
            draw() ;

            ElapsedTime = System.nanoTime() - StartTime ; // time elapsed
            waitTime = T_time - ElapsedTime / 1000000 ; // time that the thread should wait, 1000000 because target time
                                                        // is in milliseconds and elapsed time is in nano seconds
           if(waitTime<0) waitTime = T_time ; // don't wait

           try {
                thread.sleep(waitTime) ;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private void update() // updates any changes that occurs in a game state
    {
        sm.update() ;
    }
    private void render() // not visible on the game panel
    {
       sm.render(g) ;                                 // render+draw ==> double buffering
    }                                                 // we draw everything in the image first and we redraw the image on the game panel
    private void draw() // visible on the game panel
    {
        Graphics g2 = this.getGraphics() ; // g2 is basically the paint brush for the game panel
        g2.drawImage(image,0,0, width*scale,heightPlusBar*scale,null) ;
        g2.dispose() ;
    }

    // key functions

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        sm.keyPressed(e.getKeyCode()) ;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        sm.keyReleased(e.getKeyCode()) ;
    }

}
