import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = InputUtil.readInteger();

        // 배열과 Array 차이.. 왜 ...?
        // 배열 => Arrays.Sort
        // 리스트 => Collections.Sort
        // 메모리 얼마나 쓰는지, 속도는 얼마나 차이나는지 궁금하다.
        // 최대 천만 데이터 삽입.

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = InputUtil.readInteger();
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append("\n");
        }

        System.out.println(sb);
    }


    static class InputUtil {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        static int readInteger() throws IOException {
            return Integer.parseInt(br.readLine());
        }

        static long readLong() throws IOException {
            return Long.parseLong(br.readLine());
        }

        static String readString() throws IOException {
            return br.readLine();
        }

        static List<Integer> toIntegerList() throws IOException {
            return toIntegerList(new StringTokenizer(br.readLine()), null);
        }

        static List<Integer> toIntegerList(Custom custom) throws IOException {
            return toIntegerList(new StringTokenizer(br.readLine()), custom);
        }

        static List<String> toStringList() throws IOException {
            return toStringList(new StringTokenizer(br.readLine()));
        }

        static private StringTokenizer readStringTokenizer() throws IOException {
            return new StringTokenizer(br.readLine());
        }

        static private List<Integer> toIntegerList(StringTokenizer st, Custom custom) {
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