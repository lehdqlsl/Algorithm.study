import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> input = InputUtil.toIntegerList();
        char[][] arr = new char[input.get(0)][input.get(1)];

        for (int i = 0; i < input.get(0); i++) {
            String str = InputUtil.readString();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int w = 0; w <= input.get(0) - 8; w++) {
            for (int h = 0; h <= input.get(1) - 8; h++) {
                char p = arr[w][h];
                int count = 0;

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {

                        if (i == 0 || i % 2 == 0) {
                            if (j == 0 || j % 2 == 0) {
                                if (arr[i + w][j + h] != p) {
                                    count++;
                                }
                            } else {
                                if (arr[i + w][j + h] == p) {
                                    count++;
                                }
                            }
                        } else {
                            if (j % 2 == 1) {
                                if (arr[i + w][j + h] != p) {
                                    count++;
                                }
                            } else {
                                if (arr[i + w][j + h] == p) {
                                    count++;
                                }
                            }
                        }

                    }

                }

                count = Math.min(count, 64 - count);
                if (count < min) {
                    min = count;
                }
            }
        }

        System.out.println(min);
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