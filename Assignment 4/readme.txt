Assignment 4 readme file to explain how to compile and run my program

To have a better understanding I decided to use 2 different files (2 classes) to work together.
Steps to compile:
First ensure the packages are included in any location you move the files into, and ensure the input file being tested
with the code is in the same location. So if you decide to move the file, move the entire "edu" file as that includes 
both of the files (Assign4.java and DataGraph.java).

To compile both files at the same time first ensure your terminal is in the correct directory ("CPSC 319_Assign4")
then enter the following to compile both .java files: 
javac edu/ucalgary/cpsc319/*.java

The above command will go and create 2 class files, for both of the java files at the same time by going through the 
package path, and by using (*.java) it will be able to compile both files at the same time.

Steps to run:
To run this program again ensure your terminal is in the correct directory ("CPSC 319_Assign4"), and ensure
your input file for example "query.txt" is also in that same folder ("CPSC 319_Assign4").
Then enter the following to run, no need to put .txt at the end of the file names:
java edu/ucalgary/cpsc319/Assign4 <input> <query> <outputfile1> <outputfile2>


NOTE: 
*Ensure you replace input and outputfile1 and outputfile2 in the above line with your desired file names.
The output file will be found in the same folder ("CPSC 319_Assign4") that the input file was found in.
Also:
output1 is DFS
output2 is BFS

