/**
 * Write a description of class ButtonCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ButtonCommand  
{
    public void executeCommand();
    
    public void setReceiver(Receiver newReceiver);
}
