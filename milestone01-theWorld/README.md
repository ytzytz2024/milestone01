# milestone01-theWorld
## Description
This project is a simulation of a world. The details of the world are specified in a simple text file or string that contains: world description, a detailed list of all of the spaces or rooms that make up the world, and a detailed list of all of the items that can be found in the world.

## Usage
To use this project, run the main method in the driver class. The simulation will start and you can interact with it through the command-line and choose the specification file. The target character starts in space 0 and moves from space to space in order using the ordered, 0-indexed list of spaces found in the world specification.

## Example Runs
I conducted three example runs, using the following input files:

1.myOwnWorld.txt
2.mansionWithLessSpace.txt
3.a.txt

And the outputs of running the driver class are in following txt files, respectively:

1.output-myOwnWorld.txt.txt
2.output-mansion WithLessSpace.txt.txt
3.output-a.txt.txt

The first input represents a standard scenario. This run is to demonstrate the functionality of my model, and the output confirms that all features work well. The second input is similar to the first, but contains less than 20 spaces. As the result, when running the driver, my model threw an IllegalArgumentException, as expected. In the third case, the driver was given a non-existent file as input. Therefore, the model threw a FileNotFoundException, as expected. All six text files can be found in res/ directories.

## Running the JAR File
A JAR file has been generated for this project. You can run this JAR file to start the application. Here's how you can do it:

1. Open a terminal window.
2. Navigate to the directory where the JAR file is located. In this case: /res
3. Run the following command for the three example runs above, respectively:
   
   java -jar milestone01.jar myOwnWorld.txt
   java -jar milestone01.jar mansionWithLessSpace.txt
   java -jar milestone01.jar a.txt



   
   
