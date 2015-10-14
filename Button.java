import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent class of the menu buttons.
 * 
 * @author  
 * @version 
 */
public class Button extends Actor
{
    private int x;
    private GreenfootSound sound;
    protected GreenfootSound clickSound;
    private boolean playSound ;
    public Button()
    {
        x=0;
        sound = new GreenfootSound("soundB.wav");
        clickSound = new GreenfootSound("buttonSound.wav");
        playSound  = false;
    }
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        adjust();
        click();
    }   
    
    /**
     * Adjust button position
     */
    public void adjust()
    {
        if(getX() < getWorld().getWidth()/2)
            move(x);
        else
        {
            setLocation(getWorld().getWidth()/2, getY());
            if(!playSound)
            {
                sound.play();
                playSound  = true;
            }
        }
        if(x < 10)
            x++;
    }
    
    
    public void click(){}
}
