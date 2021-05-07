package GameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverWinningState extends GameState{


    private Image image ;
    private Color color ;
    private Color color2 ;
    private Font font ;
    private Font font2 ;


    public GameOverWinningState(StateManager sm) {
        super(sm);
        init();
    }

    @Override
    public void init() {
        image = new ImageIcon(getClass().getResource("/gameoverwin.gif")).getImage(); // load background gif
        color = new Color(130, 0, 0, 255) ;
        color2 = new Color(255, 255, 255, 255) ;
        font = new Font("Century Gothic",Font.BOLD,18) ;
        font2 = new Font("Century Gothic",Font.BOLD,10) ;
    }

    @Override
    public void render(Graphics2D g) {
        //draw
        g.drawImage(image,0,0, 500, 360,null); // draw background
        //draw ending text
        g.setColor(color);
        g.setFont(font);
        g.drawString("You collected the first ",12,20);
        g.drawString("pieces of your memory  ",6,38);
        g.drawString("in Budapest",60,56);
        g.setColor(color2);
        g.setFont(font2);
        g.drawString("press escape to skip",65,270);
    }

    @Override
    public void update() {

    }

    @Override
    public void keyPressed(int e) {
        if(e== KeyEvent.VK_ESCAPE)
        {
            sm.setCurrentState(StateManager.MenuState);
        }
    }

    @Override
    public void keyReleased(int e) {

    }


}
