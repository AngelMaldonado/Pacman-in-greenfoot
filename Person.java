import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class Person that extends Actor; it represents the characters inside the game, such as PacMan and Phantoms.
 * 
 * @author Ivan Uresti & Angel Maldonado
 * @version 10/24/2020
 */
public abstract class Person extends Actor // It's abstract because all its attributes and methods will be different in each characters' classes
{
    /***** ATTRIBUTES *****/
    // Array of GreenfootImage where several images/sprites can be located
    protected GreenfootImage sprites[];
    // Current image/sprite that is using the Person-character
    protected int currentSprite = 0;
    // Existing delay for changing an image on the array of images/sprites
    protected int delaySprite = 0;
    // Enum declaration for knowing the direction of the Person-character
    protected CharacterDirection direction;
    // Reference to the collisioning object
    Object collisioningElement = null;
    // Movement ratio in x and y of character
    protected int movementInX;
    protected int movementInY;
    // Speed variable
    protected int speed = 1;

    /***** METHODS *****/

    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * 
     * NOTE: IT DOES NOT MATTER IF THIS METHOD IS IMPLEMENTED IN THIS CLASS, act() METHOD BELONGS TO Actor CLASS (SO, IT CAN BE IMPLEMENTED
     *       DIFFERENT ON THE CHARACTERS' CLASSES).
     *       ONLY WILL BE IMPLEMENTED IN THIS CLASS IF A COMMON BEHAVIOUR IS DETECTED ON THE GAME CHARACTERS.
     */
    public void act(int characterOffSetX, int characterOffSetY)
    {
        // Add your action code here.
        checkCollisions(characterOffSetX, characterOffSetY);
        moveCharacter(direction);
    }

    /**
     * Method to check if a game character is collisioning with any element of map
     */
    Object checkCollisions(int characterOffSetX, int characterOffSetY)
    {
        // Reference to map objects that the character is collisioning
        Wall wall = null;
        SmallPoint smallPoint = null;
        PowerPoint powerPoint = null;

        // Switch to desglose the cases based on the character direction
        switch(direction)
        {
            /**
             * To check collisions is used the method getOneObjectAtOffset of class Actor, to check, based on the size of each element of map,
             * if the character that is using this method is in fact touching any other object/element in the map.
             * getOneObjectAtOffset() returns:
             * null < no object found
             * Object < if and object was found at the given location
             * 
             * NOTE: (type) cast is used to correctly assign the object returned by the method.
             */
            case UP:
                wall = (Wall)getOneObjectAtOffset(0, -25 - (50 - characterOffSetY), Wall.class);
                smallPoint = (SmallPoint)getOneObjectAtOffset(0, -7, SmallPoint.class);
                powerPoint = (PowerPoint)getOneObjectAtOffset(0, -15, PowerPoint.class);
            break;
            case DOWN:
                wall = (Wall)getOneObjectAtOffset(0, 25 + (50 - characterOffSetY), Wall.class);
                smallPoint = (SmallPoint)getOneObjectAtOffset(0, 7, SmallPoint.class);
                powerPoint = (PowerPoint)getOneObjectAtOffset(0, 15, PowerPoint.class);
            break;
            case RIGHT:
                wall = (Wall)getOneObjectAtOffset(25 + (50 - characterOffSetY), 0, Wall.class);
                smallPoint = (SmallPoint)getOneObjectAtOffset(7, 0, SmallPoint.class);
                powerPoint = (PowerPoint)getOneObjectAtOffset(15, 0, PowerPoint.class);
            break;
            case LEFT:
                wall = (Wall)getOneObjectAtOffset(-25 - (50 - characterOffSetY), 0, Wall.class);
                smallPoint = (SmallPoint)getOneObjectAtOffset(-7, 0, SmallPoint.class);
                powerPoint = (PowerPoint)getOneObjectAtOffset(-15, 0, PowerPoint.class);
            break;
        }

        // If any reference to an object of map is not null, assign the collisioningElement reference to the not null reference
        if(wall != null)
        {
            collisioningElement = wall;
        } else if(smallPoint != null)
        {
            collisioningElement = smallPoint;
        } else if(powerPoint != null)
        {
            collisioningElement = powerPoint;
        }

        return collisioningElement;
    }

    /** 
     * Method to move the character
     */
    void moveCharacter(CharacterDirection direction)
    {
        // Update location of pacman based on the movement ratio in x and y
        setLocation(getX() + movementInX, getY() + movementInY);
        
        movementInY = 0;
        movementInX = 0;
        switch(direction)
        {
            case UP:
                movementInY = -speed;
                this.direction = CharacterDirection.UP;
                turnTowards(getX(), 0);
            break;
            case DOWN:
                movementInY = speed;
                this.direction = CharacterDirection.DOWN;
                turnTowards(getX(), getWorld().getHeight());
            break;
            case LEFT:
                this.direction = CharacterDirection.LEFT;
                turnTowards(0, getY());
                movementInX = -speed;
            break;
            case RIGHT:
                this.direction = CharacterDirection.RIGHT;
                turnTowards(getWorld().getWidth(), getY());
                movementInX = speed;
            break;
        }
    }
}

