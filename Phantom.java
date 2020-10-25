import java.util.Random;

/**
 * Write a description of class Phantom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Phantom extends Person 
{
    private PhantomState phantomState;

    public Phantom()
    {
        phantomState = PhantomState.NORMAL;
        generateRandomDirection();
    }

    public void act()
    {
        super.act(36, 36);

        if(collisioningElement != null)
        {
            // If collisioned with a wall
            if(collisioningElement.getClass().getName() == "Wall")
            {
                generateRandomDirection();
                movementInX = movementInY = 0;
                System.out.println("PacMan collisioning the wall!");
            }
        }

        collisioningElement = null;
    }

    public void generateRandomDirection()
    {
        Random randomDirectionRandom = new Random(System.currentTimeMillis());
        int randomDirectionInt = randomDirectionRandom.nextInt(4);
        switch(randomDirectionInt)
        {
            case 0:
            direction = CharacterDirection.RIGHT;
            break;
            case 1:
            direction = CharacterDirection.LEFT;
            break;
            case 2:
            direction = CharacterDirection.DOWN;
            break;
            case 3:
            direction = CharacterDirection.UP;
            break;
        }
        randomDirectionRandom.setSeed(System.currentTimeMillis());
        /*
        Random randomDirectionRandom = new Random(System.currentTimeMillis());
        int randomDirectionInt;
        randomDirectionInt = randomDirectionRandom.nextInt(4) - exception;
        switch(direction)
        {
        // UP
        case UP:
        switch(randomDirectionInt)
        {
        case 0:
        direction = CharacterDirection.RIGHT;
        break;
        case 1:
        direction = CharacterDirection.LEFT;
        break;
        case 2:
        direction = CharacterDirection.DOWN;
        break;
        case 3:
        direction = CharacterDirection.UP;
        break;
        }
        break;
        // DOWN
        case DOWN:
        switch(randomDirectionInt)
        {
        case 0:
        direction = CharacterDirection.RIGHT;
        break;
        case 1:
        direction = CharacterDirection.LEFT;
        break;
        case 2:
        direction = CharacterDirection.UP;
        break;
        case 3:
        direction = CharacterDirection.DOWN;
        break;
        }
        break;
        // LEFT
        case LEFT:
        switch(randomDirectionInt)
        {
        case 0:
        direction = CharacterDirection.RIGHT;
        break;
        case 1:
        direction = CharacterDirection.UP;
        break;
        case 2:
        direction = CharacterDirection.DOWN;
        break;
        case 3:
        direction = CharacterDirection.LEFT;
        break;
        }
        break;
        // RIGHT
        case RIGHT:
        switch(randomDirectionInt)
        {
        case 0:
        direction = CharacterDirection.UP;
        break;
        case 1:
        direction = CharacterDirection.LEFT;
        break;
        case 2:
        direction = CharacterDirection.DOWN;
        break;
        case 3:
        direction = CharacterDirection.RIGHT;
        break;
        }
        break;
        }
        randomDirectionRandom = new Random(System.currentTimeMillis());
         */
    }
}
