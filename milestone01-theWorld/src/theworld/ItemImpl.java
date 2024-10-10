package theworld;

import java.util.Objects;

/**
 * A general item implement has name, damage, and the space index as fields.
 */
public class ItemImpl implements Item {
  private String name;
  private int damage;
  private int spaceIndex;

  /**
   * Constructs a general item implement in terms of its name, damage, and index of space. 
   * @param name       the name
   * @param damage     the damage the item could do
   * @param spaceIndex the index of the room in which the item can be found
   */
  public ItemImpl(String name, int damage, int spaceIndex) {
    if (damage < 0 || spaceIndex < 0) {
      throw new IllegalArgumentException("Invalid arguments in ItemImpl!");
    } 
    this.name = name;
    this.damage = damage;
    this.spaceIndex = spaceIndex;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getDamage() {
    return this.damage;
  }
  
  @Override
  public int getSpaceIndex() {
    return this.spaceIndex;
  }  
  
  @Override
  public String toString() {
    return String.format("Item name: %s, damage: %d, space index: %d, ",
        name, damage, spaceIndex);
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Item)) {
      return false;
    }
    ItemImpl other = (ItemImpl) o;
    return (this.name.equals(other.name)) 
      && (this.damage == other.damage)
      && (this.spaceIndex == other.spaceIndex);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(name, damage, spaceIndex);
  }

}
