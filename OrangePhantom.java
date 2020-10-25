import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OrangePhantom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrangePhantom extends Phantom
{
    public OrangePhantom()
    {
        sprites = new GreenfootImage[1];
        
        sprites[0] = new GreenfootImage("images/orange-phantom-left.png");
    }
    
    public void act()
    {
        setImage(sprites[0]);
        super.act();
    }
}
