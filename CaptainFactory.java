/**
 * Write a description of class CaptainFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaptainFactory extends EnemyFactory 
{
    public Enemy makeEnemy()
   {
       return new Captain();
   }
}
