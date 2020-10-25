/**
 * MapLoader is an interface that allows to instantiate an object of Map class with certain parameters, such as
 * a file that contains the width and height, colors, etc.
 * To make this possible, in the implementation of loadMap method when the object Map is created add the necessary parameters to the
 * constructor of Map to get the file and create the Map with the attributes that this file contains (it can be added a second constructor with
 * this parameters).
 * 
 * NOTE: This is a general interface (it can be implemented at any class that will need to instantiate/load a map
 * 
 * @author Ivan Uresti
 * @contributor Angel Maldonado
 * @version 10/22/20
 */
public interface MapLoader
{
    /**
     * Loads all the graphic elements of the map and returns the final map
     */
    Map loadMap();
    
    // NOTE: EACH ELEMENT OF THE MAP HAS ITS OWN CLASS AND ITS RESPECTIVE SPRITE AND GRAPHIC CREATION BECAUSE THEY ARE EXTENSIONS OF ACTOR CLASS
}
