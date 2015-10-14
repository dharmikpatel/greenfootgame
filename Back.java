import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button to close a window.
 * 
 * @author 
 * @version (a version number or a date)
 */
public class Back extends Button
{
    private Actor actor;
  
    public Back(Actor a)
    {
        actor = a;
    }
    
    /**
     * Act - do whatever the Back wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.click();
    }    
    
    /**
     * Close the window to see the menu again.
     */
    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
            clickSound.play();
            getWorld().removeObject(actor);
            getWorld().removeObject(this);
        }
    }
}
