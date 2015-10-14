/**
 * Write a description of class OutOfShots here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OutOfShotState implements ShaktimaanState 
{
    Shaktimaan heroObj;

    /**
     * Constructor for objects of class OutOfShotState
     */
    public OutOfShotState(Shaktimaan heroObj)
    {
         this.heroObj = heroObj;
    }
    
    public void attackEnemy(){
        //System.out.println("Out of Shot. Please collect shots");
    }

    
}
