/**
 * Write a description of class ColonelFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColonelFactory extends EnemyFactory 
{
   public Enemy makeEnemy()
   {
       return new Colonel();
   }
}
