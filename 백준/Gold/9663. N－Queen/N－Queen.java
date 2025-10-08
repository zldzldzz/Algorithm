import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[] arr;
	static int result;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void nQueens(int row) {
		//마지막 것 놓았으면 멈추기
		if (row == n) {
			result++;
			return;
		}

		for (int i = 0; i < n; i++) {
			arr[row] = i;
			boolean flag = false;
			for (int j = 0; j < row; j++) {
				if (arr[j] == arr[row]) {
					flag = true;
				}
				if (Math.abs(arr[j] - arr[row]) == Math.abs(row - j)) {
					flag = true;
				}
			}
			if (!flag) {
				nQueens(row + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		arr = new int[n];
		
		nQueens(0);

		bw.write(String.valueOf(result));

		br.close();
		bw.flush();
		bw.close();

	}
}