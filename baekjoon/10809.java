import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        String input = InputUtil.readString();
        int[] arr = new int [26];

        for(int i=0;i<arr.length;i++){
            arr[i] = -1;
        }

        for(int i=0;i<input.length();i++){
            char c = input.charAt(i);
            int index = (int)c-97;
            if(arr[index] == -1){
                arr[index] = i;
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    static class InputUtil {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        static int readInteger() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static String readString() throws IOException {
            return br.readLine();
        }

        static StringTokenizer readStringTokenizer() throws IOException {
            return new StringTokenizer(br.readLine());
        }

        static List<Integer> toIntegerList(StringTokenizer st, Custom custom) {
            List<Integer> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                int result = Integer.parseInt(st.nextToken());
                if (custom != null) {
                    result = custom.customMethod(result);
                }
                list.add(result);
            }
            return list;
        }

        static List<Integer> toIntegerList(StringTokenizer st) {
            return toIntegerList(st, null);
        }

        static List<String> toStringList(StringTokenizer st) {
            List<String> list = new ArrayList<>();
            while (st.hasMoreTokens()) {
                list.add(st.nextToken());
            }
            return list;
        }

        static int charToInteger(char c) {
            return Integer.parseInt(String.valueOf(c));
        }

    }

    interface Custom {
        int customMethod(int num);
    }
}