import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kazaki here.
 * 
 * @author  
 * @version 
 */
public class Kazaki extends Character
{
    private int health;
    private int movementMode;
    private int attackType;
    private boolean movementOrder;
    private int attackCnt;
    private SimpleTimer timer; // timer to appear on screen and attack every so often
    private boolean died;
    
    public Kazaki()
    {
        health = 1000;
        movementMode = 0;
        attackType = Greenfoot.getRandomNumber(3);
        movementOrder = false;
        attackCnt=0;
        timer = new SimpleTimer();
        timer.mark();
        died=false;
    }
    
    /**
     * Act - do whatever the Kazaki wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(health>0)
        {
            mover();
            attack();
            checkCounter();
        }
        else if(health==0)
        {
            died = true;
            timer.mark();
            health = -1;//so only once between
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
        }
        isHealthZero();
    }
    
    /**
     * Mueve al GeneralBoss en el mundo.
     */
    public void mover()
    {
        switch(movementMode)
        {
            case 0://moves to the left
                if(getX()>800 && movementOrder==false)
                {
                    if(timer.millisElapsed() > 3000)
                        setLocation(getX()-2, getY());
                }
                else
                {
                    movementOrder=true;
                    movementMode=2;
                }
            break;
            
            case 1://moves to the right until it leaves the screen
                if(getX() < getWorld().getWidth()+getImage().getWidth()/2 && movementOrder==false)
                {
                    setLocation(getX()+2, getY());
                    //finDeMovimiento=true;
                }
                else
                {
                    timer.mark();
                    movementMode = 0;
                }
            break;
            
            case 2://moves up
                if(getY() > 0+getImage().getHeight()/2)
                    setLocation(getX(), getY()-5);
                else
                    movementMode = 3;
            break;
            
            case 3://moves down
                if(getY() < getWorld().getHeight()-getImage().getHeight()/2)
                    setLocation(getX(), getY()+5);
                else
                    movementMode=2;
            break;
        }
    }
    
    /**
     * Different attacks makes the player.
     */
    public void attack()
    {
        if(movementOrder == true)
        {
            switch(attackType)
            {
                case 0:
                    if(shotTimer.millisElapsed() > 300 && timer.millisElapsed() > 5000)
                    {
                        getWorld().addObject(new ShotBoss(Greenfoot.getRandomNumber(3)), getX()-40, getY()-getImage().getHeight()/2);
                        attackCnt++;
                        shotTimer.mark();
                    }
                break;
            
                case 1:
                    if(shotTimer.millisElapsed() > 500 && timer.millisElapsed() > 6000)
                    {
                        getWorld().addObject(new BombEnemy(), getX()-40, getY()-getImage().getHeight()/2);
                        attackCnt++;
                        shotTimer.mark();
                    }
                break;
            
                case 2:
                    if(shotTimer.millisElapsed() > 1000  && timer.millisElapsed() > 10000)
                    {
                        generateEnemies();
                        getWorld().addObject(new ShotBoss(Greenfoot.getRandomNumber(3)), getX()-40, getY()-getImage().getHeight()/2);
                        attackCnt++;
                        shotTimer.mark();
                    }
                break;
            }
        }
    }
    
    /**
     * Generates a random number to create an enemy that gets in the world.
     */
    public void generateEnemies()
    {
        switch(Greenfoot.getRandomNumber(3))
        {
            case 0:
                getWorld().addObject(new BombEnemy(), 2000, getY());
            break;
            
            case 1:
                getWorld().addObject(new Captain(), 2000, getY());
            break;
            
            case 2:
                getWorld().addObject(new Colonel(), 2000, getY());
            break;
        }
    }
    
   
    public void checkCounter()
    {
        if(attackCnt > 5)
        {
            attackCnt=0;
            attackType = Greenfoot.getRandomNumber(3);
            movementMode=1;
            movementOrder = false;
        }
    }
    
    /**
     * Check if the KAzaki is on the screen, if so subtract 's' health.
     * 
     */
    public void reduceHealth(int s, GreenfootSound sound)
    {
        if(getX()-getImage().getWidth()/2 < getWorld().getWidth() && health > 0)
        {
            health -= s;
            sound.play();
        }
        else if(health < 0)
            health = 0;
    }
    
    /**
     * Return Kazaki health
     */
    public int getHealth()
    {
        return health;
    }
    
    /**
     * If health is <= zero the ship explodes and disappears.
     */
    public void isHealthZero()
    {
        if(died)
        {
            if(timer.millisElapsed() > 300 && timer.millisElapsed() < 600)
                getWorld().addObject(new Explosion(1), getX(), getY()-50);
            else if(timer.millisElapsed() > 600 && timer.millisElapsed() < 900)
                getWorld().addObject(new Explosion(2), getX()+25, getY()-25);
            else if(timer.millisElapsed() > 900 && timer.millisElapsed() < 1200)
                getWorld().addObject(new Explosion(3), getX()+50, getY());
            else if(timer.millisElapsed() > 1200 && timer.millisElapsed() < 1500)
                getWorld().addObject(new Explosion(1), getX()+25, getY()+25);
            else if(timer.millisElapsed() > 1500 && timer.millisElapsed() < 1800)
                getWorld().addObject(new Explosion(2), getX(), getY()+50);
            else if(timer.millisElapsed() > 1800 && timer.millisElapsed() < 2100)
                getWorld().addObject(new Explosion(3), getX()-25, getY()+25);
            else if(timer.millisElapsed() > 2100 && timer.millisElapsed() < 2400)
                getWorld().addObject(new Explosion(1), getX()-50, getY());
            else if(timer.millisElapsed() > 2400 && timer.millisElapsed() < 2700)
                getWorld().addObject(new Explosion(2), getX()-25, getY()-25);
            else if(timer.millisElapsed() > 2700 && timer.millisElapsed() < 3000)
                getWorld().addObject(new Explosion(1), getX(), getY());
            else if(timer.millisElapsed() > 3000 && timer.millisElapsed() < 3300)
            {
                getWorld().addObject(new Explosion(1), getX(), getY());
                getWorld().addObject(new Notice("WON!!!", true), getWorld().getWidth()/2, getWorld().getHeight()/2);
                getWorld().removeObject(this);
            }
        }
    }
}