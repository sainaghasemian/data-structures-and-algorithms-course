//@author Saina Ghasemian-Roudsari
//UCID:30113011
package edu.ucalgary.cpsc319;

import java.io.*;
import java.util.*;

class Queue {
    private Node front;
    private Node back;

    public Queue() {
        this.front = front;
        this.back = back; 
    }

    public void enqueue(Node node) { 
        Node valueOf = new Node(node.getStudentRecords(), node.getRightChild(), node.getLeftChild(), null);
        if(this.back == null) {
            this.front = this.back = valueOf;
            return;
        }
        this.back.setNextPassingValue(valueOf);
        this.back = valueOf;
    }

    public Node dequeue() {
        if (this.front == null) {
            return null;
        }
        Node valueOf = this.front;
        this.front = this.front.getNextPassingValue();

        if(this.front == null) {
            this.back = null;
        }
        return valueOf;
    }

    public boolean isEmpty() {
        if(this.front == null) {
            return true;
        }
        else return false;
    }

}