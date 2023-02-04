//@author Saina Ghasemian-Roudsari
//UCID:30113011
//@version 1.8
//@since 1.0

package edu.ucalgary.cpsc319;

import java.util.*;
import java.io.*;

public class Assign5 {
    //Bonus is implemented using quadProbing
    private static boolean quadProbing = false;
    private static Hash Hash;
    private static final int HASH_TABLE_SIZE = 16193; 

    private static String[] charName;
    private static double avgNumReads;
    private static double loadFactor;
    private static double hashingEfficiency;
    private static int sizeChain;

    public static void main(String[] args) {
        if (args.length == 2 || args.length == 3) {
            inputFileName = args[0];
            outputFileName = args[1];
            if (args.length == 3) {
                if (args[2].equals("-q")) {
                    quadProbing = true;
                } 
                else {
                    System.out.println("User should use the command-line flag -q to invoke quadratic probing.");
                }
            }
        } 
        else {
            System.out.println("Two command line arguments are needed.");
            System.exit(1);
        }

        readInputFile();
        //After checking command line arguments^ read the input file "inputA5.txt"

        analysisInput();

        //Takes the output file and writes all required values into it
        outputFile();

        System.out.println("All required values have been printed into the output file.");
    }

    private static String inputFileName = "inputA5.txt";
    private static String outputFileName = "output.txt";


    public static void readInputFile() {
        Hash = new Hash(HASH_TABLE_SIZE, quadProbing);
        charName = new String[inInputFile(inputFileName)];
        try {
            File inputFile = new File(inputFileName);
            Scanner fileReader = new Scanner(inputFile);
            for (int i = 0; fileReader.hasNextLine(); i++) {
                String charValue = fileReader.nextLine();
                charName[i] = charValue;
                Hash.insertIntoHash(charValue);
            }
            fileReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public static int inInputFile(String wordsInInput) {
        int temp = 0;
        try {
            Scanner fileReader = new Scanner(new File(wordsInInput));
            for (temp = 0; fileReader.hasNextLine() && (fileReader.nextLine()).length() > 0; temp++);
        } 
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return temp;
    }

    public static void analysisInput() {
        loadFactor = 0;
        hashingEfficiency = 0;
        sizeChain = 0;
        avgNumReads = 0;
        for (String charValue : charName) {
            int records = Hash.searchHashTable(charValue);
            if (sizeChain < records) {
                sizeChain = records;
            }
            avgNumReads += 1.0 * records / charName.length;
        }
        loadFactor = 1.0 * charName.length / HASH_TABLE_SIZE;
        hashingEfficiency = 1.0 * loadFactor / avgNumReads;
    }

    public static void outputFile() {
        try {
            FileWriter outputWriter = new FileWriter(outputFileName);
            outputWriter.write(String.format("The average number of reads per record:  %f\n", avgNumReads));
            outputWriter.write(String.format("Load factor:  %f\n", (loadFactor)*100));
            outputWriter.write(String.format("Hashing efficiency:  %f\n", (hashingEfficiency)*100));
            outputWriter.write(String.format("Size of the longest chain when searching:  %d\n", sizeChain));
            outputWriter.close();
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }



}