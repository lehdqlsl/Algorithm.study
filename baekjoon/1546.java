import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        double sum = 0;
        double max = 0;
        while(st.hasMoreTokens()){
            int score = Integer.parseInt(st.nextToken());
            if(score > max){
                max = score;
            }
            list.add(score);
        }

        for(int i : list){
            double nScore = i/max*100;
            sum = sum + nScore;
        }

        double result = sum / N;
        System.out.println(result);
    }
}
