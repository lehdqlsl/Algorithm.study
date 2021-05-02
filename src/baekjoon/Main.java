package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        나머지_10430번(StringToIntArray(scanner.nextLine()));
    }

    public static int[] StringToIntArray(String input){
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void 나머지_10430번(int[] arr) {
        int A = arr[0];
        int B = arr[1];
        int C = arr[2];
        System.out.println((A + B) % C);
        System.out.println(((A % C) + (B % C)) % C);
        System.out.println((A * B) % C);
        System.out.println(((A % C) * (B % C)) % C);
    }

}
