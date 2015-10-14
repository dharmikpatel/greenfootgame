import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Iterator here.
 * 
 * @author Jinali Jhaveri
 * @version (a version number or a date)
 */
public interface ImageIterator
{
   public boolean isDone();
   public GreenfootImage next();
   public GreenfootImage currentImage();
}
