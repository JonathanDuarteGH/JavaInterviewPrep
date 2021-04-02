// Java Substring


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    
    public static String mySubString(String myS, int myStart, int myEnd){
        String newString = myS.substring(myStart, myEnd);
        return newString;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        in.close();
        
        System.out.println(mySubString(S, start, end));
    }
}