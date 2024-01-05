import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String cards[] = br.readLine().split(" ");

        int max = 0;
        int result = 0;

        for (int i = 0; i < cards.length; i++) {
            int level = Integer.parseInt(cards[i]);
            if (max < level) {
                max = level;
            }
            result += level;
        }
        result += max * (cards.length - 2);
        System.out.println(result);
    }
}