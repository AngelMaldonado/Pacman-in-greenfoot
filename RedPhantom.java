import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedPhantom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedPhantom extends Phantom
{
    public RedPhantom()
    {
        sprites = new GreenfootImage[1];
        
        sprites[0] = new GreenfootImage("images/red-phantom-left.png");
    }
    
    public void act()
    {
        setImage(sprites[0]);
        super.act();
    }
}
