CPSC 319 Assignment 3 readme file to explain how to compile and run my program
The objective of this code was to create a binary search tree using the data from the input files.
To have a better understanding I decided to use 4 different files (4 classes) to work together to read, write
and sort the input files given. I used packages to be able to do this.

Steps to compile:
First ensure the packages are included in any location you move the files into, and ensure the input file being tested
with the code is in the same location. So if you decide to move the file, move the entire "edu" file as that includes 
all 4 of the files (Assign3.java, Node.java, Queue.java, BinarySearchTree.java).

To compile all 4 files at the same time first ensure your terminal is in the correct directory ("CPSC 319_Assign3")
then enter the following to compile all 4 .java files: 
javac edu/ucalgary/cpsc319/*.java

The above command will go and create 4 class files, for the 4 java files at the same time by going through the 
package path, and by using (*.java) it will be able to compile all 4 files at the same time.

Steps to run:
To run this program again ensure your terminal is in the correct directory ("CPSC 319_Assig3"), and ensure
your input file for example "a3input1.txt" is also in that same folder ("CPSC 319_Assign3").
Then enter the following to run:
java edu/ucalgary/cpsc319/Assign3 <inputfile> <outputfile1> <outputfile2>

NOTE: 
*Ensure you replace inputfile and outputfile1 and outputfile2 in the above line with your desired file names.
The output file will be found in the same folder ("CPSC 319_Assign3") that the input file was found in.
*I did as well provide my output files in the same folder:
 - for a3input1 the output file names are input1_output1 and input1_output2
 - for a3input2 the output file names are input2_output1 and input2_output2

