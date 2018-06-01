Target Number
-------------

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
--------

```
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

Solution:
----------
There are a variety of solutions for this problem:

1. Nested for loops
    
    * Time complexity: O(n^2)
    * Nested for loops are never ideal
2. Two pass hashmaps

    * Time complexity: O(n)
    * Good, but somewhat complicated
3. One pass hashmaps (provided)

    * Time complexity: O(n)
    * Smallest implementation