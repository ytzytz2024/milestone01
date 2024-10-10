package theworld;

/**
 * A Space includes the name, the row and column of the upper left corner, 
 * the row and column of the lower right corner, and the index in the lists of spaces.
 */
public interface Space {
  
  /**
   * Gets the name of the space.
   * @return the name
   */
  String getName();
  
  /**
   * Gets the number of the upper row of the world.
   * @return the number of the upper row
   */
  int getUpperRow();
  
  /**
   * Gets the number of the left column of the world.
   * @return the number of the left column
   */
  int getLeftColumn();
  
  /**
   * Gets the number of the lower row of the world.
   * @return the number of the lower row
   */
  int getLowerRow();
  
  /**
   * Gets the number of the right column of the world.
   * @return the number of the right column
   */
  int getRightColumn();
  
  /**
   * Gets the index in the lists of spaces.
   * @return the index
   */
  int getIndex();
}
