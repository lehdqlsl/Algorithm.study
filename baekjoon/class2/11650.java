import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int N = InputUtil.readInteger();
        TreeSet<Node> set = new TreeSet<Node>(new The_Comparator());

        for (int i = 0; i < N; i++) {
            List<Integer> list = InputUtil.toIntegerList();
            set.add(new Node(list.get(0), list.get(1)));

        }

        for (Node node : set) {
            System.out.println(node.x + " " + node.y);
        }
    }

    static class Node {
        int x;
        int y;

        public Node(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }

    static class The_Comparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.x == o2.x) {
                if (o1.y < o2.y) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (o1.x < o2.x) {
                return -1;
            } else {
                return 1;
            }
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