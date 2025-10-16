import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int startTotalTime = 0;
		int endTotalTime = 0;

		StringTokenizer start = new StringTokenizer(br.readLine(), ":");
		StringTokenizer end = new StringTokenizer(br.readLine(), ":");

		for (int i = 0; i < 3; i++) {
			int startTime = Integer.parseInt(start.nextToken());
			int endTime = Integer.parseInt(end.nextToken());

			if (i == 0) {
				startTotalTime += startTime * 3600;
				endTotalTime += endTime * 3600;
			}

			if (i == 1) {
				startTotalTime += startTime * 60;
				endTotalTime += endTime * 60;
			}
			if (i == 2) {
				startTotalTime += startTime;
				endTotalTime += endTime;
			}
		}

		int totalTime = endTotalTime - startTotalTime;

		if (totalTime < 0) {
			totalTime = (24 * 3600) + totalTime;
		}

		int[] lastTime = new int[3];
		lastTime[0] = totalTime / 3600;
		lastTime[1] = totalTime % 3600 / 60;
		lastTime[2] = totalTime % 60;

		for (int i = 0; i < 3; i++) {
			if (lastTime[i] < 10) {
				bw.write("0");
			}
			bw.write(String.valueOf(lastTime[i]));
			if (i != 2) {
				bw.write(":");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}