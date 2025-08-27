import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int length = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(br.readLine());
		int nearMin = 0;
		int nearMax = 1001;
		boolean flag = false;

		int count = 0;

		for (int i = 0; i < length; i++) {
			int x = Integer.parseInt(arr[i]);
			if (x == n) {
				flag = true;
				break;
			} else if (x < n) {
				if (nearMin < x) {
					nearMin = x;
				}
			} else {
				if (x < nearMax) {
					nearMax = x;
				}
			}
		}
       

		if (flag) {
			bw.write("0\n");
		} else {
			for (int i = nearMin + 1; i <= n; i++) {
				for (int j = n; j < nearMax; j++) {
					count++;
				}
			}
			bw.write(String.valueOf(count-1));
		}

		bw.flush();
		bw.close();
		br.close();

	}

}