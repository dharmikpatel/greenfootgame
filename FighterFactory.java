/**
 * Write a description of class FighterFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FighterFactory extends EnemyFactory 
{
   public Enemy makeEnemy()
   {
       return new Fighter();
   }
}
