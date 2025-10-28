import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[] nums = new boolean[10];

	// 현재 후보인 값을 저장
	static int[] selectedNum = new int[3];
	
	static int n; // 질문 수
	
	static int result = 0;// 문제에서 원하는 후보들 수

	static OneLine[] oneLines; //각 질문과 질문에 대한 답

	public static class OneLine {
		int number;
		int strike;
		int ball;

		public OneLine(int number, int strike, int ball) {
			this.number = number;
			this.strike = strike;
			this.ball = ball;
		}
	}

	// ball 검사
	private static boolean ballCount(int[] arr, int x) {
		return arr[0] == x || arr[1] == x || arr[2] == x;
	}

	// oneLine의(number, strike, ball)와 현재 selectedNum이 모두 일치하는지 검사
	private static boolean matches(OneLine ol) {
		int strike = 0, ball = 0;
		
		// 질문 숫자 3자리 분해 (백,십,일)
		int[] val = { ol.number / 100, (ol.number / 10) % 10, ol.number % 10 };

		for (int i = 0; i < 3; i++) {
			if (selectedNum[i] == val[i]) {
				strike++;
			} else if (ballCount(selectedNum, val[i])) {
				ball++;
			}
		}
		return (strike == ol.strike && ball == ol.ball);
	}

	public static void countNum(int num) {
		// 선택한 수가 3개이면 실행
		if (num == 3) {
			boolean flag = false;
			for (int i = 0; i < oneLines.length; i++) {
				if (!matches(oneLines[i])) { // 이전 메시지에서 준 matches 헬퍼 사용
					flag = true;
					break;
				}
			}
			if (!flag) result++;
			return;
		}

		// 여기서부터 숫자 후보 생성 (1~9, 중복 금지, 0 제외)
		for (int d = 1; d <= 9; d++) {
			if (nums[d] == false) {          // 아직 사용 안 한 숫자면
				nums[d] = true;             // 사용 표시
				selectedNum[num] = d;    // 현재 자리(0=백, 1=십, 2=일)에 배치
				countNum(num + 1);       // 다음 자리로
				nums[d] = false;             // 백트래킹(원복)
			}
		}
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		oneLines = new OneLine[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			oneLines[i] = new OneLine(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		}
		countNum(0);
		bw.write(String.valueOf(result));
		bw.newLine();
		
		bw.flush();
		bw.close();
		br.close();
	}
}