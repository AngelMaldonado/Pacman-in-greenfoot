import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Map is a subclass of World
 * Map has all the methods of World because "extends" World
 * Its function is to 'rename' World as Map and add the attribute of Hud
 * 
 * @author Ivan Uresti
 * @contributor Angel Maldonado
 * @version 10/22/20
 */
public class Map extends World
{
    /**
     * Hud attribute
     */
    private Hud hud;
    
    /**
     * Constructor of Map class
     */
    public Map()
    {
        // Create a new world with 800x700 cells with a cell size of 1x1 pixels.
        super(800, 700, 1); // super refers to the a parent class object, in this case is constructing an object World
    }
}
