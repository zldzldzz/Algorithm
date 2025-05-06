

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        String[] answer= new String[length];

        for (int i = 0; i < length; i++) {

            String[] str = br.readLine().trim().split("\\s+");

            int repeat= Integer.parseInt(str[0]);
            String string = str[1];
            StringBuilder stringAfter= new StringBuilder();
            for (char c : string.toCharArray()) {
                stringAfter.append(String.valueOf(c).repeat(repeat));
            }
            answer[i]=stringAfter.toString();
        }
        for (String s : answer) {
            bw.write(s);
            bw.write('\n');
            bw.flush();

        }

    }

}
