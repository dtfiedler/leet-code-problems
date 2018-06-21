package LongestSubstring;

import java.util.HashMap;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0){
            return 0;
        }

        if (s.length() == 1){
            return 1;
        }
        int longestSubstring = traverseSubstring(s);
        return longestSubstring;
    }

    public int traverseSubstring(String s){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); i++){
            if(hashMap.containsKey(s.charAt(i))){
                j = Math.max(j,hashMap.get(s.charAt(i))+1);
            }
            hashMap.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
