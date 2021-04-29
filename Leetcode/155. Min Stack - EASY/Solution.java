//Optimized and preferred since I don't know how to implement a stack in code. Its possible to learn from this.

import java.util.*;

class Solution {
  Stack<Integer> stack;
  Stack<Integer> minStack;

  public void MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  }

  public void push(int val) {
    if (minStack.isEmpty() || val <= minStack.peek()) {
      minStack.push(val);
    }
    stack.push(val);
  }

  public void pop() {
    int topStack = stack.peek();
    int topMinStack = minStack.peek();
    if (topStack == topMinStack) {
      minStack.pop();
    }
    stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
