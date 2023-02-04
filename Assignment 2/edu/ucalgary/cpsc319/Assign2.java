//@author Saina Ghasemian-Roudsari
//UCID:30113011
//@version 1.5
//@since 1.0

package edu.ucalgary.cpsc319;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Assign2 {
    public static void main(String args[]) throws IOException {
        //Test number of arguments
        if(args.length != 2) {
            System.out.println("Invalid entry, please enter 2 arguments.\n");
            System.exit(1);
        }
        String inputFile = args[0] + ".txt";
        File inputFileName = new File(inputFile);
        String outputFile = args[1] + ".txt";
        //First checking to see if the input file exists, then making sure the file can be read
        //if it can not be read it can not be written into
        if(inputFileName.exists()) {
            if(inputFileName.canRead()) {
                System.out.println("\nInput file is good to go, can be read!");
            } else {
                System.out.printf("\nInput file: '%s' can not be read. Try a different input file.", inputFile);
                System.exit(1);
            }
        } else {
            System.out.printf("\nInput file: '%s' does not exist. Try a different input file.", inputFile);
            System.exit(1);
        }  

        long startingTime = System.nanoTime();
        Scanner readInputFile = new Scanner(inputFileName);
        int i = 0;
        String[] array = new String[1580000];
        LinkedList[] theList = new LinkedList[1580000];
        LinkedList temp;
        String str1;
        String sortKey;
        int mainValue;

        while(readInputFile.hasNextLine()) {
            str1 = readInputFile.nextLine();
            sortKey = str(str1.toLowerCase());
            mainValue = isAnagram(sortKey, array);

            if(i == 0) {    
                array[i] = sortKey;
                temp = new LinkedList();
                temp.addFirst(str1);
                theList[i] = temp;
                i++;

            } else if(mainValue != -1) {   
                temp = theList[mainValue];
                temp.addLast(str1);

            } else {    
                array[i] = sortKey;
                temp = new LinkedList();
                temp.addFirst(str1);
                theList[i] = temp;
                i++;
            }

        }  

        int x = 0;
        int k;
        for(k = 0; theList[k] != null; k++) {
            temp = theList[k];
            temp.insertionSort();
            x++;
        }

        System.out.printf("\nLinked lists sorted. Now sorting array of linked lists.");
        LinkedList.quickSort(theList, 0, x - 1);
        System.out.printf("\n\nData has been sorted. Values will be written into outputfile: %s", outputFile);
        //Writting into the output file
        PrintWriter outputWrite = new PrintWriter(outputFile);
        for(int l = 0; theList[l] != null; l++) {
            if(l == 0) {
                temp = theList[l];
                outputWrite.printf("%s", temp.searchGet());
            } else {
                temp = theList[l];
                outputWrite.printf("\n%s", temp.searchGet());
            }
        }

        outputWrite.close();
        long totalTimeTaken = System.nanoTime() - startingTime;
        System.out.printf("\nThe time taken was: %dns.\n", totalTimeTaken);
    }

    public static int isAnagram(String str, String[] array) {
        for(int i = 0; array[i] != null; i++) {
            if(str.compareTo(array[i]) == 0) {
                return i;
            }
        }
        return -1;
    } 

    public static String str(String str1) {
        char[] sc = str1.toCharArray();
        Arrays.sort(sc);
        String str = String.valueOf(sc);
        return str;
    }

}
