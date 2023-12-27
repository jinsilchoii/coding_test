import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main  {

    public static boolean visited_arr[];
    public static ArrayList<Integer> graph[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

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

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited_arr = new boolean[N+1];
        DFS(V);
        System.out.println();
        visited_arr = new boolean[N+1];
        BFS(V);
    }

    public static void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited_arr[v] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int i : graph[now]) {
                if (!visited_arr[i]) {
                    visited_arr[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void DFS(int v) {
        System.out.print(v + " ");
        visited_arr[v] = true;
        for (int i : graph[v]) {
            if (!visited_arr[i]) {
                DFS(i);
            }
        }
    }
}