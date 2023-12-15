import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next());

        for (int i=0; i<n; i++) {
            String input = sc.next();
            String res = "YES";

            Stack st = new Stack();

            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') {
                    st.push(1);
                } else if (input.charAt(j) == ')') {
                    if(st.isEmpty()) {
                        res = "NO";
                        break;
                    } else {
                        st.pop();
                    }
                }
            }

            if(!st.isEmpty()) {
                res = "NO";
            }
            System.out.println(res);
        }
    }
}