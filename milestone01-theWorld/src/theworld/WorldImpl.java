package theworld;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.imageio.ImageIO;

/**
 * A general world implement has the size, the name, and the target character.
 * It also includes a detailed list of all of the spaces or rooms that make up the world,
 * and a detailed list of all of the items that can be found in the world.
 */
public class WorldImpl implements World {
  private String name;
  private int row;
  private int column;
  private Character targetCharacter;
  private List<Space> listOfSpace;
  private List<Item> listOfItem;
  
  /**
   * Constructs a general world implement in terms of the size, the name, and the target character.
   * It also includes a detailed list of all of the spaces or rooms that make up the world,
   * and a detailed list of all of the items that can be found in the world.
   * @param name             the name
   * @param row              the number of rows
   * @param column           the number of columns
   * @param targetCharacter  the target character
   * @param listOfSpace      the list of all spaces
   * @param listOfItem       the list of all Items
   */
  public WorldImpl(String name, int row, int column, Character targetCharacter, 
      List<Space> listOfSpace, List<Item> listOfItem) {
    if ((row < 0) || column < 0 || listOfSpace.size() < 20 || listOfItem.size() < 20) {
      throw new IllegalArgumentException("Invalid arguments in WorldImpl!");
    }    
    this.name = name;
    this.row = row;
    this.column = column;
    this.targetCharacter = targetCharacter; 
    this.listOfSpace = listOfSpace;
    this.listOfItem = listOfItem;
   
  }

  /**
   * The parse method that reads the information of the world from a file or text.
   * @param in the readable source
   * @return the specified world object based on the information read in
   * @throws IOException if something goes wrong while reading in
   */
  public static World reader(Readable in) throws IOException {
    BufferedReader reader = new BufferedReader((Reader) in);
    
    //Initialize the World
    String[] worldInfo = reader.readLine().trim().split("\\s+");

    String worldName = worldInfo[2];
    for (int i = 3; i < worldInfo.length; i++) {
      worldName = worldName + " " + worldInfo[i];
    }
    
    
    //Initialize the targetCharacter
    String[] targetCharacterInfo = reader.readLine().trim().split("\\s+");
    int health = Integer.parseInt(targetCharacterInfo[0]);
    String characterName = targetCharacterInfo[1];
    for (int i = 2; i < targetCharacterInfo.length; i++) {
      characterName = characterName + " " + targetCharacterInfo[i];
    }
    Character character = new CharacterImpl(characterName, health);
    
    //Initialize the spaces
    int numOfSpace = Integer.parseInt(reader.readLine());
    List<Space> listOfSpace = new ArrayList<>();
    for (int i = 0; i < numOfSpace; i++) {
      String[] spaceInfo = reader.readLine().trim().split("\\s+");
      int upperRow = Integer.parseInt(spaceInfo[0]);
      int leftColumn = Integer.parseInt(spaceInfo[1]);
      int lowerRow = Integer.parseInt(spaceInfo[2]);
      int rightColumn = Integer.parseInt(spaceInfo[3]);
      String spaceName = spaceInfo[4];
      for (int j = 5; j < spaceInfo.length; j++) {
        spaceName = spaceName + " " + spaceInfo[j];
      }      
      int index = i;
      
      listOfSpace.add(new SpaceImpl(spaceName, upperRow, leftColumn, lowerRow, rightColumn, index));
    }
    
    //Initialize the items
    int numOfItem = Integer.parseInt(reader.readLine());
    List<Item> listOfItem = new ArrayList<>();
    for (int i = 0; i < numOfItem; i++) {
      String[] itemInfo = reader.readLine().trim().split("\\s+");
      int spaceIndex = Integer.parseInt(itemInfo[0]);
      int damage = Integer.parseInt(itemInfo[1]);
      String itemName = itemInfo[2];
      for (int j = 3; j < itemInfo.length; j++) {
        itemName = itemName + " " + itemInfo[j];
      }      
      
      listOfItem.add(new ItemImpl(itemName, damage, spaceIndex));
    }
    int row = Integer.parseInt(worldInfo[0]);
    int column = Integer.parseInt(worldInfo[1]);
    return new WorldImpl(worldName, row, column, character, listOfSpace, listOfItem);
    
    
  }
  
  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int getColumn() {
    return this.column;
  }

