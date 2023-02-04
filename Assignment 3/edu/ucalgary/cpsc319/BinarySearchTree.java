//@author Saina Ghasemian-Roudsari
//UCID:30113011
package edu.ucalgary.cpsc319;

import java.io.*;
import java.util.*;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }
    public Node getRoot() {
        return this.root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
}