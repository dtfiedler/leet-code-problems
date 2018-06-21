package MultiplyString;

import java.util.HashMap;
import java.util.Map;

class MultiplyString {
    private static Map<Character, Integer> numberMap = new HashMap<>();

    public static void main (String[] args){
        String num1 = "123";
        String num2 = "456";
        String sum = multiply(num1, num2);
    }

    public static String multiply(String num1, String num2) {
        createHashMap();
        double int1 = getIntFromString(num1);
        double int2 = getIntFromString(num2);
        double sum = int1 * int2;                        //note: floats can causes rounding errors, especially with large numbers
        String output = String.format("%.0f", sum);   //convert to string with not decimals
        return output;
    }


    public static double getIntFromString(String number){
        double sum = 0;
        int index = 0;
        for (int i = number.length() - 1; i >= 0; i--){
            sum += (numberMap.get(number.charAt(i)) * Math.pow(10, index));
            index++;
        }
        return sum;
    }

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