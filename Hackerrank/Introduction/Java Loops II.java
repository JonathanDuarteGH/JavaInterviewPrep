// Java Loops II

import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int q=in.nextInt();
        for(int i=0;i<q;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int sum = 0;            
            for(int j=1;j<=n;j++){
                sum = 0;
                for(int k=1;k<=j;k++){
                    sum += (int)Math.pow(2,k-1)*b;
                }
                sum +=a;
                System.out.print(sum + " ");
            }   
            System.out.print("\n");            
        }
        in.close();
    }
}