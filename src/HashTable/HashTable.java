package HashTable;

import javax.print.DocFlavor;
import java.util.Arrays;

public class HashTable {

    String[] elements;
    static String searchValue = "1";

    public static void main(String[] args){
        HashTable myHash = new HashTable(30);
        String[] values = {"1", "5", "9", "14", "9"};
        myHash.mySimpleHashFunction(values, myHash.elements);
        displayStack(myHash.elements);
        System.out.println((myHash.contains(searchValue)) ? "Value of "+ searchValue +" is at " + myHash.get(searchValue): "Value of " + searchValue + " is not in hashtable.");
    }

    //put values in same index that matches it's value
    public void mySimpleHashFunction(String[] values, String[] array){
        for (int i = 0; i < values.length; i++){                            //for every value in values array
            String newElement = values[i];                                  //get value from values
            int index = Integer.parseInt(newElement) * 43  % array.length;       //get index based on value (wrap around size)

            // implement with chaining via linear probing (incrementing until it finds the best spot for it
            while(array[index] != "-1"){
                index = ++index % array.length;
            }

            array[index] = newElement;
        }
    }

    //get the index of a value
    public String get(String value){
        int index = Integer.parseInt(value) * 43 % elements.length;
        return String.valueOf(index);
    }

    //confirm if value exists at index
    public boolean contains(String value){
        int index = Integer.parseInt(value) * 43 % elements.length;
        if (elements[index] != "-1"){
            return true;
        }
        return false;
    }

    //constructor for hashtable with size
    HashTable(int size){
        elements = new String[size];
        Arrays.fill(elements, "-1");            //fill with -1 to start
    }

    //print out current array
    private static void displayStack(String[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println("Index: " + i + "\tValue: " + array[i]);
        }
    }
}

