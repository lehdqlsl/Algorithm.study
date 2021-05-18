import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = InputUtil.readInteger();

        for (int i = 0; i < n; i++) {
            List<Integer> input = InputUtil.toIntegerList();

            int floor = input.get(0);
            int rooms = input.get(1);
            int index = input.get(2);

            for (int r = 1; r <= rooms; r++) {
                for (int f = 1; f <= floor; f++) {
                    if (--index == 0) {
                        String room = String.valueOf(r);

                        if (r < 10) {
                            room = "0" + room;
                        }
                        System.out.println(f + room);
                        break;
                    }
                }
            }
        }

    }

    static class Node {
        public int min;
        public boolean isSet;
        public int value;

        public Node(int value) {
            this.value = value;
            this.isSet = false;
            this.min = Integer.MAX_VALUE;
        }
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