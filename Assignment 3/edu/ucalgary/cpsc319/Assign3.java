//@author Saina Ghasemian-Roudsari
//UCID:30113011
//@version 1.5
//@since 1.0
package edu.ucalgary.cpsc319;

import static java.lang.System.exit;
import java.io.*;
import java.util.*;

public class Assign3 {

    public static void main(String args[]) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Three command line arguments are needed.");
        }
        BinarySearchTree tree = new BinarySearchTree();
        readInputFile(args[0], tree);
        outputFile(args[1], args[2], tree);
    }

    public static void readInputFile(String inputFileName, BinarySearchTree tree) {
        Scanner fileReader = null; 
        try {
            fileReader = new Scanner(new File(inputFileName));
        }
        catch (FileNotFoundException e) {
            System.out.println (e.getMessage());
        }
        while(fileReader.hasNextLine()) {
            String value = fileReader.nextLine();
            String operationValue = value.substring(0,1);
            StudentRecords studentRecords = new StudentRecords();
            studentRecords.setUpRecords(value.substring(1,42));
            studentRecords.setStudentLastName(value.substring(8,33));

            if(operationValue.equals("I")) {
                insert(studentRecords, tree.getRoot(), tree);
            }
            else if(operationValue.equals("D")) {
                delete(studentRecords, tree.getRoot());
            }
            else {
                throw new IllegalArgumentException();
            }

        }
        fileReader.close();

    }

    public static Node insert(StudentRecords value, Node determinedNode, BinarySearchTree tree) {
        String lastName = value.findStudentLast().toLowerCase();
        
        if (tree.getRoot() == null) {
            Node nodeValue = new Node(value, null, null, null);
            tree.setRoot(nodeValue);
            return determinedNode;
        }
        if(determinedNode == null) {
            Node nodeValue = new Node(value, null, null, null);
            determinedNode = nodeValue;
            return determinedNode;
        }
        else if(determinedNode.getStudentRecords().findStudentLast().toLowerCase().compareTo(lastName) <= 0) {
            determinedNode.leftChild(insert(value, determinedNode.getLeftChild(), tree));

        }
        else {
            determinedNode.rightChild(insert(value, determinedNode.getRightChild(), tree));

        }
        return determinedNode;
    }

    public static void delete(StudentRecords value, Node determinedNode) {
		determinedNode = deleteElementInBST(value, determinedNode);
	}
    
    //Some code below used BinarySearchTree1.java from D2L as a refrence
    public static Node deleteElementInBST(StudentRecords value, Node determinedNode) {
        String lastName = value.findStudentLast().toLowerCase();

		if(determinedNode == null) {
			return null;
		}
        else if(determinedNode.getStudentRecords().findStudentLast().toLowerCase().compareTo(lastName) < 0) {
            determinedNode.leftChild(deleteElementInBST(value, determinedNode.getLeftChild()));
			return determinedNode;
		}
        else if(determinedNode.getStudentRecords().findStudentLast().toLowerCase().compareTo(lastName) > 0) {
			determinedNode.rightChild(deleteElementInBST(value, determinedNode.getRightChild()));
			return determinedNode;
		}
        else {
			// Case 1: There are no children in the tree
			if(determinedNode.getLeftChild() == null && determinedNode.getRightChild() == null) {
				return null;
			}
			
			// Case 2: If the tree has only one child node
			if(determinedNode.getRightChild() == null) {
				return determinedNode.getLeftChild();
			}
			if(determinedNode.getLeftChild() == null) {
				return determinedNode.getRightChild();
			}
			
			// Case 3: If the parent node has two child
            StudentRecords lowestValue = findLowestValue(determinedNode.getRightChild());
			determinedNode.setUpRecords(lowestValue);
            determinedNode.rightChild(deleteElementInBST(lowestValue,determinedNode.getRightChild()));
			return determinedNode;
		}
	
	}

    public static StudentRecords findLowestValue(Node determinedNode) {
        if(determinedNode.getLeftChild() == null) {
            return determinedNode.getStudentRecords();
        }
        else {
            return findLowestValue(determinedNode.getLeftChild());
        }
    }

    public static void outputFile(String outputFile1, String outputFile2, BinarySearchTree tree) {
        PrintWriter output1 = null;
        PrintWriter output2 = null;

        try {
            output1 = new PrintWriter(outputFile1);
            output2 = new PrintWriter(outputFile2);
        }
        catch(FileNotFoundException e) {
            System.out.println (e.getMessage());
        }

        depthFirst(tree.getRoot(), output1);
        output1.close();
        breadthFirst(tree.getRoot(), output2);
        output2.close();
    }

    public static void depthFirst(Node determinedNode, PrintWriter output) {
        if(determinedNode == null) {
            return;
        }

        depthFirst(determinedNode.getRightChild(), output);
        output.println(determinedNode.getStudentRecords().getRecord());
        depthFirst(determinedNode.getLeftChild(), output); 
    }

    public static void breadthFirst(Node determinedNode, PrintWriter output) {
        Queue queue = new Queue();

        if(determinedNode == null) {
            return;
        }
        if(determinedNode != null) {
            queue.enqueue(determinedNode);
            while(!queue.isEmpty()) {
                determinedNode = queue.dequeue();
                output.println(determinedNode.getStudentRecords().getRecord());
                
                
                if(determinedNode.getRightChild() != null) {
                    queue.enqueue(determinedNode.getRightChild());
                }  
                if(determinedNode.getLeftChild() != null) {
                    queue.enqueue(determinedNode.getLeftChild());
                } 
            }
        }
    }
}