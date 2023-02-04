//@author Saina Ghasemian-Roudsari
//UCID:30113011

package edu.ucalgary.cpsc319;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class LinkedList {
    //Linked List class refrence:
    //Week5_LinkList_T0205 from CPSC 319 D2L Shell
    Node head;
    Node dataValues;

    LinkedList() {
        head = new Node();
        head.next = null;
    }  

    void addFirst(String data) {
        Node n = new Node();
        n.data = data;
        n.next = head.next;
        head.next = n;
    }

    void addLast(String data) {
        Node n = new Node();
        Node current = head;

        while(current.next != null) {
            current = current.next;
        }

        n.data = data;
        n.next = current.next;
        current.next = n;
    }

    public void searchSet() {
        if(isEmpty()) {
            System.out.println("\nList is Empty!!!");
            return;
        } 
        else {
            System.out.println("\nThe list is: ");
            Node current = head;
            current = current.next;
            while(current != null) {
                if(current.next != null) {
                    System.out.print(current.data);
                } 
                else {
                    System.out.println(current.data);
                }
                current = current.next;
            }
        }
    }   

    public String searchGet() {
        String s = "";
        if(isEmpty()) {
            System.out.println("\nList is Empty!!!!");
            return "";
            } 
        else {
            Node current = head;
            current = current.next;
            while(current != null) {
                if(current.next != null) {
                    s += String.format("%s ", current.data);
                } else {
                    s += String.format("%s", current.data);
                }
                current = current.next;
            }
        }
        return s;
    }

    boolean isEmpty() {
        if (head.next == null) return true;
        else return false;
    }   

    //Insertion Sort and Quick Sort refrences:
    //Week5_LinkList_T0205 from CPSC 319 D2L Shell, https://www.geeksforgeeks.org/iterative-quick-sort/
    //https://stackabuse.com/quicksort-in-java/, and Assign1.java

    public void insertionSort() {
        Node current = head.next;
        Node sorted_head = new Node();
        while(current != null) {
            Node tempValue = sorted_head;
            while(tempValue.next != null && (tempValue.next.data.compareTo(current.data)) < 0) {
                tempValue = tempValue.next;
            }
            Node tmp = current.next;
            current.next = tempValue.next;
            tempValue.next = current;
            current = tmp;
        }
        head = sorted_head;
    } 

    public static int partition(LinkedList[] theList, int low, int high) {
        String pivot = theList[high].head.next.data;
        int i = (low - 1); // index of smaller element
        for (int j = low; j <= high - 1; j++) {
        // If current element is smaller than or equal to pivot
            if(theList[j].head.next.data.compareTo(pivot) <= 0) {
                i++;
                //swap theList i and j
                Node temp = theList[i].head.next;
                theList[i].head.next = theList[j].head.next;
                theList[j].head.next = temp;
            }
        }
        // swap theList[i+1] and theList[high]
        Node temp = theList[i + 1].head.next;
        theList[i + 1].head.next = theList[high].head.next;
        theList[high].head.next = temp;
        return i + 1;
    }

    public static void quickSort (LinkedList[] theList, int start, int end) {
        //starting index, and ending index
        int[] arr = new int[end - start + 1];
        int index = -1;
        arr[++index] = start;
        arr[++index] = end;

        while(index >= 0) {
            end = arr[index--];
            start = arr[index--];
            int pi = partition(theList, start, end); //pi is partitioning index

            if (pi - 1 > start) {
                arr[++index] = start;
                arr[++index] = pi - 1;
            }
            if (pi + 1 < end) {
                arr[++index] = pi + 1;
                arr[++index] = end;
            }
        }
    }
}