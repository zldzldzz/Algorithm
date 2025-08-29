import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int length = Integer.parseInt(br.readLine());
		int result = 0;
		String[] line = br.readLine().split(" ");
		ArrayList<Integer> list = new ArrayList<>();
		for (String s : line) {
			list.add(Integer.parseInt(s));
		}
		Collections.sort(list);
		int sum = 0;
		for (Integer i : list) {
			result += sum + i;
			sum += i;
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}