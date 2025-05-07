import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        String c = br.readLine();
        int answer=0;
        for (String s : a) {
            if (c.equals(s)){
                answer++;
            }
        }
       bw.write(String.valueOf(answer));
        bw.flush();
    }
}
