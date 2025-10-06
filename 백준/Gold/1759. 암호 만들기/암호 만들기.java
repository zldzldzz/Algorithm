import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<String> result = new ArrayList<>();
	static int l;
	static int c;
	static char[] arr;
	static char[] password;
	static List<Character> vowel = new ArrayList<Character>(List.of('a', 'e', 'i', 'o', 'u'));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void dfs(int passwordLength, int index) throws IOException {

		if (passwordLength == l) {
			int vowelCount = 0;
			int consonantCount = 0;
			for (char x : password) {
				if (vowel.contains(x)) {
					vowelCount++;
				} else {
					consonantCount++;
				}
			}
			if (vowelCount >= 1 && consonantCount >= 2) {
				bw.write(new String(password) + "\n");
			}
			return;
		}
		for (int i = index; i < c; i++) {
			password[passwordLength] = arr[i];
			dfs(passwordLength + 1, i + 1);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		//암호 길이
		l = Integer.parseInt(st.nextToken());
		//문자 수
		c = Integer.parseInt(st.nextToken());

		arr = new char[c];
		password = new char[l];

		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for (int i = 0; i < c; i++) {
			arr[i] = st2.nextToken().toCharArray()[0];
		}
		Arrays.sort(arr);

		dfs(0, 0);

		bw.flush();
		bw.close();
		br.close();
	}
}