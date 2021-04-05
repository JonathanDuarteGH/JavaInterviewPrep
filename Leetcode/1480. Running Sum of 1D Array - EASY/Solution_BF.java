// Brute Force - DNW DO NOT USE!!!

import java.util.*;

class Solution_BF {
  public int[] runningSum(int[] nums) {
    int[] sumArray;
    ArrayList<String> lumpSum = new ArrayList<String>();
    for (int i = 0; i <= nums.length(); i++) {
      if (sumArray[i] = nums[i]) {
        sumArray[i] = nums[i];
      } else {
        sumArray[i] = nums[i + 1] + nums[i];
        lumpSum.add(sumArray[i]);
      }
    }
    return lumpSum;
  }
}
