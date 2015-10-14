import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *Player Shot.
 * 
 * @author (Henil Shah) 
 * @version (a version number or a date)
 */
public class ShotPlayer extends Attack
{
   
    public ShotPlayer()
    {
        velShot = 10;
    }
    
    /**
     * Act - do whatever the ShotPlayer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
    
    /**
     * When a shot is created in the world, move forward.
     * Check if I touch an enemy or an attack, if so both objects are removed
     * Also check if you left the world, if so is eliminated
     */
    public void shoot()
    {
        Scenario es = (Scenario)getWorld();
        if(isTouching(Enemy.class))
        {
            explosionSound.play();
            Enemy e = (Enemy)getOneIntersectingObject(Enemy.class);
            getWorld().addObject(new Explosion(1), e.getX(), e.getY());
            getWorld().removeObject(e);
            es.reduceEnemies();
            es.getShaktimaan().setPoints(Greenfoot.getRandomNumber(6)+10);
            getWorld().removeObject(this);
        }
        else if(getX() > getWorld().getWidth())
            getWorld().removeObject(this);
        else if(isTouching(ShotEnemy.class))
        {
            ShotEnemy de = (ShotEnemy)getOneIntersectingObject(ShotEnemy.class);
            getWorld().removeObject(de);
            getWorld().addObject(new Explosion(3), getX(), getY());
            es.getShaktimaan().setPoints(3);
            getWorld().removeObject(this);
        }
        else if(isTouching(Kazaki.class))
        {
            Kazaki g = (Kazaki)getOneIntersectingObject(Kazaki.class);
            g.reduceHealth(8, explosionSound);
            es.getShaktimaan().setPoints(5);
            getWorld().removeObject(this);
        }
        else
            setLocation(getX()+velShot,getY());
    }
}