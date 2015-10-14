import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Attack extends Actor
{
    protected GreenfootSound explosionSound;
    protected int velShot;
    /**
     * Constructor for the Attack class
     */
    public Attack()
    {
        explosionSound = new GreenfootSound("explosionNave.wav");
    }
    
    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        shoot();
    }
    
       public void shoot()
    {}
}
