package theworldtest;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import theworld.Space;
import theworld.SpaceImpl;
import theworld.World;
import theworld.WorldImpl;

/**
 * A JUnit test class for the SpaceImpl class.
 */
public class SpaceImplTest {
  private World world;
  private List<Space> listOfSpace;
  
  /**
   * Constructs instances of the classes needed for test.
   * @throws IOException if something goes wrong while reading in
   */
  @Before
  public void setUp() throws IOException {
    FileReader fileInput = new FileReader("res/mansion.txt");
    world = WorldImpl.reader(fileInput);
    listOfSpace = world.getListOfSpace();
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRowInputOne() {
    new SpaceImpl("name", -1, 1, 1, 1, 1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRowInputTwo() {
    new SpaceImpl("name", 1, -1, 1, 1, 1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRowInputThree() {
    new SpaceImpl("name", 1, 1, -1, 1, 1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRowInputFour() {
    new SpaceImpl("name", 1, 1, 1, -1, 1);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRowInputFive() {
    new SpaceImpl("name", 1, 1, 1, 1, -1);
  }
  
  @Test
  public void testGetName() {
    assertEquals("Armory", listOfSpace.get(0).getName());
  }
  
  @Test
  public void testGetUpperRow() {
    assertEquals(22, listOfSpace.get(0).getUpperRow());
  }
  
  @Test
  public void testGetLeftColumn() {
    assertEquals(19, listOfSpace.get(0).getLeftColumn());
  }
  
  @Test
  public void testGetLowerRow() {
    assertEquals(23, listOfSpace.get(0).getLowerRow());
  }
  
  @Test
  public void testGetRightColumn() {
    assertEquals(26, listOfSpace.get(0).getRightColumn());
  }
  
  @Test
  public void testGetIndex() {
    assertEquals(0, listOfSpace.get(0).getIndex());
  }

}
