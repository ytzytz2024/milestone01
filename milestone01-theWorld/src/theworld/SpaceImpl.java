package theworld;

import java.util.Objects;

/**
 * A general space implement has name, the row and column of the upper left corner, 
 * the row and column of the lower right corner, and the index in the lists of spaces.
 */
public class SpaceImpl implements Space {
  private String name;
  private int upperRow;
  private int leftColumn;
  private int lowerRow;
  private int rightColumn;
  private int index;
  

  /**
   * Constructs a general space implement in terms of the row and column of the upper left corner, 
   * the row and column of the lower right corner, and the index in the lists of spaces.
   * @param name        the name
   * @param upperRow    the number of the upper row
   * @param leftColumn  the number of the left column
   * @param lowerRow    the number of the lower row
   * @param rightColumn the number of the right column
   * @param index       the index in the lists of spaces
   */
  public SpaceImpl(String name, int upperRow, int leftColumn, int lowerRow, int rightColumn, 
      int index) {
    if (upperRow < 0 || leftColumn < 0 || lowerRow < 0 || rightColumn < 0 || index < 0) {
      throw new IllegalArgumentException("Invalid arguments in SpaceImpl!");
    }  
    this.name = name;
    this.upperRow = upperRow;
    this.leftColumn = leftColumn;
    this.lowerRow = lowerRow;
    this.rightColumn = rightColumn;
    this.index = index;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getUpperRow() {
    return this.upperRow;
  }

  @Override
  public int getLeftColumn() {
    return this.leftColumn;
  }

  @Override
  public int getLowerRow() {
    return this.lowerRow;
  }

  @Override
  public int getRightColumn() {
    return this.rightColumn;
  }

  @Override
  public int getIndex() {
    return this.index;
  }
  
  @Override
  public String toString() {
    return String.format("Space name: %s, upperRow: %d, leftColumn: %d, "
        + "lowerRow: %d, rightColumn: %d, index: %d", 
        name, upperRow, leftColumn, lowerRow, rightColumn, index);
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Space)) {
      return false;
    }
    SpaceImpl other = (SpaceImpl) o;
    return (this.name.equals(other.name)) 
      && (this.upperRow == other.upperRow)
      && (this.leftColumn == other.leftColumn) 
      && (this.lowerRow == other.lowerRow)
      && (this.rightColumn == other.rightColumn) 
      && (this.index == other.index);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(name, upperRow, leftColumn, lowerRow, rightColumn, index);
  }

}
