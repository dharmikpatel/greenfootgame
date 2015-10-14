import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * If you click on this button gives the game starts.
 * 
 * @author  
 * @version 
 */
public class ButtonPlay extends Button implements ButtonInvoker
{
    /**
     * Act - do whatever the ButtonPlay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    ButtonCommand newButtonCommand;
    
    public void act() 
    {
        super.act();
    }    
    
    /**
     * click on this button to start the game
     */
    public void click()
    {
        newButtonCommand.executeCommand();
    }
    
    /**
     * Method to set command
     */
    public void setCommand(ButtonCommand newCmd)
    {
        this.newButtonCommand = newCmd;
    }
    
}
