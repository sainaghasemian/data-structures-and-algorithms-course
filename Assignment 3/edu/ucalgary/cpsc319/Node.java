//@author Saina Ghasemian-Roudsari
//UCID:30113011
package edu.ucalgary.cpsc319;

import java.io.*;
import java.util.*;

public class Node {
    private StudentRecords studentRecords;
    private Node rightChildNode, leftChildNode;
    private Node passingValue;

    public Node(StudentRecords studentRecords, Node rightChildNode, Node leftChildNode, Node passingValue) {
        this.studentRecords = studentRecords;
        this.rightChildNode = rightChildNode;
        this.leftChildNode = leftChildNode;
        this.passingValue = passingValue;
    }
    public void setUpRecords(StudentRecords studentRecords) {
        this.studentRecords = studentRecords;
    }
    public StudentRecords getStudentRecords() {
        return this.studentRecords;
    }
    public Node getLeftChild() {
        return leftChildNode;
    }
    public Node getRightChild() {
        return rightChildNode;
    }
    public void leftChild(Node leftChildNode) {
        this.leftChildNode = leftChildNode;
    }
    public void rightChild(Node rightChildNode) {
        this.rightChildNode = rightChildNode;
    }
    public void setNextPassingValue(Node passingValue) {
        this.passingValue = passingValue;
    }
    public Node getNextPassingValue() {
        return this.passingValue;
    }

}