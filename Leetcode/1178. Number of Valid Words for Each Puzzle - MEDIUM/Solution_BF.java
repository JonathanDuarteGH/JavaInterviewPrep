// My Solution

import java.util.*;

class Solution_BF {
  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    HashMap<Character, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < 26; i++) {
      map.put((char) ('a' + i), new ArrayList<>());
    }

    for (String word : words) {
      int mask = 0;
      for (char c : word.toCharArray()) {
        int bit = c - 'a';
        mask = mask | (1 << bit);
      }

      HashSet<Character> unique = new HashSet<>();
      for (char c : word.toCharArray()) {
        if (!unique.contains(c)) {
          List<Integer> list = map.get(c);
          list.add(mask);
          unique.add(c);
        }

      }
    }

    List<Integer> ans = new ArrayList<>();
    for (String puzzle : puzzles) {
      char chAt0 = puzzle.charAt(0);
      int count = 0;
      List<Integer> wordsToCheck = map.get(chAt0);

      int pmask = 0;
      for (char c : puzzle.toCharArray()) {
        int bit = c - 'a';
        pmask = pmask | (1 << bit);
      }

      for (int wmask : wordsToCheck) {
        if ((wmask & pmask) == wmask) {
          count++;
        }
      }

      ans.add(count);
    }
    return ans;

  }
}
