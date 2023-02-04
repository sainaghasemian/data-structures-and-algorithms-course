CPSC 319 Assignment 2 readme file to explain how to compile and run my program

This program was created to sort a list of words from a input file to an output txt file in lists.
To have a better understanding I decided to use 3 different files (3 classes) to work together to read, write
and sort the input files given. I used packages to be able to do this.

Steps to compile:
First ensure the packages are included in any location you move the files into, and ensure the input file being tested
with the code is in the same location. So if you decide to move the file, move the entire "edu" file as that includes 
all 3 of the files (Assign2.java, Node.java, LinkedList.java).

To compile all 3 files at the same time first ensure your terminal is in the correct directory ("CPSC 319 Assignment 2")
then enter the following to compile all 3 .java files: 
javac edu/ucalgary/cpsc319/*.java

The above command will go and create 3 class files, for the 3 java files at the same time by going through the 
package path, and by using (*.java) it will be able to compile all 3 files at the same time.

Steps to run:
To run this program again ensure your terminal is in the correct directory ("CPSC 319 Assignment 2"), and ensure
your input file for example "medium.txt" is also in that same folder ("CPSC 319 Assignment 2").
Then enter the following to run:
java edu/ucalgary/cpsc319/Assign2 <inputfile> <outputfile>

NOTE: 
Ensure you replace inputfile and outputfile in the above line with your desired file names.
The output file will be found in the same folder ("CPSC 319 Assignment 2") that the input file was found in.
