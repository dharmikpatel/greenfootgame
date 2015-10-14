/**
 * Write a description of class EnemyFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyFactory  
{
    public Enemy selectEnemyFactory(int newEnemyType)
    {
        Enemy newEnemy = null;
        if(newEnemyType == 0)
        {
            FighterFactory newFighterFactory = new FighterFactory();
            newEnemy = newFighterFactory.makeEnemy();
            //return newEnemy;
        }
        
        else if(newEnemyType == 1)
        {
            ColonelFactory newColonelFactory = new ColonelFactory();
            newEnemy = newColonelFactory.makeEnemy();
            //return newEnemy;
        }
        
        else if(newEnemyType == 2)
        {
            CaptainFactory newCaptainFactory = new CaptainFactory();
            newEnemy = newCaptainFactory.makeEnemy();
            //return newEnemy;   
        }
        //else return newEnemy;
        return newEnemy;
    }
}
