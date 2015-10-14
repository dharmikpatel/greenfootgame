import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class GamePoints here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GamePoints extends Actor implements PointsObserver
{
    GreenfootImage image;
    GreenfootImage text;

    public GamePoints(int points){
        updatePoints(points);
    }

    /**
     * Act - do whatever the GamePoints wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    }   

    public void updatePoints(int points){

        //Escenario scenario = (Escenario) getWorld();
        //scenario.removeObject(this);
       
         setImage(new GreenfootImage(200,100));
        GreenfootImage  image = new GreenfootImage(getImage());
        
        GreenfootImage text = new GreenfootImage("Points = " + points, 22, Color.BLACK, new Color(0,0,0,0));

        if (text.getWidth() > image.getWidth() - 20)
        {
            image.scale(text.getWidth() + 20, image.getHeight());
        }

        image.drawImage(text, (image.getWidth()-text.getWidth())/2, 
            (image.getHeight()-text.getHeight())/2);
        setImage(image);
       // scenario.addObject(this,800,15);
    }
}
