import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coronel here.
 * 
 * @author  
 * @version 
 */
public class Colonel extends Enemy
{
    /**
     * Act - do whatever the Colonel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       super.act(); 
    }   
    
    /**
     * Constructor for the Strategy Pattern
     */
    public Colonel()
    {
        attackType = new BombEnemy();
    }
    
    /**
     * Colonel moves in a straight line, if the Colonel conveys the right edge of the world changes its position xa 5000 to re-appear in the world.
     */
    public void mover()
    {
        setLocation(getX()-7, getY());
        if(stepByPlayer())
        {
            setLocation(5000,getY());
        }
    }
    
    /**
     * Putting bombs in the world every 2 seconds.
     */
    public void attack()
    {  
       super.attack();
    }
}
