import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Sets the on-screen help.
 * 
 * @author 
 * @version (a version number or a date)
 */
public class ButtonHelp extends Button implements ButtonInvoker
{
    private Help help;
    private ButtonCommand newButtonCommand;
   
    public ButtonHelp()
    {
        help = new Help();
    }
    public Help getHelp()
    {
        return help;
    }
    
    /**
     * Act - do whatever the ButtonHelp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }   
    
    /**
     * By clicking on the help  appears.
     */
    public void click()
    {
       newButtonCommand.executeCommand();
    }
    
    public void setCommand(ButtonCommand newCmd)
    {
        this.newButtonCommand = newCmd;
    }
}
