// My Solution Attempt

import java.util.*;

class Solution_BF {
  public boolean isValid(String s) {
    if (s != s) {
      return false;
    }
    StringBuilder oneString = new StringBuilder();
    for (char c : s) {
      oneString.put(c);
    }
    String combo = oneString.toString();
    if (combo != rightOrder) {
      return false;
    } else {
      return true;
    }
  }
}
