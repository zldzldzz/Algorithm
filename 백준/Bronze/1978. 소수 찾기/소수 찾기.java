import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int length = Integer.parseInt(br.readLine());
		int count =0;
		String[] line = br.readLine().split(" ");
		for (String s : line) {

			boolean flag = false;
			int n = Integer.parseInt(s);
			if(n==1||n==0){
				continue;
			}
			for (int i = 2; i*i <= n; i++) {
				if(n%i==0){
					flag = true;
					break;
				}
			}
			if(!flag){
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
}