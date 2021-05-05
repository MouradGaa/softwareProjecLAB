package audio;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio_player {

    private Clip clip;
    public Audio_player()
    {

    }


    public void playMusic(String s,boolean loop)
    {
      try
      {
          File music = new File(s) ;

            AudioInputStream audioIN = AudioSystem.getAudioInputStream(music) ;
            clip = AudioSystem.getClip() ;
            clip.open(audioIN) ;
           if(loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
      }
      catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void stopMusic()
    {
        clip.stop();
        clip.close();
    }


}
