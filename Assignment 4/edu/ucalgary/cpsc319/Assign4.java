//@author Saina Ghasemian-Roudsari
//UCID:30113011

package edu.ucalgary.cpsc319;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Assign4 {
    public static void main(String[] args) throws IOException {
        if(args.length != 4) {
            System.out.printf("\nNumber of entries is not valid, please try again with 4 arguments.\n");
            System.exit(1);
        } 

        //Receives argument inputs
        String inputFileName = args[0] + ".txt";
        String queryString = args[1] + ".txt";
        String firstOutput = args[2] + ".txt";
        String secondOutput = args[3] + ".txt";
        File inputFile = new File(inputFileName);

        DataGraph graph = new DataGraph(31);
        String value;
        int temp = -1;

        if(inputFile.exists()) {
            if(inputFile.canRead()) {
                System.out.println("\nInput file is good to go, can be read! Graph will be created.");
            } else {
                System.exit(1);
            }
        } else {
            System.out.printf("\nInput file: '%s' does not exist.", inputFileName);
            System.exit(1);
        } 

        Scanner readInput = new Scanner(inputFile);

        while(readInput.hasNextLine()) {
            temp++;
            value = readInput.nextLine();
            graph.createGraph(temp, value);
        }   
        readInput.close();
        
        File queryFile = new File(queryString);

        if(queryFile.exists()) {
            if(queryFile.canRead()) {
                System.out.printf("\n\nQuery file can be read! Beginning searches.");
            } else {
                System.exit(1);
            }
        } else {
            System.out.println("\nFile does not exist.");
            System.exit(1);
        }   

        Scanner readQuery = new Scanner(queryFile);
        File output1 = new File(firstOutput);
        File output2File = new File(secondOutput);
        temp = -1;
        while(readQuery.hasNextLine()) {
            temp++;
            value = readQuery.nextLine();
            graph.query(temp, value, output1, output2File);
        }

        readQuery.close();

        System.out.printf("\n\nPaths have now been written into %s and %s", firstOutput, secondOutput);
    }   
}   