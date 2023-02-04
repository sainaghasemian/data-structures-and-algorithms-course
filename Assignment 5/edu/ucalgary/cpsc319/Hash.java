//@author Saina Ghasemian-Roudsari
//UCID:30113011
//@version 1.6
//@since 1.0

package edu.ucalgary.cpsc319;

public class Hash {
    //Refrences used for this code:
    //D2L Week 10 Tutorial Group 1 HashMap.java and https://www.geeksforgeeks.org/hashtable-in-java/
    //and https://www.javamex.com/tutorials/collections/hash_function_technical_2.shtml
    //Bonus is implemented using quadProbing

    //private attribute
    private String[] arrOfValues;

    int size;
    Boolean quadProbing = false;

    public Hash(int sizeValue, boolean quadValue) {
        arrOfValues = new String[size = sizeValue];
        this.quadProbing = quadValue;
    }

    //Hash function that minimizes the number of collisions

    private int hash(String h) {
        int hashValue = 3;
        for(char charSet : h.toCharArray()) {
            hashValue = Math.floorMod(hashValue*91 + hashValue*31 + hashValue*197 + charSet, size);
        }
        return Math.floorMod(h.hashCode(), size);
        
    }

    //Insert words into hash table
    public void insertIntoHash(String charName) {
        int hashDetermined = hash(charName);
        for(int x = 1; arrOfValues[hashDetermined] != null; x++) {
            if(quadProbing == true) {
                hashDetermined = (hash(charName) + (int)(Math.pow(-1, x - 1) * Math.pow((x + 1) / 2, 2))) % size;
            } else {
                hashDetermined = (hash(charName) + x) % size;
            }
        }
        arrOfValues[hashDetermined] = charName;
    }

    public int searchHashTable(String charValue) {
        int k = 0;
        int numOfReads;
        int hash = hash(charValue);
        for (int i = 1; arrOfValues[hash] != null && !arrOfValues[hash].equals(charValue); i++, k++) {
            if (quadProbing == true) { //linear probing
                hash = (hash(charValue) + (int)(Math.pow(-1, i - 1) * Math.pow((i + 1) / 2, 2))) % size;
            } else {
                hash = (hash(charValue) + i) % size;
            }
        }
        numOfReads = k+1;
        return numOfReads;
    }
    //Using each word as a search item search for the word in the Hash Table
    //Calculate the number of reads made as you search for the word
    
}
