package theworld;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * A driver class that demonstrates the functionality of the model.
 * It uses the methods that implement each of the different requirements.
 */
public class WorldDriver {
  /**
   * Main driver program to show how each method works.
   * @param args Used to read in the path and name of the text file that contains all specification.
   */
  public static void main(String[] args) {
    System.out.println("Enter the world specification file: ");
    try {
      Readable worldSpecification = new FileReader(args[0]);
      World world = WorldImpl.reader(worldSpecification);
      
      /*Tests
      System.out.println(world.getName());
      System.out.println(world.getTargetCharacter().getName());
      Space space0 = world.getListOfSpace().get(0);
      System.out.println(space0.getUpperRow() + " " + space0.getLeftColumn() + " " 
      + space0.getLowerRow() + " " + space0.getRightColumn());
      Space space4 = world.getListOfSpace().get(4);
      System.out.println(space4.getUpperRow() + " " + space4.getLeftColumn() + " " 
      + space4.getLowerRow() + " " + space4.getRightColumn());
      Space space2 = world.getListOfSpace().get(2);
      System.out.println(world.displayInfoOfSpace(space2));
      */
      
      //Display info
      Space firstSpace = world.getListOfSpace().get(0);
      System.out.println(world.displayInfoOfSpace(firstSpace));
      
      //Determine neighbours
      List<Space> neighboursOfFirst = world.getNeighbour(firstSpace);
      System.out.println("The information of FirstSpace's neighbours:");
      for (int i = 0; i < neighboursOfFirst.size(); i++) {
        System.out.println(world.displayInfoOfSpace(neighboursOfFirst.get(i)));
      }
      
      //Move the character
      System.out.println("The character is in Space: " 
          + world.getTargetCharacter().getCurrentSpaceIndex());
      world.moveToNextSpace();
      System.out.println("The character is in Space: " 
          + world.getTargetCharacter().getCurrentSpaceIndex());
      
      //Generate Graph
      world.creatGraphicalReprensentation("res/worldMap.png");      
    } catch (IOException e) {
      // This model does not need specific recovery from IOException,
      // because it is not the model's fault if the user gives wrong files,
      // but I want to make sure I can identity the error.
      e.printStackTrace();
    }

  }

}
