package GameState;


import Main.gamePanel;
import audio.Audio_player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class MenuState extends GameState {

    private boolean help = false ;
    private boolean score = false ;
    private Image bg ;
    private int currentChoice = 0 ;
    private String[] options = {"START","HELP","SCORE","QUIT"} ;

    private Color titleColor ;
    private Font titleFont ;

    private Font font ;
    private Color menu_color ;
    private Color choose_color ;



    // audio
    private Audio_player sfx ;
    public static  Audio_player sfx1 ;
    public MenuState(StateManager sm) {
        super(sm);
        init();
    }

    @Override
    public void init() {
        //draw background
        bg = new ImageIcon(getClass().getResource("/MenuBg.gif")).getImage();
        titleColor = new Color(149, 98, 0) ; // set color
        titleFont = new Font("Century Gothic",Font.BOLD,32) ; // set font
        font = new Font("Century Gothic", Font.BOLD,26) ;
        menu_color = new Color(0xFF1C4792, true) ;
        choose_color = new Color(0xFFACC5F3, true) ;

        sfx = new Audio_player() ;
        sfx1 = new Audio_player() ;
        sfx1.playMusic(content.bgMenu_sound,true);
    }


    @Override
    public void render(Graphics2D g) {
        //draw background
        g.drawImage(bg,0,0, gamePanel.width, gamePanel.heightPlusBar,null);
        //draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("ASTEROID MINING",120,60);
        //draw options
        g.setFont(font);
        if(help)
        {
            g.setColor(choose_color);
            g.drawString("-Use Arrow keys to move",20,100);
            g.drawString("-Use 'I' to check asteroid state",20,150);
            g.drawString("-Use 'H' to Hide",20,200);
            g.drawString("-Use 'L' to Drill",20,250) ;
            g.drawString("-Use 'M' to Mine",20,300);
        }
        else if (score)
        {
            g.setColor(menu_color);
            g.drawString("Last scores :",20,190);
            for(int i=0; i<PlayState.score.get_scores().size();i++)
            {
                g.drawString("-" +PlayState.score.get_scores().get(i),20,215 + i *18);
            }

        }
        else{
        for(int i=0; i< options.length;i++)
        {
            if(i==currentChoice)
            {
                g.setColor(Color.white);
            }
            else {
                g.setColor(menu_color) ;
            }
            g.drawString(options[i],215,190 + i *25);
        }
        }
    }

    @Override
    public void update() {}

    private void select() // select an option
    {
        if(currentChoice== 0)
        {
            sm.setCurrentState(StateManager.PlayState);
            sfx1.stopMusic();
            sfx1.playMusic(content.play_sound,true);
        }
        if(currentChoice==1 && !help)
        {
            help = true ;
        }
        if (currentChoice==2)
        {
            score = true ;
        }
        if(currentChoice==3)
        {
            System.exit(0);
        }
    }


    @Override
    public void keyPressed(int e) {
        if(e == KeyEvent.VK_ENTER &&!help&&!score)
        {
            sfx.playMusic(content.select_sound,false);
            select() ;
        }

        if(e== KeyEvent.VK_UP && !help &&!score) {
            currentChoice--;
            if (currentChoice == -1) {
                currentChoice = options.length - 1;
            }
            sfx.playMusic(content.menu_sound,false);
        }

        if (e == KeyEvent.VK_DOWN && !help&!score)
        {
            currentChoice++ ;
            if(currentChoice== options.length) {
                currentChoice= 0 ;
            }
            sfx.playMusic(content.menu_sound,false);
        }
        if(e == KeyEvent.VK_ESCAPE)
        {
            help = false ;
            score = false ;
        }

    }

    @Override
    public void keyReleased(int e) {

    }
}
