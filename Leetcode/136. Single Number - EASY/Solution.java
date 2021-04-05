// Optimized and Preferred

import java.util.*;

class Solution {
  public int singleNumber(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], i);
      } else {
        int oldValue = map.get(nums[i]);
        map.put(nums[i], oldValue + 1);
      }
    }
    for (int k = 0; k < nums.length; k++) {
      if (map.get(nums[k]) == 1) {
        return nums[k];
      }
    }
    return 0;
  }
}
