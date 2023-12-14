import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;


public class Main  {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i <= n; i++) {
            q.offer(i);
        }

        sb.append("<");
        for(int i=0; i < n-1; i++) {
            for (int j=0; j<k-1; j++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()+", ");
        }

        sb.append(q.poll()+">");
        System.out.println(sb);
    }
}