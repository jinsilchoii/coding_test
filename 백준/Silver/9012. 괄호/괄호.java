import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String input = br.readLine();
            String res = "YES";

            Stack st = new Stack();

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') {
                    st.push(1);
                } else if (input.charAt(j) == ')') {
                    if (st.isEmpty()) {
                        res = "NO";
                        break;
                    } else {
                        st.pop();
                    }
                }
            }

            if (!st.isEmpty()) {
                res = "NO";
            }
            System.out.println(res);
        }
    }
}