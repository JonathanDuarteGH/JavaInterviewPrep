import java.util.HashMap;

// Preferred and most optimal 

class Solution {
  public in firstUniqChar(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char charS = s.charAt(i);
      map.put(charS, map.getOrDefault(charS, 0) + 1);
    }

    for (int i = 0; i < s.length(); i++) {
      if (map.get(s.charAt(i)) == 1) {
        return i;
      }
    }

    return -1;
  }
}