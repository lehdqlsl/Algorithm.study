import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = InputUtil.readInteger();
        TreeSet<Person> person = new TreeSet<>(new PersonCompare());
        for (int i = 0; i < n; i++) {
            List<String> input = InputUtil.toStringList();
            person.add(new Person(input.get(0), input.get(1), i));
        }

        Iterator<Person> iterator = person.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    static class PersonCompare implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            if (o1.age < o2.age) {
                return -1;
            } else if (o1.age > o2.age) {
                return 1;
            } else {
                if (o1.join < o2.join) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
    }

    static class Person {
        int age;
        String name;
        int join;

        public Person(String age, String name, int join) {
            this.age = Integer.parseInt(age);
            this.name = name;
            this.join = join;
        }

        @Override
        public String toString() {
            return age + " " + name;
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

        static private int[] toIntegerArray() throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[st.countTokens()];
            int index = 0;
            while (st.hasMoreTokens()) {
                int result = Integer.parseInt(st.nextToken());
                arr[index++] = result;
            }
            return arr;
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