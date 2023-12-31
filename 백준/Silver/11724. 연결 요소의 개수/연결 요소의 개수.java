import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main  {

    public static boolean visited[];
    public static ArrayList<Integer> graph[];
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph[S].add(E);
            graph[E].add(S);
        }

        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                cnt++;
                DFS(i);
            }
        }

        System.out.println(cnt);
    }

    public static void DFS(int v) {
        visited[v] = true;
        for (int i : graph[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}