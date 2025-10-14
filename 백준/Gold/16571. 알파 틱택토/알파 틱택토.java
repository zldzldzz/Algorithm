import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;

	//빈칸을 저장해 놓은 큐
	static List<Integer[]> list = new ArrayList<>();

	//누군가 이겼는지 확인 하는 메서드
	public static boolean checked(int who) {
		for (int i = 0; i < 3; i++) {
			int count = 0;
			for (int j = 0; j < 3; j++) {
				if (map[i][j] == who) {
					count++;
				}
			}
			if (count == 3) {
				return true;
			}
		}
		for (int i = 0; i < 3; i++) {
			int count = 0;
			for (int j = 0; j < 3; j++) {
				if (map[j][i] == who) {
					count++;
				}
			}
			if (count == 3) {
				return true;
			}
		}
		if (map[1][1] == who) {
			if (map[0][0] == who && map[2][2] == who) {
				return true;
			} else if (map[2][0] == who && map[0][2] == who) {
				return true;
			}
		}
		return false;
	}

	//실제 틱택토가 돌아가는 메서드
	public static int isWin(int who, int depth) {
		int opponent = who == 1 ? 2 : 1;

		if (checked(opponent)) {
			return opponent;
		}

		if (depth == list.size()) {
			return 3;
		}

		// 현재 플레이어(who)의 최선의 결과를 저장할 변수
		// 초기값은 가장 나쁜 결과(상대방 승리)로 설정
		int bestResult = (who == 1) ? 2 : 1; // X 턴이면 2(O 승리), O 턴이면 1(X 승리)


		boolean canDraw = false;

		for (int i = 0; i < list.size(); i++) {
			//빈칸에 현재 순서인 돌을 한번씩 놓고 검사
			Integer[] now = list.get(i);

			//이미 자식에서 놓은 수인지 확인
			if (map[now[0]][now[1]] != 0) {
				continue;
			}

			map[now[0]][now[1]] = who;

			int childResult = isWin(opponent, depth + 1);

			map[now[0]][now[1]] = 0;

			//지금 놓은 수로 끝난 경우
			if (childResult == who) {
				return who;
			}

			if(childResult ==3){
				bestResult =3;
			}
		}

		return bestResult;
	}

	static int countX;
	static int countO;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		map = new int[3][3];
		//틱택토 입력 받기
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					countX++;
				} else if (map[i][j] == 2) {
					countO++;
				} else {
					list.add(new Integer[] {i, j});
				}
			}
		}
		//누구 순서인가?
		if (countX > countO) {
			// O 차례
			int result = isWin(2, 0);
			if (result == 1) {
				System.out.println("L");
			} else if (result == 2) {
				System.out.println("W");
			} else {
				System.out.println("D");
			}
		} else {
			// X 차례
			int result = isWin(1, 0);
			if (result == 1) {
				System.out.println("W");
			} else if (result == 2) {
				System.out.println("L");
			} else {
				System.out.println("D");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}