import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'numKeypadSolutions' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY wordlist
     *  2. STRING_ARRAY keypads
     */

    public static List<Integer> numKeypadSolutions(List<String> wordlist, List<String> keypads) {
    // Write your code here
    
    List<Integer> answer = new ArrayList<>();
    ArrayList<Integer>[] map = new ArrayList[26];
    
    for(int i = 0; i < 26; i++)
        map[i] = new ArrayList<>();
    
    for (String wrdlst : wordlist){
        int typeWriter = 0;
        for(char ch : wrdlst.toCharArray()){
            int bit = ch - 'A';
            typeWriter = typeWriter | (1 << bit);
        }
        
        int[] unique = new int[26];
        for(char ch : wrdlst.toCharArray()){
            if(unique[ch - 'A'] != 0){
                continue;
            }
            unique[ch - 'A'] = 1;
            map[ch - 'A'].add(typeWriter);
        }
    }
    
    for(String kypds : keypads){
        int typeWriter = 0;
        int count = 0;
        for(char ch : kypds.toCharArray()){
            int bit = ch - 'A';
            typeWriter = typeWriter | (1 << bit);
        }
        
        char fc = kypds.charAt(0);
        ArrayList<Integer> list = map[fc - 'A'];
        
        for(int tpWtr : list){
            if((typeWriter & tpWtr) == tpWtr){
                count++;
            }
            
        }
        answer.add(count); 
    }
    return answer;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int wordlistCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> wordlist = IntStream.range(0, wordlistCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int keypadsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> keypads = IntStream.range(0, keypadsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.numKeypadSolutions(wordlist, keypads);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}