//Used BF method but HashMap method works faster for optimization

import java.util.*;

class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    String eS = s.toLowerCase();
    String tE = t.toLowerCase();

    int[] countChar = new int[26];

    for (int i = 0; i < countChar.length; i++) {
      countChar[eS.length() - 'a']++;
      countChar[tE.length() - 'a']--;
    }

    for (int i = 0; i < countChar.length; i++) {
      if (countChar[i] != 0) {
        return false;
      }
    }
    return true;
  }
}
