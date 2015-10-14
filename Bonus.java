import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author Jinali Jhaveri
 * @version 
 */
public class Bonus extends Actor
{
    private int dir;
    private int tempDir;
    protected GreenfootSound lifeSound;
    protected GreenfootSound bonusSound;
    
    
    public Bonus()
    {
        dir = Greenfoot.getRandomNumber(3) + 1;
        tempDir=dir;
        lifeSound = new GreenfootSound("vida.wav");
        bonusSound = new GreenfootSound("bonus.wav");
    }
    
    /**
     * Act - do whatever the Bonus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        touchBorder();
        touchPlayer();
    }    
    
    /**
     * Check if player touched bonus
     */
    public void touchPlayer()
    {
        Shaktimaan i = (Shaktimaan)getOneIntersectingObject(Shaktimaan.class);
        if(i!=null)
        {
            i.setPoints(10);
            bonus(i);
        }
    }
    
    public void bonus(Shaktimaan i)
    {}
    
    /**
     * Depending on the direction (dir) the figure moves.
     */
    public void move()
    {
        switch(dir)
        {
            case 1:setLocation(getX()+tempDir,getY()+tempDir);
            break;
            case 2:setLocation(getX()-tempDir,getY()+tempDir);
            break;
            case 3:setLocation(getX()-tempDir,getY()-tempDir);
            break;
            case 4:setLocation(getX()+tempDir,getY()-tempDir);
            break;
        }
    }
    
    /**
     * Touching the edge of the circle bounces.
     */
    public void touchBorder()
    {
        if(getY() >= getWorld().getHeight()-getImage().getWidth()/2)
        {
            if(dir == 1)
                dir=4;
            else if(dir==2)
                dir=3;
        }
        else if(getY() <= getImage().getWidth()/2)
        {
            if(dir == 3)
                dir=2;
            else if(dir == 4)
                dir=1; 
        }
        else if(getX() >= getWorld().getWidth()-getImage().getWidth()/2)
        {
            if(dir == 4)
                dir=3;
            else if(dir == 1)
                dir=2;
        }
        else if(getX() <= getImage().getWidth()/2)
        {
            if(dir == 3)
                dir=4;
            else if(dir == 2)
                dir = 1;
        }
    }
}
