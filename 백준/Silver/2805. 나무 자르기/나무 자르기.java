import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            /* 입력 받은 나무가 max 보다 클 경우 max 값을 해당 나무의 높이로 갱신 */
            if (max < tree[i]) {
                max = tree[i];
            }
        }


        while(min < max) {

            int mid = (min + max) / 2;
            long cnt = 0;

            for (int H: tree) {
                if (H - mid > 0) {
                    cnt += (H - mid);
                }
            }

            if (cnt < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min-1);
    }
}