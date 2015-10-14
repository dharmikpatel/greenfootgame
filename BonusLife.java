import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * It gives the player a life.
 * 
 * @author Jinali Jhaveri 
 * @version (a version number or a date)
 */
public class BonusLife extends Bonus
{
    /**
     * Act - do whatever the BonusLife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
    
    /**
     * increment life
     */
    public void bonus(Shaktimaan i)
    {
        lifeSound.setVolume(80);
        lifeSound.play();
        i.increaseLife();
        getWorld().removeObject(this);
    }
}
