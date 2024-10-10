package theworld;

import java.util.Objects;

/**
 * A general character implement has name, health, and current space index as fields.
 */
public class CharacterImpl implements Character {
  private String name;
  private int health;
  private int currentSpaceIndex;

  /**
   * Constructs a general character implement in terms of its name and health. 
   * Then, take zero as start index of space as default.
   * @param name   the name of the character
   * @param health the amount of health of the character
   */
  public CharacterImpl(String name, int health) {
    if (health < 0) {
      throw new IllegalArgumentException("Invalid arguments in CharacterImpl!");
    } 
    this.name = name;
    this.health = health;
    this.currentSpaceIndex = 0;
    
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getHealth() {
    return this.health;
  }

  @Override
  public int getCurrentSpaceIndex() {
    return this.currentSpaceIndex;
  }

  @Override
  public void moveToNextSpace() {
    this.currentSpaceIndex = this.currentSpaceIndex + 1;

  }
  
  @Override
  public String toString() {
    return String.format("Character name: %s, health: %d, current space index: %d, ",
        name, health, currentSpaceIndex);
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Character)) {
      return false;
    }
    CharacterImpl other = (CharacterImpl) o;
    return (this.name.equals(other.name)) 
      && (this.health == other.health)
      && (this.currentSpaceIndex == other.currentSpaceIndex);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(name, health, currentSpaceIndex);
  }

}
