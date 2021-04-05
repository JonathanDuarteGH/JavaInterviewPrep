// Optimized and preferred

import java.util.*;

class Solution {
  public int[] runningSum(int[] nums) {
    int runningTotal = 0;
    int[] resultArray = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      runningTotal += nums[i];
      resultArray[i] = runningTotal;
    }
    return resultArray;
  }
}
