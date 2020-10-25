/**
 * PacmanGoogleMapLoader is to instantiate/load the main game map in which the user will play.
 * It implements the StaticMapLoaderInterface which contains the methods that allows this class to
 * load a map with all the elements that it needs to have, such as walls, pellets, small points, characters, and
 * also, if is wished, get the parameters to load the map from a file.
 * 
 * @author Ivan Uresti
 * @contributor Angel Maldonado
 * @version 10/22/20
 */
public class PacmanGoogleMapLoader implements StaticMapLoader
{
    /**
      * Implementation of loadMap method from interface StaticMapLoader-MapLoader
      */
    public Map loadMap()
    {
        // Create the object Map
        Map map = new Map();

        // Set the black background of the level
        map.setBackground("images/level-background.png");

        // Add all the walls to the map
        addWalls(map);

        // Add all the small items to the map
        addSmallItems(map);

        // Add all the power items to the map
        addPowerItems(map);

        // Add all the fruits to the map
        addFruits(map);

        // Add the main character (pacman) to the map
        map.addObject(new PacMan(), 200, 150);
        
        // Add the phantoms
        map.addObject(new BluePhantom(), 500, 250);
        map.addObject(new RedPhantom(), 500, 350);
        map.addObject(new PinkPhantom(), 300, 400);
        map.addObject(new OrangePhantom(), 400, 450);

        // Return the final map
        return map;
    }

    /**
     * Add all the walls that will contain the final map
     */
    void addWalls(Map map)
    {
        // Corrdinates of each wall
        int wallX, wallY;
        // Number of walls in world's sizes
        int wallsInWidth;
        int wallsInHeight;

        // map.addObject(new Wall(), 25, 25)
        /*
         * For to create the walls at top and bottom edges of map:
         * Initialize:
         * > wallsInWidth at number of walls that can be created based on the world's width
         * > wallX and wallY at half the size of the image
         * 
         * Until:
         * > wallsInWidth is 0 (adds the correct amount of walls to the map)
         * 
         * Modify:
         * > wallsInWidth by -1 (to represent the walls that are already added in the map)
         * > wallX by 50 (to put in order the walls)
         */
        for(wallsInWidth = map.getWidth() / 50, wallX = wallY = 25; wallsInWidth >= 1; wallsInWidth--, wallX += 50)
        {
            // Walls for top
            map.addObject(new Wall(), wallX, wallY);
            // Walls for bottom
            map.addObject(new Wall(), wallX, map.getHeight()-25); // -25 is to draw the complete wall at bottom
        }

        /*
         * For to create the walls at left and right edges of map:
         * Initialize:
         * > wallsInHeight at number number of walls that can be created based on the world's width minus the 2 walls
         * that are already at top and bottom
         * > wallX at half the size of the image
         * > wallY at half the size of image times 3 because there is already a wall
         * 
         * Until:
         * > wallsInHeight is 0 (adds the correct amount of walls to the map)
         * 
         * Modify:
         * > wallsInHeight -1 (to represent the walls that are already added in the map)
         * > wallY by 50 (to put in order the walls)
         */
        for(wallsInHeight = (map.getHeight()/50) - 2, wallX = 25, wallY = 25 * 3; wallsInHeight >= 1; wallsInHeight--, wallY += 50)
        {
            // Walls for left
            map.addObject(new Wall(), wallX, wallY);
            // Walls for right
            map.addObject(new Wall(), map.getWidth()-25, wallY);
        }
    }

    /**
     * Add all the small items that will contain the final map
     */
    void addSmallItems(Map map)
    {
        // Coordinates of each small item
        int smallItemX, smallItemY;
        // Number of small items in world's sizes
        int smallItemsInWidth;
        int smallItemsInHeight;

        for(smallItemsInWidth = ((map.getWidth()-100)/15)-3, smallItemX = smallItemY = 85; smallItemsInWidth >= 1; smallItemsInWidth--, smallItemX += 15) {
            map.addObject(new SmallPoint(), smallItemX, smallItemY);
            map.addObject(new SmallPoint(), smallItemX, map.getHeight()-85);
        }

        for(smallItemsInHeight = ((map.getHeight()-100)/15)-10, smallItemX = 85, smallItemY = 150; smallItemsInHeight >= 1; smallItemsInHeight--, smallItemY += 15) {
            map.addObject(new SmallPoint(), smallItemX, smallItemY);
            map.addObject(new SmallPoint(), map.getWidth()-85, smallItemY);
        }
    }

    /**
     * Add all the power items that will contain the final map
     */
    void addPowerItems(Map map)
    {
        map.addObject(new PowerPoint(), 120, 120);
        map.addObject(new PowerPoint(), 120, map.getHeight()-120);
        map.addObject(new PowerPoint(), map.getWidth()-120, 120);
        map.addObject(new PowerPoint(), map.getWidth()-120, map.getHeight()-120);
    }

    /**
     * Add the fruits that will contain the final map
     */
    void addFruits(Map map)
    {
        map.addObject(new Banana(), 300, 300);
        map.addObject(new Cherry(), 500, 500);
        map.addObject(new Strowberry(), 300, 500);
    }
}
