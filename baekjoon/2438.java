import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = InputUtil.readInteger();
        for(int i=0;i<n;i++){
            for(int j=n-i;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static class InputUtil{
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
        static List<Integer> toIntegerList(StringTokenizer st){
            List<Integer> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(Integer.parseInt(st.nextToken()));
            }
            return list;
        }
        static List<String> toStringList(StringTokenizer st){
            List<String> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(st.nextToken());
            }
            return list;
        }
    }
}