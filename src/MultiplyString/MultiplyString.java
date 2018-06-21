package MultiplyString;

import java.util.HashMap;
import java.util.Map;

class MultiplyString {

    //Used to store mapping between integer equivalent of a number expressed as a char/string
    private static Map<Character, Integer> numberMap = new HashMap<>();

    //example
    public static void main (String[] args){
        String num1 = "123";
        System.out.println("num1 = " + num1);
        String num2 = "456";
        System.out.println("num2 = " + num2);
        String sum = multiply(num1, num2);
        System.out.println("Output = " + sum);
    }

    public static String multiply(String num1, String num2) {
        createHashMap();
        double int1 = getIntFromString(num1);
        double int2 = getIntFromString(num2);
        double sum = int1 * int2;                       //note: floats can causes rounding errors, especially with large numbers
        String output = String.format("%.0f", sum);     //convert to string with not decimals
        return output;
    }


    //iterate through string (starting at end, to get double value represented as real number
    public static double getIntFromString(String number){
        double sum = 0;
        int index = 0;
        for (int i = number.length() - 1; i >= 0; i--){
            //get number at index that matches that char, then multiply by 10^(index) to get it's value and add total
            sum += (numberMap.get(number.charAt(i)) * Math.pow(10, index));
            index++;    //increment index as we go
        }
        return sum;     //return integer value
    }

    //helper function to create hashmap
    private static void createHashMap(){
        numberMap.put('0', 0);
        numberMap.put('1', 1);
        numberMap.put('2', 2);
        numberMap.put('3', 3);
        numberMap.put('4', 4);
        numberMap.put('5', 5);
        numberMap.put('6', 6);
        numberMap.put('7', 7);
        numberMap.put('8', 8);
        numberMap.put('9', 9);
    }
}