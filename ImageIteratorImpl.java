import greenfoot.*;
import java.util.*;
/**
 * Write a description of class ImageIteratorImpl here.
 * 
 * @author Jinali Jhaveri 
 * @version (a version number or a date)
 */
public class ImageIteratorImpl implements ImageIterator 
{

    GreenfootImage[] arrImages;
    int cursor;
    int max;

    /**
     * Constructor for objects of class ImageIteratorImpl
     */
    public ImageIteratorImpl(GreenfootImage[] images)
    {
        this.arrImages = Arrays.copyOf(images, images.length);
        cursor = 0;
        max = arrImages.length;
    }
    
    public GreenfootImage next() {
        cursor++ ;
        if ( !isDone() )
		    return arrImages[cursor];
        else
            return null ;
	}

	public GreenfootImage currentImage() {
		return arrImages[cursor] ;
	}

	public boolean isDone() {
		return (cursor == max) ;
	}
}
