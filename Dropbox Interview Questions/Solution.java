boolean dfs(String str, int start1, char[] pattern, int start2, Map<Character, String> map, Set<String> visited) {
    if (start1 == str.length() || start2 == pattern.length) {
		return start1 == str.length() && start2 == pattern.length;
    }
	char ch = pattern[start2++];
    if (map.containsKey(ch)) {
    Find the corresponding word if in the map (str can get this word from start1)
        return dfs(str, start1 + the length of the next word, pattern, start2, map, visited);
                } 
				else {
                for (int end = start1 + 1; end <= str.length(); ++end) {
					let nextWord be the substring between start1 and end,
                    if(nextWord is visited) 
						continue;
					map.put(ch, nextWord);
					visited.add(nextWord);
					if (haveWordPattern(str, end, pattern, start2, map, visited)) {
                    return true;
                }
                map.remove(ch);
                visited.remove(nextWord);
				}
				return false;
        }