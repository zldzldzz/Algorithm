import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map = new int[19][19];
	static int[][][] mamo = new int[19][19][4];
	static int[][] dir = new int[][] {{1, 0}, {0, 1}, {1, 1}, {-1, 1}};

	public static int findFive(int row, int col, int d, int who) {
		int nRow = row + dir[d][0];
		int nCol = col + dir[d][1];

		if (nRow >= 0 && nCol >= 0 && nRow < 19 && nCol < 19) {
			if (map[nRow][nCol] == who) {
				mamo[nRow][nCol][d] = findFive(nRow, nCol, d, who) + 1;
				return mamo[nRow][nCol][d];
			}
		}

		return 1;
	}

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] result = new int[3];
		boolean flag = false;

		for (int i = 0; i < 19; i++) {

			if (flag) {
				break;
			}

			for (int j = 0; j < 19; j++) {

				if (flag) {
					break;
				}

				if (map[i][j] != 0) {
					for (int k = 0; k < 4; k++) {

						int prevRow = i - dir[k][0];
						int prevCol = j - dir[k][1];
						boolean isPrevStoneSame = false;
						if (prevRow >= 0 && prevCol >= 0 && prevRow < 19 && prevCol < 19) {
							if (map[prevRow][prevCol] == map[i][j]) {
								isPrevStoneSame = true;
							}
						}

						if (!isPrevStoneSame && mamo[i][j][k] == 0) {
							if (findFive(i, j, k, map[i][j]) == 5) {
								result[0] = map[i][j];
								result[1] = i;
								result[2] = j;
								flag = true;
								break;
							}
						}
					}
				}
			}
		}

		if (!flag) {
			bw.write("0\n");      
		} else {
			bw.write(result[0] + "\n");
			bw.write((result[1] + 1) + " " + (result[2] + 1) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}