import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int max=0;
    private static int maxIndex=1;
    public static void main(String[] args) throws IOException {
        for(int i=1;i<10;i++){
            int num = InputUtil.readInteger();
            if (num > max) {
                max = num;
                maxIndex = i;
            }
        }
        System.out.println(max);
        System.out.println(maxIndex);
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
    }

    interface Custom {
        int customMethod(int num);
    }
}
