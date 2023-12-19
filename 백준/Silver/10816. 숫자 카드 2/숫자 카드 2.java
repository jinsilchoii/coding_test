import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main  {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (hashMap.get(input) == null) {
                hashMap.put(input, 1);
            } else {
                hashMap.put(input, hashMap.get(input)+1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (hashMap.get(input) == null) {
                sb.append(0).append(" ");
            } else {
                sb.append(hashMap.get(input)).append(" ");
            }
        }
        System.out.println(sb);
    }
}