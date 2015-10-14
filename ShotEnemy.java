import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ShotEnemy extends Attack implements AttackStrategy
{
    /**
     * Constructor for the class ShotEnemy
     * Initializes the variable 'velShot' with a random number for
     * speed of bullet
     */
    public ShotEnemy()
    {
        velShot = Greenfoot.getRandomNumber(11)+10;
    }
    
    /**
     * Act - do whatever the ShotEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }   
    
    /**
      * When trigger growth in the world: 
      * Check if the player plays, if so detracts health and the bullet is removed. 
      * Check if the coordinates are less than 0 and if so removes the bullet. 
      * Check if the player touches the trigger, so if both are eliminated. 
      * Else keeps moving the world.
     */
    public void shoot()
    {
        if(isTouching(Shaktimaan.class))
        {
            Shaktimaan sm = (Shaktimaan)getOneIntersectingObject(Shaktimaan.class);
            sm.reduceHealth(Greenfoot.getRandomNumber(4)+2);
            getWorld().addObject(new Explosion(2), getX(), getY());
            getWorld().removeObject(this);
        }
        else if(getX() < 0)
            getWorld().removeObject(this);
        else if(isTouching(ShotPlayer.class))
        {
            ShotPlayer dp = (ShotPlayer)getOneIntersectingObject(ShotPlayer.class);
            getWorld().removeObject(dp);
            getWorld().addObject(new Explosion(3), getX(), getY());
            Scenario es = (Scenario)getWorld();
            es.getShaktimaan().setPoints(3);
            getWorld().removeObject(this);
        }
        else
            setLocation(getX()-velShot,getY());
    }
}
