import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int n, sum;
	static int[] arr;
	static int[] sign = new int[4];
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	//depth은 현재까지 들어간 기호 수
	public static void dfs(int depth, int sum) throws IOException {

		//마지막 것 놓았으면 멈추기
		if (depth == n) {
			if (sum > max) {
				max = sum;
			}
			if (sum < min) {
				min = sum;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int befor = sum;
			if (i == 0 && sign[i] > 0) {
				sign[i]--;
				sum += arr[depth];
				dfs(depth + 1, sum);
				sign[i]++;
			}
			if (i == 1 && sign[i] > 0) {
				sign[i]--;
				sum -= arr[depth];
				dfs(depth + 1, sum);
				sign[i]++;
			}

			if (i == 2 && sign[i] > 0) {
				sign[i]--;
				sum = sum * arr[depth];
				dfs(depth + 1, sum);
				sign[i]++;
			}
			if (i == 3 && sign[i] > 0) {
				sign[i]--;
				if (sum < 0) {
					sum = -sum;
					sum = sum / arr[depth];
					sum = -sum;
					dfs(depth + 1, sum);
				} else {
					sum = sum / arr[depth];
					dfs(depth + 1, sum);
				}
				sign[i]++;
			}
			sum = befor;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//숫자 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n];
		//수열
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//기호 넣기
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			sign[i] = Integer.parseInt(st.nextToken());
		}

		sum = arr[0];

		dfs(1, sum);
		bw.write(String.valueOf(max) + "\n" + String.valueOf(min));

		br.close();
		bw.flush();
		bw.close();

	}
}