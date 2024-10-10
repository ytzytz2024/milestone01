package theworldtest;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;
import theworld.Character;
import theworld.CharacterImpl;
import theworld.World;
import theworld.WorldImpl;

/**
 * A JUnit test class for the CharacterImpl class.
 */
public class CharacterImplTest {
  private World world;
  private Character targetCharacter;
  
  /**
   * Constructs instances of the classes needed for test.
   * @throws IOException if something goes wrong while reading in
   */
  @Before
  public void setUp() throws IOException {
    FileReader fileInput = new FileReader("res/mansion.txt");
    world = WorldImpl.reader(fileInput);
    targetCharacter = world.getTargetCharacter();
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testIfInvalidRowInputOne() {
    new CharacterImpl("name", -1);
  }
  
  @Test
  public void testGetName() {
    assertEquals("Doctor Lucky", targetCharacter.getName());
  }
  
  @Test
  public void testGetHealth() {
    assertEquals(50, targetCharacter.getHealth());
  }
  
  @Test
  public void testGetCurrentSpaceIndex() {
    assertEquals(0, targetCharacter.getCurrentSpaceIndex());
  }

  @Test
  public void testMoveToNextSpace() {
    targetCharacter.moveToNextSpace();
    assertEquals(1, targetCharacter.getCurrentSpaceIndex());
    
  }

}
