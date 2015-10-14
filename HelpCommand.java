/**
 * Write a description of class PlayCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpCommand implements ButtonCommand
{
    Receiver helpReceiver;
    
    public void setReceiver(Receiver newRec)
    {
        this.helpReceiver = newRec;
    }
    
    public void executeCommand()
    {
        helpReceiver.performAction();
    }
}
