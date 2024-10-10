package theworldtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import theworld.Character;
import theworld.Item;
import theworld.Space;
import theworld.World;
import theworld.WorldImpl;

/**
 * A JUnit test class for the WorldImpl class.
 */
public class WorldImplTest {
  private World world;
  private List<Space> listOfSpace;
  private List<Item> listOfItem;
  private Character targetCharacter;
  
  /**
   * Constructs instances of the classes needed for test.
   * @throws IOException if something goes wrong while reading in 
   */
  @Before
  public void setUp() throws IOException {
    /*
    String worldStringTest = 
        "10 10 MyWorld\n" + 
        "100 DoctorLucky\n" + 
        "3\n" + // 3 spaces
        "0 0 2 2 Room1\n" + 
        "0 3 2 5 Room2\n" + 
        "3 0 5 2 Room3\n" + 
        "2\n" + // 2 items
        "0 10 Sword\n" + 
        "1 20 Gun";
     */
    //StringReader stringInput = new StringReader(worldStringTest);
    
    FileReader fileInput = new FileReader("res/mansion.txt");

    world = WorldImpl.reader(fileInput);
    listOfSpace = world.getListOfSpace();
    listOfItem = world.getListOfItem();
    targetCharacter = world.getTargetCharacter();
    

    //world1 = WorldImpl.reader(invalidInput);
    //listOfSpace1 = world.getListOfSpace();
    //listOfItem1 = world.getListOfItem();
    //targetCharacter1 = world.getTargetCharacter();
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRowInputOne() {
    new WorldImpl("name", 1, -2, targetCharacter, listOfSpace, listOfItem);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRowInputTwo() {
    new WorldImpl("name", -1, 2, targetCharacter, listOfSpace, listOfItem);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRowInputThree() throws IOException {
    FileReader invalidInputOne = new FileReader("res/mansionWithLessSpace.txt");
    WorldImpl.reader(invalidInputOne);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRowInputFour() throws IOException {
    FileReader invalidInputTwo = new FileReader("res/mansionWithLessItem.txt");
    WorldImpl.reader(invalidInputTwo);
  }
  
  @Test
  public void testGetName() {
    assertEquals("Doctor Lucky's Mansion", world.getName());
  }
  
  @Test
  public void testGetRow() {
    assertEquals(36, world.getRow());
  }
  
  @Test
  public void testGetColumn() {
    assertEquals(30, world.getColumn());
  }
  
  @Test
  public void testGetTargetCharacter() {
    assertEquals(targetCharacter, world.getTargetCharacter());
  }
  
  @Test
  public void testGetListOfSpace() {
    assertEquals(listOfSpace, world.getListOfSpace());
  }
  
  @Test
  public void testGetListOfItem() {
    assertEquals(listOfItem, world.getListOfItem());
  }

  @Test
  public void testGetNeighbour() {
    List<Space> neighboursOfFirst = world.getNeighbour(listOfSpace.get(0));
    assertEquals(3, neighboursOfFirst.size());   
    assertEquals("Billiard Room", neighboursOfFirst.get(0).getName());
    assertEquals("Dining Hall", neighboursOfFirst.get(1).getName());
    assertEquals("Drawing Room", neighboursOfFirst.get(2).getName());
  }
  
  @Test
  public void testDisplayInfoOfSpace() {
    Space firstSpace = listOfSpace.get(0);
    assertEquals("The space's name is Armory, the item is: Revolver , "
        + "and the spaces can be seen from this space is: Billiard Room Dining Hall Drawing Room ", 
        world.displayInfoOfSpace(firstSpace));
  }
  
  @Test
  public void testMoveToNextSpace() {
    targetCharacter.moveToNextSpace();
    assertEquals(1, targetCharacter.getCurrentSpaceIndex());
   
  }
  
  @Test
  public void testCreatGraphicalReprensentation() {
    BufferedImage result = world.creatGraphicalReprensentation("res/worldMap.png"); 
    assertTrue(result instanceof BufferedImage);
  }

}
