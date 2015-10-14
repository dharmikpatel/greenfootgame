import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author 
 * @version 
 */
public class BombEnemy extends Attack implements AttackStrategy
{
    private SimpleTimer timerShot;
    private GreenfootImage bomba0;
    private GreenfootImage bomba1;
   
    public BombEnemy()
    {
        timerShot = new SimpleTimer();
        timerShot.mark();
        bomba0 = new GreenfootImage("bombaEnemigo0.png");
        bomba1 = new GreenfootImage("bombaEnemigo.png");
        setImage(bomba0);
    }
    
    /**
     * Act - do whatever the BombEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
    
 
    
    public void shoot()
    {
        if(isTouching(Shaktimaan.class))
        {
            Shaktimaan i = (Shaktimaan)getOneIntersectingObject(Shaktimaan.class);
            i.reduceHealth(7);
            getWorld().addObject(new Explosion(2), getX(), getY());
            getWorld().removeObject(this);
        }
        else if(getY()-getImage().getHeight()/2 > getWorld().getHeight())
            getWorld().removeObject(this);
        else if(isTouching(ShotPlayer.class))
        {
            ShotPlayer dp = (ShotPlayer)getOneIntersectingObject(ShotPlayer.class);
            getWorld().removeObject(dp);
            getWorld().addObject(new Explosion(3), getX(), getY());
            Scenario es = (Scenario)getWorld();
            es.getShaktimaan().setPoints(4);
            getWorld().removeObject(this);
        }
        else
            movement();
    }
    
   
    public void movement()
    {
        if(timerShot.millisElapsed() > 10000)
        {
            setImage(bomba1);
            Scenario e = (Scenario)getWorld();
            Shaktimaan i = e.getShaktimaan();
            turnTowards(i.getX(), i.getY());
            move(5);
        }
    }
}