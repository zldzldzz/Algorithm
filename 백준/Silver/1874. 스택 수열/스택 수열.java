import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        List<String> answer = new ArrayList<>();
        int now = 1;
        for (int i = 0; i < length; i++) {
            int k=Integer.parseInt(br.readLine());

            while (now <= k) {
                stack.push(now++);
                answer.add("+");
            }

            if (stack.peek() == k) {
                stack.pop();
                answer.add("-");
            } else {
                // 만들 수 없는 수열
                System.out.println("NO");
                return;
            }

        }

        for (String string : answer) {
            System.out.println(string);

        }

    }
}