  @Override
  public Character getTargetCharacter() {
    return this.targetCharacter;
  }
  
  @Override
  public List<Space> getListOfSpace() {
    return this.listOfSpace;
  }
  
  @Override
  public List<Item> getListOfItem() {
    return this.listOfItem;
  }

  @Override
  public List<Space> getNeighbour(Space space) {
    
    List<Space> neighbours = new ArrayList<Space>();
    for (int i = 0; i < this.getListOfSpace().size(); i++) {
      Space that = this.getListOfSpace().get(i);
      
      if ((that.getUpperRow() - 1 == space.getLowerRow() 
          || that.getLowerRow() + 1 == space.getUpperRow())
          && ((that.getLeftColumn() <= space.getRightColumn()) 
              && (space.getLeftColumn() <= that.getRightColumn()))) {
        neighbours.add(that);
      } 
      
      if ((that.getLeftColumn() - 1 == space.getRightColumn() 
          || that.getRightColumn() + 1 == space.getLeftColumn())
          && ((that.getUpperRow() <= space.getLowerRow()) 
              && (space.getUpperRow() <= that.getLowerRow()))) {
        neighbours.add(that);
      }  
    }
    return neighbours;
  }

  @Override
  public String displayInfoOfSpace(Space space) {
    String itemName = "";
    for (int i = 0; i < this.getListOfItem().size(); i++) {
      if (this.getListOfItem().get(i).getSpaceIndex() == space.getIndex()) {
        itemName = itemName + this.getListOfItem().get(i).getName() + " ";
      }
    }
    String neighbourName = "";
    for (int i = 0; i < this.getNeighbour(space).size(); i++) {
      neighbourName = neighbourName + this.getNeighbour(space).get(i).getName() + " ";
    }
    
    return String.format("The space's name is %s, the item is: %s, "
        + "and the spaces can be seen from this space is: %s", 
        space.getName(), itemName, neighbourName);
  }
  
  @Override
  public void moveToNextSpace() {
    targetCharacter.moveToNextSpace();
  }

  @Override
  public BufferedImage creatGraphicalReprensentation(String path) {
    int width = this.getColumn();
    int height = this.getRow();
    BufferedImage image = new BufferedImage(width * 100, height * 100, BufferedImage.TYPE_INT_RGB);
    Graphics worldImage = image.getGraphics();
    worldImage.setColor(Color.WHITE);
    worldImage.fillRect(0, 0, width * 100, height * 100);
    
    
    List<Space> listOfSpace = this.getListOfSpace();
    for (int i = 0; i < listOfSpace.size(); i++) {
      Space space = listOfSpace.get(i);
      int upperRow = space.getUpperRow();
      int leftColumn = space.getLeftColumn();
      int lowerRow = space.getLowerRow();
      int rightColumn = space.getRightColumn();
      
      worldImage.setColor(Color.BLACK);
      worldImage.drawRect(leftColumn * 100, upperRow * 100, (rightColumn - leftColumn + 1) * 100, 
          (lowerRow - upperRow + 1) * 100);  
      
      worldImage.setFont(new Font("Arial", Font.PLAIN, 40));
      worldImage.drawString(space.getName(), (leftColumn + rightColumn) * 100 / 2, 
          (upperRow + lowerRow) * 100 / 2);
    }
    try {
      File file = new File(path);
      ImageIO.write(image, "png", file);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return image;
  }
  
  @Override
  public String toString() {
    StringBuilder string = new StringBuilder();
    string.append("World Name: ").append(this.name)
      .append("\nRows: ").append(this.row)
      .append("\nColumns: ").append(this.column)
      .append("\nTarget: ").append(this.targetCharacter)
      .append("\nSpaces: ").append(this.listOfSpace)
      .append("\nItems: ").append(this.listOfItem);
    return string.toString();
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof World)) {
      return false;
    }
    WorldImpl other = (WorldImpl) o;
    return (this.row == other.row) 
      && (this.column == other.column) 
      && (this.name.equals(other.name)) 
      && this.targetCharacter.equals(other.targetCharacter) 
      && this.listOfSpace.equals(other.listOfSpace) 
      && this.listOfItem.equals(other.listOfItem);
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(row, name, column, targetCharacter, listOfSpace, listOfItem);
  }

}
