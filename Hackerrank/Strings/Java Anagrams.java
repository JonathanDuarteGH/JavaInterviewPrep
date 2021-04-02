// Java Anagrams


import java.util.Scanner;

class Solution {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        a = a.toLowerCase();
        b = b.toLowerCase();

        int countChar[] = new int[26];

        for (int i = 0; i < a.length(); i++) {
            countChar[a.charAt(i) - 'a']++;
            countChar[b.charAt(i) - 'a']--;
        }

        for (int i = 0; i < countChar.length; i++) {
            if (countChar[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}