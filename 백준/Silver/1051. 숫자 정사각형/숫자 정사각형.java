import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int maxSize = 0;
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = j + 1; k < m; k++) {
					if (map[i][j] == map[i][k]) {
						int length = k - j;
						if (i + length < n) {
							if (map[i][j] == map[i + length][j] && map[i][j] == map[i + length][k]) {
								int size = length + 1;
								maxSize = Math.max(maxSize, size * size);
							}
						}

					}
				}
			}
		}
		if (maxSize == 0) {
			bw.write("1");
		} else {
			bw.write(String.valueOf(maxSize));
		}
		bw.flush();
		bw.close();
		br.close();
	}
}