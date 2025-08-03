import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		int i = Integer.parseInt(line[2]);
		int round = 1;
		boolean find = false;
		while (n >= 1) {
			if ((k + 1) / 2 == (i + 1) / 2) {
				find = true;
			}
			if (find) {
				break;
			} else {
				k = (k + 1) / 2;
				i = (i + 1) / 2;
				n = n / 2;
				round++;
			}
		}
		if (find) {
			bw.write(String.valueOf(round));
		} else {
			bw.write("-1");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}