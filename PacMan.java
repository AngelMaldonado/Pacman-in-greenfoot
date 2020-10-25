import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class PacMan that extends Person which also extends Actor; it represents the character of game PacMan
 * 
 * @author Ivan Uresti & Angel Maldonado 
 * @version 10/24/2020
 */
public class PacMan extends Person
{
    /***** CONSTANTS *****/
    // Total lifes that pacman has when the game starts
    private static final int INITIAL_LIFES = 3;
    // Initial points that pacman has collected
    private static final int INITIAL_POINTS = 0;
    // Number of iterations (Greenfoot cycles) to change the image/sprite of array
    private static final int ITERATIONS_TO_CHANGE_SPRITE = 15;
    // Movement speed
    private static final int PACMAN_SPEED = 2;
    
    /***** ATTRIBUTES *****/
    // Remaining lifes of pacman
    private int lifes;
    // Total points collected by pacman
    private int points;

    /***** METHODS *****/
    
    /** 
     * Constructor 
     */
    public PacMan()
    {
        // Initialize the array of images/sprites in size of 2
        sprites = new GreenfootImage[2];
        // Locate the pacman-open sprite in position 0
        sprites[0] = new GreenfootImage("images/pacman-open.png");
        // Locate the pacman-open sprite in position 1
        sprites[1] = new GreenfootImage("images/pacman-close.png");

        // Initialize the remaining lifes at INITIAL_LIFES
        lifes = INITIAL_LIFES;
        // Initialize collected points at INITIAL_POINTS
        points = INITIAL_POINTS;
        // Initialize direction at RIGHT
        direction = CharacterDirection.RIGHT;
    }

    /**
     * Act - do whatever the PacMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Show the accumulated points
        getWorld().showText("POINTS:", 300, 10);
        getWorld().showText(String.format("%d", points), 400, 10);
        // Invoque the act() method of class Person
        super.act(36, 36);
        // If the referenced object to check collision is null means that the actor didn't collisioned with other
        if(collisioningElement != null)
        {
            // If collisioned with a wall
            if(collisioningElement.getClass().getName() == "Wall")
            {
                movementInX = movementInY = 0;
                System.out.println("PacMan collisioning the wall!");
                
            } 
            // If collisioned with a SmallPoint
            else
            {
                if(collisioningElement.getClass().getName() == "SmallPoint")
                {
                    SmallPoint smallPoint = (SmallPoint)collisioningElement;
                    points = points + smallPoint.getPoints();
                    getWorld().removeObject((SmallPoint)collisioningElement);
                    System.out.println("PacMan collisioned a SmallPoint!");
                }
                // If collisioned with a PowerPoint
                else
                {
                    if(collisioningElement.getClass().getName() == "PowerPoint")
                    {
                        PowerPoint powerPoint = (PowerPoint)collisioningElement;
                        points = points + powerPoint.getPoints();
                        getWorld().removeObject((PowerPoint)collisioningElement);
                        speed = PACMAN_SPEED;
                        
                        System.out.println("PacMan collisioned a PowerPoint!");
                    }
                }
            }
                
            collisioningElement = null;
        }
        
        // Variable to locate the lastKeyPressed as String
        String lastKeyPressed;
        
        // Checks if the delaySprite attribute of class Person
        if(delaySprite >= ITERATIONS_TO_CHANGE_SPRITE)
        {
            // currentSprite will change from 1 to 0 in this line
            currentSprite = (++currentSprite) % sprites.length;
            setImage(sprites[currentSprite]); // Set the image computed in past line
            
            // Reset the delaySprite
            delaySprite = 0;
        }

        // Increment the delaySprite
        delaySprite++;


        // Update the lastKeyPressed
        lastKeyPressed = Greenfoot.getKey();
        
        // If lastKeyPressed is different from null
        if(lastKeyPressed != null)
        {
            // Show the pressed key
            getWorld().showText(lastKeyPressed, 100, 10);
            switch(lastKeyPressed)
            {
                case "up":
                    moveCharacter(CharacterDirection.UP);
                break;
                case "down":
                    moveCharacter(CharacterDirection.DOWN);
                break;
                case "left":
                    moveCharacter(CharacterDirection.LEFT);
                break;
                case "right":
                    moveCharacter(CharacterDirection.RIGHT);
                break;
            }
        }
    }       
}