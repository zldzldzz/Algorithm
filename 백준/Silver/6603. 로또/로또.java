import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String[] line = br.readLine().split(" ");
			int k = Integer.parseInt(line[0]);

			if (k == 0) {
				break;
			}

			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 1; i < line.length; i++) {
				list.add(Integer.parseInt(line[i]));
			}
			Collections.sort(list);
			for (int i = 0; i < list.size(); i++) {
				if(i+5>=list.size()) {
					break;
				}
				for (int j = i + 1; j < list.size(); j++) {       
					for (int l = j + 1; l < list.size(); l++) {    
						for (int m = l + 1; m < list.size(); m++) {
							for (int n = m + 1; n < list.size(); n++) { 
								for (int o = n + 1; o < list.size(); o++) {
									bw.write(list.get(i) + " " + list.get(j) + " " + list.get(l) + " " +
										list.get(m) + " " + list.get(n) + " " + list.get(o) + "\n");
								}
							}
						}
					}
				}
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}