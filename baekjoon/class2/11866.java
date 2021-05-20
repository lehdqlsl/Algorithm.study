import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> input = InputUtil.toIntegerList();
        List<Integer> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        int n = input.get(0);
        int k = input.get(1);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int count = 0;
        int index = 0;
        while (list.size() != 0) {
            ++count;
            if (count == k) {
                answer.add(list.get(index));
                list.remove(index);
                count = 0;
            } else {
                index++;
            }
            if (list.size() == index) {
                index = 0;
            }
        }

        System.out.println(answer.toString().replaceAll("\\[", "<").replaceAll("]", ">"));

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