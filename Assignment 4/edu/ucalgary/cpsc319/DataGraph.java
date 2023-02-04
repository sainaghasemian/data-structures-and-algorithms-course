//@author Saina Ghasemian-Roudsari
//UCID:30113011

package edu.ucalgary.cpsc319;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class DataGraph {
    boolean determinedValueOf;
    int[][] createGraph;
    int[] graphValue;
    
    //Some code below used stack and queue notes and tutorials from D2L as a refrence
    public class Stack {
        //Push and Pop done in Stack
        private int maximum;
        private int top;
        private int[] stack;

        public Stack(int x) {
            this.maximum = x;
            this.stack = new int[x];
            this.top = -1;
        }   
        public void push(int push) {
            stack[++top] = push;
        }  
        public int pop() {
            if(isEmpty()) {
                return -1;
            } //else returns stack[top--]
            return stack[top--];
        } 
        public int peek() {
            if(isEmpty()) {
                return -1;
            }
            return stack[top];
        }  

        public boolean isEmpty() {
            return (top == -1);
        }   
        public boolean isFull() {
            return (top == maximum - 1);
        }   
        public void emptyStack() {
            if(!isEmpty()) {
                for(int i = top; top >= 0; top--) {
                    stack[top] = 0;
                }
            }
        }   

        public String printStack() {
            String determinedValue = "";
            if(top == -1) {
                return "Stack is empty.";
            }
            for(int tempValueUsed = 0; tempValueUsed <= top; tempValueUsed++) {
                if(tempValueUsed == top) {
                    determinedValue += String.format("%d", stack[tempValueUsed]);
                }
                else {
                    determinedValue += String.format("%d, ", stack[tempValueUsed]);
                }
            }
            return determinedValue;
        }   
    }  

    public class Queue {
        int front;
        int back;
        int node; 
        int valueOf;
        int[] queue;
        
        public Queue(int n) {
            queue = new int[n];
            node = n;
            front = 0;
            back = -1;
            valueOf = 0;
        }   
        public int dequeue() {
            if(isEmpty()) {
                System.out.println("\nQueue is empty.");
            }
            else {
                int temp = queue[front];
                front = (front + 1) % node;
                valueOf--;
                return temp;
            }
            return -1;
        }   
        public void enqueue(int nodeValue) {
            if(isFull()) {
            }
            else {
                back = (back + 1) % node;
                queue[back] = nodeValue;
                valueOf++;
            }
        }   
        public int peek() {
            if(isEmpty()) {
                System.out.printf("\nQueue is now empty.");
                return 0;
            }
            return queue[front];
        }
        public int size() {
            return valueOf;
        }   

        public boolean isFull() {
            return (size() == node);
        }   

        public boolean isEmpty() {
            return (size() == 0);
        }  

        public void emptyQueue(int newV) {
            for(int i = 0; i < queue.length; i++) {
                queue[i] = 0;
            }
            queue = new int[newV];
            node = newV;
            front = 0;
            back = -1;
            valueOf = 0;
        }   
    }   

    //Stack and Queue
    Stack stack;
    Queue queue;

    public DataGraph(int nodeValue) {
        determinedValueOf = false;
        createGraph = new int[nodeValue][nodeValue];
        graphValue = new int[nodeValue];
        stack = new Stack(nodeValue);
        queue = new Queue(nodeValue);
    }   
    
    public void createGraph(int rowOfGraph, String values) {
        Scanner readData = new Scanner(values);
        int getVertexValue = -1;
        int adjacent;

        while(readData.hasNextInt()) {
            getVertexValue++;
            adjacent = readData.nextInt();
            createGraph[rowOfGraph][getVertexValue] = adjacent;
        }
        readData.close();
    }  

    public String createFormat(int rowOfGraph) {
        String formatofGraph = String.format("%d ->", rowOfGraph);
        int i = 0;
        while(i < createGraph[rowOfGraph].length) {
            if(createGraph[rowOfGraph][i] == 1) {
                formatofGraph += String.format(" %d", i);
            }
            i++;
        }
        if(formatofGraph.equals(String.format("%d ->", rowOfGraph))) {
        }
        return formatofGraph;
    }   
    
    public void query(int cvalue, String query, File output1, File output2File) throws IOException{
        Scanner readQuery = new Scanner(query);
        int beginRead = readQuery.nextInt();
        int last = readQuery.nextInt();
        String depthFirstSearch = "";
        String breadthFirstSearch = "";

        readQuery.close();
        PrintWriter output1Writer;
        PrintWriter output2Writer;

        if(cvalue == 0) {
            output1Writer = new PrintWriter(new FileWriter(output1, false));
        }
        else {
            output1Writer = new PrintWriter(new FileWriter(output1, true));
        }

        depthFirst(beginRead, last);
        if(stack.peek() != last) {
            output1Writer.printf("\n\nDepth-first results for: %d -> %d\n%d, -1, %d", beginRead, last, beginRead, last);
        }
        else {
            depthFirstSearch = stack.printStack();
            output1Writer.printf("\n\nDepth-first results for: %d -> %d\n%s", beginRead, last, depthFirstSearch);
        }

        output1Writer.close();
        
        if(cvalue == 0) {
            output2Writer = new PrintWriter(new FileWriter(output2File, false));
        }
        else {
            output2Writer = new PrintWriter(new FileWriter(output2File, true));
        }

        breadthFirst(beginRead, last);
        if(stack.peek() != last) {
            output2Writer.printf("\n\nBreadth first results for: %d -> %d\n%d, -1, %d", beginRead, last, beginRead, last);
        }
        else {
            breadthFirstSearch = stack.printStack();
            output2Writer.printf("\n\nBreadth first results for: %d -> %d\n%s", beginRead, last, breadthFirstSearch);
        }

        output2Writer.close();
    }   

    public void depthFirst(int beginRead, int last) {
        determinedValueOf = false;

        for(int i = 0; i < graphValue.length; i++) {   
            graphValue[i] = 0;
        }

        stack.emptyStack();
        stack.push(beginRead);
        graphValue[beginRead] = 1;
        for(int i = 0; i < createGraph[beginRead].length; i++) {  
            if(determinedValueOf == true) {
                break;
            }
            if(createGraph[beginRead][i] == 1 && graphValue[i] == 0) {   
                stack.push(i);
                if(i == last) {
                    determinedValueOf = true;
                    break;
                }
                DFS(i, last);
            }   
        }   
    }   
    //A refrence for this was tutorial section 3 notes from week 9
    public void DFS(int vertex, int last) {
        graphValue[vertex]++;

        for(int i = 0; i < createGraph[vertex].length; i++) { 
            if(determinedValueOf == true) {
                break;
            }
            if(createGraph[vertex][i] == 1 && graphValue[i] == 0) {   
                stack.push(i);
                if(i == last) {  
                    determinedValueOf = true;
                    break;
                }   
                DFS(i, last);    
            }   
            if(i == createGraph[vertex].length -1) {  
                stack.pop();
            }
        }   
    }      

    public void breadthFirst(int beginRead, int last) {
        determinedValueOf = false;
        for(int j = 0; j < graphValue.length; j++) {
            graphValue[j] = 0;
        }
        stack.emptyStack();
        queue.emptyQueue(graphValue.length);

        for(int k = beginRead; k < graphValue.length; k++) {
            if(determinedValueOf == true) {
                break;
            }
            if(k == beginRead) {
                graphValue[k]++;
                queue.enqueue(k);
            }
            while(!queue.isEmpty()) {
                int vertex = queue.dequeue();
                stack.push(vertex);
                if(vertex == last) {
                    determinedValueOf = true;
                    break;
                }
                for(int l = 0; l < createGraph[vertex].length; l++) {
                    if(createGraph[vertex][l] == 1 && graphValue[l] == 0) {
                        graphValue[l]++;
                        queue.enqueue(l);
                    }
                }
            }
        }
    }   
}
