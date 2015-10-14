import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 * @author  
 * @version (a version number or a date)
 */
public class ShotBoss extends Attack
{
    private int dir;
    
    public ShotBoss(int direction)
    {
        velShot = 7;
        dir = direction;
    }
    
    /**
     * Act - do whatever the ShotBoss wants to do. This method is called whenever
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
            i.reduceHealth(5);
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
        {
            switch(dir)
            {
                case 0://moves in a straight line
                    setLocation(getX()-velShot, getY());
                break;
            
                case 1://moves diagonally upward
                    setLocation(getX()-velShot, getY()-5);
                break;
            
                case 2://moves diagonally down
                    setLocation(getX()-velShot, getY()+5);
                break;
            }
            invertDirection();
        }
    }
    
    /**
     * Check if the bullet goes diagonally touching the edge up or down changes direction.
     * 
     */
    public void invertDirection()
    {
        if(dir == 1 && getY() < 0+getImage().getHeight()/2)
            dir=2;
        else if(dir == 2 && getY() > getWorld().getHeight()-getImage().getHeight()/2)
            dir=1;
    }
}
