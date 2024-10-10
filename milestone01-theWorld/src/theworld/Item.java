package theworld;

/**
 * A Item includes the name, the amount of damage it could do, and 
 * the index of the room in which the item can be found.
 */
public interface Item {
  
  /**
   * Gets the name of the item.
   * @return the name
   */
  String getName();
  
  /**
   * Gets the amount of damage the item could do.
   * @return the amount of damage
   */
  int getDamage();
  
  /**
   * Gets the index of the room in which the item can be found.
   * @return the index of the room
   */
  int getSpaceIndex();
 

}
