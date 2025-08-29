import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int count = 0;
		int length = Integer.parseInt(br.readLine());
		for (int i = 0; i < length; i++) {
			Stack<String> stack = new Stack<>();
			String[] s = br.readLine().split("");
			for (String string : s) {
				if(stack.isEmpty()){
					stack.push(string);
				} else if(string.equals(stack.peek())) {
					stack.pop();
				}else  {
					stack.push(string);
				}
			}
			if(stack.isEmpty()) {
				count++;
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
}