package theworld;

import java.awt.image.BufferedImage;
import java.util.List;

/**
 * A World includes the size, the name, and the target character.
 * It also includes a detailed list of all of the spaces or rooms that make up the world,
 * and a detailed list of all of the items that can be found in the world.
 */
public interface World {
  
  /**
   * Gets the name of the world.
   * @return the name
   */
  String getName();
  
  /**
   * Gets the number of rows of the world.
   * @return the number of rows
   */
  int getRow();
  
  /**
   * Gets the number of columns of the world.
   * @return the number of columns
   */
  int getColumn();
   
  /**
   * Gets the target character of the world.
   * @return the target character
   */
  Character getTargetCharacter();
  
  /**
   * Gets the list of all spaces that make up the world.
   * @return the list of all spaces
   */
  List<Space> getListOfSpace();
  
  /**
   * Gets the list of all Items that can be found the world.
   * @return the list of all Items
   */
  List<Item> getListOfItem();
  
  /**
  * Gets the list of neighbours of a specified space. Spaces that share a "wall" are neighbors.
  * @param space The specified space
  * @return the list of neighbours
  */
  List<Space> getNeighbour(Space space);
  
  /**
   * Displays information about a specified space, including the name of the space, 
   * what items are in the space, and what spaces can be seen from the specified space.
   * @param space The specified space
   * @return the information in the format of String
   */
  String displayInfoOfSpace(Space space);
  
  /**
   * Moves the target character to next space, in order using 
   * the ordered, 0-indexed list of spaces found in the world specification.
   */
  void moveToNextSpace();
   
  /**
   * Creates a graphical representation of the world map.
   * @param folder The path to output the graphical representation
   * @return BufferedImage of the graphical representation
   */
  BufferedImage creatGraphicalReprensentation(String folder);


}
