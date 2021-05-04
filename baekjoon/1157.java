package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();
        br.close();

        for (int i = 0; i < word.length; i++) {
            arr[Character.toUpperCase(word[i]) - 'A']++;
        }

        int max = 0;
        char result = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
                result = (char)(i+'A');
            }else if(arr[i] == max){
                result = '?';
            }
        }
        System.out.println(result);
    }
}
