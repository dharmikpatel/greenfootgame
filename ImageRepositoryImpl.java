import greenfoot.*;

/**
 * Write a description of class ImageRepositoryImpl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageRepositoryImpl implements ImageRepository 
{
    private GreenfootImage[] images;
    
    public ImageRepositoryImpl()
    {
        images = new GreenfootImage[3];
        images[0] = new GreenfootImage("Explosion1.png");
        images[1] = new GreenfootImage("Explosion2.png");
        images[2] = new GreenfootImage("Explosion3.png");
        //images[3] = new GreenfootImage("Explosion4.png");
        //images[4] = new GreenfootImage("Explosion5.png");
    }
    
    public ImageIterator createIterator() {
		return new ImageIteratorImpl(images);
	}
}
