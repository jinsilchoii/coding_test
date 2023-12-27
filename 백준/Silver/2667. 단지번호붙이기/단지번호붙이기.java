import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main  {

    final static int max = 25 + 10;
    static boolean[][] graph;
    static boolean[][] visited;
    static int cntPerDanji;
    static int dirX[] = {0, 0, 1, -1};
    static int dirY[] = {1, -1, 0, 0};

    static void dfs(int x, int y) {
        visited[x][y] = true;
        cntPerDanji++;

        for (int i = 0; i < 4; i++) {
            int newX = x + dirX[i];
            int newY = y + dirY[i];
            if (!visited[newX][newY] && graph[newX][newY]) {
                dfs(newX, newY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new boolean[max][max];
        visited = new boolean[max][max];

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N ; j++) {
                // 그래프 배열에서
                // 아파트가 존재한다 = true
                // 아파트가 존재하지 않는다  = false
                graph[i][j] = s.charAt(j - 1) == '1';
            }
        }
        // (1,1) 부터 (N,N)까지 돌면서 dfs
        // cntList = 각 단지가 몇개의 아파트로 구성되어 있는지에 대한 arrayList
        ArrayList<Integer> cntList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N ; j++) {
                if (graph[i][j] && !visited[i][j]) {
                    // cntPerDanji = 각 단지별로 몇개의 아파트가 존재하는지
                    cntPerDanji = 0;
                    dfs(i, j);
                    cntList.add(cntPerDanji);
                }
            }
        }
        // 출력
        // 단지의 갯수
        System.out.println(cntList.size());
        Collections.sort(cntList);
        for (int i = 0; i < cntList.size(); i++) {
            // 단지의 아파트 갯수
            System.out.println(cntList.get(i));
        }
        br.close();
    }
}