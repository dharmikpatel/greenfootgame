import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent class of game characters.
 * 
 * @author 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    protected SimpleTimer shotTimer;
   
    public Character()
    {
        shotTimer = new SimpleTimer();  
        shotTimer.mark();
    }
    
    /**
     * Act - do whatever the Personaje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
}