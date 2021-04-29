// Optimized Final Solution - EASY char to array is an easy method to memorize

import java.util.*;

class Solution {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<Character>();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(')');
      } else if (c == '{') {
        stack.push('}');
      } else if (c == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }
    return stack.isEmpty();
  }
}
