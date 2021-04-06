//Optimized and preferred since I still don;t know how linked list work

import java.ulti.*;

class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode currentNode = head;
    ListNode nullPreviousNode = null;

    if (currentNode == null) {
      return null;
    }

    while (currentNode != null) {
      ListNode currentNextNode = currentNode.next;
      currentNode.next = nullPreviousNode;
      nullPreviousNode = currentNode;
      currentNode = currentNextNode;
    }
    return nullPreviousNode;
  }
}
