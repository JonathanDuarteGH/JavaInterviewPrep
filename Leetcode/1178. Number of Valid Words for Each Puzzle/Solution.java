// Final Optimized

import java.util.*;

class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int[] sets = new int[words.length];
        int i = 0;
        final int max = 7;
        for (String word : words) {
            int set = getSet(word.toCharArray());
            if (Integer.bitCount(set) <= max) {
                sets[i++] = set;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (String puzzle : puzzles) {
            res.add(validWords(puzzle.toCharArray(), sets));
        }
        return res;
    }

    private int getSet(char[] s) {
        int set = 0;
        for (char c : s) {
            set |= 1 << (c - 'a');
        }
        return set;
    }

    private int validWords(char[] puzzle, int[] sets) {
        int res = 0;
        int puzzleSet = getSet(puzzle);
        int firstChar = 1 << (puzzle[0] - 'a');
        for (int set : sets) {
            if ((set & firstChar) == 0) {
                continue;
            }

            res += (puzzleSet == (puzzleSet | set)) ? 1 : 0;
        }
        return res;
    }
}