package AddTwoNumbers;

/*
 * Definition for singly-linked list;
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class TwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        //create a number that consists of numbers from list one and list two.
        //add those two numbers, then create a new linked list

        //create full numbers and add them
        //2, 4, 3. Starting at end, establish a new number. So length of number is list length
        // ((index) * 10) * num[index]
        // (10^index) * num[index]
        // 10^0 = 1 * 2 = 2
        // 10^1 = 10 * 4 = 40
        // 10^2 = 100 * 3 = 300
        // Sum = 342

        //now that we can createa full numbers, need to break it apart
        //convert to string?
        //divde by length?
        //get length of final number (e.g. 3)
        //number / 10 ^ (length - 1)
        // (number - number % 10^(length - 1)) / 10^(length - 1)
        // 807 - 7 / 100 = 8
        // 807 - 0 / 10^1 = 0
        // 807 - 0 / 1 = 7

        int total1 = getMultiplier(l1);
        int total2 = getMultiplier(l2);
        int sum = total1 + total2;
        ListNode output = createListFromNumber(sum);
        return output;
    }

    public int getMultiplier(ListNode list){
        int total = 0;
        ListNode current = list;
        int i = 0;
        while (current != null){
            int multiplier = (int)Math.pow(10, i);
            total += (multiplier * current.val);
            current = current.next;
            i++;
        }
        return total;
    }

    public ListNode createListFromNumber(int sum){
        String numString = "" + sum + "";
        int length = numString.length();
        ListNode list = null;
        for (int i = 0 ; i < length; i++){
            int multiplier = (int) Math.pow(10, length - 1 - i);
            int value = (sum - (sum % multiplier)) / multiplier;
            ListNode newNode = new ListNode(value);
            newNode.next = list;
            list = newNode;
            sum -= multiplier * value;
        }
        return list;
    }

    public static void  main (String[] args){
        ListNode num1 = new ListNode(3);
        num1.next = new ListNode(4);
        num1.next.next = new ListNode(5);
        ListNode num2 = new ListNode(6);
        num2.next = new ListNode(5);
        num2.next.next = new ListNode(4);
        TwoNumbers twoNumbers = new TwoNumbers();
        ListNode output = twoNumbers.addTwoNumbers(num1, num2);
        ListNode current = output;
        while(current != null){
            System.out.print(current.val);
            current = current.next;
        }
    }
}
