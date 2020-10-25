import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PinkPhantom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PinkPhantom extends Phantom
{
    public PinkPhantom()
    {
        sprites = new GreenfootImage[1];
        
        sprites[0] = new GreenfootImage("images/pink-phantom-left.png");
    }
    
    public void act()
    {
        setImage(sprites[0]);
        super.act();
    }
}
