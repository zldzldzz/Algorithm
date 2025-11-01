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

	//위치, 방향을 인뎃스로 해당 돌이 몇번째 돌인지 체크 만약 시작할때 0이 아니면 다른 곳에서 이미 체크
	static int[][][] mamo = new int[19][19][4];

	// 각 좌표에 더해질 값
	static int[][] dir = new int[][] {{1, 0}, {0, 1}, {1, 1}, {-1, 1}};

	public static int findFive(int row, int col, int d, int who) {
		int nRow = row + dir[d][0];
		int nCol = col + dir[d][1];

		if (nRow >= 0 && nCol >= 0 && nRow < 19 && nCol < 19) {
			// 이전의 값이랑 비교 같으면 통과
			if (map[nRow][nCol] == who) {
				mamo[nRow][nCol][d] = findFive(nRow, nCol, d, who) + 1;
				// 1씩 증가한 값을 반환
				return mamo[nRow][nCol][d];
			}
		}

		// 다른 돌을 만난 순간 1 반환 시작
		return 1;
	}

	public static void main(String[] args) throws IOException {

		// 입력 받기
		for (int i = 0; i < 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 결과 저장
		int[] result = new int[3];
		// 찾은 경우 종료하기 위한 프레그
		boolean flag = false;

		for (int i = 0; i < 19; i++) {

			if (flag) {
				break;
			}

			for (int j = 0; j < 19; j++) {

				if (flag) {
					break;
				}

				// 빈 곳인지 확인
				if (map[i][j] != 0) {
					// 방향은 8곳이지만 왼쪽으로 이동은 x+1만 해도 x-1은 포함 된 것과 같음
					for (int k = 0; k < 4; k++) {

						//이전 돌과 다른 돌 아닌 지 확인
						int prevRow = i - dir[k][0];
						int prevCol = j - dir[k][1];
						boolean isPrevStoneSame = false;
						if (prevRow >= 0 && prevCol >= 0 && prevRow < 19 && prevCol < 19) {
							if (map[prevRow][prevCol] == map[i][j]) {
								isPrevStoneSame = true;
							}
						}

						// 이전 돌과 다른 돌 && 체크한 적 없는 위치, 방향
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

		//결과 출력
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
 //실패 해서 참고한 블로그
//https://velog.io/@chaerim1001/%EB%B0%B1%EC%A4%80-2615%EB%B2%88-%EC%98%A4%EB%AA%A9-Java