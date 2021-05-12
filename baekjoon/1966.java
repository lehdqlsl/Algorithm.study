import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = InputUtil.readInteger();

        for (int i = 0; i < n; i++) {
            List<Integer> list = InputUtil.toIntegerList();
            int loc = list.get(1);

            Queue<Node> queue = new LinkedList<>();
            int index = 0;
            List<Integer> tempList = InputUtil.toIntegerList();
            for (int num : tempList) {
                queue.offer(new Node(num, index++));
            }

            int high = queue.stream().mapToInt(a -> a.priority).max().getAsInt();
            int count = 0;
            while (queue.size() > 0) {
                Node get = queue.poll();
                if (get.priority != high) {
                    queue.offer(get);
                } else {
                    count++;
                    if (loc == get.index) {
                        System.out.println(count);
                        break;
                    }
                    if (queue.size() > 0) {
                        high = queue.stream().mapToInt(a -> a.priority).max().getAsInt();
                    }
                }
            }

        }
    }

    static class Node {
        public int priority;
        public int index;

        Node(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "priority=" + priority +
                    ", index=" + index +
                    '}';
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