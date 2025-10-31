import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(br.readLine());
		// 숫자 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 숫자열 받기 위한 배열
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			// 위에서 st로 한줄 입력 받은 것을 하나씩 짤라서 배열과 set에 넣기
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//중복 제거를 위해 set 사용
		// 중복 제거 후 정렬
		Set<Integer> set = new HashSet<>();
		for (int x : arr)
			set.add(x);
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);

		//[결과 출력] 해당 배열의 값이 나오면 해당 순서 출력
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i), i);
		}

		for (int x : arr) {
			bw.write(map.get(x) + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}