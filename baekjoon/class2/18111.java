import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> input = InputUtil.toIntegerList();
        int[][] arr = new int[input.get(0)][input.get(1)];

        for (int i = 0; i < input.get(0); i++) {
            List<Integer> input2 = InputUtil.toIntegerList();
            arr[i] = input2.stream().mapToInt(x -> x).toArray();
        }

        int max = Arrays.stream(arr).flatMapToInt(Arrays::stream).max().getAsInt();
        int min = Arrays.stream(arr).flatMapToInt(Arrays::stream).min().getAsInt();

        int minTime = Integer.MAX_VALUE;
        int minPoint = 0;


        for (int i = min; i <= max; i++) {
            int point = i;
            int time = 0;
            int block = input.get(2);
            for (int[] iArr : arr) {
                for (int x : iArr) {
                    if (x > point) {
                        // need 만큼 깎는다. (2초)
                        int need = x - point;
                        time += need * 2;

                        // 깎은 블록 수 만큼 인벤토리 증가
                        block += need;
                    } else if (x < point) {
                        int need = point - x;
                        // need 만큼 쌓는다. (1초)
                        time += need;
                        // 쌓은 블록 수 만큼 인벤토리 감소
                        block -= need;
                    }
                }
            }

            if (block < 0) {
                continue;
            }

            if (time <= minTime) {
                minTime = time;
                minPoint = point;
            }
        }

        System.out.printf("%d %d", minTime, minPoint);
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