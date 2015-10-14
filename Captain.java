import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Capitan here.
 * 
 * @author 
 * @version (a version number or a date)
 */
public class Captain extends Enemy
{
    private int stepsX;
    private int stepsY;
    
    /**
     * Builder Captain class. StepsY stepsX and the variables used for the movement of the enemy are initialized.
     * 
     */
    public Captain()
    {
        stepsX = 100;
        stepsY = 1;
        shotEnemy = new GreenfootSound("disparoEnemigo.wav");
        attackType = new ShotEnemy();
    }
    
    /**
     * Act - do whatever the Captain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!stepByPlayer())
        {    
            super.act();
            bounce();
        }
        else 
        {
            Scenario e = (Scenario)getWorld();
            Shaktimaan i = e.getShaktimaan();
            i.reduceHealth(i.getSalud()/2);
            
            e.reduceEnemies();
            
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Move to Captain zigzag
     */
    public void mover()
    {
        if(stepsX > 0)
        {
            setLocation(this.getX()-velMov, this.getY()+stepsY);
            stepsX--;
        }
        else if(stepsX <= 0 && stepsX > -70 && getX()+getImage().getWidth()/2 < getWorld().getWidth())
        {
            setLocation(this.getX()+velMov, this.getY()+stepsY);
            stepsX--;
        }   
        else if(stepsX <= -70)
            stepsX = 100;
    }
    
    /**
     * Touching an edge either upper or lower direction is reversed.
     */
    public void bounce()
    {
        if(getY() <= getImage().getHeight()/2)
            stepsY = 1;
        else if(getY() > getWorld().getHeight()-getImage().getHeight()/2)
            stepsY = -1;
        else if(getX() >= getWorld().getWidth())
            stepsX = 100;
    }
    
   
    public void attack()
    {
       super.attack();
    }
}
