import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Parent class of enemies.
 * 
 * @author (Sergio Humberto Aguilar Ochoa) 
 * @version (a version number or a date)
 */
public class Enemy extends Character
{
    protected int velMov; // Variable representing the speed of the enemy
    public Attack attackType; //For Strategy Pattern
    protected GreenfootSound shotEnemy; 
    
    /**
     * Constructor of the class enemy. The velMov variable is initialized with a minimum of 5 and a maximum of 7.
     * 
     */
    public Enemy()
    {
        velMov = Greenfoot.getRandomNumber(3)+5;
    }
    
    /**
     * Act - do whatever the Enemigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        mover();
        if(getX() <= 1800)
            attack();
    }
    
  
    public void mover(){}
    
    
    public void attack(){
        if(getClass().getName().equalsIgnoreCase("colonel"))
        {
            //this.changeAttack(new ShotEnemy());// For testing Change of Strategy
            if(shotTimer.millisElapsed() > 2000)
            {
                //getWorld().addObject(new BombEnemy(),getX(), getY()+getImage().getHeight()/2);
                getWorld().addObject(attackType,getX(), getY()+getImage().getHeight()/2);
                shotTimer.mark();
            }
        }
        
        if(getClass().getName().equalsIgnoreCase("captain"))
        {
            if(shotTimer.millisElapsed() > 5000)
            {
                shotEnemy.play();
                getWorld().addObject(attackType,this.getX()-getImage().getWidth()/2, this.getY()-50);
                getWorld().addObject(attackType,this.getX()-getImage().getWidth()/2, this.getY());
                getWorld().addObject(attackType,this.getX()-getImage().getWidth()/2, this.getY()+50);
                shotTimer.mark();
            }
        }
        
    }
    
    public void changeAttack(Attack newAttack)
    {
        this.attackType = newAttack;
    }
    
    /**
     *If the position 'X' the enemy is less than 0, returns true otherwise returns false.
     */
    public boolean stepByPlayer()
    {
        if(getX()+getImage().getWidth()/2 < 0)
            return true;
        return false;
    }
}
