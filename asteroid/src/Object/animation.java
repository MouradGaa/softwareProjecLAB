package Object;

import java.awt.image.BufferedImage;

// animates a series of tiles
public class animation {

    private BufferedImage[] images ; // 2d array of tiles
    private int current_image ;
    private int num_images ;

    private int counter ; // counts until wait time to switch to the next image
    private int wait_time ; // the wait time to switch between 1 tile to another


    public animation()
    {

    }

    // setters and getters
    public void setImages(BufferedImage[] images)
    {
        this.images = images ;
        current_image = 0 ;
        wait_time = 0 ;
        counter = 0 ;
        num_images= images.length ;

    }
    public void set_wait_time(int t)
    {
        wait_time = t ;
    }
    public int get_image()
    {
        return current_image ;
    }
    public BufferedImage get_tile()
    {
        return images[current_image] ;
    }
    public void update()
    {
        counter ++ ;
        if(counter==wait_time)
        {
            current_image ++ ; // move to next image and reset the counter
            counter = 0 ;
        }
        if(current_image==num_images) // reset
        {
            current_image = 0 ;
        }

    }

}
