import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Put a sign on the screen.
 * 
 * @author  
 * @version 
 */
public class Notice extends Actor
{
    private int vel;
    private boolean fin; 
   
    
    public Notice(String text, boolean f)
    {
        setImage( new GreenfootImage(text,100,java.awt.Color.WHITE,java.awt.Color.BLACK) );
        
        vel = 100;
        
        fin = f;
    }
    
    /**
     * Act - do whatever the Notice wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Scenario e = (Scenario)getWorld();
        if(vel<0)
            move(vel);
        vel--;
        if(getX()+getImage().getWidth()/2 < 0)
        {
            if(fin == true)
            {
                if(e.getActualSound().isPlaying())
                    e.getActualSound().stop();
                    Greenfoot.setWorld(new Menu());
            }
            else
                getWorld().removeObject(this);
        }
    }    
}
