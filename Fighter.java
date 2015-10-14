import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kamikase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fighter extends Enemy
{
    /**
     * Act - do whatever the Fighter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        //mover();
        //atacar();
    }    
    
     /**
     * Move so that the enemy pursues the player.
     */
    public void mover()
    {
        move(velMov);
        Scenario e = (Scenario)getWorld();
        Shaktimaan i = e.getShaktimaan();
        turnTowards(i.getX(), i.getY());
    }
    
    /**
     * Attack the enemy. Gets the position of the player and goes to him to exploit her.
     * 
     */
    public void attack()
    {
        if(isTouching(Shaktimaan.class))
        {
            Scenario e = (Scenario)getWorld();
            Shaktimaan i = e.getShaktimaan();
            i.reduceHealth(7);
        }
    }
}
