// More Optimized Solution

import java.util.*;

class Solution_Opt {
  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    List<Integer> answer = new ArrayList<>();
    ArrayList<Integer>[] map = new ArrayList[26];

    for (int i = 0; i < 26; i++)
      map[i] = new ArrayList<>();

    for (String word : words) {
      int mask = 0;
      for (char ch : word.toCharArray()) {
        int bit = ch - 'a';
        mask = mask | (1 << bit);
      }

      int[] unique = new int[26];
      for (char ch : word.toCharArray()) {
        if (unique[ch - 'a'] != 0)
          continue;
        unique[ch - 'a'] = 1;
        map[ch - 'a'].add(mask);
      }
    }

    for (String puzzle : puzzles) {
      int mask = 0;
      int count = 0;
      for (char ch : puzzle.toCharArray()) {
        int bit = ch - 'a';
        mask = mask | (1 << bit);
      }

      char fc = puzzle.charAt(0);
      ArrayList<Integer> list = map[fc - 'a'];

      for (int msks : list) {
        if ((mask & msks) == msks)
          count++;
      }
      answer.add(count);
    }

    return answer;
  }
}
