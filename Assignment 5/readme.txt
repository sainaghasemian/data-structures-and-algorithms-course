CPSC 319 Assignment 5 readme file to explain how to compile and run my program.

To have a better understanding I decided to use 2 different files (2 classes) to work together.
Steps to compile:
First ensure the packages are included in any location you move the files into, and ensure the input file being tested
with the code is in the same location. So if you decide to move the file, move the entire "edu" file as that includes 
both of the files (Assign5.java and Hash.java).

To compile both files at the same time first ensure your terminal is in the correct directory ("CPSC 319_Assign5")
then enter the following to compile both .java files: 
javac edu/ucalgary/cpsc319/*.java

The above command will go and create 2 class files, for both of the java files at the same time by going through the 
package path, and by using (*.java) it will be able to compile both files at the same time.

Steps to run linear:
To run this program again ensure your terminal is in the correct directory ("CPSC 319_Assign5"),and ensure
your input file for example "inputA5.txt" is also in that same folder ("CPSC 319_Assign5").
Then enter the following to run:
java edu/ucalgary/cpsc319/Assign5 <input.txt> <output1.txt>

Steps to run quadratic (the bonus):
To run this program again ensure your terminal is in the correct directory ("CPSC 319_Assign5"),and ensure
your input file for example "inputA5.txt" is also in that same folder ("CPSC 319_Assign5").
Then enter the following to run:
java edu/ucalgary/cpsc319/Assign5 <input.txt> <output2.txt> -q
When the command-line flag -q is used that will indicate that quadratic probing is being used instead of linear probing.

NOTE: 
*Ensure you replace input and output1 and output2 in the above line with your desired file names. Also ensure .txt is added
at the end of input file name!
The output file will be found in the same folder ("CPSC 319_Assign5") that the input file was found in.
Also:
output1.txt is linear probing
output2.txt is quadratic probing