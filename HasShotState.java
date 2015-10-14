import greenfoot.*;
/**
 * Write a description of class HasShots here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HasShotState implements ShaktimaanState 
{
    Shaktimaan heroObj;
    World world;
    SimpleTimer shotTimer;

    public HasShotState(Shaktimaan heroObj,SimpleTimer shotTimer)
    {
        this.heroObj = heroObj;
        this.shotTimer = shotTimer;
    }

    public void attackEnemy(){
        // disparoSound.setVolume(80);
        // disparoSound.play();
        World world = heroObj.getWorld();
        world.addObject(new ShotPlayer(), heroObj.getX()+heroObj.getImage().getWidth()/2, heroObj.getY());
        int shot = heroObj.getNumShots()-1;
        heroObj.setNumShots(shot);
        if(heroObj.getNumShots() == 0){
            heroObj.setCurrState(heroObj.getOutOfShotState());
        }
        shotTimer.mark();
    }

}
