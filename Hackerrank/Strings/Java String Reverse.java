// Java String Reverse

import java.io.*;
import java.util.*;

class Solution {
    
    static boolean isPalindrome(String str){
        int i = 0, j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        
        if (isPalindrome(A)){
        System.out.println("Yes");            
        } else {
        System.out.println("No");            
        }       
    }
}