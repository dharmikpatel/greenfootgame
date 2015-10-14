import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Put a picture of an explosion when a ship is destroyed.
 * 
 * @author (Jinali Jhaveri) 
 * @version 
 */
public class Explosion extends Actor
{
    private GreenfootImage[] explosiones;
    private int explosionType;
    SimpleTimer timer;
   
    public Explosion(int type)
    {
        explosionType = type; 
        timer = new SimpleTimer();
        timer.mark();
    }

    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        showExplosion();
    }    

    /**
     * When a ship explodes an image appears, lasts 1 second and disappears
     */
    public void showExplosion()
    {
        move(-10);
        
        if(explosionType == 1)
        {
            ImageRepository imageRepo = new ImageRepositoryImpl() ;
            ImageIterator iter =  imageRepo.createIterator() ;
            if(timer.millisElapsed() < 200){
                while(!iter.isDone())
                {
                   setImage(iter.currentImage());
                   iter.next();
                }
            }
            else
                getWorld().removeObject(this);

        }
        else if(explosionType == 2)
        {
            if(timer.millisElapsed() < 500)
                setImage(new GreenfootImage("Explosion4.png"));
            else
                getWorld().removeObject(this);
        }
        else if(explosionType == 3)
        {
            if(timer.millisElapsed() < 500)
                setImage(new GreenfootImage("Explosion5.png"));
            else
                getWorld().removeObject(this);
        }
    }
}
