import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length=Integer.parseInt(br.readLine());
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for (int i = 0; i < length; i++) {
            String[] str = br.readLine().split("");
            for (String string : str) {
                if(string.equals("<")){
                    if(!left.empty()) right.push(left.pop());
                } else if (string.equals(">")) {
                    if(!right.empty()) left.push(right.pop());
                } else if (string.equals("-")) {
                    if (!left.empty()) left.pop();
                } else {
                    left.push(string);
                }
            }
            // 출력
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
            while (!right.isEmpty()) {
                bw.write(right.pop());
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        
    }
}
