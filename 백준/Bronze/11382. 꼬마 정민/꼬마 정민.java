import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer=0;
        String[] str = br.readLine().trim().split("\\s+");
        for (String s : str) {
            try {
                answer += Long.parseLong(s);
            } catch (NumberFormatException e) {
                return;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
