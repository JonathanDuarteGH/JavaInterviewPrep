// Brute Force

class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i<26; i++){
            map.put((char)('a' + i), new ArrayList<>());
        }

        for(String word: words){
            int mask = 0;
            for(char c: word.toCharArray()){
                int bit = c - 'a';
                mask = mask | (1 << bit);
            }

            HashSet<Character> unique = new HashSet<>();
            for(char c: word.toCharArray()){
                if(!unique.contains(c)){
                    List<Integer> list = map.get(c);
                    list.add(mask);
                    unique.add(c);
                }
                
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(String puzzle: puzzles){
            char chAt0 = puzzle.charAt(0);
            int count = 0;
            List<Integer> wordsToCheck = map.get(chAt0);

            int pmask = 0;
            for(char c: puzzle.toCharArray()){
                int bit = c - 'a';
                pmask = pmask | (1 << bit);
            }

            for(int wmask: wordsToCheck){
                if((wmask & pmask) == wmask){
                    count++;
                }
            }

            ans.add(count);
        }
        return ans;
        
    }
}

// More Optimized Solution

class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> answer = new ArrayList<>();
		ArrayList<Integer>[] map = new ArrayList[26];
    
		for(int i = 0; i < 26; i++)
			map[i] = new ArrayList<>();
         
		for(String word : words){
			int mask = 0;
			for(char ch : word.toCharArray()){
				int bit = ch - 'a';
				mask = mask | (1 << bit);
        }
        
			int[] unique = new int[26];
			for(char ch : word.toCharArray()){
				if(unique[ch - 'a'] != 0)
					continue;
				unique[ch - 'a'] = 1;     
				map[ch - 'a'].add(mask);      
				}
    }
    
    for(String puzzle : puzzles){
        int mask = 0;
        int count = 0;
        for(char ch : puzzle.toCharArray()){
            int bit = ch - 'a';
            mask = mask | (1 << bit);
        }
        
        char fc = puzzle.charAt(0);
        ArrayList<Integer> list = map[fc - 'a'];
        
        for(int msks : list){
            if((mask & msks) == msks)
            count++;
        }
        ans.add(count);
    }
    
    return ans;
    }
}

// Final Optimized

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
            if ((set & firstChar) == 0) { continue; }

            res += (puzzleSet == (puzzleSet | set)) ? 1 : 0;
        }
        return res;
    }
}