import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Given extra shots injury.
 * 
 * @author (Jinali Jhaveri) 
 * @version (a version number or a date)
 */
public class BonusShot extends Bonus
{
    /**
     * Act - do whatever the BonusShot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
    
    /**
     * Increments Shots
     */
    public void bonus(Shaktimaan i)
    {
        bonusSound.play();
        i.setNumShots(i.getNumShots() + 10);
        i.setCurrState(i.getHasShotState());
        getWorld().removeObject(this);
    }
}
