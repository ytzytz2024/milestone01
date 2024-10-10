package theworld;

/**
 * A Character includes the name, the amount of health it has, 
 * and the index of the space where the item is currently in. 
 */
public interface Character {
  
  /**
   * Gets the name of the character.
   * @return the name
   */
  String getName();
  
  /**
   * Gets the amount of health of the character.
   * @return the amount of health
   */
  int getHealth();
  
  /**
   * Gets the index of the space where the item is currently in.
   * @return the index of the current space
   */
  int getCurrentSpaceIndex();
  
  /**
   * Moves the target character to next space, in order using 
   * the ordered, 0-indexed list of spaces found in the world specification.
   */
  void moveToNextSpace();

}
