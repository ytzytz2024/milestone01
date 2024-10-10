package theworldtest;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import theworld.Item;
import theworld.ItemImpl;
import theworld.World;
import theworld.WorldImpl;

/**
 * A JUnit test class for the ItemImpl class.
 */
public class ItemImplTest {

  private World world;
  private List<Item> listOfItem;
  
  /**
   * Constructs instances of the classes needed for test.
   * @throws IOException if something goes wrong while reading in
   */
  @Before
  public void setUp() throws IOException {
    FileReader fileInput = new FileReader("res/mansion.txt");
    world = WorldImpl.reader(fileInput);
    listOfItem = world.getListOfItem();
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRowInputOne() {
    new ItemImpl("name", -1, 0);
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRowInputTwo() {
    new ItemImpl("name", 1, -1);
  }
  
  @Test
  public void testGetName() {
    assertEquals("Crepe Pan", listOfItem.get(0).getName());
  }
  
  @Test
  public void testGetDamage() {
    assertEquals(3, listOfItem.get(0).getDamage());
  }
  
  @Test
  public void testGetSpaceIndex() {
    assertEquals(8, listOfItem.get(0).getSpaceIndex());
  }

}
