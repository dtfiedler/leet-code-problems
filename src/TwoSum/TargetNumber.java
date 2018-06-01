import java.util.HashMap;
import java.util.Map;

public class TargetNumber {
    public int[] twoSum(int[] nums, int target) {

        //we actually want to use the numbers as the keys, and the indexes as the values
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //resulting array that we will return (only needs to two values)
        int[] result = new int[2];
        //iterate through, see if target - current index value is in hash map, if so, we have two values and return
        for (int i = 0; i < nums.length; i++) {
            //because the values are our keys, we check if it has already been added
            if (map.containsKey(target - nums[i])) {
                //we've found matching pair, get it's index and set
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String args[]){
        int[] nums = {2, 7, 10, 3, 5, 6};
        TargetNumber sol = new TargetNumber();
        int[] result = sol.twoSum(nums, 9);
        System.out.format("[%d, %d]", result[0], result[1]);
    }
}
